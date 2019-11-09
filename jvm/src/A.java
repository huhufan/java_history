import java.util.Random;

public class A{
    private int sum=0;
    private int cur_num=1;
    private int cur_char=0;

    public synchronized void printNum() throws InterruptedException {
        while (sum==2){
            wait();
        }
        System.out.println("线程名称："+Thread.currentThread().getName()+"-------"+cur_num);
        cur_num++;
        sum++;
        notifyAll();
    }
    public synchronized void printChar() throws InterruptedException {
        while (sum!=2){
            wait();
        }
        System.out.println("线程名称："+Thread.currentThread().getName()+"-------"+(char)('A'+cur_char));
        cur_char++;
        sum=0;
        notifyAll();
    }

}
 class B {
     public static void main(String[] args) {
         A a = new A();
         new Thread(() -> {
               for (int i = 0;i<52;i++){
                   try {
                       a.printNum();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
         },"1").start();

         new Thread(() -> {
             for (int i = 0;i<26;i++){
                 try {
                     a.printChar();
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
         },"2").start();
     }


}
