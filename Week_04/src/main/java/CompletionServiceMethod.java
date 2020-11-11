import domain.Fibonacci;

import java.util.concurrent.*;

/**
 * @creator fanglc@anch.net
 * @createdTime 2020/11/11 19:13
 * @desc
 */
public class CompletionServiceMethod {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        long start = System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CompletionService<Integer> completionService = new ExecutorCompletionService<>(executorService);
        // 异步执行 下面方法
        Future<Integer> future = completionService.submit(Fibonacci::sum);
        // 确保拿到result 并输出
        Integer result = future.get(1, TimeUnit.SECONDS);
        System.out.println("异步计算结果为：" + result);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
        // 然后退出main线程
    }
}
