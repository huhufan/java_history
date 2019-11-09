package test_8_2;

import java.util.HashMap;
import java.util.Map;

public class calculator {

    Map<Character,Integer> map;
    public calculator(){
        map = new HashMap();
        map.put('*',1);
        map.put('/',1);
        map.put('+',2);
        map.put('-',2);
    }
    public boolean isSign(char c){
        for (Character sign:map.keySet()){
            if (c == sign)
                return true;
        }
        return false;
    }
    public int getPriority(char c){
        return map.get(c);
    }


    public  int calculate(String s){
        for (int i = 0;i<s.length();i++) {

        }
        return 0;
    }


    public static void main(String[] args) {

    }

}
