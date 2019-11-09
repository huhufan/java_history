package 分治法与动态规划;

public class A {
    static int h(int[] a,int start,int end,int b){
        if (end - start == 1) {
            if (a[start]>b) return a[start];
            return a[end];
        }
        int z = (start+end)/2;
        if (a[z]>b)  return h(a,start,z,b);
        else  return h(a,z,end,b);


    }

    static int f(int[] a,int b){
        return h(a,0,a.length-1,b);
    }

    public static void main(String[] args) {
        int[] a ={1,3,4,6,23,31,42,56,71};
        System.out.println( f(a,57));
    }

}
