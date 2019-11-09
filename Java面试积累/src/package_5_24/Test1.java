package package_5_24;

class People{

    private String name;
    private int age;

    public People(String name, int age){
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)                                                        // 使用 == 符合检查参数是否为这个对象的引用
            return true;                                                       // 如果是这个对象的引用，返回true
        if (obj instanceof People){                                            // 使用 instanceOf 检查参数是否是正确的类型
            People p = (People)obj;                                             // 在 instanceOf 检查返回为true的时候，将参数转成当前对象的类型
            if (this.getName() == p.getName() && this.getAge() == p.getAge())  // 逐一比较当前对象与比较对象的每一条属性是否一致
                return true;                                                   // 逐一比较完成，全部相等，返回true
        }
        return false;
    }
}
public class Test1 {
    public static void main(String[] args) {
        People a = new People("张三",13);
        People b = new People("张三",13);
        System.out.println("a.equals(b)的结果为： "+a.equals(b));
    }
}
