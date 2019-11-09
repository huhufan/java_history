import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class LoadConfig  {
    @Test
    public void test() throws Exception{
        //方式1，通过输入流,配置文件放置在module路径下
        FileInputStream in = new FileInputStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(in);
        System.out.println(properties.get("user"));
        System.out.println(properties.get("password"));

        //方式二，通过类加载器，配置文件放置在src路径下
        ClassLoader classLoader = LoadConfig.class.getClassLoader();
        InputStream in2 = classLoader.getResourceAsStream("jdbc.properties");
        Properties properties2 = new Properties();
        properties2.load(in2);
        System.out.println(properties2.get("user"));
        System.out.println(properties2.get("password"));
    }
}
