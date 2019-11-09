package com.demo.utils;

import com.sun.org.apache.regexp.internal.RE;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.omg.CORBA.PUBLIC_MEMBER;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;

public class SqlsessionFactoryUtils {
    private static String RESOURCE = "mybatis-config.xml";
    private static SqlSessionFactory sqlsessionFactory;
    private static ThreadLocal<SqlSession> threadLocal=new ThreadLocal<SqlSession>();

    public static


    void initSqlSessionFactory() {
        try {
            InputStream is= Resources.getResourceAsStream(RESOURCE);
            sqlsessionFactory =new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlsessionFactory;
    }

    public static void close() {
        SqlSession sqlSession=threadLocal.get();
        if (sqlSession != null) {
            sqlSession.close();
            threadLocal.set(null);
        }
    }


}
