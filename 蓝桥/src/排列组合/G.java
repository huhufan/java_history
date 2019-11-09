package 排列组合;

import java.util.ArrayList;
import java.util.List;

public class G {

    static List f(String a,int k){
        List<String> list = new ArrayList();

        if (k==0){
           list.add("");
           return list;
        }
        for (int i = 0; i < a.length(); i++) {
            char b = a.charAt(i);
            List l = f(a.substring(0,i)+a.substring(i+1),k-1);
            for (int j = 0; j < l.size(); j++) {
                list.add(""+b+l.get(j));
            }
        }
        return list;
    }
    public static void main(String[] args) {
        String a = "ABC";
        List e = f(a,2);
        for (int i = 0; i < e.size(); i++) {
            System.out.println(e.get(i));
        }

    }
}
