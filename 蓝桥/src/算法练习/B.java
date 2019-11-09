package 算法练习;

public class B {
    static int f(int a,int b){
        if (a==b) return 0;
        System.out.println(b);
        return f(a,b-1);
    }
    public static void main(String args[]){
        System.out.println(f(1,10));
    }
}
