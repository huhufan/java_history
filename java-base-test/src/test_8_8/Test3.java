package test_8_8;

/**
 * @auther hu  .
 * @create 2019/9/2
 */
public class Test3 {
    public static void main(String[] args) {
        Thread smart = new Thread(() -> {
            try { Thread.sleep(3000);} catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println(Thread.currentThread().getName() + " start");
        }, "smart");

        Thread big = new Thread(() -> {
            /**
             * 如果smart线程join 2s,给smart线程2s的执行时间
             * smart线程sleep 3s，所以打印语句还没有打印，即执行时间完毕，big线程被调度起执行
             *
             */
            //try { smart.join(2000); } catch (InterruptedException e) { e.printStackTrace(); }
            try { smart.join(); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println(Thread.currentThread().getName() + " start");
        }, "big");

        smart.start();
        big.start();
    }
}
