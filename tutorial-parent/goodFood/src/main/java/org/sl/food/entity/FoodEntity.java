package org.sl.food.entity;

import java.util.Date;

public class FoodEntity {
    private String id;

    private String name;

    private String detailsSite;

    private String picture;

    private Integer diffculteLevel;

    private String tasteType;

    private String auther;

    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDetailsSite() {
        return detailsSite;
    }

    public void setDetailsSite(String detailsSite) {
        this.detailsSite = detailsSite == null ? null : detailsSite.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public Integer getDiffculteLevel() {
        return diffculteLevel;
    }

    public void setDiffculteLevel(Integer diffculteLevel) {
        this.diffculteLevel = diffculteLevel;
    }

    public String getTasteType() {
        return tasteType;
    }

    public void setTasteType(String tasteType) {
        this.tasteType = tasteType == null ? null : tasteType.trim();
    }

    public String getAuther() {
        return auther;
    }

    public void setAuther(String auther) {
        this.auther = auther == null ? null : auther.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}