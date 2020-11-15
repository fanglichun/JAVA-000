package com.flc.singleton;

/**
 * @creator fanglc@anch.net
 * @createdTime 2020/11/15 20:24
 * @desc
 */
public enum EnumSingleton {
    INSTANCE;
    //直接通过Singleton.INSTANCE.doSomething()的方式调用即可。方便、简洁又安全。
    public void doSomething() {
        System.out.println("do something");
    }

}
