package 算法练习;



public class D {
    static int f(int a, int b) {
        System.out.print(a+";"+b+"--  ");
        if (a==0) return 1;
        if (b==0) return f(a-1,1);
        return f(a-1,b+1) + f(a,b-1);
    }

    static int f(int n){
        return f(n,0);
    }

    public static void main(String[] args) {
//        for (int i = 1; i < 17; i++) {
            System.out.println(3+" : "+f(3));
//        }
    }
}
