package com.mrrun.qunyingzhuan.ui.chapter7;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.Button;

import com.mrrun.lib.androidbase.base.activity.BaseActivity;
import com.mrrun.qunyingzhuan.R;
import com.mrrun.qunyingzhuan.ui.chapter7.animation.CustomTimerAnimation;
import com.mrrun.qunyingzhuan.ui.chapter7.animation.CustomTranslateAnimation;

import butterknife.BindView;
import butterknife.OnClick;

public class Chapter7Activity4 extends BaseActivity {

    @BindView(R.id.btn1)
    Button mBtn1;
    @BindView(R.id.btn2)
    Button mBtn2;

    Animation animation1;
    Animation animation2;

    @Override
    protected void setupViewAndData() {
    }

    @Override
    protected int layoutId() {
        return R.layout.chapter7_activity4;
    }

    @OnClick({R.id.btn1, R.id.btn2})
    @Override
    public void setupViewOnClick(View view) {
        switch (view.getId()){
            case R.id.btn1:
                animation1 = new CustomTranslateAnimation(0f, 1f, 0f, 1f);
                animation1.setDuration(3000);
                mBtn1.startAnimation(animation1);
                break;
            case R.id.btn2:
                animation2 = new CustomTimerAnimation(mBtn2, 60, 0);
                animation2.setInterpolator(new LinearInterpolator());
                animation2.setDuration(60 * 1000);
                mBtn2.startAnimation(animation2);
                break;
            default:
                break;
        }
    }
}
