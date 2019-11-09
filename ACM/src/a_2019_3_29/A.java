package a_2019_3_29;

import java.util.Scanner;

public class A {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //String a = s.nextLine();


//        int a1=Integer.valueOf(a.substring(0,1));
//        int a2=Integer.valueOf(a.substring(2,3));
        int a1 =s.nextInt();
        int a2 =s.nextInt();

        int[] b = new int[a1+a2+1];
        //String c = s.nextLine();
       for (int i = 0; i < b.length; i++) {
            b[i]=s.nextInt();
        }

        System.out.println();
    }
}
