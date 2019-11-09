package com.atguigu.provider_ticker.service;


import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Component
@Service //将服务注册出去
public class TickerServiceImpl implements TickerService {
    @Override
    public String get() {
        return "哈哈哈";
    }
}
