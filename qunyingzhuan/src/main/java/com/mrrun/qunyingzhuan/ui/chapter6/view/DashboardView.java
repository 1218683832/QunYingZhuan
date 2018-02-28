package com.mrrun.qunyingzhuan.ui.chapter6.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by lipin on 2017/10/13.
 * 仪表盘
 */

public class DashboardView extends View {

    private int mRadius;// 圆半径
    private int mX, mY;// 圆心点
    private Paint mCirclePaint;

    private Paint mPainDegree;

    private Paint mPosterPaint;

    public DashboardView(Context context) {
        super(context);
    }

    public DashboardView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DashboardView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public DashboardView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mRadius = getMeasuredWidth() / 2;
        mX = mRadius;
        mY = mRadius + 10;
        mCirclePaint = new Paint();
        mCirclePaint.setAntiAlias(true);
        mCirclePaint.setColor(Color.YELLOW);
        mCirclePaint.setStyle(Paint.Style.STROKE);
        mCirclePaint.setStrokeWidth(5);

        mPainDegree = new Paint();
        mPainDegree.setAntiAlias(true);
        mPainDegree.setColor(Color.YELLOW);
        mPainDegree.setStrokeWidth(3);

        mPosterPaint = new Paint();
        mPosterPaint.setAntiAlias(true);
        mPosterPaint.setColor(Color.WHITE);
        mPosterPaint.setStrokeWidth(5);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.BLACK);
        onDrawCircle(canvas);// 画仪表盘
        onDrawPainDegree(canvas);// 画刻度及刻度值
        onDrawPointer(canvas);// 画指针
    }

    private void onDrawPointer(Canvas canvas) {
        canvas.drawLine(mX, mY, mX + 30, mY + 120, mPosterPaint);// 分针
        canvas.drawLine(mX, mY, mX + 60, mY + 60, mPosterPaint);// 时针
    }

    private void onDrawPainDegree(Canvas canvas) {
        for (int i = 0; i < 24; i ++) {
            // 区分整点(0、6、12、18)与非整点
            if (i == 0 || i == 6 || i == 12 || i == 18) {
                mPainDegree.setStrokeWidth(5);
                mPainDegree.setTextSize(30);
                canvas.drawLine(mX, mY - mRadius, mX, mY - mRadius + 60, mPainDegree);
                String degree = String.valueOf(i);
                canvas.drawText(degree, mX - mPainDegree.measureText(degree) / 2, mY - mRadius + 90, mPainDegree);
            } else {
                mPainDegree.setStrokeWidth(3);
                mPainDegree.setTextSize(15);
                canvas.drawLine(mX, mY - mRadius, mX, mY - mRadius + 30, mPainDegree);
                String degree = String.valueOf(i);
                canvas.drawText(degree, mX - mPainDegree.measureText(degree) / 2, mY - mRadius + 60, mPainDegree);
            }
            // 通过旋转画布简化坐标运算
            canvas.rotate(15, mX, mY);
        }
    }

    private void onDrawCircle(Canvas canvas) {
        canvas.drawCircle(mX, mY, mRadius, mCirclePaint);
    }
}
