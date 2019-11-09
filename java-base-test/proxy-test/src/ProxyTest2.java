import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @auther hu
 * @create 2019/8/18
 * <p>
 * 动态代理示例
 */

interface People {
    void eat(String food);
}

//被代理类
class SuperMan implements People {

    @Override
    public void eat(String food) {
        System.out.println("超人喜欢吃" + food);
    }
}

//代理类
class ProxyFactory {
    //返回一个代理对象
    public static Object getProxyInstance(Object obj) {
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
        myInvocationHandler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), myInvocationHandler);
    }
}

class MyInvocationHandler implements InvocationHandler {
    private Object obj;

    //给需要代理的对象赋值
    public void bind(Object obj) {
        this.obj = obj;
    }

    //等通过代理类的对象调用方法时，会自动的调用如下的方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //object 被代理的对象
        Object returnVal = method.invoke(obj, args);
        //方法的返回值作为invoke的返回值
        return returnVal;
    }
}

public class ProxyTest2 {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        People proxyInstance = (People) ProxyFactory.getProxyInstance(superMan);
        proxyInstance.eat("红烧肉");
    }
}
