package com.bawbty.helper.utilities;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;

import java.util.List;

import static android.content.pm.PackageManager.MATCH_DEFAULT_ONLY;

/**
 * Created by Mohamed Khaled on Mon, 08/Oct/2018 at 4:52 PM.
 * <p>
 * mohamed.khaled@apptcom.com
 * linkedin.com/in/mohamed5aled
 */
public class IntentUtils {


    /**
     * @param context
     * @param address latitude,longitude and any queries ex: "24.690466,46.68419319999998"
     */
    public static void openLocationAddress(Context context, String address) {
        String map = "http://maps.google.com/maps?q=loc:" + Uri.encode(address);
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(map));
        startActivitySafely(context, i);
    }

    public static void openWebsite(Context context, String url) {
        String finalURl = url;
        if (!url.startsWith("http://") && !url.startsWith("https://"))
            finalURl = "http://" + url;
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(finalURl));
        startActivitySafely(context, browserIntent);
    }

    private static void openWebsite(String url, Context context) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivitySafely(context, browserIntent);
    }

    private static void startActivitySafely(Context context, Intent intent) {
        if (intent.resolveActivity(context.getPackageManager()) != null)
            context.startActivity(intent);
/*        else
            Toast.makeText(context,
                    context.getResources().getString(R.string.no_apps_avialable_to_open),
                    Toast.LENGTH_SHORT).show();*/
    }

    private static boolean isCanOpenIntent(Context context, Intent browserIntent) {
        PackageManager packageManager = context.getPackageManager();
        List<ResolveInfo> infoPackage = packageManager
                .queryIntentActivities(browserIntent, MATCH_DEFAULT_ONLY);
        return infoPackage != null && !infoPackage.isEmpty();
    }


}
