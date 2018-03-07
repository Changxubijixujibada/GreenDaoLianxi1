package com.example.cx.greendaolianxi1;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.administrator.greebdao.gen.DaoMaster;
import com.example.administrator.greebdao.gen.DaoSession;

/**
 * Created by cx on 2018/2/25.
 */

public class MyAppaction extends Application {
    public static MyAppaction application;

    private DaoSession daoSession;


    public static MyAppaction getApplication() {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application=this;
        DbData();

    }

    private void DbData() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "mybean.db");

        SQLiteDatabase db = devOpenHelper.getWritableDatabase();

        DaoMaster daoMaster = new DaoMaster(db);

        daoSession=daoMaster.newSession();
    }

    public DaoSession getDaoSession(){
        return daoSession;
    }

}
