package com.imooc.cp.biz.impl;

import com.imooc.cp.biz.GlobalBiz;
import com.imooc.cp.dao.EmployeeDao;
import com.imooc.cp.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GlobalBizImpl implements GlobalBiz {
    @Autowired
    private EmployeeDao employeeDao;

    public Employee login(String sn, String password) {
        Employee employee = employeeDao.select(sn);
        if (employee.getPassword().equals(password))
            return employee;
        return null;
    }

    public void changPassord(Employee employee) {
         employeeDao.update(employee);
    }
}
