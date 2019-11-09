package 分治法与动态规划;

public class F {


    static int num;
    static void h(int i,int j,int[][] a,int k){
        System.out.print(i*4+j+1+",");
        if (k == 6){
            System.out.println();
            num++;
            return;
        }

        if (j<a[0].length-1) {
            if (a[i][j+1]==0){
                a[i][j+1]=1;
                h(i,j+1,a,k+1);
                a[i][j+1]=0;

            }
            if (a[i][j+1]==1){
                a[i][j+1]=2;
                h(i,j+1,a,k);
                a[i][j+1]=1;
            }
        }
        if (j>0) {
            if (a[i][j-1]==0){
                a[i][j-1]=1;
                h(i,j-1,a,k+1);
                a[i][j-1]=0;

            }
            if (a[i][j-1]==1){
                a[i][j-1]=2;
                h(i,j-1,a,k);
                a[i][j-1]=1;
            }
        }
        if (i<a.length-1) {
            if (a[i+1][j]==0){
                a[i+1][j]=1;
                h(i+1,j,a,k+1);
                a[i+1][j]=0;
            }
            if (a[i+1][j]==1){
                a[i+1][j]=2;
                h(i+1,j,a,k);
                a[i+1][j]=1;
            }
        }
        if (i>0) {
            if (a[i-1][j]==0){
                a[i-1][j]=1;
                h(i-1,j,a,k+1);
                a[i-1][j]=0;
            }
            if (a[i-1][j]==1){
                a[i-1][j]=2;
                h(i-1,j,a,k);
                a[i-1][j]=1;
            }
        }
    }
    public static void main(String[] args) {
        int[][] a = new int[3][4];
        for (int i=0;i<a.length;i++){
            for (int j=0;j<a[0].length;j++){
                h(i,j,a,0);
            }
        }
        System.out.println(num);
    }
}
