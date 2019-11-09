import com.demo.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TsetDemo {

    @Test
    public void testDemo1() throws IOException {
        //初始化mybatis配置环境
        String resource="mybatis.xml";
        InputStream is= Resources.getResourceAsStream(resource);
        //打开和数据库之间的连接
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
        SqlSession session=factory.openSession();
        List<User> userList=session.selectList("userList");
        for (User user : userList) {
            System.out.println(user);
        }
        session.close();

    };
}
