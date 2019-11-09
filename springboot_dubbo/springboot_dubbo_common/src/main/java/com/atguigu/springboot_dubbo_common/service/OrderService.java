package com.atguigu.springboot_dubbo_common.service;


import com.atguigu.springboot_dubbo_common.bean.UserAddress;

import java.util.List;

public interface OrderService {
	
	/**
	 * 初始化订单
     * @param userId
     */
	public List<UserAddress> initOrder(String userId);

}
