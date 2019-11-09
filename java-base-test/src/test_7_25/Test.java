package test_7_25;


import java.util.Arrays;

class MyData{
    int a = 10;
}
public class Test {

    public static void main(String[] args) {
        int b = 1;
        Integer c = 1;
        String d = "hello";
        int[] e = {1,2,3,4,5};
        MyData myData = new MyData();
        change(b,c,d,e,myData);
        System.out.println(b);     // 1
        System.out.println(c);     // 1
        System.out.println(d);     // hello
        System.out.println(Arrays.toString(e)); //[9,2,3,4,5]
        System.out.println(myData.a);// 11
    }

    private static void change(int b, Integer c, String d, int[] e, MyData myData) {
        b+=1;
        c+=1;
        d+="world";
        e[0] = 9;
        myData.a += 1;
    }
}
