package me.ccrama.redditslide.Views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.jetbrains.annotations.NotNull;

/**
 * Created by ccrama on 7/20/2015.
 */
class AutoHideFAB extends FloatingActionButton.Behavior {
    public AutoHideFAB(Context context, AttributeSet attributeSet) {
        super();
    }

    @Override
    public void onNestedScroll(@NotNull CoordinatorLayout coordinatorLayout,
                               @NotNull FloatingActionButton child, @NotNull View target, int dxConsumed,
                               int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type, @NonNull int[] consumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type, consumed);
        if (dyConsumed > 0 && child.getVisibility() == View.VISIBLE) {
            child.hide();
        } else if (dyConsumed < 0 && child.getVisibility() == View.GONE) {
            child.show();
        }
    }

    @Override
    public boolean onStartNestedScroll(@NotNull CoordinatorLayout coordinatorLayout,
                                       @NotNull FloatingActionButton child, @NotNull View directTargetChild,
                                       @NotNull View target, int nestedScrollAxes, int type) {
        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL;
    }

}