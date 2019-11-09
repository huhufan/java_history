package com.imooc.bm.entity;

import java.sql.Time;
import java.sql.Timestamp;

/**
 *  `id` bigint(20) NOT NULL AUTO_INCREMENT,
 *   `category_id` bigint(20) NOT NULL,
 *   `name` varchar(45) NOT NULL,
 *   `level` INT (2) NOT NULL,
 *   `price` INT(11) NOT NULL,
 *   `img_path` varchar(200) NOT NULL,
 *   `create_time` timestamp NULL DEFAULT NULL,
 *   `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRE
 */
public class Book {
    private int id;
    private Category category;
    private String name;
    private int level;
    private int price;
    private String imgPath;
    private Timestamp createTime;
    private Timestamp update_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Timestamp update_time) {
        this.update_time = update_time;
    }


}
