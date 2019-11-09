/**
 * @auther hu
 * @create 2019/8/18
 * <p>
 * 静态代理示例
 * 代理类和被代理类在编译期间，就确定下来了
 */
interface ClotheFactory {
    void produce();
}

class NikeClothFactory implements ClotheFactory {
    @Override
    public void produce() {
        System.out.println("生产Nike衣服");
    }
}

class ProxyClotheFactory implements ClotheFactory {
    private ClotheFactory clotheFactory;

    public ProxyClotheFactory(ClotheFactory clotheFactory) {
        this.clotheFactory = clotheFactory;
    }

    @Override
    public void produce() {
        System.out.println("生产衣服的准备工作");
        clotheFactory.produce();
        System.out.println("生产衣服的后续工作");
    }
}

public class ProxyTest {
    public static void main(String[] args) {
        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        ProxyClotheFactory proxy = new ProxyClotheFactory(nikeClothFactory);
        proxy.produce();

    }
}
