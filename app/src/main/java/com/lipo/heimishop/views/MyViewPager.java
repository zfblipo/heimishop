package com.lipo.heimishop.views;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Administrator on 2016/10/18 0018.
 */
public class MyViewPager extends ViewPager {


    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyViewPager(Context context) {
        super(context);
    }


    private float rawY;
    private float rawX;

//防止与PhotoView 的触摸事件冲突发生错误：
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        switch (ev.getAction()) {

            case MotionEvent.ACTION_DOWN:
                rawY = ev.getRawY();
                rawX = ev.getRawX();
                break;
            case MotionEvent.ACTION_MOVE:
                float nowY = ev.getRawY() - rawY;
                float nowX = ev.getRawX() - rawX;
                if (Math.abs(nowX)<Math.abs(nowY)) {
                    return false;
                }
                rawY = ev.getRawY();
                rawX = ev.getRawX();
                break;

        }

        return super.onInterceptTouchEvent(ev);
    }

}
