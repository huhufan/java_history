package callable;

import java.util.concurrent.*;

//class Thread implements Runnable
class T1 extends Thread {
    @Override
    public void run() {
        System.out.println("我是T1的run方法");
    }
}

class T2 implements Runnable {
    @Override
    public void run() {
        System.out.println("我是T2的run方法");
    }
}

class T3 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("我是T3的call方法，我有返回值");
        return 99;
    }
}

class T4 implements Runnable {
    @Override
    public void run() {
        System.out.println("我是线程池调用的run方法");
    }
}

public class MyThread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         * 创建线程的四种方法
         */

        // 1--继承Thread类，Thread实现了Runnable接口，但由于一类一继承制，并不推荐使用
        Thread t1 = new Thread(new T1(), "T1");
        t1.start();
        // 1--直接实现Runnable接口，推荐使用，并且可以创建线程的时候使用Lamda表达式
        Thread t2 = new Thread(new T2(), "T2");
        t2.start();

        //  interface RunnableFuture<V> extends Runnable, Future<V>
        // class FutureTask<V> implements RunnableFuture<V>
        // 3--实现Callable接口，该方法有返回值，可抛出异常
        //   适用场景：1：对于一个比较消耗CPU时间的计算任务，主线程启动一个FutureTask子线程去执行，主线程继续执行其他任务，当主线程需要子线程的计算结果时，再异步获取子线程的执行结果
        //            2: FutureTask确保即使调用了多次run方法，它只会执行一次Runnable或Callable任务，或者通过cancel取消执行。执行一次后就保持在运算完成的状态而不会回滚。
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new T3());
        futureTask.run();
        System.out.println("返回值为：" + futureTask.get());


        /** 3--线程池
         * 线程池的submit和execute方法区别：1、接受的参数不一样，都可以是Runnable,但submit也可以是Callable
         *                                2、submit有返回值Future<> ，而execute没有
         *                                3、submit方便Exception处理
         */

        ExecutorService executorService = new ThreadPoolExecutor(1, 1, 2,
                TimeUnit.SECONDS, new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());
        Future<Integer> submit = executorService.submit(new T3());
        System.out.println("我是线程池调用的实现Callable接口的方法的返回结果：" + submit.get());
        executorService.shutdown();

    }

}
