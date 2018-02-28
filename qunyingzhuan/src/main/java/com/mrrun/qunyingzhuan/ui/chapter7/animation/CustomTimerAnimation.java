package com.mrrun.qunyingzhuan.ui.chapter7.animation;

import android.support.annotation.Nullable;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.Button;

import java.lang.ref.WeakReference;

/**
 * Created by lipin on 2017/10/27.
 */

public class CustomTimerAnimation extends Animation{

    private int mStartTime;// 计时开始时间点
    private int mEndTime;// 计时结束时间点
    private WeakReference<Button> mTarget;// 需要动画的View

    public CustomTimerAnimation(Button view, int startTime, int endTime) {
        this.mStartTime = startTime;
        this.mEndTime = endTime;
        setTarget(view);
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        float incr = (mStartTime - mEndTime) /(this.getDuration() / 1000.0f);// 增量
        int d = (int) (incr * (interpolatedTime * (this.getDuration() / 1000.0f)));
        if (getTarget() != null) {
            getTarget().setText(String.valueOf(mStartTime - d));
        }
    }

    public Button getTarget() {
        return mTarget == null ? null : mTarget.get();
    }

    public void setTarget(@Nullable Button target) {
        final Button oldTarget = getTarget();
        if (oldTarget != target) {
            mTarget = target == null ? null : new WeakReference<Button>(target);
        }
    }
}
