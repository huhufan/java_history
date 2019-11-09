package 算法练习;
//取球博弈
//        两个人玩取球的游戏。
//        一共有N个球，每人轮流取球，每次可取集合{n1,n2,n3}中的任何一个数目。
//        如果无法继续取球，则游戏结束。
//        此时，持有奇数个球的一方获胜。
//        如果两人都是奇数，则为平局。
//
//        假设双方都采用最聪明的取法，
//        第一个取球的人一定能赢吗？
//        试编程解决这个问题。
//
//        输入格式：
//        第一行3个正整数n1 n2 n3，空格分开，表示每次可取的数目 (0<n1,n2,n3<100)
//        第二行5个正整数x1 x2 ... x5，空格分开，表示5局的初始球数(0<xi<1000)
//
//        输出格式：
//        一行5个字符，空格分开。分别表示每局先取球的人能否获胜。
//        能获胜则输出+，
//        次之，如有办法逼平对手，输出0，
//        无论如何都会输，则输出-

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.ArrayList;
import java.util.Scanner;

public class E {
    static int layer = -2;
    static boolean flag = true;
    static ArrayList<Integer[]> result = new ArrayList();
    static ArrayList<Integer> r = new ArrayList();
    static int start = 0;

    static int f(int a, int b,int[] c) {
        if (b < 0) {
            return 1;
        }
        if (b >= 0) {
            if (flag) layer++;
            flag = true;
            if (layer != -1) {
                if (layer+1 > r.size()) {
                    r.add(layer, a);
                } else {
                    r.set(layer, a);
                }
            }
            //System.out.println("层数: "+layer+"---- 取的数量"+a);
        }
        if (b == 0) {
            Integer[] v = new Integer[r.size()];
            for (int i = 0; i < r.size(); i++) {
                v[i] = r.get(i);
                System.out.print(v[i]);
            }
            System.out.println();
            result.add(v);
            start++;
            if (layer!=0){
                r.remove(layer);
            }
            if (layer!=0)
            layer--;
            flag = false;
            return 1;
        }
        return f(c[0], b - c[0],c) + f(c[1], b - c[1],c) + f(c[2], b - c[2],c);
    }

    static char check(Integer[] a) {
        if (a.length==0)
            return '平';
        int c = 0, d = 0;
        for (int i = 0; i < a.length; i++) {
            if (i % 2 == 0) c += a[i];
            else d += a[i];
        }
        if (c % 2 != 0 && d % 2 == 0) return '胜';
        if (c % 2 == 0 && d % 2 != 0) return '输';
        else return '平';
    }

    static char twoCheck(ArrayList a) {
        boolean flag = true;
        for (int i = 0; i < a.size(); i++) {
            if (check(result.get(i)) == '胜') {
                return '+';
            }
            if (check(result.get(i)) == '平') {
                flag = false;
            }
        }
        if (!flag) {
            return '0';
        } else {
            return '-';
        }
    }


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] a = new int[3];
        int[] c = new int[5];

        for (int i = 0; i < 8; i++) {
            int b = s.nextInt();
            if (i >= 3) c[i - 3] = b;
            else a[i] = b;
        }
        for (int j = 0; j < c.length; j++) {
            f(0,c[j],a);
            char c1 = twoCheck(result);
            layer = -2;
            flag = true;
            result = new ArrayList();
            r = new ArrayList();
            start = 0;
            System.out.print(c1);
        }
    }
}


