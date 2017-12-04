package com.testinstanfit.app.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.testinstanfit.app.InstanFitApplication;


public class ConectionManager {


    public boolean isConnected() {
        ConnectivityManager connectivityManager =(ConnectivityManager) InstanFitApplication.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);

        if(connectivityManager != null) {
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            return networkInfo != null && networkInfo.isConnected();
        }

        return false;
    }
}
