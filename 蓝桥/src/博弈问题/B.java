package 博弈问题;

import javafx.scene.input.DataFormat;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class B {
    static void f() {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd--hh---mm--ss");
        String bir_day = "1998-07-10--00---00--00";
        try {
            Date date1 = s.parse(bir_day);
            System.out.println(date1);
            Date date2 = new Date();
            long i = date2.getTime() - date1.getTime();
            long l = i / (3600 * 24 * 1000);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        f();
    }
}
