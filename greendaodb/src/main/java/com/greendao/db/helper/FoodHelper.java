package com.greendao.db.helper;

import com.greendao.db.bean.Food;
import com.greendao.db.bean.User;
import com.greendao.db.config.DaoFactory;
import com.greendao.gen.FoodDao;
import com.greendao.gen.UserDao;

import java.util.List;

/**
 * ClassName: UserHelper
 * Description: 描述
 * Author: HuangGuoHua
 * Date: 2021/1/20 17:16
 */
public class FoodHelper {

    public static void save(Food book) {
        DaoFactory.getInstance().getBookDao().insert(book);
    }

    public static void delete(Food bk) {

        DaoFactory.getInstance().getBookDao().delete(bk);
    }

    public static void update(Food food){
        DaoFactory.getInstance().getBookDao().update(food);
    }

    public static List<Food> findAll(int type){
        if (type==0){
            return DaoFactory.getInstance().getBookDao().queryAll();
        }
        return DaoFactory.getInstance().getBookDao().queryByQueryBuilder(FoodDao.Properties.Type.eq(type));
    }

}
