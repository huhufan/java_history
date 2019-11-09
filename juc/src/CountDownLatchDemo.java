import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {


    public static void main(String[] args) throws InterruptedException {
        //秦灭六国统一
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1 ; i <= 6 ; i ++ ){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+ "  国被灭");
                countDownLatch.countDown();
            },CountryData.getName(i)).start();
        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+ "  秦收复六国");


    }
}
