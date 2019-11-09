package com.imooc.canvas.service;

import com.imooc.canvas.common.MyBatisUtils;
import com.imooc.canvas.entity.Canvas;
import com.imooc.canvas.entity.Category;
import com.imooc.canvas.mapper.CanvasMapper;
import com.imooc.canvas.mapper.CategoryMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;
import java.util.List;

public class CanvasService {

    public List<Canvas> getCanvasById(Long categoryId) {
        SqlSession sqlSession = MyBatisUtils.getSession();
        try {
            CanvasMapper mapper = sqlSession.getMapper(CanvasMapper.class);
            return mapper.getCanvasByCategoryId(categoryId);
        } finally {
            sqlSession.close();
        }
    }

    public Canvas getCanvasByID(Long id) {
        SqlSession sqlSession = MyBatisUtils.getSession();
        try {
            CanvasMapper mapper = sqlSession.getMapper(CanvasMapper.class);
            return mapper.getCanvasById(id);
        } finally {
            sqlSession.close();
        }

    }

    public List<Canvas> getCanvas() {
        SqlSession sqlSession = MyBatisUtils.getSession();
        try {
            CanvasMapper mapper = sqlSession.getMapper(CanvasMapper.class);
            return mapper.getCanvas();
        } finally {
            sqlSession.close();
        }

    }

    public void delCanvas(Long id) {
        SqlSession sqlSession = MyBatisUtils.getSession();
        try {
            CanvasMapper mapper = sqlSession.getMapper(CanvasMapper.class);
            mapper.deleteCategory(id);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public void updateCanvas(Canvas canvas) {
        SqlSession sqlSession = MyBatisUtils.getSession();
        try {
            CanvasMapper mapper = sqlSession.getMapper(CanvasMapper.class);
            mapper.updateCanvas(canvas);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public void addCanvas(Canvas canvas) {
        SqlSession sqlSession = MyBatisUtils.getSession();
        try {
            CanvasMapper mapper = sqlSession.getMapper(CanvasMapper.class);
            mapper.addCanvas(canvas);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }
    public List<Canvas> getCanvasView(Integer skip,Integer size) {
        SqlSession sqlSession = MyBatisUtils.getSession();
        try {
            CanvasMapper mapper = sqlSession.getMapper(CanvasMapper.class);
            return mapper.getCanvasView(skip,size);
        } finally {
            sqlSession.close();
        }
    }
    public List<Canvas> getCanvasViewByCategoryId(Long categoryId,Integer skip,Integer size) {
        SqlSession sqlSession = MyBatisUtils.getSession();
        try {
            CanvasMapper mapper = sqlSession.getMapper(CanvasMapper.class);
            return mapper.getCanvasViewByCategoryId(categoryId,skip,size);
        } finally {
            sqlSession.close();
        }
    }
    public Integer countCanvas() {
        SqlSession sqlSession = MyBatisUtils.getSession();
        try {
            CanvasMapper mapper = sqlSession.getMapper(CanvasMapper.class);
            return mapper.countCanvas();
        } finally {
            sqlSession.close();
        }
    }
    public Integer countCanvasByCategoryId(Long id) {
        SqlSession sqlSession = MyBatisUtils.getSession();
        try {
            CanvasMapper mapper = sqlSession.getMapper(CanvasMapper.class);
            return mapper.countCanvasByCategoryId(id);
        } finally {
            sqlSession.close();
        }
    }
    public Canvas getImgById(Long id) {
        SqlSession sqlSession = MyBatisUtils.getSession();
        try {
            CanvasMapper mapper = sqlSession.getMapper(CanvasMapper.class);
            return mapper.getImg(id);
        } finally {
            sqlSession.close();
        }
    }
}


