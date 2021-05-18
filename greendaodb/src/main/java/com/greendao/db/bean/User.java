package com.greendao.db.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * ClassName: User
 * Description: 描述
 * Author: HuangGuoHua
 * Date: 2021/1/20 16:37
 */
@Entity
public class User {

    @Id(autoincrement = true)
    private Long id;
    @Property
    private String name;
    @Unique
    private String email;
    @Unique
    private String phone;
    @Property
    private String address;
    @Property
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Generated(hash = 586692638)
    public User() {
    }

    @Generated(hash = 353038568)
    public User(Long id, String name, String email, String phone, String address,
            String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.password = password;
    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
