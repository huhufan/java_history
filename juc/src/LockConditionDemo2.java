import sun.awt.windows.ThemeReader;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class LCData2{
    private int i = 1;
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void aPrint() throws InterruptedException {
        lock.lock();
        try {
            while (i!=1){
                c1.await();
            }
            System.out.println(Thread.currentThread().getName()+"-------A--------");
            i = 2;
            c2.signal();
        }finally {
            lock.unlock();
        }
    }
    public void bPrint() throws InterruptedException {
        lock.lock();
        try {
            while (i!=2){
                c2.await();
            }
            System.out.println(Thread.currentThread().getName()+"-------B--------");
            i = 3;
            c3.signal();
        }finally {
            lock.unlock();
        }
    }
    public void cPrint() throws InterruptedException {
        lock.lock();
        try {
            while (i!=3){
                c3.await();
            }
            System.out.println(Thread.currentThread().getName()+"-------C--------");
            i = 1;
            c1.signal();
        }finally {
            lock.unlock();
        }
    }


}
public class LockConditionDemo2 {
    public static void main(String[] args) {
        LCData2 data2 = new LCData2();
        for (int i = 0 ; i < 10 ; i ++ ){
            new Thread(() -> {
                try {
                    data2.aPrint();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "AA").start();
        }
        for (int i = 0 ; i < 10 ; i ++ ){
            new Thread(()->{
                try {
                    data2.bPrint();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"BB").start();
        }
        for (int i = 0 ; i < 10 ; i ++ ){
            new Thread(()->{
                try {
                    data2.cPrint();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"CC").start();
        }
    }
}
