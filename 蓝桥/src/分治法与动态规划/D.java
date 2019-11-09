package 分治法与动态规划;

public class D {
    static void f(String a,String b,int goal){
        if (Integer.valueOf(a)== goal){
            b = a+b+"=100";
            System.out.println(b);
        }
        for (int i=a.length()-1;i>0;i--){
            String cur = a.substring(i);
            f(a.substring(0,i),"+"+cur+b,goal-Integer.valueOf(cur));
            f(a.substring(0,i),"-"+cur+b,goal+Integer.valueOf(cur));
        }
    }

    public static void main(String[] args) {
        f("123456789","",100);
    }
}
