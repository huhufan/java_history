import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Data{
    private int i = 30;
    Lock lock = new ReentrantLock();

    public void sale(){
        lock.lock();
        try {
            if(i > 0){
                i--;
                System.out.println(Thread.currentThread().getName()+"\t--卖出一张--剩余\t"+i);
            }
        }
        finally {
            lock.unlock();
        }
    }
}

public class LockDemo {
    public static void main(String[] args) {
        Data data = new Data();
        for (int i  = 1 ; i <=50 ; i++){
            new Thread(()->{
                data.sale();
            },String.valueOf(i)).start();
        }

    }
}
