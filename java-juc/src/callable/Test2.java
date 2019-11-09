package callable;


import jdk.internal.org.objectweb.asm.tree.InnerClassNode;

import java.sql.Time;
import java.util.concurrent.*;

class TT1 implements Runnable{
    @Override
    public void run() {
        System.out.println("i am Runnable");
    }
}

class TT2 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("i am Callable");
        return 1;
    }
}

public class Test2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor service = new ThreadPoolExecutor(1, 1, 2,
                TimeUnit.SECONDS, new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());


        Future<?> submit = service.submit(new TT2());
        System.out.println(submit.get());

        service.shutdown();





    }
}
