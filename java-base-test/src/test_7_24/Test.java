package test_7_24;

public class Test {
    public static void main(String[] args) {
        int i = 2;
        int k = ++i;    // i=i+1=3  k=i=3
        int t = i+ ++i + i++; // t = 3+(3+1)+4    //++i 已经对i加一操作 所以后面是4 ------计算完成后i再加1

        System.out.println(i);// 5
        System.out.println(k);// 3
        System.out.println(t);// 11
        System.out.println("***************");
        int a = 2;
        int b = a++;
        int u = i+ ++i + i++;
        System.out.println(a);// 3
        System.out.println(b);// 2
        System.out.println(u);// 17
        System.out.println("***************");
        int e = 2;
        System.out.println(e++);// 2
        System.out.println(e);// 3
        System.out.println("***************");
        int r = 2;
        System.out.println(++r);// 3
        System.out.println(r);// 3
    }
}
