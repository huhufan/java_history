package 生产消费;

public class Use implements Runnable {

       private  Account a1;

    public Use(Account a1) {
        this.a1=a1;
    }

    @Override
    public void run() {
        while (true) {
            a1.use(1+(int)(Math.random()*10));
        }
    }
}
