package com.bawbty.helper.core;

import android.util.Log;
import com.bawbty.helper.BuildConfig;

public class Logger {

    private static final String TAG = "bawbty";

    public static void v(String str) {
        if (BuildConfig.DEBUG)
            Log.v(TAG, str);
    }

    public static void i(String str) {
        if (BuildConfig.DEBUG)
            Log.i(TAG, str);
    }

    public static void e(String str, Throwable e) {
        if (BuildConfig.DEBUG)
            Log.e(TAG, str, e);
    }

    public static void d(String str) {
        if (BuildConfig.DEBUG)
            Log.d(TAG, str);
    }

}

