package common;

import mapper.NameMapper;
import mapper.Y;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.List;

/**
 * MyBatis工具类
 */

public class MyBatisUtils {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;
    static {
        try {

            String resource = "config.xml";
            //获取resource目录下的config.xml文件
            reader = Resources.getResourceAsReader(resource);
            //创建sqlSessionFactory工程对象
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader) ;

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     *  返回sqlSession对象
     * @return SqlSession
     */

    public static SqlSession getSession() {
        return sqlSessionFactory.openSession();
    }

    public static List<Y> get(){

        SqlSession sqlSession = MyBatisUtils.getSession();
        try {
            NameMapper mapper = sqlSession.getMapper(NameMapper.class);
           return mapper.getId();
        }finally {
            sqlSession.close();
        }
    }

    public static void main(String[] args) {
        MyBatisUtils.get();
        List<Y> ys = MyBatisUtils.get();
        for (Y y:ys){
            System.out.println(y.getId());
        }
    }
}

