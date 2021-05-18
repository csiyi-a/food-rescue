package com.example.foodrescue;


import android.app.Application;

import com.greendao.db.config.DaoManager;

/**
 * Created with Android Studio.
 * User: huanggh
 * Date: 2020/11/4
 * Time: 18:58
 */
public class MyApp extends Application {

    public static MyApp getContext() {
        return application;
    }

    private static MyApp application;

    @Override
    public void onCreate() {
        super.onCreate();

        application = this;

        DaoManager.getInstance().init(this);

    }





}
