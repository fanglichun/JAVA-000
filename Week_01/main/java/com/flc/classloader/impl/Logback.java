package com.flc.classloader.impl;

import com.flc.classloader.Log;

/**
 * @creator fanglc@anch.net
 * @createdTime 2020/12/29 16:18
 * @desc
 */
public class Logback implements Log {
    @Override
    public void log(String info) {
        System.out.println("Logback:" + info);
    }
}
