package a_2019_3_29;

public class C {

    public static boolean leap_year(int year){
        boolean d = false;
        if (year%4==0) d= true;
        if (year%100==0) d = false;
        if (year%400==0) d = true;
        return d;
    }
    public static int[] mon_day(int year){
        if (leap_year(year))
            return new int[]{0,31,29,31,30,31,30,31,31,30,31,30,31};
        return new int[]{0,31,28,31,30,31,30,31,31,30,31,30,31};
    }

    /**
     *
     * @param s:yyyy.mm.dd
     * @param days
     */
    public static void y_minus(String s,int days){
        int year =Integer.valueOf(s.substring(0,4));
        int month =Integer.valueOf(s.substring(5,7));
        int day =Integer.valueOf(s.substring(8));

        y:for (int a = year;a>0;a--){
            int[] arr = mon_day(year);
            if (a!=year)
                month = 12;
            for (int j =month;j>0;j--){
                    if (j!=month)
                        day=arr[j];
                    if (day>days){
                        day = day-days;
                        System.out.println(a+"."+j+"."+day);
                        break y;
                    }
                    else{
                        days = days-day;
                        continue ;
                    }
            }
        }
    }

    public static void main(String[] args) {
        y_minus("1998.03.01",2);
    }
}
