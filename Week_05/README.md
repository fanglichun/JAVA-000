学习笔记
# 总结一下，单例的各种写法，比较它们的优劣。

## 懒汉模式
```java
public class HungrySingleton {
    //类加载的时候就创建了实例
    private static HungrySingleton instance = new HungrySingleton();
    private HungrySingleton() {}

    public static HungrySingleton getInstance() {
        return instance;
    }
}
```
### 实现简单

### 类加载时候就被创建好，线程安全

### 即使单例没被用到也会创建，浪费内存

## 懒汉式
```java
public class LazySingleton {
    private static LazySingleton instance = null;

    static {
        instance = new LazySingleton();
    }

    private LazySingleton() {
    }

    synchronized
    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
```
### 支持延迟加载

### 线程安全

### 每次获取单例的时候，是加锁的，如果频繁使用，会影响并发

## 双重检测
```java
public class TwinCheckSingleton {
    //这里还用到了volatile关键字来修饰singleton，其最关键的作用是防止指令重排
    private static volatile TwinCheckSingleton instance = null;

    static {
        instance = new TwinCheckSingleton();
    }

    private TwinCheckSingleton() {
    }

    //采用了双重校验的方式，对懒汉式单例模式做了线程安全处理。
    //通过加锁，可以保证同时只有一个线程走到第二个判空代码中去，这样保证了只创建 一个实例。
    public static TwinCheckSingleton getInstance() {
        if (instance == null) {
            synchronized (TwinCheckSingleton.class) {
                if (instance == null) {
                    instance = new TwinCheckSingleton();
                }
            }
        }
        return instance;
    }
}
```
### 只要 instance 被创建之后，即便再调用 getInstance() 函数也不会再进入到加锁逻辑中了。所以，这种实现方式解决了懒汉式并发度低的问题

### 给 instance 成员变量加上 volatile 关键字，禁止指令重排序，避免了线程安全问题

## 静态内部类
```java
public class StaticInnerClassSingleton{
    private StaticInnerClassSingleton() {
    }

    private static class SingletonHolder {
        private static StaticInnerClassSingleton INSTANCE = new StaticInnerClassSingleton();
    }

    public static StaticInnerClassSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

}
```
### 实现简单

### 延迟加载，当调用 getInstance() 方法时，SingletonHolder 才会被加载，这个时候才会创建 instance

### instance 的唯一性、创建过程的线程安全性，都由 JVM 来保证

### 还存在反射攻击或者反序列化攻击，不能创建出绝对的单例

## 枚举
```java
public enum EnumSingleton {
    INSTANCE;
    //直接通过Singleton.INSTANCE.doSomething()的方式调用即可。方便、简洁又安全。
    public void doSomething() {
        System.out.println("do something");
    }

}
```
### 实现最简单

### 基于枚举类型的单例实现。这种实现方式通过 Java 枚举类型本身的特性，保证了实例创建的线程安全性和实例的唯一性

# （必做）给前面课程提供的Student/Klass/School实现自动配置和Starter。
遇到一个坑，starter里面的配置文件的格式若是properties,maven引入这个starter的话，若是你要覆盖里面的值的话，
当前这个maven项目或者module里面配置文件格式也应该是properties,否则会无法覆盖值，同理yaml格式也是一样

# （必做）研究一下JDBC接口和数据库连接池，掌握它们的设计和用法：
1）使用JDBC原生接口，实现数据库的增删改查操作。
2）使用事务，PrepareStatement方式，批处理方式，改进上述操作。
3）配置Hikari连接池，改进上述操作。提交代码到Github。
见JdbcApplicationTests和UserDao。
# （必做）写代码实现Spring Bean的装配，方式越多越好（XML、Annotation都可以）,提交到Github。
