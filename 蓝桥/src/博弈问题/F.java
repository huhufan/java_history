package 博弈问题;

import java.awt.event.KeyAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class F {
    static int[] result = new int[100];
    static int f(int[] a,int k) {
        boolean d =false;
        for (int c = 0; c < a.length-1; c++) {
            if (a[c]+1!=a[c+1]) {
                d=true;
                break;
            }
        }
        if (!d) {
            return -1;
        }

        for (int i = 0; i < a.length-1; i++) {
            for (int j=1;j<(a[i+1]-a[i]);j++){
                try {
                    a[i]=a[i]+j;
                    switch (f(a,k+1)){
                        case -1:
                            if (k==0){
                                result[i]=a[i];
                            }
                            return 1;
                        case 1:
                            continue;
                    }
                }
                finally {
                    a[i]=a[i]-j;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int [] a = new int[100];
        String e ="";
        int n=0;
        String c = s.nextLine();
        for (int i = 0; i < c.length(); i++) {
            char d =c.charAt(i);
            if (i==c.length()-1){
                e+=d;
                a[n]=Integer.valueOf(e);
            }
            if (d==' ') {
                a[n]=Integer.valueOf(e);
                n++;
                e="";
            }
            else {
                e+=d;
            }
        }
        int [] d =new int[n+1];
        for (int t = 0; t <= n; t++) {
            d[t]=a[t];
        }

        f(d,0);

        for (int r=0;r<result.length;r++){
            if (result[r]!= 0) {
                System.out.println(r+1+" "+result[r]);
                ;break;
            }
        }

    }
}
