package package_5_24;


import java.util.ArrayList;
import java.util.List;

public class Person{
    public static void main(String[] args) {
         Person p1 = new Person();
         Person p2 = new Person();
         System.out.println("p1==p2的结果是： "+(p1==p2 ));

         List l1 = new ArrayList();
         List l2 = new ArrayList();
         System.out.println("l1==l2的结果是： "+(l1==l2 ));
    }
}

