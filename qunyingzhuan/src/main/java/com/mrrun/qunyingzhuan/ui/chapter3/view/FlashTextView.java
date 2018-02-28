package com.mrrun.qunyingzhuan.ui.chapter3.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by lipin on 2017/10/11.
 */

public class FlashTextView extends AppCompatTextView {

    private Paint mPaint;
    private Paint mPaint1;
    private Paint mPaint2;
    private LinearGradient mLinearGradient;// 渐变效果
    /**
     * 在Android中，对图片的处理需要使用到Matrix类，Matrix是一个3 x 3的矩阵,
     * 它对图片的处理分为四个基本类型：
     * 1、Translate平移变换
     * 2、Scale缩放变换
     * 3、Rotate旋转变换
     * 4、Skew倾斜变换
     */
    private Matrix mGradientMaxtrix;// 通过矩阵的方式不断平移渐变效果,从而在绘制文字时,产生动态闪动效果

    int mViewWidth;
    int mViewHeight;
    int mTranslate;

    public FlashTextView(Context context) {
        super(context);
        init();
    }

    private void init() {
        mPaint1 = new Paint();
        mPaint1.setColor(getResources().getColor(android.R.color.holo_blue_light));
        mPaint1.setStyle(Paint.Style.FILL);

        mPaint2 = new Paint();
        mPaint2.setColor(Color.YELLOW);
        mPaint2.setStyle(Paint.Style.FILL);
    }

    public FlashTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FlashTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (mViewWidth == 0) {
            mViewWidth = getMeasuredWidth();
            if (mViewWidth > 0) {
                mPaint = getPaint();
                mLinearGradient = new LinearGradient(0, 0, mViewWidth, 0, new int[]{
                        Color.BLUE, Color.RED, Color.BLUE
                }, null, Shader.TileMode.CLAMP);
                mPaint.setShader(mLinearGradient);
                mGradientMaxtrix = new Matrix();
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint1);
        canvas.drawRect(2, 2, getMeasuredWidth() - 2, getMeasuredHeight() - 2, mPaint2);
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
        if (mGradientMaxtrix != null){
            mTranslate += mViewWidth / 5;
            if (mTranslate > 2 * mViewWidth) {
                mTranslate = -mViewWidth;
            }
            mGradientMaxtrix.setTranslate(mTranslate, 0);
            mLinearGradient.setLocalMatrix(mGradientMaxtrix);
            postInvalidateDelayed(300);
        }
    }
}
