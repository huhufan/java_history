package com.demo.listener;

import com.demo.utils.SqlsessionFactoryUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitSqlSessionListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        SqlsessionFactoryUtils.initSqlSessionFactory();
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        SqlsessionFactoryUtils.close();
    }
}
