package 排列组合;

import java.util.List;
import java.util.Vector;

public class A {

    static List f(String s) {
       List lst = new Vector();
        if (s.length() == 1) {
            lst.add(s);
            return lst;

        }

        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            List t = f(s.substring(0, i) + s.substring(i + 1));
            for (int k = 0; k < t.size(); k++) {
                lst.add(""+x+t.get(k));
            }
        }
        return lst;
    }

    public static void main(String[] args) {
        List lst = f("ABC");
        for (int i = 0; i < lst.size(); i++) {
            System.out.println(lst.get(i));
        }
    }
}
