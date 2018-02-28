package com.mrrun.qunyingzhuan.ui.chapter6;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import com.mrrun.lib.androidbase.base.activity.BaseActivity;
import com.mrrun.qunyingzhuan.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class Chapter6Activity4 extends BaseActivity {

    @BindView(R.id.gridview)
    GridView mGridView;
    private MyAdapter1 mAdapter1;
    private List<String> mDatas1;
    private float[] mColorMatrx;

    @BindView(R.id.imageView)
    ImageView mImageView;
    @BindView(R.id.btn_change)
    Button mBtnChange;

    private Bitmap bitmap;

    @Override
    protected void setupViewAndData() {
        bitmap = ((BitmapDrawable)mImageView.getDrawable()).getBitmap();
        mColorMatrx = new float[]{
                1.438f, -0.122f, -0.016f, 0, -0.03f,
                -0.062f, 1.378f, -0.016f, 0, 0.05f,
                -0.062f, -0.122f, 1.483f, 0, -0.02f,
                0, 0, 0, 1, 0
        };
        setupGridView();
    }

    private void setupGridView() {
        mDatas1 = new ArrayList<>();
        for (int i = 0; i < 20; i ++) {
            mDatas1.add(String.valueOf(mColorMatrx[i]));
        }
        mAdapter1 = new MyAdapter1(mContext, mDatas1, R.layout.lay_chapter6_gridview1_item);
        mGridView.setAdapter(mAdapter1);
    }

    @Override
    protected int layoutId() {
        return R.layout.chapter6_activity4;
    }

    @OnClick({R.id.btn_change})
    @Override
    public void setupViewOnClick(View view) {
        switch (view.getId()){
            case R.id.btn_change:
                // 将颜色矩阵设置到图像
                mImageView.setImageBitmap(handleImageEffect(bitmap, mColorMatrx));
                break;
            default:
                break;
        }
    }

    private Bitmap handleImageEffect(Bitmap bitmap, float[] colorMatrx) {
        Bitmap bmp = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bmp);
        Paint paint = new Paint();

        ColorMatrix imageMatrx = new ColorMatrix();
        imageMatrx.set(colorMatrx);

        paint.setColorFilter(new ColorMatrixColorFilter(imageMatrx));
        canvas.drawBitmap(bitmap, 0, 0, paint);
        return bmp;
    }
}
