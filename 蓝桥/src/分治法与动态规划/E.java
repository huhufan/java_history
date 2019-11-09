package 分治法与动态规划;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class E {
    static Set<int[]> s = new HashSet();
    static void f(int[] a,int[] b,int cur,int k){
        if (k==5){
            s.add(b.clone());
            return;
        }
        for (int i = cur; i < a.length; i++) {
             b[k] = a[i];
             f(a,b,i+1,k+1);
        }
    }
    static boolean check_detail(List<Integer> y,List<Integer> x,int a,int b){
        List e1 = new ArrayList();
        List e2 = new ArrayList();
        for (int i = 0; i < y.size(); i++) {
            if (y.get(i) == a)
                e1.add(x.get(i));
            if (y.get(i) == b)
                e2.add(x.get(i));
        }
        e1.retainAll(e2);
        if (e1.isEmpty())
            return false;
        return true;
    }
    static boolean check(List<Integer> y,List<Integer> x) {
        if (!y.contains(1)) return false;

        if (x.contains(0)&&!x.contains(1)) return false;
        if (x.contains(1)&&!(x.contains(0)||x.contains(2))) return false;
        if (x.contains(2)&&!(x.contains(1)||x.contains(3))) return false;
        if (x.contains(3)&&!x.contains(2)) return false;

        if (y.contains(0) && y.contains(1)&&!check_detail(y,x,0,1)) return false;
        if (y.contains(1) && y.contains(2)&&!check_detail(y,x,1,2)) return false;
        if (x.contains(0) && x.contains(1)&&!check_detail(x,y,0,1)) return false;
        if (x.contains(1) && x.contains(2)&&!check_detail(x,y,1,2)) return false;
        if (x.contains(2) && x.contains(3)&&!check_detail(x,y,2,3)) return false;
        return true;
    }


    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9,10,11,12};
        int[] b = new int[5];
        int sum = 0;
        f(a,b,0,0);
        for (int[] d:s) {
            List<Integer> y = new ArrayList<>();
            List<Integer> x = new ArrayList<>();
            for (int i = 0 ;i<d.length;i++){
                y.add((int)(d[i]/4.5));
                x.add((d[i]-1)%4);
            }
            if (check(y,x)){
                sum++;
            }
        }
        System.out.println(sum);
    }
}
