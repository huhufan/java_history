package com.imooc.cake.service;

import com.imooc.cake.common.MyBatisUtils;
import com.imooc.cake.entity.Category;
import com.imooc.cake.mapper.CategoryMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;
import java.util.List;

/**
 *
 * 分类
 *
 * @version 1.0
 */
public class CategoryService {

    /**
     * 查询全部蛋糕分类
     * @return  全部蛋糕分类
     */
    public List<Category> getCateegories() {
        //获取SqlSession对象
        SqlSession sqlSession = MyBatisUtils.openSession();
        try {
            //获取CakeMapper的映射文件
            CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
            //通过getCategories()方法可以获得全部蛋糕的分类
            return mapper.getCategories();
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 插入蛋糕分类信息
     * @param category  蛋糕分类实体
     */
    public void addCategory(Category category) {
        //创建Date(日期类)对象
        Date now = new Date();
        //设置分类的创建时间
        category.setCreateTime(now);
        //设置分类的更新时间
        category.setUpdateTime(now);
        //获取SqlSession对象
        SqlSession sqlSession = MyBatisUtils.openSession();
        try {
            //获取CategoryMapper的映射文件
            CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
            //插入蛋糕的分类信息
            mapper.addCategory(category);
            //提交会话
            sqlSession.commit();
        } finally {
            //关闭会话
            sqlSession.close();
        }
    }

}
