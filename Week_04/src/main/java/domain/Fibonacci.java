package domain;

/**
 * @creator fanglc@anch.net
 * @createdTime 2020/11/11 18:56
 * @desc
 */
public class Fibonacci {

    public static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if (a < 2)
            return 1;
        return fibo(a - 1) + fibo(a - 2);
    }
}
