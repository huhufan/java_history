package month_5;

public class StringToInteger {
    public int myAtoi(String str) {
        int index = 0;
        boolean flag = false;
        int first = 1;

        int var = 0;
        while (true){
            if (index>=str.length() || (flag && (str.charAt(index)<48 || str.charAt(index)>57)))
                break;

            int charAsc = str.charAt(index);

            if (charAsc>=48 && charAsc<=57){
                int g = Integer.valueOf(charAsc)-48;
                if (var*first>Integer.MAX_VALUE/10 || (var*first == Integer.MAX_VALUE/10 && g > 7 ))
                    return Integer.MAX_VALUE;
                if (var*first<Integer.MIN_VALUE/10 || (var*first == Integer.MIN_VALUE/10 && g > 8 ))
                    return Integer.MIN_VALUE;
                var = var*10+(Integer.valueOf(charAsc)-48);
                flag = true;
            }
            else if (charAsc == 45)
                first=-1;
            index++;
        }
        return var*first;
    }

    public int myAtoi2(String str) {
        int var = 0;
        int sign = 1;
        boolean var_change = false;
        boolean sign_change = false;
        boolean get_zero = false;
        for (int i = 0 ;i<str.length();i++){
            int cur = str.charAt(i);
            if (cur == 32 && ((!var_change && !sign_change)|| get_zero))
                continue;
            if (cur == 48 && !var_change){
                get_zero = true;
                continue;
            }
            if (cur == 43){ // +
                if (get_zero)
                    return 0;
                if (!sign_change) {
                    sign = 1;
                    sign_change = true;
                    continue;
                }
                else
                    return 0;
            }
            if (cur == 45){ // -
                if (get_zero)
                    return 0;
                if (!sign_change) {
                    sign = -1;
                    sign_change = true;
                    continue;
                }
                else
                    return 0;
            }
            if (cur>=48 && cur<=57){
                int g = Integer.valueOf(cur)-48;
                if (var*sign>Integer.MAX_VALUE/10 || (var*sign == Integer.MAX_VALUE/10 && g > 7 ))
                    return Integer.MAX_VALUE;
                if (var*sign<Integer.MIN_VALUE/10 || (var*sign == Integer.MIN_VALUE/10 && g > 8 ))
                    return Integer.MIN_VALUE;
                var = var*10+(Integer.valueOf(cur)-48);
                var_change = true;
            }
            else
                return var*sign;

        }
        return var*sign ;
    }

    public static void main(String[] args) {
       StringToInteger s = new StringToInteger();
        System.out.println(s.myAtoi2(" - 881zxcxcc"));
    }

}
