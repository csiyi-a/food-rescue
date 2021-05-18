package com.greendao.db.config;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.github.yuweiguocn.library.greendao.MigrationHelper;
import com.greendao.gen.DaoMaster;
import com.greendao.gen.UserDao;


import org.greenrobot.greendao.database.Database;

/**
 * 添加一个新的实体类步骤：
 * 一、旧表字段有改动，需要升级的，在MigrationHelper.migrate里面加上新的 NewDao.class，新表不需要加
 * 二、guild.gradle中修改schemaVersion为更高的版本号
 */
public class DaoUpdateOpenHelper extends DaoMaster.OpenHelper {

    public DaoUpdateOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }
    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        MigrationHelper.migrate(db, new MigrationHelper.ReCreateAllTableListener() {

            @Override
            public void onCreateAllTables(Database db, boolean ifNotExists) {
                DaoMaster.createAllTables(db, ifNotExists);
            }

            @Override
            public void onDropAllTables(Database db, boolean ifExists) {
                DaoMaster.dropAllTables(db, ifExists);
            }
        }, UserDao.class);
    }
}
