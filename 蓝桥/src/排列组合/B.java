package 排列组合;

import java.util.ArrayList;
import java.util.List;

public class B {
    static List f(String a){
        List lst= new ArrayList() ;
        if (a.length()==1){
            lst.add(a);
            return lst;
        }
        for (int i = 0; i < a.length(); i++) {
             char b= a.charAt(i);
             List c= f(a.substring(0,i)+a.substring(i+1));
             for (int j = 0; j < c.size(); j++) {
                lst.add(""+b+c.get(j));
            }
        }
        return lst;
        }

    public static void main(String[] args) {
        String a= "abc";
        List l = f(a);
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i));
        }
    }
}
