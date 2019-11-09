package 排列组合;

public class C {

    static void f(char[] a, int k){
        if (k == a.length - 1) {
            System.out.println(String.valueOf(a));
            return;
        }

        for (int i = k; i < a.length; i++) {
            {char t = a[k]; a[k]=a[i]; a[i]=t;}
            f(a,k+1);
            {char t = a[k]; a[k]=a[i]; a[i]=t;}
        }
    }

    public static void main(String[] args) {
        f("ABC".toCharArray(),0);
    }
}
