package com.imooc.canvas.entity;

import javafx.scene.chart.PieChart;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;

/**
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
public class Canvas {
    private Long id;
    private Long categoryId;
    private String name;
    private String creator;
    private Integer price;
    private byte[] smallImg;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String description;
    private String details;

    @Override
    public String toString() {
        return "Canvas{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", creator='" + creator + '\'' +
                ", price=" + price +
                ", smallImg=" + Arrays.toString(smallImg) +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", description='" + description + '\'' +
                ", details='" + details + '\'' +
                '}';
    }

    public Canvas() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public byte[] getSmallImg() {
        return smallImg;
    }

    public void setSmallImg(byte[] smallImg) {
        this.smallImg = smallImg;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Canvas(Long id, Long categoryId, String name, String creator, Integer price, Timestamp createTime, Timestamp updateTime, String description, String details) {
        this.id = id;
        this.categoryId = categoryId;
        this.name = name;
        this.creator = creator;
        this.price = price;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.description = description;
        this.details = details;
    }

    public Canvas(Long id, Long categoryId, String name, String creator, Integer price, byte[] smallImg, Timestamp createTime, Timestamp updateTime, String description, String details) {
        this.id = id;
        this.categoryId = categoryId;
        this.name = name;
        this.creator = creator;
        this.price = price;
        this.smallImg = smallImg;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.description = description;
        this.details = details;
    }
}
