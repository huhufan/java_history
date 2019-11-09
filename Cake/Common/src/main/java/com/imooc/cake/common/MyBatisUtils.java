package com.imooc.cake.common;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 *
 * MyBatis工具类
 *
 * @version 1.0
 */
public class    MyBatisUtils {

    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;

    static {
        try {
            String resource = "config.xml";
            //获取resources目录下的config.xml的配置文件
            reader = Resources.getResourceAsReader(resource);
            //创建SqlSessionFactory工程对象
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 返回SqlSession对象
     * @return SqlSession
     */
    public static SqlSession openSession() {
        return sqlSessionFactory.openSession();
    }

}
