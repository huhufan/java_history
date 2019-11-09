package a_4_2;

public class C {
    public static void main(String[] args) {
        for (int a = 3;a>=0;a--){
            for (int b = 3;b>=0;b--){
                for (int c = 3;c>=0;c--){
                    if (a+b+c==3&&b<=a&&c<=b)
                        System.out.println(a+"+"+b+"+"+c+"="+3);
                }
            }
        }
    }
}
