####1.（必做）搭建一个 3 节点 Kafka 集群，测试功能和性能；实现 spring kafka 下对 kafka 集群的操作，将代码提交到 github。
#####zookeeper集群安装
#######下载zookeeper安装包:
```
cd /usr/opt
wget https://mirrors.tuna.tsinghua.edu.cn/apache/zookeeper/stable/apache-zookeeper-3.5.8.tar.gz
tar xf apache-zookeeper-3.5.8-bin.tar.gz -C /usr/local
```
#######配置zookeeper:
```
cd /usr/local
#软链接
ln -sv apache-zookeeper-3.5.8-bin zookeeper

cd /zookeeper/conf/
cp  zoo_sample.cfg  zoo.cfg

vim zoo.cfg
#客户端与服务器或者服务器与服务器之间每个tickTime时间就会发送一次心跳。通过心跳不仅能够用来监听机器的工作状态，还可以通过心跳来控制Flower跟Leader的通信时间，默认2秒
tickTime=2000

initLimit=10
syncLimit=5
dataDir=/data/zookeeper/data/data
dataLogDir=/data/zookeeper/data/log
clientPort=2181
server.1=172.16.150.154:2888:3888
server.2=172.16.150.155:2888:3888
server.3=172.16.150.156:2888:3888
分别在在192.168.28.128~130上执行：
mkdir -p /data/zookeeper/data/data
mkdir -p /data/zookeeper/data/log

在192.168.28.128上执行：
echo "1" > /data/zookeeper/data/data/myid
在192.168.28.129上执行：
echo "2" > /data/zookeeper/data/data/myid
在192.168.28.130上执行：
echo "3" > /data/zookeeper/data/data/myid
```
#######启动zookeeper并查看日志:
```
分别在在192.168.28.128~130上执行：
cd /usr/local/zookeeper/bin && ./zkServer.sh start
tail /usr/local/zookeeper/logs/zookeeper-root-server-localhost.localdomain.out
```
#######验证zookeeper集群访问:
```
分别在在192.168.28.128~130上执行：
netstat -nlpt | grep -E "2181|2888|3888"
分别在在192.168.28.128~130上执行：
./zkCli.sh  -server 192.168.28.128:2181
./zkCli.sh  -server 192.168.28.129:2181
./zkCli.sh  -server 192.168.28.130:2181
```
#####kafka集群安装
#######下载kafka安装包:
```
cd /usr/opt
wget https://mirror.bit.edu.cn/apache/kafka/2.7.0/kafka_2.13-2.7.0.tgz
tar xf kafka_2.13-2.7.0.tgz -C /usr/local
```
#######配置kafka集群:
```
cd /usr/local
ln -sv kafka_2.13-2.7.0 kafka
cd kafka/config/
cp server.properties server.properties-bak
grep "^[a-Z]" server.properties
vi server.properties
broker.id=1  #唯一
listeners=PLAINTEXT://192.168.28.128:9092  #修改为本机地址
num.network.threads=3
num.io.threads=8
socket.send.buffer.bytes=102400
socket.receive.buffer.bytes=102400
socket.request.max.bytes=104857600
log.dirs=/data/kafka/data/log
num.partitions=3
num.recovery.threads.per.data.dir=1
offsets.topic.replication.factor=1
transaction.state.log.replication.factor=1
transaction.state.log.min.isr=1
log.retention.hours=168
log.segment.bytes=1073741824
log.retention.check.interval.ms=300000
zookeeper.connect=192.168.28.128:2181,192.168.28.129:2181,192.168.28.130:2181  #zokeeper集群地址，以","为分割
zookeeper.connection.timeout.ms=6000
group.initial.rebalance.delay.ms=0
其他节点192.168.28.129、192.168.28.130配置相同,除了以下内容
#192.168.28.129
broker.id=2
listeners=PLAINTEXT://192.168.28.129:9092  #修改为本机地址
#192.168.28.130
broker.id=3
listeners=PLAINTEXT://192.168.28.130:9092  #修改为本机地址
```
#######启动kafka集群:
```
./bin/kafka-server-start.sh -daemon  config/server.properties
启动报错：
[2021-01-10 16:08:35,982] ERROR Fatal error during KafkaServer startup. Prepare to shutdown (kafka.server.KafkaServer)
kafka.zookeeper.ZooKeeperClientTimeoutException: Timed out waiting for connection while in state: CONNECTING
	at kafka.zookeeper.ZooKeeperClient.waitUntilConnected(ZooKeeperClient.scala:262)
	at kafka.zookeeper.ZooKeeperClient.<init>(ZooKeeperClient.scala:119)
	at kafka.zk.KafkaZkClient$.apply(KafkaZkClient.scala:1881)
	at kafka.server.KafkaServer.createZkClient$1(KafkaServer.scala:441)
	at kafka.server.KafkaServer.initZkClient(KafkaServer.scala:466)
	at kafka.server.KafkaServer.startup(KafkaServer.scala:233)
	at kafka.server.KafkaServerStartable.startup(KafkaServerStartable.scala:44)
	at kafka.Kafka$.main(Kafka.scala:82)
	at kafka.Kafka.main(Kafka.scala)
原因：zookeeper.connection.timeout.ms的值太短了，调大了server.properties文件里的超时时间就可以了
```
#######登录zookeeper验证,验证服务是否正常
```
cd /usr/local/zookeeper/bin
./zkCli.sh -server 192.168.28.128
get  /brokers/ids/1
```
{"features":{},"listener_security_protocol_map":{"PLAINTEXT":"PLAINTEXT"},"endpoints":["PLAINTEXT://192.168.28.128:9092"],"jmx_port":-1,"port":9092,"host":"192.168.28.128","version":5,"timestamp":"1610264776275"}

```
get  /brokers/ids/2
```
{"features":{},"listener_security_protocol_map":{"PLAINTEXT":"PLAINTEXT"},"endpoints":["PLAINTEXT://192.168.28.129:9092"],"jmx_port":-1,"port":9092,"host":"192.168.28.129","version":5,"timestamp":"1610280011339"}

```
get  /brokers/ids/3
```
{"features":{},"listener_security_protocol_map":{"PLAINTEXT":"PLAINTEXT"},"endpoints":["PLAINTEXT://192.168.28.129:9092"],"jmx_port":-1,"port":9092,"host":"192.168.28.129","version":5,"timestamp":"1610280011339"}

```
```
#######创建topic验证,验证服务是否正常
```
./kafka-topics.sh --create --zookeeper 192.168.28.128:2181 --replication-factor 1 --partitions 1 --topic love
--创建主题
./kafka-topics.sh --create --zookeeper 192.168.28.128:2181 --replication-factor 1 --partitions 1 --topic love
--生产者给该主题发了个消息
./kafka-console-producer.sh --broker-list 192.168.28.128:9092 --topic love
--消费者收到了消息
./kafka-console-consumer.sh --bootstrap-server 192.168.28.129:9092 --topic love --from-beginning
--消费者收到了消息
./kafka-console-consumer.sh --bootstrap-server 192.168.28.130:9092 --topic love --from-beginning
```
