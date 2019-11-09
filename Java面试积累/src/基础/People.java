package 基础;

public  abstract class People{
    private String name;
    private int age;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //抽象方法必须被子类实现
    public  abstract void run();

    public  void eat(){
        System.out.println("我能吃");
    }

    public static void main(String[] args) {
      Universe universe = new Universe();
        Universe.Earth e  =universe.new Earth();
    }
}
