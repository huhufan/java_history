package myPackage;

public class Test2 {
    public void test(final int a) {
        new Thread(){
            public void run() {
                System.out.println(a);
            };
        }.start();
    }
}