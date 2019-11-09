package 排列组合;

import 算法练习.I;

import java.util.*;

public class Z {

   static List<Integer> re = new ArrayList<Integer>();
    static void f(int sum,int n){
        if (n == 0) {
            re.add(sum);
            return;
        }
        for (int i = 1;i<7;i++){
            f(sum+i,n-1);
        }

    }
    public static void main(String[] args) {
        Map<Integer,Integer> re2 = new HashMap<>();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        f(0,n);
        for (int c:re)
            System.out.print(c+" ");
        System.out.println();
        for (int c:re){
            if (re2.containsKey(c))
                re2.put(c,re2.get(c)+1);
            else
                re2.put(c,1);
        }
        Integer total = re.size();
        for (Map.Entry r:re2.entrySet()){
            double chance = (int)r.getValue()/(double)total;
            System.out.println("值:"+r.getKey()+"   概率:"+chance);
        }
    }
}
