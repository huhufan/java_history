package com.imooc.bm.service.impl;

import com.imooc.bm.dao.BookMapper;
import com.imooc.bm.dao.CategoryMapper;
import com.imooc.bm.entity.Book;
import com.imooc.bm.entity.Category;
import com.imooc.bm.service.BookService;
import com.imooc.bm.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    public void add(Category category) {
        categoryMapper.insert(category);
    }

    public List<Category> getAll() {
        return categoryMapper.getAll();
    }
}
