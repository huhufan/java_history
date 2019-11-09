package package_5_24;

public class Test2 {
    public static void main(String[] args) {
        Integer a = new Integer(1);
        Integer b = new Integer(1);
        System.out.println(a==b);

        Integer c = 2;
        Integer d = 2;
        System.out.println(c==d);

        Integer e = 128;
        Integer f = 128;
        System.out.println(e==f);

        int aa = 1;
        System.out.println(aa==a);
        int cc = 2;
        System.out.println(cc==c);

        int ee = 128;
        System.out.println(ee==e);

        Integer aaa = 1;
        System.out.println(aaa==a);

    }
}
