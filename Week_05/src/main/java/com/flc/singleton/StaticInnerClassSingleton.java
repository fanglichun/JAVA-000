package com.flc.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @creator fanglc@anch.net
 * @createdTime 2020/11/15 10:30
 * @desc
 */
public class StaticInnerClassSingleton{
    private StaticInnerClassSingleton() {
    }

    private static class SingletonHolder {
        private static StaticInnerClassSingleton INSTANCE = new StaticInnerClassSingleton();
    }

    public static StaticInnerClassSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public static void main(String[] args) {
    }

    public static void reflect() throws
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException,
            NoSuchMethodException {
        StaticInnerClassSingleton singleton = StaticInnerClassSingleton.getInstance();
        Constructor<StaticInnerClassSingleton> constructor = StaticInnerClassSingleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        StaticInnerClassSingleton newSingleton = constructor.newInstance();
        System.out.println(singleton == newSingleton);
    }

}

//通过静态内部类的方式实现单例模式是线程安全的，同时静态内部类不会在Singleton类加载时就加载，
//而是在调用getInstance()方法时才进行加载，达到了懒加载的效果。
//instance的唯一性、创建过程的线程安全性，都由JVM来保证
//但是还存在反射攻击或者反序列化攻击

