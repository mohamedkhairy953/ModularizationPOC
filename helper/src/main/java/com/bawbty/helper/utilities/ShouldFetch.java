package com.bawbty.helper.utilities;


import com.bawbty.application.BaseApplicationClass;

/**
 * Created by Mohamed Khaled on Mon, 15/Oct/2018 at 11:52 AM.
 * <p>
 * mohamed.khaled@apptcom.com
 * linkedin.com/in/mohamed5aled
 */
public class ShouldFetch {
    public static boolean networkRecommended() {
        return NetworkUtils.isNetworkAvailable(BaseApplicationClass.Companion.get());
    }
}
