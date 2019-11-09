package 分治法与动态规划;

public class H {
    static boolean h(String a){
        String v = ""+a.charAt(0)+a.charAt(1)+a.charAt(2)+a.charAt(3);
        String x = ""+a.charAt(4)+a.charAt(5)+a.charAt(6)+a.charAt(1);
        String re =""+ a.charAt(4)+a.charAt(5)+a.charAt(2)+a.charAt(1)+a.charAt(7);
        if (Integer.valueOf(v)+Integer.valueOf(x)==Integer.valueOf(re))
            return true;
        return false;
    }


    static void f(String a,String con,int k){
        if (k == 8) {
            if (con.charAt(0)== '0'||con.charAt(4)=='0')
                return;
            if (h(con))
               System.out.println(con);
            return;
        }
        for (int i=0;i<a.length();i++){
             f(a.substring(0,i)+a.substring(i+1),con+a.charAt(i),k+1);
        }
    }
    public static void main(String[] args) {
        String a = "0123456789";
        f(a,"",0);
    }
}
