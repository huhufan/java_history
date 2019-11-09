package test_7_25;

public class Test1 {

    static int s;
    int i;
    int j;

    {
        int i = 1;
        i++;
        j++;
        s++;
    }

    public void test(int j){
        j++;
        i++;
        s++;
    }

    public static void main(String[] args) {
        Test1 t1 = new Test1();// 构造代码块sij=000+101=101
        Test1 t2 = new Test1();// 构造代码块sij=100+101=201
        t1.test(10);   //t1->test方法sij=201+110=311
        t1.test(20);   //t1->test方法sij=311+110=421
        t2.test(30);   //t2->test方法sij=401+110=511    -->此时静态变量s变为5->t1->sij=521
        System.out.println(s+" "+t1.i+" "+t1.j);
        System.out.println(s+" "+t2.i+" "+t2.j);
    }
}
