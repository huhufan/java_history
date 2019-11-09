import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class FieldTest {

    @Test
    public void test() {
        Class cla = Person.class;

        //获取属性结构
        //getFields():获取当前运行类及其父类中声明为public访问权限的属性
        Field[] fields = cla.getFields();

        //getDeclaredFields():获取当前运行时类中声明的所有属性（不包含父类中声明的属性）
        Field[] declaredFields = cla.getDeclaredFields();
    }

    //获取变量的修饰符 类型 变量名
    @Test
    public void test2() {
        Class cla = Person.class;
        Field[] declaredFields = cla.getDeclaredFields();
        for (Field f : declaredFields) {
            System.out.print(Modifier.toString(f.getModifiers()) + "\t");
            System.out.print(f.getType().getName() + "\t");
            System.out.print(f.getName());
            System.out.println();
        }
    }
}
