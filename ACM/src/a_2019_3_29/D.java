package a_2019_3_29;

public class D {
    static int min=Integer.MAX_VALUE;
    static boolean f = false;
    static void f(int[] a ,int k,int goal,int add,int minus,String s){
        if (k == a.length){
            System.out.println(s+"="+goal);
            if (Math.abs(goal)<min)
                min = Math.abs(goal);
            return;
        }
        f(a,k+1,goal+a[k],add+1,minus,s+"+"+a[k]);
        f(a,k+1,goal-a[k],add,minus+1,s+"-"+a[k]);
    }
    public static void main(String[] args) {
        int[] a = new int[]{1,3,8,9};
        f(a,0,0,0,0,"");
        System.out.println(min);
    }
}
//1 3  8 9
//2 1
//1

