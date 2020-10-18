package com.flc.jvm;
/**
 * @ClassName HelloClassLoader
 * @Description
 * @Author fanglichun
 * @Date 2020/10/18 2:07 PM
 * @Version 1.0
 **/

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HelloClassLoader extends ClassLoader {

    public static void main(String[] args) {
        try {

            Class<?> clz = new HelloClassLoader().findClass("Hello");
            Method hello = clz.getDeclaredMethod("hello");
            hello.setAccessible(true);
            hello.invoke(clz.newInstance());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String filePath = this.getClass().getResource("/Hello.xlass").getPath();
        File file = new File(filePath);
        int length = (int) file.length();
        byte[] bytes = new byte[length];
        try {
            new FileInputStream(file).read(bytes);
        } catch (IOException e) {
            return super.findClass(name);
        }
        for (int i = 0; i < length; i++) {
            bytes[i] = (byte) (255 - bytes[i]);
        }
        return defineClass(name, bytes, 0, length);
    }
}
