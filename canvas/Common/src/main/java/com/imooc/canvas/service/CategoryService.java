package com.imooc.canvas.service;

import com.imooc.canvas.common.MyBatisUtils;
import com.imooc.canvas.entity.Category;
import com.imooc.canvas.mapper.CategoryMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CategoryService {
    public List<Category> getCategories() {
        SqlSession sqlSession = MyBatisUtils.getSession();
        try {
            CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
            return mapper.getCategory();
        }finally {
            sqlSession.close();
        }
    }

    public void delCategory(Long id) {
        SqlSession sqlSession = MyBatisUtils.getSession();
        try {
            CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
            mapper.deleteCategory(id);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }
    public void updateCategory(Category category) {
        SqlSession sqlSession = MyBatisUtils.getSession();
        try {
            CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
            mapper.updateCategory(category);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }
    public void addCategory(Category category) {
        SqlSession sqlSession = MyBatisUtils.getSession();
        try {
            CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
            mapper.addCategory(category);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }

    public Category getCategoryById(Long id) {
        SqlSession sqlSession = MyBatisUtils.getSession();
        try {
            CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
            return mapper.getCategoryById(id);
        }finally {
            sqlSession.close();
        }
    }
}
