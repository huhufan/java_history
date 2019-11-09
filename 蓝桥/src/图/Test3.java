package 图;

public class Test3 {
    static void f(int a,int k){
        if (a<3) {
            System.out.println(k);
            return ;
        }
        if (a>=3) f(a-2,k+1);

    }
    public static void main(String[] args) {
        int a = 6;
        f(a,a);

    }


}
