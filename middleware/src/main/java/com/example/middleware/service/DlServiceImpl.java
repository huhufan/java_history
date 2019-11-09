package com.example.middleware.service;

import com.example.middleware.Dao.DlDAO;
import com.example.middleware.entity.Dl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DlServiceImpl implements DlService {
    @Autowired
    private DlDAO dlDAO;
    @Override
    public boolean add(Dl dl) {
        return dlDAO.insert(dl);
    }

    @Override
    public boolean remove(String xm) {
        return dlDAO.delete(xm);
    }

    @Override
    public boolean update(Dl dl) {
        return dlDAO.update(dl);
    }

    @Override
    public List<Dl> getAll() {
        return dlDAO.selectAll();
    }

    @Override
    public Dl getByXM(String xm) {
        return dlDAO.selectByXM(xm);
    }
}
