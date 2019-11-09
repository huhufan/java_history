package com.test.mvc.test;

import com.test.mvc.Entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @auther hu  .
 * @create 2019/9/9
 */
public class MyTest {

    @Test
    public void test1(){
        ApplicationContext appCon = new ClassPathXmlApplicationContext("applicationContext-mvc.xml");
        Person person = (Person) appCon.getBean("person");
        System.out.println(person);

    }
}
