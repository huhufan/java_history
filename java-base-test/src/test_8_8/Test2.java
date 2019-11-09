package test_8_8;

/**
 * @auther hu  .
 * @create 2019/9/2
 */
public class Test2 {
    public static void f(){
        try{
            int a = 2/0;
        }
        catch (ArithmeticException e) {
            System.out.println("ArithmeticException ");
        }
        catch (Exception e){
            System.out.println("ArithmeticException " );
        }

    }

    public static void main(String[] args) {
        f();
        String a = "22";
    }

}
