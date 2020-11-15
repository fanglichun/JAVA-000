package com.flc.singleton;

/**
 * @creator fanglc@anch.net
 * @createdTime 2020/11/15 10:18
 * @desc
 */
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

//优点：线程安全
//缺点：懒汉式的缺点在于，每次获取单例的时候，是加锁的，如果频繁使用，会影响调用效率


