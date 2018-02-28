package com.mrrun.qunyingzhuan.ui.chapter6;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.mrrun.lib.androidbase.base.activity.BaseActivity;
import com.mrrun.qunyingzhuan.R;

import butterknife.BindView;
import butterknife.OnClick;

public class Chapter6Activity6 extends BaseActivity {

    @BindView(R.id.imageView)
    ImageView mImageView;
    @BindView(R.id.btn_change)
    Button mBtnChange;

    private Bitmap bitmap;
    private float[] translateMatrix;
    private float[] rotateMatrix;
    private float[] scaleMatrix;
    private float[] skewMatrix;

    @Override
    protected void setupViewAndData() {
        bitmap = ((BitmapDrawable)mImageView.getDrawable()).getBitmap();
        translateMatrix = new float[]{
                1.0f, 0, 100,
                0, 1.0f, 0,
                0, 0, 1.0f
        };
        rotateMatrix = new float[]{
                1.0f, 0, 0,
                0, 1.0f, 0,
                0, 0, 1.0f
        };
        scaleMatrix = new float[]{
                0.8f, 0, 0,
                0, 0.8f, 0,
                0, 0, 1.0f
        };
        skewMatrix = new float[]{
                1.0f, 0.2f, 0,
                0, 1.0f, 0,
                0, 0, 1.0f
        };
    }

    @OnClick({R.id.btn_change})
    @Override
    public void setupViewOnClick(View view) {
        switch (view.getId()){
            case R.id.btn_change:
                // 将变形矩阵设置到图像
                mImageView.setImageBitmap(handleImageEffect(bitmap));
                break;
            default:
                break;
        }
    }

    @Override
    protected int layoutId() {
        return R.layout.chapter6_activity6;
    }

    /**
     *
     * @param bitmap
     * @return
     */
    private Bitmap handleImageEffect(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap bmp = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bmp);
        Paint paint = new Paint();
        Matrix matrix = new Matrix();
        matrix.setValues(skewMatrix);
        canvas.drawBitmap(bitmap, matrix, paint);
        return bmp;
    }
}
