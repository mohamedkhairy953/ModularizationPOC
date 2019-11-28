package com.bawbty.helper.utilities;

import android.app.Activity;
import android.graphics.Color;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import androidx.fragment.app.Fragment;

/**
 * Created by Mohamed Khaled on Tue, 19/Feb/2019 at 5:22 PM.
 * <p>
 * mohamed.khaled@apptcom.com
 * linkedin.com/in/mohamed5aled
 */
public class ImageViewUtils {
    public static void loadUrlIntoImageView(Fragment fragment, String url, ImageView imageView) {
        Glide.with(fragment).load(url)
                .apply(new RequestOptions()
                        .override(imageView.getWidth(), imageView.getHeight()))
                .into(imageView);
    }

    public static void loadUrlIntoImageView(Activity activity, String url, ImageView imageView) {
        Glide.with(activity).load(url)
                .apply(new RequestOptions()
                        .override(imageView.getWidth(), imageView.getHeight()))
                .into(imageView);
    }

    public static void dimImage(ImageView imageView) {
        imageView.setColorFilter(Color.rgb(123, 123, 123),
                android.graphics.PorterDuff.Mode.MULTIPLY);
    }

    public static void clearImageFilter(ImageView imageView) {
        imageView.clearColorFilter();
    }
}
