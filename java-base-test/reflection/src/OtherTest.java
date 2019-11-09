import org.junit.Test;

import java.lang.reflect.*;

public class OtherTest {
    @Test
    public void test() throws NoSuchMethodException {
        Class cls = Person.class;
        //1、获得构造器
        //getConstructors();获取当前运行类中声明为public的构造器
        Constructor constructor = cls.getConstructor();

        //getDeclaredConstructors();获取当前运行类中所有的的构造器

        //2. 获得运行时类的父类
        Class superclass = cls.getSuperclass();
        //获得运行时类的带泛型的父类
        Type type = cls.getGenericSuperclass();
        //获取运行时类的带泛型的父类的泛型
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Type[] TypeArguments = parameterizedType.getActualTypeArguments();

        //3.获取运行时类实现的接口
        Class[] interfaces = cls.getInterfaces();
        //获取运行时类父类实现的接口
        Class[] interfaces1 = cls.getSuperclass().getInterfaces();

        //4.获取当前运行时类的包
        Package aPackage = cls.getPackage();

    }

    //操作运行时类的属性
    @Test
    public void test2() throws Exception {
        Class cls = Person.class;
        //创建运行时类的对象
        Person p = (Person) cls.newInstance();

        /**1.getDeclaredField(String fieldName) 获取运行时类指定变量名的属性
         *   getField(String filedName)获取运行时类指定变量名的属性，但要求此属性public
         */
        Field name = cls.getDeclaredField("name");
        //2.保证当前属性是可访问的
        name.setAccessible(true);
        name.set(p, "tom");
        System.out.println(name.get(p));
    }

    //操作运行时类的方法
    @Test
    public void test3() throws Exception {
        Class cls = Person.class;
        //创建运行时类的对象
        Person p = (Person) cls.newInstance();

        //1.getDeclaredMethod() 参数一：指明获取的方法的名称 参数二：指明获取的方法的形参列表

        Method method = cls.getMethod("sayPublic", String.class);
        //2.保证当前方法是可访问的
        method.setAccessible(true);
        /**3.调用方法的invoke()方法，参数一：方法的调用者(如果是静态方法，直接填入类就行），参数二：该方法形参赋值的实参
         * invoke的返回值即为对应方法的返回值
         */
        Object returnVal = method.invoke(p, "jock");
    }

    //操作运行时类的构造器
    @Test
    public void test4() throws Exception {
        Class cls = Person.class;
        //创建运行时类的对象
        Person p = (Person) cls.newInstance();

        //1.getDeclaredConstructor() 参数:构造器的参数列表
        Constructor constructor = cls.getDeclaredConstructor(String.class);
        //2.保证当前构造器是可访问的
        constructor.setAccessible(true);

        //3.使用此构造器创建对象
        Person per = (Person) constructor.newInstance("tom");

    }
}
