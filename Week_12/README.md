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
```
1.xshell同时登陆192.168.28.128/192.168.28.129/192.168.28.130(root/root),并开启所有会话
2.解压redis安装包:tar -xvf redis-5.0.0.tar.gz
3.cd redis-5.0.0/src/ && make MALLOC=libc
4.mkdir -p /usr/redis_cluster/6379 && mkdir -p /usr/redis_cluster/6380
5.cd ../
6.cp redis.conf /usr/redis_cluster/6379 && cp redis.conf /usr/redis_cluster/6380
7.cd /root && mv redis-5.0.0 /usr/redis_cluster/
8.分别修改三台机器下的目录中的redis.conf的配资，具体见配置
9.安装ruby和redis插件:安装过程见:[Centos7 源码安装、升级 Ruby](https://blog.csdn.net/HeyShHeyou/article/details/108937918)
10.分别在三台机器下执行如下命令：
cd /usr/redis_cluster && ./redis-5.0.0/src/redis-server ./6379/redis.conf
cd /usr/redis_cluster && ./redis-5.0.0/src/redis-server ./6380/redis.conf
11.启动集群:
cd /usr/redis_cluster/redis-5.0.0/src && redis-cli --cluster create --cluster-replicas 1 192.168.28.128:6379 192.168.28.128:6380 192.168.28.129:6379 192.168.28.129:6380 192.168.28.130:6379 192.168.28.130:6380
12.验证集群:
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