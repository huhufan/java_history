import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier  cyclicBarrier = new CyclicBarrier(6,()->{
            //此线程为 parties 为6的那个线程name
            System.out.println(Thread.currentThread().getName()+"  召唤神龙");
        });
        for(int i = 1 ; i <= 6 ;i++){
            new Thread(()->{
                try {
                    System.out.println(Thread.currentThread().getName()+"  收集到一棵龙珠");
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }

    }
}
