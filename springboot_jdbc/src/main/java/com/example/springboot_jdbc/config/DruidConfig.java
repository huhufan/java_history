package com.example.springboot_jdbc.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }

    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        Map<String,String> initParam = new HashMap<>();
        initParam.put("loginUsername","fhh");
        initParam.put("loginPassword","fhh");
        initParam.put("allow","");
        initParam.put("deny","");
        servletRegistrationBean.setInitParameters(initParam);
        return servletRegistrationBean;
    }
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean filter = new FilterRegistrationBean();
        filter.setFilter(new WebStatFilter());
        Map<String,String> initParam = new HashMap<>();
        initParam.put("exclusions","*.js,*.css,/druid/*");
        filter.setInitParameters(initParam);
        filter.setUrlPatterns(Arrays.asList("/*"));
        return filter;

    }

}
