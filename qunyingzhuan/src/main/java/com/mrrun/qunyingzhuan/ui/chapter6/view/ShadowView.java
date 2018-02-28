package com.mrrun.qunyingzhuan.ui.chapter6.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by lipin on 2017/10/24.
 * 具有倒影效果的图片
 */

public class ShadowView extends View {

    private Bitmap mSrcBtimap, mRefBitmap;
    private Paint mPaint;
    private LinearGradient mLinearGradient;
    private Matrix matrix;

    public ShadowView(Context context) {
        super(context);
        init();
    }

    public ShadowView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ShadowView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        matrix = new Matrix();
        matrix.setScale(1f, -1f);// 图片垂直翻转
        mSrcBtimap = ((BitmapDrawable) this.getBackground()).getBitmap();
        mRefBitmap = Bitmap.createBitmap(mSrcBtimap,0, 0, mSrcBtimap.getWidth(), mSrcBtimap.getHeight(),
                matrix, true);
        mLinearGradient = new LinearGradient(0, mSrcBtimap.getHeight(), 0,
                mSrcBtimap.getHeight() + mSrcBtimap.getHeight(), 0XDD000000, 0X10000000, Shader.TileMode.CLAMP);
        mPaint.setShader(mLinearGradient);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);// 绘制画布背景色
        canvas.drawBitmap(mSrcBtimap, 0, 0, null);// 绘制原图
        canvas.drawBitmap(mRefBitmap, 0, mSrcBtimap.getHeight(), null);// 绘制原图垂直翻转后的图
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));// 先画的图形
        canvas.drawRect(0f, mSrcBtimap.getHeight(), mSrcBtimap.getWidth(), mSrcBtimap.getHeight() * 2, mPaint);// 绘制倒影遮盖层,渐变效果
        mPaint.setXfermode(null);
    }
}