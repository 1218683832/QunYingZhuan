package com.mrrun.qunyingzhuan.ui.chapter7;

import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.LinearLayout;

import com.mrrun.lib.androidbase.base.activity.BaseActivity;
import com.mrrun.lib.androidbase.util.SizeUtils;
import com.mrrun.qunyingzhuan.R;

import butterknife.BindView;
import butterknife.OnClick;

public class Chapter7Activity3 extends BaseActivity {

    @BindView(R.id.btn_add)
    Button mBtn1;
    @BindView(R.id.btn_remove)
    Button mBtn2;
    @BindView(R.id.ll2)
    LinearLayout mLinearLayout2;

    Animation animation;

    /**
     * 1、子控件显示顺序可取值：
     *      ORDER_NORMAL：正常顺序，及按照从上往下开始执行；
     *      ORDER_REVERSE：倒序，从下往上；
     *      ORDER_RANDOM：随机；
     * 2、其是在控件初始化时调用，对ViewGroup控件整体的子控件加载一个按照固定顺序显示的动画，
     * 我们可以调用ViewGroup.startLayoutAnimation()让其子控件全部重新显示一遍。
     */
    LayoutAnimationController layoutAnimationController;

    @Override
    protected void setupViewAndData() {
        animation = AnimationUtils.loadAnimation(mContext, R.anim.scale);
        layoutAnimationController = new LayoutAnimationController(animation, 0.2f);
        layoutAnimationController.setOrder(LayoutAnimationController.ORDER_NORMAL);
        /**
         * 其是在控件初始化时调用，对ViewGroup控件整体的子控件加载一个按照固定顺序显示的动画
         */
        mLinearLayout2.setLayoutAnimation(layoutAnimationController);

        /**
         * 这种方式控制子控件的添加、移除动画、对其他子控件设置动画
         * 注意点：唯一需要注意的是，在控件进入或消失对其他控件的影响时，会出现一种情况，当我们连续点击添加控件时，
         * 其他控件的动画还没结束，会将动画停止到其执行状态，并执行下一次动画。
         * 所以需要设置动画监听，当动画结束时的操作。
         */
        LayoutTransition mTransition = new LayoutTransition();
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(null, "rotationY", -90f, 90f, 0f)
                .setDuration(3000);
        // 当一个View在ViewGroup中出现时，对此View设置的动画
        mTransition.setAnimator(LayoutTransition.APPEARING, animator1);
        mLinearLayout2.setLayoutTransition(mTransition);

        /**
         * 也可以XML方式使用系统提供的默认LayoutTransition动画
         * 我们可以通过如下方式使用系统提供的默认ViewGroup的LayoutTransition动画：
         * android:animateLayoutChanges="true"
         */
    }

    @Override
    protected int layoutId() {
        return R.layout.chapter7_activity3;
    }

    @OnClick({R.id.btn_add, R.id.btn_remove})
    @Override
    public void setupViewOnClick(View view) {
        switch (view.getId()){
            case R.id.btn_add:
                Button btn = new Button(mContext);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                params.topMargin = SizeUtils.dp2px(5f);
                btn.setLayoutParams(params);
                btn.setText("+控件");
                mLinearLayout2.addView(btn, 0);
                break;
            case R.id.btn_remove:
                if (mLinearLayout2.getChildCount() > 0) {
                    mLinearLayout2.removeViewAt(0);
                }
                break;
            default:
                break;
        }
    }
}
