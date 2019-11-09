import java.util.Arrays;
import java.util.List;

class Father{
    private int age;
    String name;
    static String desc;

    public Father(int age, String name) {
        this.age = age;
        this.name = name;
    }

    static void eat(){
        System.out.println("father-eat");
    }
    private void say(){
        System.out.println("father-say");
    }
    public void sing(){
        System.out.println("father-sing");
    }
}

class Son extends Father{
    public Son(int age, String name) {
        super(age, name);
    }

    @Override
    public void sing() {
        super.sing();
    }
}
public class Main2 {

    public static void main(String[] args) throws InterruptedException {
       Son son = new Son(2,"大头儿子");
       son.sing();
    }
}
