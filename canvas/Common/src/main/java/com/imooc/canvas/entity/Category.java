package com.imooc.canvas.entity;

import java.sql.Timestamp;

public class Category {
    private Long id;
    private String name;
    private String createName;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
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

    public void setUpdateTime(Timestamp upTimestampTime) {
        this.updateTime = upTimestampTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category(Long id, String name,String createName, Timestamp createTime, Timestamp updateTime, String description) {
        this.id = id;
        this.name = name;
        this.createName = createName;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.description = description;
    }

    public Category(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Category(String name, String createName, String description) {
        this.name = name;
        this.createName = createName;
        this.description = description;
    }
}
