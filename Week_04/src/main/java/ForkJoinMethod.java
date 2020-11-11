import domain.Fibonacci;

import java.util.concurrent.*;

/**
 * @creator fanglc@anch.net
 * @createdTime 2020/11/11 18:55
 * @desc
 */
public class ForkJoinMethod {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        long start = System.currentTimeMillis();
        ForkJoinTask<Integer> forkJoinTask = ForkJoinPool.commonPool().submit(Fibonacci::sum);
        Integer result = forkJoinTask.get(1, TimeUnit.SECONDS);
        // 确保拿到result 并输出
        System.out.println("ForkJoin 异步计算结果为：" + result);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
        // 然后退出main线程
    }
}
