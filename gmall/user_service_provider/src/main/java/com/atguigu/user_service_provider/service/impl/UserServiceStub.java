package com.atguigu.user_service_provider.service.impl;

import java.util.List;

import com.atguigu.gmall_interface.bean.UserAddress;
import com.atguigu.gmall_interface.service.UserService;
import org.springframework.util.StringUtils;


public class UserServiceStub implements UserService {
	
	private final UserService userService;
	

	/**
	 * 传入的是userService远程的代理对象
	 * @param userService
	 */
	public UserServiceStub(UserService userService) {
		super();
		this.userService = userService;
	}


	@Override
	public List<UserAddress> getUserAddressList(String userId) {
		// TODO Auto-generated method stub
		System.out.println("UserServiceStub.....");
		if(!StringUtils.isEmpty(userId)) {
			return userService.getUserAddressList(userId);
		}
		return null;
	}

}