package 排列组合;

public class F {
    static void show(int[] a){
        for (int c:a)
            System.out.print(c+" ");
        System.out.println();
    }
    static void f(int[] a,int b[],int start,int k){
        if (k==2){
            show(b);
            return;
        }
        for (int i=start;i<a.length;i++){
            b[k] = a[i];
            f(a,b,i+1,k+1);
        }
        return;
    }
    public static void main(String[] args) {
        int[] a = {1,2,3};
        int[] b = new int[2];
        f(a,b,0,0);


    }
}
