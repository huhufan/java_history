package test_7_24;


import sun.dc.pr.PRError;

//最简单的单例模式：1
// **************************************************************
class Singleton1{
    public static final  Singleton1 INSTANCE = new Singleton1();
    private Singleton1(){}
}
//枚举实现:2
// **************************************************************
enum Singleton2{
    INSTANCE;
}
//静态代码块:3
// **************************************************************
class Singleton3{
    public static final  Singleton3 INSTANCE ;
    //如果类的构造器中有复杂的操作，比如从配置文件中读取属性值赋给构造器，可以使用静态代码块
    static {
        INSTANCE = new Singleton3();
    }
    private Singleton3(){}
}
//**************************************************************


//懒汉式
//**************************************************************
class Singleton4{
    private static Singleton4 INSTANCE;
    private Singleton4(){}
    public Singleton4 getINSTANCE(){
        if (INSTANCE == null){
            synchronized (Singleton4.class){ //需要加锁保证线程安全
                if (INSTANCE == null){
                    INSTANCE = new Singleton4();
                }
            }
        }
        return INSTANCE;
    }
}
//*****************************************************************
/**
 * 在内部类被加载和初始化时，才加载INSTANCE对象
 * 静态内部类不会随着外部类的加载和初始化而初始化，而是调用的时候单独去加载和初始化的
 * 线程安全的！！！
 */
class Singleton5{
    private Singleton5(){}
    private static class Inner{
        private static final Singleton5 INSTANCE = new Singleton5();
    }
    public static Singleton5 getInstance(){
        return Inner.INSTANCE;
    }
}


public class Singleton {
}
