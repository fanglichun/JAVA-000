package com.flc;

/**
 * @creator fanglc@anch.net
 * @createdTime 2020/11/24 17:29
 * @desc
 */
public class LambdaApp {
    public static void main(String[] args) {
        ILambda lambda = System.out::println;
        lambda.print("hello world");
        enact(System.out::println, "我是立春");
    }

    public static void enact(ILambda lambda, String s) {
        lambda.print(s);
    }
}
