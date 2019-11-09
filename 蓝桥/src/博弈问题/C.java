package 博弈问题;


/**
 * 拿球输赢问题
 */
public class C {

    static boolean f(int n) {
        if (n==0) return true;

        if (n>=1 && f(n-1)==false) { System.out.print(1);return true; }
        if (n>=3 && f(n-3)==false) { System.out.print(3);return true; }
        if (n>=7 && f(n-7)==false) { System.out.print(7);return true; }
        if (n>=8 && f(n-8)==false) { System.out.print(8);return true; }

        return false;
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            System.out.println("**************************");
            System.out.println("--"+i+"--");
            System.out.println(f(i));
        }
    }
}
