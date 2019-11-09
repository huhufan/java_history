import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        try {
           for(int i = 0 ; i<15;i++){
               Future<Integer> future = executor.submit(() -> {
                   System.out.print(Thread.currentThread().getName() + " 执行了业务   回执单：");
                   return new Random().nextInt(10);
               });
               System.out.println(future.get() );
           }
        }
        finally {
            executor.shutdown();
        }
    }
}
