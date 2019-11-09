package a_4_2;

import java.util.Scanner;

/**
 * 分苹果
 */
public class D {
    static int f(int sum,int k,int[] a,int pan){
        if (k==pan){
            if (sum==0)
                return 1;
            return 0;
        }
        int re =0;
        for (int i = sum;i>=0;i--){
            if (k==0){
                a[k]= i;
                re+=f(sum-i,k+1,a,pan);
            }
            else{
                if (i<=a[k-1]){
                    a[k]= i;
                    re+=f(sum-i,k+1,a,pan);
                }
            }
        }
        return re;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int sum = s.nextInt();
        int pan = s.nextInt();
        int[] a = new int[pan];
        System.out.println(f(sum,0,a,pan));
    }
}
