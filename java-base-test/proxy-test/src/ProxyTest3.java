/**
 * @auther hu  .
 * @create 2019/8/19
 */

// 导入jar包 cglib-version.jar   asm-version.jar      https://mvnrepository.com/search?q=cglib

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

interface Man {
    void sayHello();
}

class Chinese implements Man {
    @Override
    public void sayHello() {
        System.out.println("Chinese say hello.");
    }
}

class ChinesePoxy implements MethodInterceptor {

    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("-------- start --------");
        Object intercept = methodProxy.invokeSuper(object, args);
        System.out.println("-------- end ---------");
        return intercept;
    }
}


public class ProxyTest3 {
    public static void main(String[] args) {
        ChinesePoxy chinesePoxy = new ChinesePoxy();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Chinese.class);
        enhancer.setCallback(chinesePoxy);
        Chinese proxy = (Chinese) enhancer.create();
        proxy.sayHello();
    }
}
