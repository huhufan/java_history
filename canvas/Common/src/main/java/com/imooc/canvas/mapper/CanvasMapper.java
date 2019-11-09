package com.imooc.canvas.mapper;

import com.imooc.canvas.entity.Canvas;
import com.imooc.canvas.entity.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 油画接口
 * CREATE TABLE `canvas` (
 *   `id` bigint(20) NOT NULL AUTO_INCREMENT,
 *   `categoryId` bigint(20) NOT NULL,
 *   `name` varchar(45) NOT NULL,
 *   `creator` varchar(50) DEFAULT NULL,
 *   `price` int(9) DEFAULT NULL,
 *   `smallImg` mediumblob,
 *   `createTime` timestamp NULL DEFAULT NULL,
 *   `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
 *   `description` varchar(255) DEFAULT NULL,
 *   `details` varchar(20000) DEFAULT NULL,
 *   PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
 */
public interface CanvasMapper {


    @Select("select c.id , categoryId , c.name ,creator , price , c.createTime , c.updateTime , c.description , ca.name as details from canvas as c join category as ca on c.categoryId = ca.id order by createTime")
    List<Canvas> getCanvas();

    @Select("select id , categoryId , name ,creator , price , createTime , updateTime , description , details from canvas where id = #{id} order by createTime")
    Canvas getCanvasById(@Param("id") Long id);

    @Select("select c.id,categoryId,c.name,creator,price,c.createTime,c.updateTime,c.description,ca.name as details from canvas as c join category as ca on c.categoryId = ca.id and c.categoryId = #{categoryId} order by createTime")
    List<Canvas> getCanvasByCategoryId(@Param("categoryId")Long categoryId);

    @Delete("delete from canvas where id = #{id}")
    void deleteCategory(@Param("id") Long id);

    @Update("update canvas set name = #{canvas.name},categoryId = #{canvas.categoryId},price = #{canvas.price}, description = #{canvas.description},smallImg =#{canvas.smallImg} where id = #{canvas.id}")
    void updateCanvas(@Param("canvas") Canvas canvas);

    @Insert("insert into canvas(name,categoryId,price,description,creator,smallImg,createTime) values(#{canvas.name},#{canvas.categoryId}, #{canvas.price}, #{canvas.description}, #{canvas.creator} ,#{canvas.smallImg},#{canvas.createTime})")
    void addCanvas(@Param("canvas") Canvas canvas);

    @Select("select smallImg  from canvas where id = #{id} for update")
    Canvas getImg(@Param("id")Long id);

    //Site

    @Select("select id , name , description from canvas order by createTime limit #{skip},#{size} ")
    List<Canvas> getCanvasView(@Param("skip") Integer skip,@Param("size") Integer size);

    @Select("select id , name , description from canvas where categoryId = #{categoryId} order by createTime limit #{skip},#{size} ")
    List<Canvas> getCanvasViewByCategoryId(@Param("categoryId") Long categoryId,@Param("skip") Integer skip,@Param("size") Integer size);

    @Select("select count(*) from canvas where categoryId = #{categoryId}")
    int countCanvasByCategoryId(@Param("categoryId")Long categoryId);

    @Select("select count(*) from canvas")
    int countCanvas();

}
