package com.mrrun.qunyingzhuan.ui.chapter6.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.mrrun.qunyingzhuan.R;

/**
 * Created by lipin on 2017/10/24.
 * 使用画笔特效之BitmapShader渲染的View
 */

public class BitmapShaderView extends View {

    private BitmapShader mShader1, mShader2, mShader3;
    private Bitmap mBmp1, mBmp2;
    private int mWidth, mHeight, mR;
    private Paint mPaint1, mPaint2, mPaint3;

    public BitmapShaderView(Context context) {
        super(context);
        init();
    }

    public BitmapShaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BitmapShaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public BitmapShaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        mPaint1 = new Paint();
        mPaint2 = new Paint();
        mPaint3 = new Paint();
        mBmp1 = BitmapFactory.decodeResource(getResources(), R.mipmap.bg);
        mBmp2 = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        mWidth = mBmp1.getWidth();
        mHeight = mBmp1.getHeight();
        mR = (int) ((mWidth + mHeight) / 3.5f);
        mShader1 = new BitmapShader(mBmp1, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        mShader2 = new BitmapShader(mBmp2, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        mShader3 = new BitmapShader(mBmp2, Shader.TileMode.MIRROR, Shader.TileMode.MIRROR);
        Matrix matrix = new Matrix();
        matrix.setRotate(30);
        mShader1.setLocalMatrix(matrix);
        mPaint1.setShader(mShader1);
        mPaint2.setShader(mShader2);
        mPaint3.setShader(mShader3);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(mR, mR * 1, mR, mPaint1);
        canvas.drawCircle(mR, mR * 3, mR, mPaint2);
        canvas.drawCircle(mR, mR * 5, mR, mPaint3);
    }
}
