package com.imooc.canvas.common;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

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

    public static void main(String[] args) {
        MyBatisUtils.getSession();
    }
}

