学习笔记
#读写分离-动态切换数据源版本1.0
######1、基于Spring/Spring Boot，配置多个数据源(例如2个，master 和slave)
######2、根据具体的Service 方法是否会操作数据，注入不同的数据源,1.0版本
######3、改进一下1.1：基于操作AbstractRoutingDataSource 和自定义注解readOnly 之类的，简化自动切换数据源
######4、改进二下1.2：支持配置多个从库；
######5、改进三下1.3：支持多个从库的负载均衡
######6、总结:
```
Caused by: java.io.FileNotFoundException: Could not open ServletContext resource [/classpath*:mapping/*.xml]
springboot2.0+版本无需添加如下配置,spring-boot2.0以下版本需要添加
mybatis.mapper-locations=classpath*:mapping/*.xml

```

```
org.apache.ibatis.binding.BindingException: Invalid bound statement (not found)
resouce下的mapper是文件夹，不是包
启动类需要配置mybatis扫描的包路径，如下所示：
@MapperScan(basePackages = "com.flc.dms.mapper")
```

```
AbstractRoutingDataSource的determineCurrentLookupKey()执行时间还要早于切换数据源的切面
最后的解决方案是:将切入点放在了service中，并且在切面类指定类优先级为0或者1临时解决了，需要进一步定位下为什么
不能再DAO层生效
```

#按自己设计的表结构，插入100万订单模拟数据，测试不同方式的插入效率。