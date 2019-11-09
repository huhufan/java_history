package 图;

import java.util.HashSet;
import java.util.Set;

/**
 ** 分酒问题
 */
public class E {
    static int f(Set<int[]> set,int[] goal,int[] stan) {
        for (int[] c : set) {
            boolean p = true;
            for (int e =0;e<c.length;e++){
                if (c[e]!=goal[e]){
                    p = false;
                    break;
                }
            }
            if (p)
                return 0;

        }
            Set<int[]> s = new HashSet();
        for (int[] c : set) {
            for (int j = 0; j < goal.length; j++) {
                     if (c[j]==0) continue;
                for (int k = 0; k < goal.length; k++) {
                         if (k==j)
                             continue;

                    if (c[j] <= stan[k] - c[k]) {
                        int[] re = c.clone();
                        re[j] = 0;
                        re[k] = c[k] +c[j];
                        s.add(re);
                    }
                    if (c[j] > stan[k] - c[k]) {
                        int[] re = c.clone();
                        re[j] = c[j]-(stan[k] - c[k]);
                        re[k] = stan[k];
                        s.add(re);
                    }
                }
            }
        }
        if (s.isEmpty()) return -1;
        int r = f(s,goal,stan);
        if (r<0) return -1;
        return r+1;

    }
    public static void main(String[] args) {
        int[] start = {9,0,0,0};
        int[] goal =  {7,1,1,0};
        int[] stan =  {9,7,4,2};
        Set s = new HashSet();
        s.add(start);
        System.out.println(f(s,goal,stan));

    }
}
