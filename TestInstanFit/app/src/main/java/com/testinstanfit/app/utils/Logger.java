package com.testinstanfit.app.utils;

import android.util.Log;

import com.testinstanfit.daniel.BuildConfig;


/**
 * Created by Daniel Ruiz
 */

public final class Logger {
    private Logger(){}

    public static void i(final String tag, final String memsaje) {
        if(BuildConfig.DEBUG_MODE_ENABLE) {
            Log.i(BuildConfig.TAG_DEBUG_MODE + "[" + tag + "]", memsaje);
        }


    }

    public static void i(final String memsaje) {

        if(BuildConfig.DEBUG_MODE_ENABLE) {
            Log.i(BuildConfig.TAG_DEBUG_MODE + "[" + Logger.class.getSimpleName() + "]", memsaje);
        }

    }

    public static void e(final String tag, final String memsaje) {
        if(BuildConfig.DEBUG_MODE_ENABLE) {
            Log.e(BuildConfig.TAG_DEBUG_MODE + "[" + tag + "]", memsaje);
        }

    }

    public static void e(final String memsaje) {
        if(BuildConfig.DEBUG_MODE_ENABLE) {
            Log.e(BuildConfig.TAG_DEBUG_MODE + "[" + Logger.class.getSimpleName() + "]", memsaje);
        }

    }

    public static void d(final String tag, final String memsaje) {
        if(BuildConfig.DEBUG_MODE_ENABLE) {
            Log.d(BuildConfig.TAG_DEBUG_MODE + "[" + tag + "]", memsaje);
        }

    }

    public static void d(final String memsaje) {
        if(BuildConfig.DEBUG_MODE_ENABLE) {
            Log.d(BuildConfig.TAG_DEBUG_MODE + "[" + Logger.class.getSimpleName() + "]", memsaje);
        }

    }
}
