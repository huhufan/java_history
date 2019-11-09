package test_7_24;

class Animal{
    public Animal(){
        System.out.println("这是父类的--构造方法");
    }
    {
        System.out.println("这是父类的--构造代码块");
    }
    static {
        System.out.println("这是父类的--静态代码块");
    }
}
class Cat extends Animal{
    public Cat(){
        System.out.println("这是子类--猫的--构造方法");
    }
    {
        System.out.println("这是子类--猫的--构造代码块");
    }
    static {
        System.out.println("这是子类--猫的--静态代码块");
    }
}

class Dog extends Animal{
    public Dog(){
        System.out.println("这是子类--狗的--构造方法");
    }
    {
        System.out.println("这是子类--狗的--构造代码块");
    }
    static {
        System.out.println("这是子类--狗的--静态代码块");
    }
}

public class Test1 {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
    }
}
