package 博弈问题;

import java.util.HashMap;

public class H {

    static HashMap result = new HashMap();

    public static boolean f(int n){
        if (result.containsKey(n)) return (boolean)result.get(n);
        if (n == 0)  return true;

        boolean e = false;
        if (n >= 1 && f(n-1) == false) e=true;
        if (n >= 3 && f(n-3) == false) e=true;
        if (n >= 7 && f(n-7) == false) e=true;
        if (n >= 8 && f(n-8) == false) e=true;

        result.put(n,e);
        return e;

    }

    public static void main(String[] args) {
        System.out.println(f(10));
    }
}
