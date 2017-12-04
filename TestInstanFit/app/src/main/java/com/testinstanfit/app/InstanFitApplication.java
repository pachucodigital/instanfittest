package com.testinstanfit.app;


import android.app.Application;


/**
 * Created by Daniel Ruiz
 */

public class InstanFitApplication extends Application {
    private static final String TAG =InstanFitApplication.class.getSimpleName();
    private static InstanFitApplication mInstance;

    public InstanFitApplication(){
        //not override method
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initialize(this);
     }



    private static void initialize(final InstanFitApplication apiApplication) {
        mInstance = apiApplication;
    }



    public static InstanFitApplication getInstance(){
        return mInstance;
    }
}



