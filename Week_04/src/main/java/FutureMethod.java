import domain.Fibonacci;

import java.util.concurrent.*;

/**
 * @creator fanglc@anch.net
 * @createdTime 2020/11/11 18:54
 * @desc
 */
public class FutureMethod implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return Fibonacci.sum();
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        long start = System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(new FutureMethod());
        long result = future.get(1, TimeUnit.SECONDS);
        // 确保拿到result 并输出
        System.out.println("Future 异步计算结果为：" + result);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
        // 然后退出main线程
        executor.shutdown();
    }
}
