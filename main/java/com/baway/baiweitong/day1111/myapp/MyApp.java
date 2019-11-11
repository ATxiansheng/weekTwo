package com.baway.baiweitong.day1111.myapp;
/**
 * 时间:2019.11.11
 * 作者:白维童
 * 功能:MyApp
 * */
import android.app.Application;
import android.content.Context;

public class MyApp extends Application {

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
}
