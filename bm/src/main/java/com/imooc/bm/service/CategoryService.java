package com.imooc.bm.service;

import com.imooc.bm.entity.Book;
import com.imooc.bm.entity.Category;

import java.util.List;

public interface CategoryService {
    void add(Category category);
    List<Category> getAll();
}
