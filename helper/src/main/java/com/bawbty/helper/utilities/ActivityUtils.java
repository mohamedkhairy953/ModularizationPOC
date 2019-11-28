package com.bawbty.helper.utilities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

/*
  Created by Mohamed Khaled on Thu, 09/Aug/2018 at 1:01 PM.
  <p>
  mohamed.khaled@apptcom.com
  linkedin.com/in/mohamed5aled
 */

/**
 * This provides methods to help Activities load their UI.
 */
public class ActivityUtils {

    /**
     * The {@code fragment} is added to the container view with id {@code frameId}. The operation is
     * performed by the {@code fragmentManager}.
     */
    public static void replaceFragmentInActivity(@NonNull FragmentManager fragmentManager,
                                                 @NonNull Fragment fragment, int frameId, boolean addToBackStack) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(frameId, fragment);
        if (addToBackStack)
            transaction.addToBackStack(fragment.getClass().getSimpleName());
        transaction.commit();
    }

    /**
     * The {@code fragment} is added to the container view with id {@code frameId} in this Fragment ( Nested Fragments ). The operation is
     * performed by the {@code fragmentManager} with transaction fragment fade.
     */
    public static void replaceFragmentInFragment(@NonNull FragmentManager fragmentManager,
                                                 @NonNull Fragment fragment, int frameId) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(frameId, fragment);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        transaction.commit();
    }

    /**
     * The {@code fragment} is added to the container view with id {@code frameId}. Also this fragment is added to backStack.
     * The operation is performed by the {@code fragmentManager}.
     */
    public static void addFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                             @NonNull Fragment fragment, int frameId) {
        if (fragment == null || fragmentManager == null)
            return;
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(frameId, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public static void goToActivity(Activity activity, Class mClassDestination, boolean clearBackStack) {
        if (!activity.isDestroyed()) {
            Intent myIntent = new Intent(activity, mClassDestination);
            activity.startActivity(myIntent);
            if (clearBackStack) {
                activity.finishAffinity();
            }
        }
    }

    public static void goToActivity(Activity activity, Intent myIntent, boolean clearBackStack) {
        if (!activity.isDestroyed()) {
            activity.startActivity(myIntent);
            if (clearBackStack) {
                activity.finishAffinity();
            }
        }
    }


    /**
     * Helper method to hide the keyboard
     */
    public static void hideKeyboard(Activity activity) {
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            InputMethodManager inputManager = (InputMethodManager)
                    activity.getSystemService(Context.INPUT_METHOD_SERVICE);

            if (inputManager != null)
                inputManager.hideSoftInputFromWindow((null == activity.getCurrentFocus()) ? null : activity.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    /**
     * Helper method to check if a given fragment is the last fragment is back stack entries
     * @param activity Current activity that holds the stack
     * @param fragment Fragment to check
     * @return true if it's the last fragment, false if it's not.
     */
    public static boolean isLastFragmentInStack(AppCompatActivity activity, Fragment fragment) {
        int fragmentsCount = activity.getSupportFragmentManager().getBackStackEntryCount();
        return activity.getSupportFragmentManager().getBackStackEntryAt
                (fragmentsCount - 1).getName().equals(fragment.getClass().getSimpleName());
    }
}
