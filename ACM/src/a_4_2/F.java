package a_4_2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class F {
    /**
     * 数组中三个数相加得 零 的组合
     */
    static Set<String> s = new HashSet<String>();
    static void f(int[] a,int k,int creIndex,int[] re){
        if (k==3){
            if (re[0]+re[1]+re[2]==0){
                int[] b = re.clone();
                Arrays.sort(b);
                s.add("["+b[0]+","+b[1]+","+b[2]+"]");
            }

            return;
        }
       for (int i=creIndex+1;i<a.length;i++){
           re[k]=a[i];
           f(a,k+1,i,re);
       }
    }
    public static void main(String[] args) {
        int[] a = {-1,0,1,2,-1,-4};
        int[] b = new int[3];
        f(a,0,-1,b);
        for (String re:s){
            System.out.println(re);
        }
    }
}
