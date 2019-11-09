package a_4_2;

import java.util.Arrays;

/**
 * 风口之下，猪都能飞。当今中国股市牛市，真可谓“错过等七年”。 给你一个回顾历史的机会，已知一支股票连续n天的价格走势，以长度为n的整数数组表示，数组中第i个元素（prices[i]）代表该股票第i天的股价。 假设你一开始没有股票，但有至多两次买入1股而后卖出1股的机会，并且买入前一定要先保证手上没有股票。若两次交易机会都放弃，收益为0。 设计算法，计算你能获得的最大收益。 输入数值范围：2<=n<=100,0<=prices[i]<=100
 *
 * 输入例子1:
 * 3,8,5,1,7,8
 *
 * 输出例子1:
 * 12
 */
public class Pig_can_fly {
    public int f(int[] prices){
        int len = prices.length;
        int[][] a = new int[len<4?(len+1):5][len+1];
        if (len==1)
            return 0;
        if (len==2){
            return prices[1]-prices[0]>0?prices[1]-prices[0]:0;
        }
        if (len==3){
            int big = Math.max(prices[2]-prices[1],prices[2]-prices[0]);
            int big2 = Math.max(prices[1]-prices[0],0);
            return Math.max(big,big2);
        }
        for (int i = 1;i<a.length;i++){
            int ind = 1;
            if (i==2){
                ind=2;
            }
            else if (i==3){
                ind=3;
            }
            else if (i==4){
                ind=4;
            }
            for (int j=ind; j<a[0].length;j++){
                int[] a2 = Arrays.copyOfRange(a[i-1],i-1,j);
                Arrays.sort(a2);
                int big = a2[a2.length-1];
                if (i%2!=0){
                    a[i][j] = big-prices[j-1];
                }
                else{
                    int ss = big+prices[j-1];
                    a[i][j] = ss<0?0:ss;
                }
            }
        }
        int[] a2 = Arrays.copyOfRange(a[2],2,a[2].length-1);
        Arrays.sort(a2);
        int big = a2[a2.length-1];
        return Math.max(a[a.length-1][a[0].length-1],big);
    }

    static void show(int[][] a,int[] prices){
        System.out.print(" \t"+0);

        for (int j=0;j<prices.length;j++){
                System.out.print(" \t"+prices[j]);
            }
        System.out.println();
        for (int i = 0;i<a.length;i++){
            for (int j=0;j<a[1].length;j++){
                System.out.print(" \t"+a[i][j]);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
//        Pig_can_fly pog = new Pig_can_fly();
//        int[] prices = new int[]{29,63,75,4};
////        for (int i = 0;i<20;i++){
////            prices[i] = (int) (Math.random()*10);
////        }
//        System.out.println(pog.f(prices));

            int i;
            int j;
            int f=0;
            for(i=1;i<=100;i++){
                for(j=1;j<=100;j++){
                    if(i%j==0){
                        f++;
                    }
                }
                if (f<=2){
                    System.out.println(i+"  ");
                }
                f=0;
            }
        }


}
