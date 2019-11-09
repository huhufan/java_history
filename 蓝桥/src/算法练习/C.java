package 算法练习;

public class C {

    static int f(int x,int y){
        if(x==1||y==1) return 1;
        return f(x-1,y)+f(x,y-1);
    }


    public static void main(String[] args) {
        System.out.println(f(5,4));

    }
}
