package 图;

import 算法练习.I;

import java.util.ArrayList;
import java.util.Scanner;

public class B {

    static ArrayList<ArrayList> re = new ArrayList<>();

    static void show (ArrayList<Integer> s){
        for (int d:s)
            System.out.print(d+" ");
    }

    static void h(int[] a1,int[] a2,ArrayList<Integer> b,int f,int goal){
        if (a2[f]==goal){
            ArrayList<Integer> o = new ArrayList<>();
            o.addAll(b);
            re.add(o);
//            show(b);
//            System.out.print(goal);
//            System.out.println();
            return;
        }
        f(a1,a2,b,0,a2[f],goal);
    }

    static void f(int[] a1,int[] a2,ArrayList<Integer> b,int f,int start,int goal){
        for (int i = 0;i<a1.length;i++){
            if (a1[i]==start){
                b.add(start);
                h(a1,a2,b,i,goal);
                b.remove(b.size()-1);
            }
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        int[] a1 = new int[b];
        int[] a2 = new int[b];
        for (int i=0;i<b;i++){
            a1[i] = s.nextInt();
            a2[i] = s.nextInt();
        }
        int start = s.nextInt();
        int end = s.nextInt();
//        int[] a1 ={1,2,3,3,4,5};
//        int[] a2 ={3,3,4,5,5,6};
//        int start = 1;
//        int end = 6;
        ArrayList<Integer> r = new ArrayList();
        f(a1,a2,r,0,start,end);
        for (int i =0;i<re.size();i++){
            re.get(0).retainAll(re.get(i));
        }
        System.out.println(re.get(0).size()-1);

    }
}
