package 排列组合;

import java.util.ArrayList;
import java.util.List;

/**
 * 五个中取三个
 */
public class E {
    static List f(String a,int n){
        List l = new ArrayList();
        if (n == 0) {
            l.add("");
            return l;
        }
        for (int i =0;i<a.length();i++){
            char x = a.charAt(i);
            List s = f(a.substring(i+1),n-1);
            for (int j = 0; j < s.size(); j++) {
                l.add(""+x+s.get(j));
            }
        }
        return l;
    }


    public static void main(String[] args) {
        List e =f("abcde",3);
        for (int i = 0; i < e.size(); i++) {
            System.out.println(e.get(i));
        }
    }
}


