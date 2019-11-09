package com.atguigu.springboot_dubbo_ticket_provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.springboot_dubbo_common.bean.UserAddress;
import com.atguigu.springboot_dubbo_common.service.UserService;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


@Component
@Service(weight = 100) //设置权重
public class UserServiceImpl implements UserService {

	@Override
	public List<UserAddress> getUserAddressList(String userId) {
		System.out.println("UserServiceImpl.....3...");
		// TODO Auto-generated method stub
		UserAddress address1 = new UserAddress(1, "北京市昌平区宏福科技园综合楼3层", "1", "李老师", "010-56253825", "Y");
		UserAddress address2 = new UserAddress(2, "深圳市宝安区西部硅谷大厦B座3层（深圳分校）", "1", "王老师", "010-56253825", "N");

		return Arrays.asList(address1,address2);
	}

}
