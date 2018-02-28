package com.mrrun.qunyingzhuan.ui.chapter6;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.mrrun.lib.androidbase.base.activity.BaseActivity;
import com.mrrun.qunyingzhuan.R;

import butterknife.BindView;
import butterknife.OnClick;

public class Chapter6Activity5 extends BaseActivity {

    @BindView(R.id.imageView)
    ImageView mImageView;
    @BindView(R.id.btn_change)
    Button mBtnChange;

    private Bitmap bitmap;

    @Override
    protected void setupViewAndData() {
        bitmap = ((BitmapDrawable)mImageView.getDrawable()).getBitmap();
    }

    @OnClick({R.id.btn_change})
    @Override
    public void setupViewOnClick(View view) {
        switch (view.getId()){
            case R.id.btn_change:
                // 将颜色矩阵设置到图像
                mImageView.setImageBitmap(handleImageEffect(bitmap));
                break;
            default:
                break;
        }
    }

    @Override
    protected int layoutId() {
        return R.layout.chapter6_activity5;
    }

    /**
     * 像素点处理
     * 底片效果
     *
     * @param bitmap
     * @return
     */
    private Bitmap handleImageEffect(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] oldPxs = new int[width * height];
        int[] newPxs = new int[width * height];
        int color;
        int r,g,b,a;

        Bitmap bmp = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        bitmap.getPixels(oldPxs, 0, width, 0, 0, width, height);// 构造像素点数组

        // 底片效果
        for (int i = 0; i < width * height; i ++) {
            color = oldPxs[i];// 取出像素点
            r = Color.red(color);// 像素点的红色分量
            g = Color.green(color);// 像素点的绿色分量
            b = Color.blue(color);// 像素点的蓝色分量
            a = Color.alpha(color);// 像素点的透明度分量

            r = 255 - r;
            g = 255 - g;
            b = 255 - b;

            if (r > 255) {
                r = 255;
            } else if (r < 0){
                r = 0;
            }
            if (g > 255) {
                g = 255;
            } else if (g < 0){
                g = 0;
            }
            if (b > 255) {
                b = 255;
            } else if (b < 0){
                b = 0;
            }

            newPxs[i] = Color.argb(a, r, g, b);
        }
        bmp.setPixels(newPxs, 0, width, 0, 0, width, height);
        return bmp;
    }
}
