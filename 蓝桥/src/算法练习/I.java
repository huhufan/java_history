package 算法练习;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class I {

    static int have(int[] a ,int b) {
        for (int i =b-1;i>=0;i--){
            if (a[i]==a[b]) return i;
        }
        return -1;
    }

    static int num(int[] a,int b,int c) {
        ArrayList e = new ArrayList();
        int d = 0;
        for (int i=b-1;i>=c+1;i--){
            if (!e.contains(a[i])) e.add(a[i]);
        }
        return e.size();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b[] = new int[a];
        for (int i=0;i<a;i++){
            int c = s.nextInt();
            b[i]=c;
        }
        int[] c = new int[b.length];
        for (int i=0;i<b.length;i++){
            int h1 = have(b, i);
            if (h1==-1) c[i]=-b[i];
            else {
              int num = num(b,i,h1);
              c[i]=num;
            }
        }

        for (int i:c){
            System.out.print(i+" ");
        }

    }
}
