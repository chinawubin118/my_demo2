package com.lotte.mydemo2.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Administrator on 2016/7/2.
 */
public class ScaleViewPager extends ViewPager {
    public ScaleViewPager(Context context) {
        super(context);
    }

    public ScaleViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean result = false;
        try {
            result = super.onInterceptTouchEvent(ev);
        } catch (IllegalArgumentException e) {

        }
        return result;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        boolean result = false;
        try {
            result = super.onTouchEvent(ev);
        } catch (IllegalArgumentException e) {

        }
        return result;
    }
}
