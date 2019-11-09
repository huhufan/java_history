package com.imooc.cake.service;

import com.imooc.cake.common.MyBatisUtils;
import com.imooc.cake.entity.Cake;
import com.imooc.cake.mapper.CakeMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;
import java.util.List;

/**
 *
 * 蛋糕
 *
 * @version 1.0
 */
public class CakeService {

    /**
     * 根据分类分页查询蛋糕
     * @param categoryId    蛋糕分类ID
     * @param page  要查询的页数
     * @param size  要查询的记录数
     * @return  蛋糕集合
     */
    public List<Cake> getCakesByCategoryId(Long categoryId, Integer page, Integer size) {
        SqlSession sqlSession = MyBatisUtils.openSession();
        try {
            //获取CakeMapper的映射文件
            CakeMapper mapper = sqlSession.getMapper(CakeMapper.class);
            //通过mapper中的getCakesByCategoryId方法可以获取蛋糕集合
            return mapper.getCakesByCategoryId(categoryId, (page - 1) * size, size);
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 新增蛋糕
     * @param cake  蛋糕信息
     */
    public void addCake(Cake cake) {
        //创建时间类
        Date now = new Date();
        //设置cake的创建时间
        cake.setCreateTime(now);
        //设置cake的更新时间
        cake.setUpdateTime(now);
        //获取SqlSession对象
        SqlSession sqlSession = MyBatisUtils.openSession();
        try {
            //获取CakeMapper的映射文件
            CakeMapper mapper = sqlSession.getMapper(CakeMapper.class);
            //保存蛋糕信息
            mapper.addCake(cake);
            //提交当前sql会话
            sqlSession.commit();
        } finally {
            //关闭sql会话
            sqlSession.close();
        }
    }

    /**
     * 统计给定分类ID下的蛋糕数量
     * @param categoryId    分类ID
     * @return  统计结果
     */
    public int countCakesByCategoryId(Long categoryId) {
        //获取SqlSession对象
        SqlSession sqlSession = MyBatisUtils.openSession();
        try {
            //获取CakeMapper的映射文件
            CakeMapper mapper = sqlSession.getMapper(CakeMapper.class);
            //通过countCakesByCategoryId方法可以获得当前分类下蛋糕的数量
            return mapper.countCakesByCategoryId(categoryId);
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 根据ID查询对应的图片
     * @param id    蛋糕ID
     * @return  只包含图片信息的蛋糕实体
     */
    public Cake getCakeImg(Long id) {
        //获取SqlSession对象
        SqlSession sqlSession = MyBatisUtils.openSession();
        try {
            //获取CakeMapper的映射文件
            CakeMapper mapper = sqlSession.getMapper(CakeMapper.class);
            //通过getImg方法可以获得只包含图片的蛋糕实体类
            return mapper.getImg(id);
        } finally {
            sqlSession.close();
        }
    }

//    public static void main(String[] args) {
//        CakeService cakeService = new CakeService();
//        List<Cake> cakesByCategoryId = cakeService.getss();
//        System.out.println(cakesByCategoryId);
//    }

}
