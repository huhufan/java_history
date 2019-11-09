import org.junit.Test;

public class NewInstance {

    @Test
    public void test() throws Exception{
        /**
         *  要想通过此方法创建实例，要求：
         *  1. 运行时类必须提供空参的构造器
         *  2. 空参的构造器的访问权够，通常设置为public
         *
         *  在java中通常要求提供一个public的空参构造器，原因
         *  1. 便于通过反射，创建运行时类的对象
         *  2. 便于子类基础此运行时类时，调用super(),不会出错
         */

        Class cla = Class.forName("Person");
        Person p = (Person) cla.newInstance();
        System.out.println(p);
    }
}
