import org.junit.validator.ValidateWith;

import javax.annotation.Resource;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Person {
    public String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Person(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person() {
    }
    @Resource
    public void sayPublic() throws Exception {
        System.out.println("i am public");
    }

    private void sayPrivate() {
        System.out.println("i am private");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class ReflectionTest {
    public static void main(String[] args) throws Exception {
        Class cla = Class.forName("Person");
//**********************************************************************************
        //通过反射，调用Person类的公共结构的，比如，私有的构造器、方法、属性
        //调用公共的构造器
        Constructor c1 = cla.getConstructor(String.class, int.class);
        Object tom = c1.newInstance("tom", 12);
        Person p1 = (Person) tom;
        System.out.println(p1);
        //调用公共的属性
        Field name = cla.getField("name");
        name.set(p1, "jack");
        System.out.println(p1);
        //调用公共的方法
        Method sayPublic = cla.getMethod("sayPublic");
        sayPublic.invoke(p1);
//************************************************************************************
        //通过反射，调用Person类的私有结构的，比如，私有的构造器、方法、属性
        //调用私有的构造器
        Constructor c2 = cla.getDeclaredConstructor(String.class);
        c2.setAccessible(true);
        Person p2 = (Person) c2.newInstance("bob");
        System.out.println(p2);
        //调用私有的属性
        Field age = cla.getDeclaredField("age");
        age.setAccessible(true);
        age.setInt(p2, 14);
        System.out.println(p2);
        //调用私有的方法
        Method sayPrivate = cla.getDeclaredMethod("sayPrivate");
        sayPrivate.setAccessible(true);
        sayPrivate.invoke(p2);
    }
}
