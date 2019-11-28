package com.bawbty.helper.alerts;

import android.content.Context;
import android.widget.Toast;
import androidx.annotation.StringRes;

/**
 * Provides method for showing UI messages, Snackbar, toast, etc..
 */
public class UiMessagesUtils {

    /**
     * /**
     * helper method that show a toast for short duration
     *
     * @param msg toast message
     */
    public void showToast(Context context, String msg) {
        if (context == null || msg == null) {
            return;
        }
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();

    }

    /**
     * helper method that show a toast for short duration
     *
     * @param stringRes toast message string resource
     */
    public void showToast(Context context, @StringRes int stringRes) {
        if (context == null) {
            return;
        }

        Toast.makeText(context, stringRes, Toast.LENGTH_SHORT).show();
    }



  /*  public void showSnackBar(View v, @StringRes int stringRes) {
        if (v == null) {
            return;
        }
        Snackbar snackbar = Snackbar.make(v, stringRes, Snackbar.LENGTH_LONG);
        snackbar.getView().setBackground(ContextCompat.getDrawable(v.getContext(), R.drawable.bg_bottom_sheet_dialog_error_fragment));
        TextView tv = snackbar.getView().findViewById(com.google.android.material.R.id.snackbar_text);
        tv.setTextColor(Color.WHITE);
        Snackbar.SnackbarLayout.LayoutParams layoutParams = (Snackbar.SnackbarLayout.LayoutParams) snackbar.getView().getLayoutParams();
        layoutParams.bottomMargin = 0;
        layoutParams.rightMargin = 0;
        layoutParams.leftMargin = 0;
        snackbar.getView().setLayoutParams(layoutParams);
        snackbar.show();
    }*/

}
