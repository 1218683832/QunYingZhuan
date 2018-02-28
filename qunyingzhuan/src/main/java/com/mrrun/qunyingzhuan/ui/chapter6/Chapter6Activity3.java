package com.mrrun.qunyingzhuan.ui.chapter6;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.mrrun.lib.androidbase.base.activity.BaseActivity;
import com.mrrun.qunyingzhuan.R;

import butterknife.BindView;

public class Chapter6Activity3 extends BaseActivity implements SeekBar.OnSeekBarChangeListener {

    @BindView(R.id.seekBar_sediao)
    SeekBar mSediaoBar;
    @BindView(R.id.seekBar_baohedu)
    SeekBar mBaoHeDuBar;
    @BindView(R.id.seekBar_liangdu)
    SeekBar mLiangDuBar;
    @BindView(R.id.imageView)
    ImageView mImageView;

    private float mSediao = MIDDLE_VALUE;
    private float mBaoHeDu = MIDDLE_VALUE;
    private float mLiangDu = MIDDLE_VALUE;

    /**
     * SeekBar的中间值
     */
    private static final int MIDDLE_VALUE = 127;
    /**
     * SeekBar的最大值
     */
    private static final int MAX_VALUE = 255;

    @Override
    protected void setupViewAndData() {
        mSediaoBar.setOnSeekBarChangeListener(this);
        mBaoHeDuBar.setOnSeekBarChangeListener(this);
        mLiangDuBar.setOnSeekBarChangeListener(this);
        bitmap = ((BitmapDrawable)mImageView.getDrawable()).getBitmap();
    }

    @Override
    protected int layoutId() {
        return R.layout.chapter6_activity3;
    }

    /**
     * 数值改变, 正在拖动
     *
     * @param seekBar
     * @param progress
     * @param fromUser
     */
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()){
            case R.id.seekBar_sediao:
                // 色调
                mSediao = (progress - MIDDLE_VALUE) * 1.0F / MIDDLE_VALUE * 180;
                break;
            case R.id.seekBar_baohedu:
                // 饱和度
                mBaoHeDu = progress * 1.0F / MIDDLE_VALUE;
                break;
            case R.id.seekBar_liangdu:
                // 亮度
                mLiangDu = progress * 1.0F / MIDDLE_VALUE;
                break;
            default:
                break;
        }
        mImageView.setImageBitmap(handleImageEffect(bitmap, mSediao, mBaoHeDu, mLiangDu));
    }

    private Bitmap handleImageEffect(Bitmap bitmap, float sediao, float baohedu, float liangdu) {
        Bitmap bmp = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bmp);
        Paint paint = new Paint();

        ColorMatrix seDiaoMatrx = new ColorMatrix();
        seDiaoMatrx.setRotate(0, sediao);
        seDiaoMatrx.setRotate(1, sediao);
        seDiaoMatrx.setRotate(2, sediao);

        ColorMatrix baoheduMatrx = new ColorMatrix();
        baoheduMatrx.setSaturation(baohedu);

        ColorMatrix liangduMatrx = new ColorMatrix();
        liangduMatrx.setScale(liangdu, liangdu, liangdu, 1);

        ColorMatrix imageMatrx = new ColorMatrix();// 设置整体效果
        imageMatrx.postConcat(seDiaoMatrx);
        imageMatrx.postConcat(baoheduMatrx);
        imageMatrx.postConcat(liangduMatrx);

        paint.setColorFilter(new ColorMatrixColorFilter(imageMatrx));
        canvas.drawBitmap(bitmap, 0, 0, paint);
        return bmp;
    }

    Bitmap bitmap;

    /**
     * 开始拖动
     *
     * @param seekBar
     */
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    /**
     * 停止拖动
     *
     * @param seekBar
     */
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}
