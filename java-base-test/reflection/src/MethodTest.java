import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MethodTest {

    @Test
    public void test() {
        Class cls = Person.class;

        //获取运行时类的方法结构

        //getMethods():获取当前运行类及其所有父类中声明为public权限的方法
        Method[] methods = cls.getMethods();

        //获取当前运行时类中声明的所有方法（不包含父类中定义的方法）
        Method[] declaredMethods = cls.getDeclaredMethods();
    }

    //获取方法的 @注解 权限修饰符 返回值类型 方法名 （参数类型 参数名） throws xxxException
    @Test
    public void test2() {
        Class cls = Person.class;
        Method[] declaredMethods = cls.getDeclaredMethods();
        for (Method m : declaredMethods) {
            //1.获取方法声明的注解
            Annotation[] annotations = m.getAnnotations();
            for (Annotation a : annotations)
                System.out.print(a + "\t");
            //2. 权限修饰符
            System.out.print(Modifier.toString(m.getModifiers()) + "\t");
            //3. 返回值类型
            System.out.print(m.getReturnType().getName() + "\t");
            //4. 方法名
            System.out.print(m.getName() + "\t");
            //5. 形参列表
            Class<?>[] parameterTypes = m.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                System.out.print(parameterTypes[i].getName() + "_args_" + i + "\t");
            }
            //6. 抛出的异常
            Class<?>[] exceptionTypes = m.getExceptionTypes();
            for (int j = 0; j < exceptionTypes.length; j++) {
                System.out.print(exceptionTypes[j].getName() + "_exception_" + j + "\t");
            }
            System.out.println();
        }
    }
}
