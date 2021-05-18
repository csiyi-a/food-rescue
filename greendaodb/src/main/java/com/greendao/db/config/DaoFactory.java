package com.greendao.db.config;

import com.greendao.db.bean.Food;
import com.greendao.db.bean.User;


/**
 * 初始化、存放及获取DaoUtils
 */
public class DaoFactory {

    private volatile static DaoFactory instance = new DaoFactory();
    private DaoUtils<User> mUserDao;
    private DaoUtils<Food> mFoodDao;


    public static DaoFactory getInstance() {
        return instance;
    }

    private DaoFactory() {

        DaoManager mManager = DaoManager.getInstance();

        mUserDao = new DaoUtils(User.class, mManager.getDaoSession().getUserDao());
        mFoodDao = new DaoUtils(Food.class, mManager.getDaoSession().getFoodDao());

    }

    public DaoUtils<User> getUserDao() {
        return mUserDao;
    }

    public DaoUtils<Food> getBookDao() {
        return mFoodDao;
    }

}