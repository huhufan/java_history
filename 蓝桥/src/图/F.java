package 图;

import java.util.*;

public class F {
    static void f(Set<String> re,int[] a){
        for (int i=a[0];i<a[2];i++){
            for (int j=a[1];j<a[3];j++){
                re.add(i+","+j);
            }
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        List<int[]> b = new ArrayList<>();
        for (int i =0;i<a;i++){
            int [] c = new int[4];
            for (int j=0;j<4;j++){
                c[j] = s.nextInt();
            }
            b.add(c);
        }
        Set re = new HashSet();
        for (int z = 0; z < b.size(); z++) {
                f(re,b.get(z));
        }
        System.out.println(re.size());
    }
}
