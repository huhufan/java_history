import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                syn();
            }
        });

        thread.run();
        System.out.println("hello");
        thread.start();
        System.out.println("hello");
    }

    private static synchronized void syn() {
        System.out.println("java");
    }
}
