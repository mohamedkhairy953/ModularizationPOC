package com.bawbty.helper.core;

import android.content.SharedPreferences;
import androidx.annotation.Nullable;

/**
 * Created by Mohamed Khaled on Thu, 09/Aug/2018 at 1:01 PM.
 * <p>
 * mohamed.khaled@apptcom.com
 * linkedin.com/in/mohamed5aled
 */
public class SharedPreferencesHelper {

    public static final String PREF_NAME = "bawbty_shared_prefs";

    private static final String USER_TOKEN = "user_token";
    private static final String DEVICE_TOKEN = "device_token";
    private static final String BIO_AUTH = "biometric";
    private static final String DEVICE_TYPE = "dev";

    private static final String LANGUAGE_CODE = "language_code";
    private static final String LANGUAGE_ID = "id";

    private static final String USER_LOGGED_IN = "user_logged_in";


    private SharedPreferences sharedPreferences;
    private String LOCALE = "locale";

    public SharedPreferencesHelper(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public void clearSharedPreferences() {
        sharedPreferences.edit().clear().apply();
    }

    @Nullable
    public String getUserToken() {
        return sharedPreferences.getString(USER_TOKEN, "");
    }

    public void setUserToken(String userToken) {
        sharedPreferences.edit().putString(USER_TOKEN, userToken).apply();
    }

    @Nullable
    public boolean isUserUseBioAuth() {
        return sharedPreferences.getBoolean(BIO_AUTH, false);
    }

    public void setUserUseBioAuth(boolean isUserUseBioAuth) {
        sharedPreferences.edit().putBoolean(BIO_AUTH, isUserUseBioAuth).apply();
    }

    @Nullable
    public String getDeviceType() {
        return DEVICE_TYPE;
    }

    @Nullable
    public String getLanguageCode() {
        return sharedPreferences.getString(LANGUAGE_CODE, "en");
    }

    public void setLanguageCode(String languageCode) {
        sharedPreferences.edit().putString(LANGUAGE_CODE, languageCode).apply();
    }

    public boolean isUserLoggedIn() {
        return sharedPreferences.getBoolean(USER_LOGGED_IN, false);
    }

    public void setUserLoggedIn(boolean isUserLoggedIn) {
        sharedPreferences.edit().putBoolean(USER_LOGGED_IN, isUserLoggedIn).apply();
    }

    public void saveLocale(String locale) {
        sharedPreferences.edit().putString(LOCALE, locale).apply();
    }

    public String getLocale() {
        return sharedPreferences.getString(LOCALE, null);
    }

    public void logout() {
        setUserToken("");
    }
}
