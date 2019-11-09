package 排列组合;

//AABBC 取3个，哪些取法
public class D {
    static void f(int[] a,int[] b,int k,int goal){
        if (goal == 0) {
            char c = 'A';
            for (int i=0;i<b.length;i++){
                 if (i==1) c = 'B';
                if (i==2) c = 'C';

                for(int j =0;j<b[i];j++){
                   System.out.print(c);
               }
            }
            System.out.println();
            return;
        }
        if (k>2)
            return;
        if (goal<0){
            return;
        }
        int min = Math.min(a[k],goal);
        for (int i=0;i<=min;i++){
            b[k]=i;
            f(a,b,k+1,goal-i);
            continue;
        }
    }


    public static void main(String[] args) {
        int[] a ={1,1,2};
        int[] b = new int[a.length];
        f(a,b,0,3);
    }
}
