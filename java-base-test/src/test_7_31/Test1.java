package test_7_31;

import java.util.Stack;

public class Test1 {
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(null);
        s.push(null);
        System.out.println(s.empty());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());

    }
}
