package 基础;

public class Out {
    String name;
    int age;

    public Out(In in){
        this.age = in.age;
        this.name = in.name;
    }
    public void showMe(){
        System.out.println("Out age is "+age+" and  name is "+name);
    }
    static class In{
        String name;
         int age;

         public In(String name,int age){
             this.age = age;
             this.name = name;
         }
        public void showMe(){
            System.out.println("In age is "+age+" and  name is "+name);
            // System.out.println(Out.this.age);//这行会报错
        }
    }

    public static void main(String[] args) {
        In in = new In("张三",5);
        in.showMe();
        Out out = new Out(in);
        out.showMe();


    }
}
