package com.bawbty.helper.animation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Keep;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.snackbar.Snackbar;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Mohamed Khaled on Tue, 14/Aug/2018 at 1:22 PM.
 * <p>
 * mohamed.khaled@apptcom.com
 * linkedin.com/in/mohamed5aled
 * <p>
 * This class handles pushing up any view inside Coordinator layout when a snackbar is shown
 * <p>
 * usage inside any view inside Coordinator layout that requires pushing upwards:
 * <br>
 * app:layout_behavior="com.apptcom.zevent.helpers.animation.MoveUpwardBehavior"
 * <p>
 * </p>
 */

@Keep //keep annotation used to make proguard keep the class when minifyEnabled is true
public class MoveUpwardBehavior extends CoordinatorLayout.Behavior<View> {

    public MoveUpwardBehavior() {
        super();
    }

    public MoveUpwardBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(@NotNull CoordinatorLayout parent, @NotNull View child, @NotNull View dependency) {
        return dependency instanceof Snackbar.SnackbarLayout;
    }

    @Override
    public boolean onDependentViewChanged(@NotNull CoordinatorLayout parent, @NotNull View child, @NotNull View dependency) {
        float translationY = Math.min(0, dependency.getTranslationY() - dependency.getHeight());
        ViewCompat.animate(child).cancel(); //cancel potential animation started in onDependentViewRemoved()
        child.setTranslationY(translationY);
        return true;
    }

    //you need this when you swipe the snackbar(thanx to ubuntudroid's comment)
    @Override
    public void onDependentViewRemoved(@NotNull CoordinatorLayout parent, @NotNull View child, @NotNull View dependency) {
        ViewCompat.animate(child).setDuration(100).translationY(0).start();
    }
}