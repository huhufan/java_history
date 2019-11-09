package 图;

import java.util.HashSet;
import java.util.Set;

public class D {

    static int  f(char[][] data, Set from,String goal){
        if (from.contains(goal)) return 0;

        Set set = new HashSet();
        for (Object obj : from) {
            String [] ss = ((String)obj).split(",");
            int y = Integer.valueOf(ss[0]);
            int x = Integer.valueOf(ss[1]);
            if (y>0 && data[y-1][x]=='0') {
                data[y-1][x]='*';
                set.add(y-1+","+x);
            }if (y<data.length-1 && data[y+1][x]=='0') {
                data[y+1][x]='*';
                set.add(y+1+","+x);
            }if (x>0 && data[y][x-1]=='0') {
                data[y][x-1]='*';
                set.add(y+","+(x-1));
            }if (x<data[0].length-1 && data[y][x+1]=='0') {
                data[y][x+1]='*';
                set.add(y+","+(x+1));
            }
        }
            if (set.isEmpty()) return -1;
            int r = f(data,set,goal);
            if (r<0) return -1;
            return r+1;
    }

    public static void main(String[] args) {
        char[] a = {'0','0','0','0','0','1'};
        char[] b = {'0','1','0','1','0','1'};
        char[] c = {'0','1','0','1','0','1'};
        char[] d = {'0','1','0','1','0','1'};
        char[] g = {'0','1','0','1','0','1'};
        char[] h = {'0','0','0','1','0','0'};

        char[][] e = new char[6][6];
        e[0] = a;e[1] = b;e[2] = c;e[3] = d;e[4] = g;e[5] = h;
        Set set = new HashSet();
        set.add("0,0");
        System.out.println(f(e,set,"5,5"));
        System.out.println();
    }
}
