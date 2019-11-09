package a_4_2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class B {
     class Data{
        int a=0;
        int b=0;

        public Data(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    private void h(Data data){
        String b = String.valueOf(data.b);
        int a = data.a;
        int sum = 0;
        int dig = 0;
        for (int i=0;i<b.length();i++){
            String c = b.substring(i,i+1);
            int cc = Integer.valueOf(c);
            sum+=cc;
            dig+=cc*Math.pow(a,b.length()-1-i);
        }
        if (dig%sum==0) System.out.println("yes");
        else
            System.out.println("no");
    }
    public List f(){
        Scanner s = new Scanner(System.in);
        List<Data> li = new ArrayList<>();
        while (true){
            int a =s.nextInt();
            if (a==0)
                break;
            int b =s.nextInt();
            li.add(new Data(a,b));
        }
        return li;
    }
    public static void main(String[] args) {
        B b = new B();
        List<Data> f = b.f();
        for (int i =0;i<f.size();i++){
            b.h(f.get(i));
        }

    }

}
