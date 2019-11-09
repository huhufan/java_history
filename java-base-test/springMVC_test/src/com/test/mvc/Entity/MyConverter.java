package com.test.mvc.Entity;

import org.springframework.core.convert.converter.Converter;

/**
 * @auther hu  .
 * @create 2019/9/11
 */

public class MyConverter implements Converter<String,Object>{
    @Override
    public Object convert(String s) {
        return null;
    }
//    @Override
//    public Person convert(String s) {
//        String[] split = s.split("-");
//        Person person = new Person();
//        person.name = split[0];
//        person.age = Integer.valueOf(split[1]);
//        return person;
//    }
}
