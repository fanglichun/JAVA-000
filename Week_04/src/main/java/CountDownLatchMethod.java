import domain.Fibonacci;

import java.util.concurrent.*;

/**
 * @creator fanglc@anch.net
 * @createdTime 2020/11/11 19:23
 * @desc
 */
public class CountDownLatchMethod {
    private static int sum;

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        CountDownLatch latch = new CountDownLatch(1);
        // 在这里创建一个线程或线程池，
        //异步执行 下面方法
        new Thread(() -> {
            try {
                sum = Fibonacci.sum();
            } finally {
                latch.countDown();
            }
        }).start();
        latch.await(1, TimeUnit.SECONDS);
        // 确保拿到result 并输出
        System.out.println("异步计算结果为：" + sum);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
        // 然后退出main线程
    }

}
