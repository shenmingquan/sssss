package com.example.day2_zuoyeyi;

import android.app.Application;
import android.content.Context;

/**
 * Created by lenovo on 2019/11/19.
 */

public class MyApp extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
