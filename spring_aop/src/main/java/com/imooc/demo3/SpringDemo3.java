package com.imooc.demo3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")

public class SpringDemo3 {

    //@Resource(name="studentDaoImpl")
    @Resource(name = "studentDaoProxy")
    private StudentDao studentDao;

    @Test
    public void demo3(){
       studentDao.save();
       studentDao.update();
    }
}
