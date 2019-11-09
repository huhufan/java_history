package 分治法与动态规划;

public class C {
    static int f(int a,int b){
        if (a == 1 || b==1) return 1;
        return f(a-1,b)+f(a,b-1) ;
    }

    static void h(int a,int b){
        int[][] r = new int[a][b];
        for (int i =1;i<a;i++){
            r[i][0] = 1;
        }
        for (int j =1;j<b;j++){
            r[0][j] = 1;
        }
        for (int i =1;i<a;i++){
            for (int j=1;j<b;j++){
                r[i][j] = r[i-1][j]+r[i][j-1];
            }
        }
        System.out.println(r[a-1][b-1]);
    };
    public static void main(String[] args) {
        System.out.println(f(25,12));
        h(25,12);
    }
}
