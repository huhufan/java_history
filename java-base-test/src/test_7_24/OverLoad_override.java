package test_7_24;

public class OverLoad_override {
    /**
     * 重载(Overload)
     * 被重载的方法必须改变参数列表(参数个数或类型不一样)；
     * 被重载的方法可以改变返回类型；
     * 被重载的方法可以改变访问修饰符；
     * 被重载的方法可以声明新的或更广的检查异常；
     * 方法能够在同一个类中或者在一个子类中被重载。
     */
    public int fun(int a){
        return 1;
    }
    protected int fun(int a,int b){  //
        return a;
    }

    /**
     * 重写(Override)
     * 重写是子类对父类的允许访问的方法的实现过程进行重新编写, 返回值和形参都不能改变。即外壳不变，核心重写！
     * 重写的好处在于子类可以根据需要，定义特定于自己的行为。 也就是说子类能够根据需要实现父类的方法。
     *
     * 参数列表必须完全与被重写方法的相同；
     * 返回类型与被重写方法的返回类型可以不相同，但是必须是父类返回值的派生类（java5 及更早版本返回类型要一样，java7 及更高版本可以不同）；
     * 访问权限不能比父类中被重写的方法的访问权限更低。例如：如果父类的一个方法被声明为public，那么在子类中重写该方法就不能声明为protected。
     * 父类的成员方法只能被它的子类重写。
     * 声明为final的方法不能被重写。
     * 声明为static的方法不能被重写，但是能够被再次声明。
     */
    class Son extends OverLoad_override{
        @Override
        public int fun(int a) {
            return super.fun(a);
        }

        @Override
        // 访问权限不能比父类中被重写的方法的访问权限更低。例如：如果父类的一个方法被声明为public，那么在子类中重写该方法就不能声明为protected。
        public int fun(int a, int b) {
            return super.fun(a, b);
        }
    }
}
