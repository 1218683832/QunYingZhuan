package com.mrrun.qunyingzhuan.ui.chapter7;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import com.mrrun.lib.androidbase.base.activity.BaseActivity;
import com.mrrun.lib.androidbase.util.ToastUtils;
import com.mrrun.qunyingzhuan.R;
import com.mrrun.qunyingzhuan.ui.chapter7.wrapper.TimerBtnWrapper;

import butterknife.BindView;
import butterknife.OnClick;

public class Chapter7Activity2 extends BaseActivity {

    @BindView(R.id.img)
    ImageView mImg;
    @BindView(R.id.btn1)
    Button mBtn1;
    @BindView(R.id.btn2)
    Button mBtn2;
    @BindView(R.id.btn3)
    Button mBtn3;
    @BindView(R.id.btn4)
    Button mBtn4;
    @BindView(R.id.btn5)
    Button mBtn5;
    @BindView(R.id.btn6)
    Button mBtn6;
    @BindView(R.id.btn7)
    Button mBtn7;

    ValueAnimator mValueAnimator;
    ObjectAnimator mObjectAnimator;
    ObjectAnimator mObjectAnimator2;
    AnimatorSet animSet;

    @Override
    protected void setupViewAndData() {
    }

    @Override
    protected int layoutId() {
        return R.layout.chapter7_activity2;
    }

    @OnClick({R.id.btn1, R.id.btn2, R.id.btn3,
            R.id.btn4, R.id.btn5, R.id.btn6,
            R.id.btn7, R.id.img})
    @Override
    public void setupViewOnClick(View view) {
        switch (view.getId()){
            case R.id.btn1:
                testValueAnimator1();
                break;
            case R.id.btn2:
                testObjectAnimator1();
                break;
            case R.id.btn3:
                break;
            case R.id.btn4:
                testPropertyValuesHolder();
                break;
            case R.id.btn5:
                testAnimatorSet();
                break;
            case R.id.btn6:
                testValueAnimator2();
                break;
            case R.id.btn7:
                testObjectAnimator2();
                break;
            case R.id.img:
                ToastUtils.showToast(mContext, "点击事件");
                break;
            default:
                break;
        }
    }

    /**
     * 动画集合，提供把多个动画组合成一个组合的机制，并可设置动画的时序关系，如同时播放、顺序播放或延迟播放。
     */
    private void testAnimatorSet() {
        // 动画:绕View中心的旋转0°-360°-0°
        mObjectAnimator = ObjectAnimator.ofFloat(mImg, "rotation", 0f, 360f, 0f).setDuration(3000);
        mObjectAnimator2 = ObjectAnimator.ofFloat(mImg, "translationX", 180).setDuration(3000);
        animSet = new AnimatorSet();

        // 两个动画同时执行
        animSet.play(mObjectAnimator).after(mObjectAnimator2);

        animSet.start();
    }

    /**
     * 多属性动画同时工作管理类,有时候我们需要同时修改多个属性，那就可以用到此类.
     * 需求:利用PropertyValuesHolder对一个View同时启动多个动画效果
     * 通过PropertyValuesHolder可以对一个控件的不同属性定义动画，可以定义为扩大了动画的范围。
     *
     * keyframe则是提高动画的精度。frame是帧的意思。我们可以定义一个动画中某一帧是什么状态。
     */
    private void testPropertyValuesHolder() {
        // 逐渐透明的时候，逐渐缩小
        PropertyValuesHolder pvhX = PropertyValuesHolder.ofFloat("scaleX", 1f, 0f);
        PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat("scaleY", 1f, 0f);
        PropertyValuesHolder pvhAlhpa = PropertyValuesHolder.ofFloat("alpha", 1f, 0f);
        mObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(mImg, pvhAlhpa, pvhX, pvhY);
        mObjectAnimator.setDuration(3000);
        mObjectAnimator.start();
    }

    /**
     * 继承自ValueAnimator，允许你指定要进行动画的对象以及该对象 的一个属性。
     *
     * 测试ObjectAnimator
     * 对于propertyName我们都可以设置那些值呢：
     * 1、translationX和translationY ：相对于控件本身先x,y轴的偏移量。与x,y类比。
     * 2、x和y：相对于其所在父控件的x，y轴的偏移量。其与上面的属性，都是按照像素进行偏移。
     * 3、rotation，rotationX，rotationY:旋转，分别是绕中心点的2d旋转和绕x,y轴的3D旋转。
     * 4、scaleX，scaleY：缩放，x，y轴的缩放。
     * 5、pivotX，pivotY:旋转和缩放相对于某一点的设置。默认是中心点。
     * 6、alpha:透明度。
     * 7、自定义属性包装类。
     */
    // 普通使用
    private void testObjectAnimator1() {
        // 动画:绕View中心的旋转0°-360°-0°
        mObjectAnimator = ObjectAnimator.ofFloat(mImg, "rotation", 0f, 360f, 0f).setDuration(3000);
        mObjectAnimator.start();
    }

    /**
     * 测试ObjectAnimator
     * 对于propertyName我们都可以设置那些值呢：
     * 1、translationX和translationY ：相对于控件本身先x,y轴的偏移量。与x,y类比。
     * 2、x和y：相对于其所在父控件的x，y轴的偏移量。其与上面的属性，都是按照像素进行偏移。
     * 3、rotation，rotationX，rotationY:旋转，分别是绕中心点的2d旋转和绕先x,y轴的3D旋转。
     * 4、scaleX，scaleY：缩放，x，y轴的缩放。
     * 5、pivotX，pivotY:旋转和缩放相对于某一点的设置。默认是中心点。
     * 6、alpha:透明度。
     * 7、自定义属性包装类。
     */
    // 自定义属性使用
    private void testObjectAnimator2() {
        mObjectAnimator = ObjectAnimator.ofInt(new TimerBtnWrapper(mBtn7), "time", 60, 0).setDuration(60 * 1000);
        mObjectAnimator.setInterpolator(new LinearInterpolator());
        mObjectAnimator.start();
    }

    /**
     * 属性动画中的时间驱动，管理着动画时间的开始、结束属性值，相应时间属性值计算方法等。
     * 测试ValueAnimator
     */
    private void testValueAnimator1() {
        mValueAnimator = ValueAnimator.ofFloat(1f, 0f, 1f).setDuration(3000);
        // 动画:缩小的同时慢慢的透明，然后又慢慢的放大并显现
        mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                // 根据动画的过渡产生数量值,通过getAnimatedValue获取变化的值
                float offset = (float) animation.getAnimatedValue();
                // 设置透明度
                mImg.setAlpha(offset);
                // 设置缩放
                mImg.setScaleX(offset);
                mImg.setScaleY(offset);
            }
        });
        mValueAnimator.start();
    }

    /**
     * 测试ValueAnimator
     */
    private void testValueAnimator2() {
        final TimerBtnWrapper wrapper = new TimerBtnWrapper(mBtn6);
        mValueAnimator = ValueAnimator.ofInt(60, 0).setDuration(60 * 1000);
        mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                // 根据动画的过渡产生数量值,通过getAnimatedValue获取变化的值
                int offset = (int) animation.getAnimatedValue();
                wrapper.setTime(offset);
            }
        });
        mValueAnimator.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                wrapper.setIsClick(false);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                wrapper.setTimeEndText("计时结束");
                wrapper.setIsClick(true);
            }
        });
        mValueAnimator.start();
    }
}
