package com.imooc.sm.service.impl;

import com.imooc.sm.dao.SelfDao;
import com.imooc.sm.dao.StaffDao;
import com.imooc.sm.entity.Staff;
import com.imooc.sm.service.SelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("selfService")
public class SelfImpl implements SelfService {
    @Autowired
    private SelfDao selfDao;
    @Autowired
    private StaffDao staffDao;


    public Staff login(String account,String password) {
        Staff s = selfDao.selectByAccount(account);
        if (s==null) return null;
        if (s.getPassword().equals(password)) return s;
        return null;
    }

    public void changePassword(Integer id, String password) {
        Staff s = staffDao.selectById(id);
        s.setPassword(password);
        staffDao.update(s);
    }
}
