package com.timen4.ronnny.customview1.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

/**
 * 该图形由园、弧形、TextView 三部分组成
 * Created by luore on 2016/6/20.
 */
public class ScoreView extends View{
    private int mCircleXY;
    public ScoreView(Context context) {
        this(context,null);
    }

    public ScoreView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ScoreView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        int length=getScreenWidth(getContext());
        //1、设置要绘制的图形的参数
        mCircleXY=length/2;


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    //获取屏幕的宽度
    public static int getScreenWidth(Context context) {
        WindowManager manager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        return display.getWidth();
    }
    //获取屏幕的高度
    public static int getScreenHeight(Context context) {
        WindowManager manager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        return display.getHeight();
    }
}
