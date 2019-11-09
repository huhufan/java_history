package com.imooc.cp.biz;

import com.imooc.cp.entity.Employee;

public interface GlobalBiz {
    Employee login(String sn,String password);

    void changPassord(Employee employee);
}
