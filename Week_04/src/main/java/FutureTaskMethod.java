import domain.Fibonacci;

import java.util.concurrent.*;

/**
 * @creator fanglc@anch.net
 * @createdTime 2020/11/11 18:53
 * @desc
 */
public class FutureTaskMethod {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        long start = System.currentTimeMillis();
        FutureTask<Integer> futureTask = new FutureTask<>(Fibonacci::sum);
        new Thread(futureTask).start();
        Integer result = futureTask.get(1, TimeUnit.SECONDS);
        // 确保拿到result 并输出
        System.out.println("FutureTask 异步计算结果为：" + result);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
        // 然后退出main线程
    }
}


