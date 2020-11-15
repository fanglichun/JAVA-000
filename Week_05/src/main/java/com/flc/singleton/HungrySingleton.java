package com.flc.singleton;

/**
 * @creator fanglc@anch.net
 * @createdTime 2020/11/15 10:14
 * @desc
 */
//（选做）总结一下，单例的各种写法，比较它们的优劣
public class HungrySingleton {
    //类加载的时候就创建了实例
    private static HungrySingleton instance = new HungrySingleton();
    private HungrySingleton() {}

    public static HungrySingleton getInstance() {
        return instance;
    }
}
//优点：类加载的时候创建一次实例，避免了多线程同步问题
//缺点：即使单例没被用到也会创建，浪费内存
