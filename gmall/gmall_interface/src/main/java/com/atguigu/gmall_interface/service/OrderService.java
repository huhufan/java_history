package com.atguigu.gmall_interface.service;

import java.util.List;

import com.atguigu.gmall_interface.bean.UserAddress;
import com.atguigu.gmall_interface.bean.UserAddress;

public interface OrderService {
	
	/**
	 * 初始化订单
     * @param userId
     */
	public List<UserAddress> initOrder(String userId);

}
