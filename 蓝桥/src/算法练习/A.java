package 算法练习;

public class A {

    static String f(String s){
        if(s.length()<=1) return s;
        return f(s.substring(1)) + s.charAt(0);
    }


    public static void main(String args[]){
        System.out.println(f("abcde"));

    }
}
