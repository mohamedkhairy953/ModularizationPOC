package com.bawbty.helper.binding;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.databinding.BindingAdapter;
import com.bawbty.helper.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class BindingAdapters {

    /**
     * helper method to set the @param view (ImageView) with the given remote
     *
     * @param imageUrl (String) using Glide
     */
    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext()).asDrawable().load(imageUrl).into(view);
    }

    /**
     * helper method to set the @param view (ImageView) with the given
     *
     * @param drawable (Drawable) as its background
     */
    @BindingAdapter("loadBackgroundDrawable")
    public static void loadBackgroundDrawable(ImageView view, Drawable drawable) {
        view.setBackground(drawable);
    }

    /**
     * helper method to set the @param view (TextView) with the given
     *
     * @param stringRes (@StringRes) as its text
     */
    @BindingAdapter("setTextString")
    public static void setTextString(TextView view, @StringRes int stringRes) {
        view.setText(stringRes);
    }

    /**
     * helper method to set the @param view (ImageView) with the given
     *
     * @param imageUrl (String) and applying CircleCropTransformation
     */
    @BindingAdapter("ImageUrlCircular")
    public static void loadCircularImage(ImageView view, String imageUrl) {
        // Logger.i("loading circular image");
        Glide.with(view.getContext())
                .load(imageUrl)
                .apply(RequestOptions.circleCropTransform().placeholder(R.drawable.ic_launcher_background))
                .into(view);
    }

    /**
     * helper method to set the @param view (ImageView) with the given
     *
     * @param drawable (Drawable) as its source
     */
    @BindingAdapter("imageDrawable")
    public static void setImageDrawable(ImageView view, Drawable drawable) {
        view.setImageDrawable(drawable);
    }

    /**
     * helper method to set the @param view (ImageView) with the given
     *
     * @param imageUrl (String) as its source and transform that ImageView
     *                 with rounded corners options (value 16)
     */
    @BindingAdapter("ImageUrlRounded")
    public static void loadRoundedImage(ImageView view, String imageUrl) {
        //  Logger.i("loading rounded image");
        RequestOptions requestOptions = new RequestOptions();
        requestOptions = requestOptions.transforms(new RoundedCorners(16));
        Glide.with(view.getContext())
                .load(imageUrl)
                .apply(requestOptions)
                .into(view);
    }

    /**
     * helper method to set the @param view visibility based on the response from the server whether
     * the object is null or not
     */
    @BindingAdapter("ImageDrawableRounded")
    public static void loadRoundedImage(ImageView view, Drawable drawable) {
        //  Logger.i("loading rounded image");
        RequestOptions requestOptions = new RequestOptions();
        requestOptions = requestOptions.transforms(new RoundedCorners(16));
        Glide.with(view.getContext())
                .load(drawable)
                .apply(requestOptions)
                .into(view);
    }

    /**
     * helper method to set the @param view visibility based on the response from the server whether
     * the object is null or not
     */
    @BindingAdapter("viewVisibility")
    public static void setViewVisibility(View view, Object object) {
        view.setVisibility(object == null ? GONE : VISIBLE);
    }

    /**
     * helper method to set the @param view (AppCompatSpinner) with the given
     *
     * @param spinnerValue (String) , With a default value of Male
     */
    @BindingAdapter("genderSpinnerValue")
    public static void loadSpinnerValue(AppCompatSpinner view, String spinnerValue) {
        if (spinnerValue == null)
            view.setSelection(0);
        else {
            if (spinnerValue.equals("male"))
                view.setSelection(0);
            else
                view.setSelection(1);
        }
    }

}
