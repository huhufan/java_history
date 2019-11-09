
public class ClassTest {
    public static void main(String[] args) throws ClassNotFoundException {
        //方式1：调用运行时类的属性.class
        Class cla = Person.class;
        System.out.println(cla);

        //方式2：调用运行时类的对象，getClass
        Person p1 = new Person(null,0);
        Class cla2 = p1.getClass();
        System.out.println(cla2);

        //方式3：调用Class的静态方法：forName(String classpath)
        Class cla3 = Class.forName("Person");
        System.out.println(cla3);

        //方式4：使用类的加载器，ClassLoader
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class cla4 = classLoader.loadClass("Person");
        System.out.println(cla4);
    }
}
