package com.bawbty.helper.livedata;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import androidx.annotation.Nullable;
import com.bawbty.application.BaseApplicationClass;
import com.bawbty.helper.utilities.NetworkUtils;
import com.bawbty.helper.R;
import retrofit2.Response;

import java.lang.ref.WeakReference;

/**
 * Wrapper helper class that wraps the result of the network calls
 * </br>
 * Provides easy access to response body and code
 *
 * @param <T>
 */
public class ApiResponse<T> {

    private static final String TAG = "ApiResponse";
    public final int code;
    @Nullable
    public final T body;

    @Nullable
    private final String errorMessage;

    private final boolean isSuccessful;

    private WeakReference<Context> contextWeakReference = new
            WeakReference<>(BaseApplicationClass.Companion.get());

    private Resources appResources = contextWeakReference.get().getResources();

    public ApiResponse(Throwable error) {
        code = 500;
        body = null;
        isSuccessful = false;
        Log.e(TAG, error.getMessage(), error);
        if (contextWeakReference.get() != null &&
                !NetworkUtils.isNetworkAvailable(contextWeakReference.get())) {
            errorMessage = appResources.getString(R.string.general_error_network);
        } else
            errorMessage = appResources.getString(R.string.general_error_server);
    }

    public ApiResponse(Response<T> response) {
        code = response.code();
        if (response.isSuccessful()) {
            body = response.body();
            errorMessage = null;
            isSuccessful = true;
            Log.d("LOGD", "ApiResponse: " + response.body());
        } else {
            isSuccessful = false;
            body = null;
            Log.d("LOGD", "ApiResponse: false");
            if (contextWeakReference.get() != null) {
                if (response.code() == 401) {
                    errorMessage = appResources.getString(R.string.general_error_invalid_credentials);
                } else {
                    errorMessage = appResources.getString(R.string.general_error_try_again_error);
                }
            } else
                errorMessage = appResources.getString(R.string.general_error_try_again_error);
        }
    }

    @Nullable
    public String getErrorMessage() {
        return errorMessage;
    }

    public boolean isSuccessful() {
        return isSuccessful;
    }

    public int getCode() {
        return code;
    }

    @Nullable
    public T getBody() {
        return body;
    }

}