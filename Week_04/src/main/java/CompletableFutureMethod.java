import domain.Fibonacci;

import java.util.concurrent.*;

/**
 * @creator fanglc@anch.net
 * @createdTime 2020/11/11 19:17
 * @desc
 */
public class CompletableFutureMethod {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        long start = System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        // 异步执行 下面方法
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(Fibonacci::sum, executorService);
        int result = future.get(1, TimeUnit.SECONDS); //这是得到的返回值
        // 确保拿到result 并输出
        System.out.println("异步计算结果为：" + result);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
        // 然后退出main线程
    }
}
