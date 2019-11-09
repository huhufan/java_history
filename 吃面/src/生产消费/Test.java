package 生产消费;

public class Test {
    public static void main(String[] args) {
        Account a=new Account();
        new Thread(new Put(a)).start();
        new Thread(new Use(a)).start();

    }
}
