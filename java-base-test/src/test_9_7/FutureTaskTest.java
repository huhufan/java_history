package test_9_7;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @auther hu  .
 * @create 2019/9/7
 */
public class FutureTaskTest {
    public static void main(String[] args) {
        FutureTask futureTask = new FutureTask(() -> {
            System.out.println(Thread.currentThread().getName());
        }, 1);

        new Thread(futureTask).start();
        new Thread(futureTask).start();

        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
    /**
     * 输出
     * Thread-0
     * 1
     */


}
