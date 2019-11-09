package 基础;

public class Universe {
    int area = 66666;
    String name = "universe";
    //内部类可以访问外部类的私有属性 age 和私有方法 move()
    private int age = 99999 ;
    private void move(){
        System.out.println("Universe can turn around");
    }
    //内部类可以任意使用访问控制符（public、protected、private等）
     class Earth{
        String name = "earth";
        int age = 11111;
        int size = 5555;

        public void move(){
            //调用外部类非同名变量 area
            System.out.println("The area of the universe is "+area+"square meters");
            //调用内部类变量
            System.out.println("The "+name+ "has rotated for "+age+"years");
            //调用外部类同名的变量 name 和 age
            System.out.println("The "+Universe.this.name+ "has rotated for "+Universe.this.age+"years");
            //调用同名方法
            Universe.this.move();
        }
    }
    public static void main(String[] args) {
        //创建内部类对象必须使用外部类对象
        Universe universe = new Universe();
        Earth earth = universe.new Earth();
        earth.move();


    }
}
