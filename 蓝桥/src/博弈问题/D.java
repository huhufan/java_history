package 博弈问题;

import java.util.HashMap;
import java.util.Scanner;

public class D {
    static char f(int[] a,int c,int d,int sum){
        if (sum<Math.min(a[0],Math.min(a[1],a[2]))){
            if (c%2!=0&&d%2==0) return '+';
            if (c%2==0&&d%2!=0) return '-';
            else return '0';
        }

        boolean ping = false;
        for (int i = 0; i < a.length; i++) {
            if (sum>=a[i]){
                switch (h(a,c+a[i],d,sum-a[i])){
                    case '-':return '+';
                    case '0':ping = true;
                }
            }
        }
        if (ping) return '0';
        return '-';
    }
    static char h(int[] a,int c,int d,int sum){
        if (sum<Math.min(a[0],Math.min(a[1],a[2]))){
            if (d%2!=0&&c%2==0) return '+';
            if (d%2==0&&c%2!=0) return '-';
            else return '0';
        }

        boolean ping = false;
        for (int i = 0; i < a.length; i++) {
            if (sum>=a[i]){
                switch (f(a,c,d+a[i],sum-a[i])){
                    case '-':return '+';
                    case '0':ping = true;
                }
            }
        }
        if (ping) return '0';
        return '-';
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
        for (int i=0;i<c.length;i++){
            System.out.print(f(a,0,0,c[i]));
        }

    }
}
