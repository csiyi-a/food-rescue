package com.greendao.db.helper;

import android.content.Context;

import com.greendao.db.bean.User;
import com.greendao.db.config.DaoFactory;
import com.greendao.db.config.DaoUtils;

import java.util.List;

/**
 * ClassName: UserHelper
 * Description: 描述
 * Author: HuangGuoHua*
 * Date: 2021/1/20 17:16
 */
public class UserHelper {

    public static void save(User user){
        DaoFactory.getInstance().getUserDao().insert(user);
    }

    public static void delete(User user){
        DaoFactory.getInstance().getUserDao().delete(user);
    }

    public static void update(User user){
        DaoFactory.getInstance().getUserDao().update(user);
    }

    public static User find(){
       return DaoFactory.getInstance().getUserDao().query();
    }

}
