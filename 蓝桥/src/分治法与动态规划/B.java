package 分治法与动态规划;

public class B {

    static int h(int[] a,int begin,int end){
        if (end-begin==1){
            if (a[begin]>0) return a[begin];
            return 0;
        }
        int k =(begin+end)/2;
        int t1 = h(a,begin,k);
        int t2 = h(a,k,end);

        int t3a = 0;
        int sum = 0;
        for (int i=k-1;i>=begin;i--){
            sum+=a[i];
            if (sum>t3a) t3a = sum;
        }
        int t3b = 0;
        sum = 0;
        for (int i=k;i<end;i++){
            sum+=a[i];
            if (sum>t3b) t3b = sum;
        }

        int t3 = t3a+t3b;

        int max = 0;
        if (t1>max) max = t1;
        if (t2>max) max = t2;
        if (t3>max) max = t3;

        return max;
    }
    static int f(int[] a){
        return h(a,0,a.length);
    }
    public static void main(String[] args) {
        System.out.println(f(new int[] {2,4,-7,5,2,-1,2,-4,3}));
    }
}
