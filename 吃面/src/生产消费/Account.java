package 生产消费;

public class Account {
   volatile private int value;
   volatile private boolean isHave=false;

    synchronized void put(int i) {
        while(isHave){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        value=value+i;
        System.out.println("生产"+i+"件，剩余"+value+"件");
        isHave=true;
        notifyAll();
    }
    synchronized void use(int i) {
        while(!isHave){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (value>=i){
            value=value-i;
            System.out.println("消费"+i+"件，剩余"+value+"件");

        }
        else{
            isHave=false;
        }
        notifyAll();

    }
}
