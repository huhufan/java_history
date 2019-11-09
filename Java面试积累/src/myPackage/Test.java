package myPackage;

public class Test {

    public void show(){
        final int a = 1;  //加final 或 不加final且保证不修改 即不报错
        new Thread(){
            public void run(){
                System.out.println(a);
            };
        }.start();
    }

    public static void main(String[] args) {

    }
}
