package com.learning.profuturo.en501863.vivenciav02.sliderpanel;

import android.content.Context;
import android.support.v4.widget.SlidingPaneLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by EN501863 on 08/01/2018.
 */

public class SliderTwoPane extends SlidingPaneLayout {

    private View partialView = null;
    private View fullView = null;

    public SliderTwoPane(Context context) {
        super(context);
    }

    public SliderTwoPane(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SliderTwoPane(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        if (getChildCount() < 1) {
            return;
        }

        View panel = getChildAt(0);
        if (!(panel instanceof ViewGroup)) {
            return;
        }

        ViewGroup viewGroup = (ViewGroup) panel;
        if (viewGroup.getChildCount() != 2) {
            return;
        }
        fullView = viewGroup.getChildAt(0);
        partialView = viewGroup.getChildAt(1);

        super.setPanelSlideListener(crossFadeListener);
    }

    private SimplePanelSlideListener crossFadeListener
            = new SimplePanelSlideListener() {
        @Override
        public void onPanelSlide(View panel, float slideOffset) {
            super.onPanelSlide(panel, slideOffset);
            if (partialView == null || fullView == null) {
                return;
            }
//            partialView.setVisibility(isOpen() ? View.GONE : VISIBLE);
            partialView.setVisibility(VISIBLE);
//            partialView.setAlpha(1 - slideOffset);
            fullView.setAlpha(slideOffset);
        }
    };

    @Override
    protected void onLayout(
            boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);

        if (partialView != null) {
//            partialView.setVisibility(isOpen() ? View.GONE : VISIBLE);
            partialView.setVisibility(VISIBLE);

        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }
}
