package com.mrrun.qunyingzhuan.ui.chapter7;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.mrrun.lib.androidbase.base.activity.BaseActivity;
import com.mrrun.lib.androidbase.util.ToastUtils;
import com.mrrun.qunyingzhuan.R;

import butterknife.BindView;
import butterknife.OnClick;

public class Chapter7Activity1 extends BaseActivity {

    @BindView(R.id.img)
    ImageView mImg;
    @BindView(R.id.btn_alpha)
    Button mBtn1;
    @BindView(R.id.btn_rotate)
    Button mBtn2;
    @BindView(R.id.btn_translate)
    Button mBtn3;
    @BindView(R.id.btn_scale)
    Button mBtn4;
    @BindView(R.id.btn_set)
    Button mBtn5;

    Animation animation;

    @Override
    protected void setupViewAndData() {
    }

    @Override
    protected int layoutId() {
        return R.layout.chapter7_activity1;
    }

    @OnClick({R.id.btn_alpha, R.id.btn_rotate, R.id.btn_translate,
            R.id.btn_scale, R.id.btn_set, R.id.img})
    @Override
    public void setupViewOnClick(View view) {
        switch (view.getId()){
            case R.id.btn_alpha:
                animation = AnimationUtils.loadAnimation(mContext, R.anim.alpha);
                mImg.startAnimation(animation);// 补间动画执行之后并未改变View的真实布局属性值.
                break;
            case R.id.btn_rotate:
                animation = AnimationUtils.loadAnimation(mContext, R.anim.rotate);
                mImg.startAnimation(animation);
                break;
            case R.id.btn_translate:
                animation = AnimationUtils.loadAnimation(mContext, R.anim.translate);
                mImg.startAnimation(animation);
                break;
            case R.id.btn_scale:
                animation = AnimationUtils.loadAnimation(mContext, R.anim.scale);
                mImg.startAnimation(animation);
                break;
            case R.id.btn_set:
                animation = AnimationUtils.loadAnimation(mContext, R.anim.set);
                mImg.startAnimation(animation);
                break;
            case R.id.img:
                ToastUtils.showToast(mContext, "点击事件");
                break;
            default:
                break;
        }
    }
}
