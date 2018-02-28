package com.mrrun.qunyingzhuan.ui.chapter7.animation;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by lipin on 2017/10/27.
 *  自定义视图动画---类似位移动画
 */

public class CustomTranslateAnimation extends Animation {

    /** @hide */
    protected float mFromXValue = 0.0f;
    /** @hide */
    protected float mToXValue = 0.0f;

    /** @hide */
    protected float mFromYValue = 0.0f;
    /** @hide */
    protected float mToYValue = 0.0f;

    /** @hide */
    protected float mFromXDelta;
    /** @hide */
    protected float mToXDelta;
    /** @hide */
    protected float mFromYDelta;
    /** @hide */
    protected float mToYDelta;

    public CustomTranslateAnimation(float fromXDelta, float toXDelta, float fromYDelta, float toYDelta) {
        mFromXValue = fromXDelta;
        mToXValue = toXDelta;
        mFromYValue = fromYDelta;
        mToYValue = toYDelta;
    }

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        mFromXDelta = width * mFromXValue;
        mToXDelta = width * mToXValue;
        mFromYDelta = height * mFromYValue;
        mToYDelta = height * mToYValue;
    }

    /**
     * @param interpolatedTime  [0.0f, 1.0f]
     * @param t
     */
    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        float dx = mFromXDelta;
        float dy = mFromYDelta;
        if (mFromXDelta != mToXDelta) {
            dx = mFromXDelta + ((mToXDelta - mFromXDelta) * interpolatedTime);
        }
        if (mFromYDelta != mToYDelta) {
            dy = mFromYDelta + ((mToYDelta - mFromYDelta) * interpolatedTime);
        }
        t.getMatrix().setTranslate(dx, dy);
    }
}
