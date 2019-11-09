package myPackage;

public class Outer {
    String name;
    public Outer(){

    }
     class Inner{
         String name;
         public Inner(){
             //空参构造方法
         }
         public void show(){
             System.out.println("I am a Inner_method!");
         }
    }

    public static void main(String[] args)
    {
        Outer outer = new Outer();
        Inner inner = outer.new Inner();
    }
}
