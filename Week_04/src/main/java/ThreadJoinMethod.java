import domain.Fibonacci;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @creator fanglc@anch.net
 * @createdTime 2020/11/11 19:39
 * @desc
 */
public class ThreadJoinMethod {

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        AtomicInteger result = new AtomicInteger();
        Thread thread = new Thread(() ->
                result.set(Fibonacci.sum())
        );
        thread.start();
        thread.join();
        // 确保拿到result并输出
        System.out.println("Thread Join 异步计算结果为：" + result.get());
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
        // 然后退出main线程
    }
}
