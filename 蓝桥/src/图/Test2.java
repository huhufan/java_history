package 图;

import java.util.Vector;

public class Test2 {
    public static int f(int n, int m)
    {
        n = n % m;
        Vector v = new Vector();


        for(;;)
        {
            v.add(n);
            n *= 10;
            n = n % m;
            if(n==0) return 0;
            if(v.indexOf(n)>=0) System.out.println(v.indexOf(n));; //填空
        }
    }

    public static void main(String[] args) {
        System.out.println(f(11,13));
    }
}
