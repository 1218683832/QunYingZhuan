package com.mrrun.qunyingzhuan.ui.chapter3.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by lipin on 2017/10/12.
 */

public class CurveView extends View {

    protected float mViewWidth;
    /**
     * 圆的代码
     */
    protected float mCircleX;// 圆心点X
    protected float mCircleY;// 圆心点Y
    protected float mRadius;// 圆半径
    protected Paint mCirclePaint;
    /**
     * 弧线的代码
     */
    protected RectF mArcRectf;
    protected Paint mArcPaint;

    public CurveView(Context context) {
        super(context);
    }

    public CurveView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CurveView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CurveView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mViewWidth = getMeasuredWidth();
        mCircleX = mCircleY = mViewWidth / 2;
        mRadius = (float) (mViewWidth * 0.5 / 2);
        mCirclePaint = new Paint();
        mCirclePaint.setAntiAlias(true);// 设置画笔为无锯齿
        mCirclePaint.setStyle(Paint.Style.FILL);
        mCirclePaint.setColor(Color.YELLOW);

        mArcRectf = new RectF(mViewWidth * 0.1f, mViewWidth * 0.1f,  mViewWidth * 0.9f, mViewWidth * 0.9f);
        mArcPaint = new Paint();
        mArcPaint.setAntiAlias(true);// 设置画笔为无锯齿
        mArcPaint.setStrokeWidth(mViewWidth * 0.1f);// 线宽
        mArcPaint.setStyle(Paint.Style.STROKE);
        mArcPaint.setColor(Color.YELLOW);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 绘制圆
        canvas.drawCircle(mCircleX, mCircleY, mRadius, mCirclePaint);
        // 绘制弧线
        canvas.drawArc(mArcRectf, 270, 270, false, mArcPaint);
    }
}
