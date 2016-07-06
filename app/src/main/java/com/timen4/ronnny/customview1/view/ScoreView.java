package com.timen4.ronnny.customview1.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import com.timen4.ronnny.customview1.R;

/**
 * 该图形由两个弧形、TextView 三部分组成
 * Created by luore on 2016/6/20.
 */
public class ScoreView extends View{
    private int mCircleXY;
    private Paint whilePaint;
    private Paint blackPafint;
    //    public ScoreView(Context context) {
//        this(context,null);
//    }
//
//    public ScoreView(Context context, AttributeSet attrs) {
//        this(context, attrs,0);
//    }
//
//    public ScoreView(Context context, AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//    }

    public ScoreView(Context context,int score){
        super(context);
        init(score);

    }

    private void init(int score) {
        Resources res = getResources();
        //以10dp作为单位量
        float unitage = res.getDimension(R.dimen.unitage);
        //初始黑色笔
        blackPafint = new Paint();


        //初始白色笔
        whilePaint = new Paint();

        //初始化圆弧所需条件


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
