import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class LCData{
    private int sum = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void produce() throws InterruptedException {
        lock.lock();
        try{
            while (sum != 0){
                condition.await();
            }
                sum++;
                System.out.println(Thread.currentThread().getName()+" \t++++生产一件  "+"\t剩余"+sum+"件");
                condition.signalAll();
        }
        finally {
            lock.unlock();
        }

    }
    public void consume() throws InterruptedException {
        lock.lock();
        try{
            while (sum == 0){
                condition.await();
            }
            sum--;
            System.out.println(Thread.currentThread().getName()+" \t----消费一件  "+"\t剩余"+sum+"件");
            condition.signalAll();
        }
        finally {
            lock.unlock();
        }

    }


}


public class LockCondition {
    public static void main(String[] args) {
        LCData data = new LCData();
        for(int i = 1 ; i<= 20 ; i++){
            new Thread(()->{
                try {
                    data.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
        for(int i = 21 ; i<=40 ; i++){
            new Thread(()->{
                try {
                    data.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }


}
