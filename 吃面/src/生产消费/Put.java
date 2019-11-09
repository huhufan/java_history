package 生产消费;

public class Put implements Runnable {

       private  Account a1;

    public Put(Account a1) {
        this.a1=a1;
    }

    @Override
    public void run() {
        while (true) {
            a1.put(1+(int)(Math.random()*10));
        }
    }
}
