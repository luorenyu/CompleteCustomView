package com.timen4.ronnny.customview1.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;

import com.timen4.ronnny.customview1.R;

/**
 * 该图形由两个弧形、TextView 三部分组成
 * Created by luore on 2016/6/20.
 */
public class ScoreView extends View{
    private int mCircleXY;
    private Paint mPaint_while;
    private Paint mPaint_black;
    private float unitage;
    private RectF mRectf;
    private int score;
    private float arc_y = 0f;
    private int score_text;
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
        //1、初始化所有的备用条件
        init(score);

    }

    private void init(int score) {
        this.score=score;
        Resources res = getResources();
        //以10dp作为单位量
        unitage = res.getDimension(R.dimen.unitage);

        //初始黑色笔
        mPaint_black = new Paint();
        //设置抗锯齿，优化绘制效果的精细度
        mPaint_black.setAntiAlias(true);
        //设置图像抖动处理,也是用于优化图像的显示效果
        mPaint_black.setDither(true);
        //设置画笔的颜色
        mPaint_black.setColor(Color.BLACK);
        //设置画笔的风格为空心
        mPaint_black.setStyle(Paint.Style.STROKE);
        //设置“空心”的外框宽度为2dp
        mPaint_black.setStrokeWidth(unitage*0.2f);

        //初始白色笔
        mPaint_while = new Paint();
        mPaint_while.setAntiAlias(true);
        mPaint_while.setStyle(Paint.Style.STROKE);
        mPaint_while.setStrokeWidth(unitage*0.2f);
        mPaint_while.setDither(true);
        //设置文本的字号大小
        mPaint_while.setTextSize(unitage*6);
        //设置文本的对其方式为水平居中
        mPaint_while.setTextAlign(Paint.Align.CENTER);
        mPaint_while.setColor(Color.WHITE);

        //初始化圆弧所需条件（及设置圆弧的外接矩形的四边）
        mRectf = new RectF();
        mRectf.set(unitage*0.5f,unitage*0.5f,unitage*18.5f,unitage*18.5f);
        //设置整个控件的宽高配置参数
        setLayoutParams(new ViewGroup.LayoutParams((int)(unitage*19.5f),(int)(unitage*19.5f)));

        //获取该view的视图树观察者并添加绘制变化监听者
        //实现有绘制变化时的回调方法
        this.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                //开启子线程对绘制用到的数据进行修改
                new DrawThread();
                getViewTreeObserver().removeOnPreDrawListener(this);
                return false;
            }
        });



    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制弧形
        canvas.drawArc(mRectf,0,360,false,mPaint_black);
        canvas.drawArc(mRectf,0,arc_y,false,mPaint_while);
        //绘制文本
        canvas.drawText(score_text+"",unitage*9.7f,unitage*11.0f,mPaint_while);

        //到此整个自定义View就已经写完了
    }


    public class DrawThread implements Runnable {

        private final Thread mDrawThread;
        private int statek;
        int count;


        public DrawThread() {
            mDrawThread = new Thread(this);
            mDrawThread.start();
        }

        @Override
        public void run() {
            while (true) {
                switch (statek) {
                    case 0:
                        try {
                            Thread.sleep(200);
                            statek = 1;
                        } catch (InterruptedException e) {

                        }
                        break;
                    case 1:
                        try {
                            Thread.sleep(150);
                            arc_y += 3.6f;
                            score_text++;
                            count++;
                            postInvalidate();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                }
                if (count >= score)
                    break;
            }

        }
    }
}
