package com.greendao.db.bean;


import androidx.annotation.Nullable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Transient;

import java.io.Serializable;


@Entity
public class Food implements Serializable {
    @Transient
    private static final long serialVersionUID = 1L;

    @Id(autoincrement = true)
    private Long id;
    private int type;// 0 全部；1 我的


    private String title;
    private String imgUrl;
    private String desc;

    private String createDate;

    private String quantity;

    private String location;


    @Generated(hash = 661270706)
    public Food(Long id, int type, String title, String imgUrl, String desc,
            String createDate, String quantity, String location) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.imgUrl = imgUrl;
        this.desc = desc;
        this.createDate = createDate;
        this.quantity = quantity;
        this.location = location;
    }

    @Generated(hash = 866324199)
    public Food() {
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
