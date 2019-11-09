package a_4_2;

import java.util.Scanner;


public class A {
    static void f(char[] a){
        for (int i=0;i<a.length;i++){
            System.out.print(a[i]);
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int sum = 0;

        int a = s.nextInt();
        for (int i = 0;i<a;i++){
            int b = s.nextInt();
            sum+=b;
        }
        System.out.println((sum-3)/2+1);
        }
}
