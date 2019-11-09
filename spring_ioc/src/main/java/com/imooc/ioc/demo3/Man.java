package com.imooc.ioc.demo3;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Man implements BeanNameAware, ApplicationContextAware, InitializingBean, DisposableBean {
    private String name;

    public void setName(String name) {
        System.out.println("第二步：设置属性");
        this.name = name;
    }
    public Man() {
        System.out.println("第一步：Man被实例化了");
    }

    public void init(){
        System.out.println("第七步：Man被初始化了");
    }

    public void destory(){
        System.out.println("第十一步：Man被销毁了");
    }

    public void setBeanName(String s) {
        System.out.println("第三步：设置Bean的名称");
    }

    public void destroy() throws Exception {
        System.out.println("第十部：执行spring的销毁方法");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("第六步：属性设置后");
    }
    public void run(){
        System.out.println("第九步：执行业务方法");
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("第四步：了解工厂信息");
    }
}
