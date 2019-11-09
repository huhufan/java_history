package 链表;

public class A {
    private String name;
    private int age;

    public A(String name ,int age){
        this.name = name;
        this.age = age;
    }


    public static void main(String[] args) {
        A a = new A("HAHA",3);
        A aa = a;
        aa.name = "eee";
        System.out.println(aa+"  "+a);
        System.out.println(a.name);
    }
}
