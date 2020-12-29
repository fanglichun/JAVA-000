package com.flc;

import com.flc.classloader.Log;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @creator fanglc@anch.net
 * @createdTime 2020/12/29 16:23
 * @desc
 */
public class Main {
    public static void main(String[] args) {
        ServiceLoader<Log> serviceLoader =
                ServiceLoader.load(Log.class);
        Iterator<Log> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            Log log = iterator.next();
            log.log("JDK SPI");
        }
    }
}
