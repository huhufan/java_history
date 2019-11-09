package 图;

import java.util.Scanner;


/**
 * 迷宫问题
 */
public class A {
    static int step = -1;
    static boolean f(char[][] e,int y,int x,int num,int yg,int xg){
            if (step!=-1&&num>=step)
                return false;
        if (y==yg&&x==xg){
            step = num;
            return true;
        }
        char old = e[y][x];
        e[y][x] = '*';
        boolean flag = false;
        try {
            if (y>0 && e[y-1][x]==0 && f(e,y-1,x,num+1,yg,xg)==true)         { flag = true;}
            if (y<yg && e[y+1][x]==0 && f(e,y+1,x,num+1,yg,xg) == true)      { flag = true; }
            if (x>0 && e[y][x-1]==0 && f(e,y,x-1,num+1,yg,xg) == true)       { flag = true; }
            if (x<xg && e[y][x+1]==0 && f(e,y,x+1,num+1,yg,xg) == true)      { flag = true; }
        }
        finally {
            e[y][x] = old;
        }
        return flag;
    }
    public static void main(String[] args) {

//        char[] a = {0,0,0,0,0,0};
//        char[] b = {0,1,0,1,0,0};
//        char[] c = {0,1,0,0,0,0};
//        char[] d = {0,1,0,1,0,0};
//        char[] g = {0,0,0,1,0,0};
//        char[] h = {0,0,1,0,0,0};
//
//        char[][] e = new char[6][6];
//        e[0] = a;e[1] = b;e[2] = c;e[3] = d;e[4] = g;e[5] = h;
        Scanner s = new Scanner(System.in);
        char[][] c = new char[21][];
        for (int i=0;i<21;i++){
            String str = s.nextLine();
            char[] d = str.toCharArray();
            c[i] = d;
        }

        f(c,0,0,0,31,20);
        System.out.println(step);


    }
}
