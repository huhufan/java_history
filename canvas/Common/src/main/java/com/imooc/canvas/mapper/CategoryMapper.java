package com.imooc.canvas.mapper;

import com.imooc.canvas.entity.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 分类接口
 */
public interface CategoryMapper {

    @Select("select id,name,createName,createTime,updateTime,description from category")
    List<Category> getCategory();

    @Select("select id,name,createName,createTime,updateTime,description from category where id = #{id}")
    Category getCategoryById(@Param("id") Long id);

    @Delete("delete from category where id = #{id}")
    void deleteCategory(@Param("id") Long id);

    @Update("update category set description = #{category.description},name =#{category.name} where id = #{category.id}")
    void updateCategory(@Param("category") Category category);

    @Insert("insert into category(name,createName,description) values (#{category.name}, #{category.createName}, #{category.description})")
    void addCategory(@Param("category") Category category);



}
