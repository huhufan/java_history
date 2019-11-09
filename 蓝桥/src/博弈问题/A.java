package 博弈问题;

/**
 * 两个date 天数之差
 */
public class A {
    static int get_day(int y1,int m1,int d1,int y2,int m2,int d2 ){
        return  get__day(y1,m1,d1)-get__day(y2,m2,d2);
    }
    static boolean leap_year(int y){
        boolean f =false;
        if (y%4==0) f=true;
        if (y%100==0) f=false;
        if (y%400==0) f=true;
        return f;
    }

    static int get__day(int y,int m,int d){
        int sum=0;
        int[] M = {0,31,28,31,30,31,30,31,31,30,31,30,31};
        if (leap_year(y)) M[2]=29;
        for (int i=1;i<y;i++){
            sum+=365;
            if (leap_year(y)) sum++;
        }
        for (int j=1;j<m;j++){
            sum+=M[j];
        }
        sum+=d;
        return sum;
    }

    static void test(){

    }

    public static void main(String[] args) {
        System.out.println(get_day(2019,3,1,2000,2,29));

    }
}
