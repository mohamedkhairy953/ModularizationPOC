package com.bawbty.helper.utilities;

import android.content.Context;

public class DimensUtil {
    public static float dpFromPx(final Context context, final float px) {
        float v = px / context.getResources().getDisplayMetrics().density;

        return v;
    }

    public static float pxFromDp(final Context context, final float dp) {
        return dp * context.getResources().getDisplayMetrics().density;
    }
}
