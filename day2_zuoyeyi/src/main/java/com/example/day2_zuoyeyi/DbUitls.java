package com.example.day2_zuoyeyi;

import android.database.sqlite.SQLiteDatabase;


import com.example.day2_zuoyeyi.db.DaoMaster;
import com.example.day2_zuoyeyi.db.DaoSession;
import com.example.day2_zuoyeyi.db.PersonDao;

import java.util.List;

/**
 * Created by lenovo on 2019/11/19.
 */

public class DbUitls {
    private static final DbUitls ourInstance = new DbUitls();
    private final PersonDao dao;

    public static DbUitls getInstance() {
        return ourInstance;
    }

    private DbUitls() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(MyApp.getContext(), "student.db");
        SQLiteDatabase writableDatabase = devOpenHelper.getWritableDatabase();
        writableDatabase.disableWriteAheadLogging();
        DaoMaster daoMaster = new DaoMaster(writableDatabase);
        DaoSession daoSession = daoMaster.newSession();
        dao = daoSession.getPersonDao();
    }
    public long insert(Person person){
        if (person!=null){
            return dao.insertOrReplace(person);
        }
        return -1;
    }
    public List<Person> loadAll(){
        List<Person> people = dao.loadAll();
        return people;
    }
}
