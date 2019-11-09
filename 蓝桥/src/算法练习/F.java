package 算法练习;

import java.util.ArrayList;
import java.util.Scanner;

public class F {

static int min;
static  ArrayList<String> r = new ArrayList();

    /**
     *
     * @param a 每次可以取的球的数量[]
     * @param b 先手拥有球数
     * @param c 后手拥有球数
     * @param d 总球数
     * @return
     */

    //先手
    static int f(int[] a,int b,int c,int d){
        if (d==min){
            f(a,b,c+min,d-min);
        }
        if (d<0) return 0;
        if (0<=d &&d<min){
            String e = judge(b,c);
            r.add(e);
            return 0;
        }
        if (b+a[0]%2!=0) h(a,b+a[0],c,d-a[0]);
        if (b+a[1]%2!=0) h(a,b+a[1],c,d-a[1]);
        if (b+a[2]%2!=0) h(a,b+a[2],c,d-a[2]);

        else {
            h(a,b+a[0],c,d-a[0]);
            h(a,b+a[1],c,d-a[1]);
            h(a,b+a[2],c,d-a[2]);
        }
        return 0;
    }
    //后手
    static int h(int[] a,int b,int c,int d){
        if (d==min){
            f(a,b+min,c,d-min);
        }
        if (d<0) return 0;
        if (0<=d &&d<min){
            String e = judge(b,c);
            r.add(e);
            return 0;
        }

        if (c+a[0]%2!=0) f(a,b,c+a[0],d-a[0]);
        if (c+a[1]%2!=0) f(a,b,c+a[1],d-a[1]);
        if (c+a[2]%2!=0) f(a,b,c+a[2],d-a[2]);

        else {
            f(a,b,c+a[0],d-a[0]);
            f(a,b,c+a[1],d-a[1]);
            f(a,b,c+a[2],d-a[2]);
        }
        return 0;
    }
    //奇数步
    static String judge(int a,int b){
        if (a % 2 != 0 && b % 2 == 0) return "+";
        if (a % 2 == 0 && b % 2 != 0) return "-";
        else return "0";
    }
    static int min(int[] a){
        int b = Math.min(a[0],Math.min(a[1],a[2]));
        return b;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] a = new int[3];
        int[] c = new int[5];

        for (int i = 0; i < 8; i++) {
            int b = s.nextInt();
            if (i >= 3) c[i - 3] = b;
            else a[i] = b;
        }
        min = min(a);

        for (int j = 0; j < c.length; j++) {
            f(a,0,0,c[j]);
            if (r.contains("+")) System.out.print("+");
            else if (r.contains("0")) System.out.print("0");
            else if (r.contains("-")) System.out.print("-");
            r.clear();
        }
    }
}
