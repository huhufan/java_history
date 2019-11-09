package 博弈问题;


/**
 * 高僧斗法————尼姆堆问题
 */
public class G {
    static boolean h(int[] a){
        int sum = 0;
        for (int i = 0; i < a.length-1; i += 2) {
            sum ^= a[i+1]-a[i]-1;
        }
        return sum!=0;
    }
    static void f(int[] a){
        boolean e =false;
        for (int i = 0; i < a.length - 1; i++) {
            for (int k = a[i] + 1; k < a[i + 1]; k++) {
                int old = a[i];
                try {
                    a[i] = k;
                    if (h(a)==false){
                        System.out.println(old+" "+k);
                        e=true;
                        return;
                    }
                }
                finally {
                    a[i] = old;
                }
            }
        }
        if (!e) {
            System.out.println(-1);
        }
    }
    public static void main(String[] args) {
        int[] a={1,28};
        int[] b={1,5,8,10,18,46,89,211,500};
        f(b);
    }
}
