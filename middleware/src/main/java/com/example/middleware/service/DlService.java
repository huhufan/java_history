package com.example.middleware.service;

import com.example.middleware.entity.Dl;

import java.util.List;

public interface DlService {
     boolean add(Dl dl);
     boolean remove(String xm);
     boolean update(Dl dl);
     List<Dl> getAll();
     Dl getByXM(String xm);
}
