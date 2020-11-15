package com.flc.singleton;

/**
 * @creator fanglc@anch.net
 * @createdTime 2020/11/15 10:18
 * @desc
 */
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



