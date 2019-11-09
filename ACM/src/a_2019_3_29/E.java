package a_2019_3_29;

import java.util.Arrays;

public class E {
    static int f(int[] a,int min){
        int[][] re = new int[a.length+1][min+1];
        for(int i =1;i<=a.length;i++){
            for(int j =1;j<=min;j++){
                if (a[i-1]>j)
                    re[i][j] = re[i-1][j];
                else{
                    re[i][j] = Math.max(re[i-1][j-a[i-1]]+a[i-1],re[i-1][j]);
                }
            }
        }
        for (int s = 0;s<re.length;s++){
            for (int b= 0;b<min+1;b++){
                if (s == 0 ){
                    re[s][b] = b;
                }
                if (b == 0 ){
                    re[s][b] = s;
                }
                System.out.print("\t"+re[s][b]+" ");
            }
            System.out.println();
        }
        return re[a.length][min];
    }
    public static void main(String[] args) {
        int in = 10;
        int[] a = new int[in];
        int sum = 0;
        for (int i =0;i<in;i++){
            a[i]= (int) (Math.random()*10);
            System.out.print(a[i]+" ");
            sum+=a[i];
        }
        System.out.println();
        int ave = sum/2;
        int re = f(a,ave);
        System.out.println(sum-2*re);
    }

}
