package com.example.allen.cours_selection.application;

import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatDelegate;

public class CourseApplication extends Application {
    private static CourseApplication instance;
    private static Context appContext;

    public static CourseApplication getInstance() {
        return instance;
    }

    public static Context getAppContext() {
        return appContext;
    }

    public void setAppContext(Context mAppContext) {
        this.appContext = mAppContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        this.setAppContext(getApplicationContext());
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
}