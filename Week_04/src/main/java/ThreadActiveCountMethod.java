import domain.Fibonacci;

import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @creator fanglc@anch.net
 * @createdTime 2020/11/11 19:48
 * @desc
 */
public class ThreadActiveCountMethod {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int defaultThreadNum = 2;
        AtomicInteger result = new AtomicInteger();
        Thread thread = new Thread(() -> result.set(Fibonacci.sum()));
        thread.start();
        while (Thread.activeCount() > defaultThreadNum) {
            Thread.yield();
        }
        // 确保拿到result并输出
        System.out.println("异步计算结果为：" + result.get());
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
        // 然后退出main线程
    }
}
