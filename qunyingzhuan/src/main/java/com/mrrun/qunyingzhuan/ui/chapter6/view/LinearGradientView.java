package com.mrrun.qunyingzhuan.ui.chapter6.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.mrrun.qunyingzhuan.R;

/**
 * Created by lipin on 2017/10/24.
 * 使用画笔特效之LinearGradient渲染的View
 */

public class LinearGradientView extends View {

    private LinearGradient mShader1, mShader2, mShader3;
    private Bitmap mBmp1, mBmp2;
    private int mWidth, mHeight, mR;
    private Paint mPaint1, mPaint2, mPaint3;

    public LinearGradientView(Context context) {
        super(context);
        init();
    }

    public LinearGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LinearGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public LinearGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
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
        mShader1 = new LinearGradient(0, 0, mR * 2, mR * 2, Color.RED, Color.BLUE, Shader.TileMode.CLAMP);
        mShader2 = new LinearGradient(0, mR, mR * 2, mR, Color.RED, Color.BLUE, Shader.TileMode.REPEAT);
        mShader3 = new LinearGradient(mR * 2, 0, 0, mR * 2, Color.RED, Color.BLUE, Shader.TileMode.MIRROR);
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
