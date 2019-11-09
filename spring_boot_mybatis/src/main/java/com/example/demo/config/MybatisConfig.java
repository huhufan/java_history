package com.example.demo.config;

import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Configuration;


//departmentName department_name  的解决
// 使用@MapperScan批量扫描所有的Mapper 接口
@Configuration
public class MybatisConfig {

     public ConfigurationCustomizer configurationCustomizer(){
          return  new ConfigurationCustomizer() {
             @Override
             public void customize(org.apache.ibatis.session.Configuration configuration) {
                 configuration.setMapUnderscoreToCamelCase(true);
             }
         };

     }
}
