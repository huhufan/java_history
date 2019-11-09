package 基础.测试;

public class Outer {
    String name;

     class Inner{
         String name;

         public void show(){
             System.out.println("I am a method!");
         }
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
    }
}
