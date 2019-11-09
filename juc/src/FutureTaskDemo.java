import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

class FTDara implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        TimeUnit.SECONDS.sleep(4);
        return 200;
    }
}
public class FutureTaskDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new FTDara());
        new Thread(futureTask,"AA").start();
        System.out.println(Thread.currentThread().getName()+"运行");
        Integer res = futureTask.get();

        System.out.println("result: "+res);
    }


}
