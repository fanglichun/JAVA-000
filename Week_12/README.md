#####1、（必做）配置redis的主从复制，sentinel高可用，Cluster集群。 提交如下内容到github：
######1）config配置文件;
######2）启动和操作、验证集群下数据读写的命令步骤。

#####redis Cluster集群部署方案:
物料准备:
######虚拟机:
```
VMware® Workstation 16 Pro(VMware-16.0.0 build-16894299)
```
######三台CentOS虚拟机:
```
192.168.28.128(主-6379/从-6380)
192.168.28.129(主-6379/从-6380)
192.168.28.130(主-6379/从-6380)
```
######ruby
```
ruby-2.5.5.tar.gz
安装过程见:[Centos7 源码安装、升级 Ruby](https://blog.csdn.net/HeyShHeyou/article/details/108937918)
```
######redis安装包
```
redis-5.0.0.tar.gz 
wget http://download.redis.io/releases/redis-5.0.0.tar.gz
```
部署步骤:
######xshell同时登陆并开启所有会话
```
192.168.28.128/192.168.28.129/192.168.28.130(root/root)
```
######解压redis安装包
```
tar -xvf redis-5.0.0.tar.gz
```
######编译redis源码
```
cd redis-5.0.0/src/ && make MALLOC=libc
```
######给各个节点创建主备文件夹
```
mkdir -p /usr/redis_cluster/6379 && mkdir -p /usr/redis_cluster/6380
```
######回到cd redis-5.0.0文件夹
```
cd ../
```
######拷贝redis.conf配置到三节点的主备目录下
```
cp redis.conf /usr/redis_cluster/6379 && cp redis.conf /usr/redis_cluster/6380
```
######将编译好的redis源码包拷贝到/usr/redis_cluster/下
```
cd /root && mv redis-5.0.0 /usr/redis_cluster/
```
######分别修改三台机器下的目录中的redis.conf的配资，具体见配置，以192.168.28.128的redis.conf为例：

```
#6379-主节点配置：
#绑定的主机地址
bind 192.168.28.128
#指定Redis监听端口
port 6379
cluster-enabled yes
#cluster开启必须重命名指定cluster-config-file，不能与别的节点相同，否则会启动失败(Sorry, the cluster configuration file nodes.conf is already used bySorry,
#the cluster configuration file nodes.conf is already used by),最好按主机+端口命名
cluster-config-file nodes_6379.conf
#集群节点的超时时限
cluster-node-timeout 5000
#指定是否在每次更新操作后进行日志记录，Redis在默认情况下是异步的把数据写入磁盘，
#如果不开启，可能会在断电时导致一段时间内的数据丢失。因为 redis本身同步数据文件是按上面save条件来同步的，所以有的数据会在一段时间内只存在于内存中。默认为no
appendonly yes
#Redis默认不是以守护进程的方式运行，可以通过该配置项修改，使用yes启用守护进程
daemonize yes

protected-mode no
#日志记录方式，默认为标准输出，如果配置Redis为守护进程方式运行，而这里又配置为日志记录方式为标准输出，则日志将会发送给/dev/null
logfile  /usr/redis_cluster/6379/redis_6379.log
#当Redis以守护进程方式运行时，Redis默认会把pid写入/var/run/redis.pid文件，可以通过pidfile指定
pidfile /usr/bin/redis_cluster/6379/redis_6379.pid
#指定本地数据库存放目录
dir /usr/redis_cluster/6379/data
```
```
#绑定的主机地址
bind 192.168.28.128
#指定Redis监听端口
port 6380
cluster-enabled yes
#cluster开启必须重命名指定cluster-config-file，不能与别的节点相同，否则会启动失败(Sorry, the cluster configuration file nodes.conf is already used bySorry,
#the cluster configuration file nodes.conf is already used by),最好按主机+端口命名
cluster-config-file nodes_6380.conf
#集群节点的超时时限
cluster-node-timeout 5000
#指定是否在每次更新操作后进行日志记录，Redis在默认情况下是异步的把数据写入磁盘，
#如果不开启，可能会在断电时导致一段时间内的数据丢失。因为 redis本身同步数据文件是按上面save条件来同步的，所以有的数据会在一段时间内只存在于内存中。默认为no
appendonly yes
#Redis默认不是以守护进程的方式运行，可以通过该配置项修改，使用yes启用守护进程
daemonize yes

protected-mode no
#日志记录方式，默认为标准输出，如果配置Redis为守护进程方式运行，而这里又配置为日志记录方式为标准输出，则日志将会发送给/dev/null
logfile  /usr/redis_cluster/6380/redis_6380.log
#当Redis以守护进程方式运行时，Redis默认会把pid写入/var/run/redis.pid文件，可以通过pidfile指定
pidfile /usr/bin/redis_cluster/6380/redis_6380.pid
#指定本地数据库存放目录
dir /usr/redis_cluster/6380/data

```
######129和130节点只需要换下ip地址即可。

######安装ruby和redis插件:安装过程见:[Centos7 源码安装、升级 Ruby](https://blog.csdn.net/HeyShHeyou/article/details/108937918)

######分别在三台机器下执行如下命令：
```
cd /usr/redis_cluster && ./redis-5.0.0/src/redis-server ./6379/redis.conf
cd /usr/redis_cluster && ./redis-5.0.0/src/redis-server ./6380/redis.conf
```
######启动集群:
```
cd /usr/redis_cluster/redis-5.0.0/src && redis-cli --cluster create --cluster-replicas 1 192.168.28.128:6379 192.168.28.128:6380 192.168.28.129:6379 192.168.28.129:6380 192.168.28.130:6379 192.168.28.130:6380
```
######验证集群:
```
./redis-cli -c -h 192.168.28.128 -p 6379
set name
get name
exit
./redis-cli -c -h 192.168.28.128 -p 6380
get name
exit
./redis-cli -c -h 192.168.28.129 -p 6380
get name
exit
./redis-cli -c -h 192.168.28.130 -p 6380
get name
exit
```
[参考手册](https://blog.csdn.net/weixin_39891030/article/details/82752291)

