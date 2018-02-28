package com.mrrun.qunyingzhuan.ui.chapter7;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.mrrun.lib.androidbase.base.activity.BaseActivity;
import com.mrrun.lib.androidbase.util.SizeUtils;
import com.mrrun.qunyingzhuan.R;

import butterknife.BindView;
import butterknife.OnClick;

public class Chapter7Activity5 extends BaseActivity {

    @BindView(R.id.iv_wechat)
    ImageView mImg1;
    @BindView(R.id.iv_weibo)
    ImageView mImg2;
    @BindView(R.id.iv_qq)
    ImageView mImg3;
    @BindView(R.id.iv_baidu)
    ImageView mImg4;
    @BindView(R.id.iv_menu)
    ImageView mImg5;

    private Boolean mFlag = true;

    @Override
    protected void setupViewAndData() {
    }

    @Override
    protected int layoutId() {
        return R.layout.chapter7_activity5;
    }

    @OnClick({R.id.iv_wechat, R.id.iv_weibo, R.id.iv_qq,
            R.id.iv_baidu, R.id.iv_menu})
    @Override
    public void setupViewOnClick(View view) {
        switch (view.getId()){
            case R.id.iv_menu:// 展开
                if (mFlag) {
                    startAnim();
                } else {
                    closeAnim();
                }
                break;
            default:
                break;
        }
    }

    private void startAnim() {
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(mImg1, "translationX", SizeUtils.dp2px(-64));
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(mImg2, "translationY", SizeUtils.dp2px(-64));
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(mImg3, "translationX", SizeUtils.dp2px(64));
        ObjectAnimator animator4 = ObjectAnimator.ofFloat(mImg4, "translationY", SizeUtils.dp2px(64));
        ObjectAnimator animator5 = ObjectAnimator.ofFloat(mImg5, "alpha", 1.0f, 0.5f);
        AnimatorSet set = new AnimatorSet();
        set.setDuration(500);
        set.setInterpolator(new BounceInterpolator());
        set.playTogether(animator1, animator2, animator3, animator4, animator5);
        set.start();
        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                mFlag = false;
            }
        });
    }

    private void closeAnim(){
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(mImg1, "translationX", 0);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(mImg2, "translationY", 0);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(mImg3, "translationX", 0);
        ObjectAnimator animator4 = ObjectAnimator.ofFloat(mImg4, "translationY", 0);
        ObjectAnimator animator5 = ObjectAnimator.ofFloat(mImg5, "alpha", 0.5f, 1.0f);
        AnimatorSet set = new AnimatorSet();
        set.setDuration(500);
        set.setInterpolator(new LinearInterpolator());
        set.playTogether(animator1, animator2, animator3, animator4, animator5);
        set.start();
        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                mFlag = true;
            }
        });
    }
}
