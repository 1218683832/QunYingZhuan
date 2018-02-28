package com.mrrun.qunyingzhuan.ui.chapter3.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mrrun.qunyingzhuan.R;

/**
 * Created by lipin on 2017/10/11.
 */

public class TopBar extends RelativeLayout {

    protected Context mContext;
    protected Button mLeftButton;
    protected Button mRightButton;
    protected TextView mTitleView;
    protected LayoutParams mLeftParams, mRightParams, mTitleParams;
    protected String mLeftText;
    protected String mRightText;
    protected String mTitleText;

    public interface TopBarClickListener {
        // 左边按钮点击事件
        void leftClick();
        // 右边按钮点击事件
        void rightClick();
    }
    protected TopBarClickListener mTopBarClickListener;
    public void setTopBarClickListener(TopBarClickListener topBarClickListener) {
        mTopBarClickListener = topBarClickListener;
    }

    public TopBar(Context context) {
        super(context);
        mContext = context;
        init(null);
    }

    public TopBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init(attrs);
    }

    public TopBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init(attrs);
    }

    public TopBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        mContext = context;
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        initAttrs(attrs);
        initView();
    }

    private void initView() {
        // 1、创建组件
        mLeftButton = new Button(mContext);
        mRightButton = new Button(mContext);
        mTitleView = new TextView(mContext);
        // 2、为组件赋值
        mLeftButton.setText(mLeftText);
        mRightButton.setText(mRightText);
        mTitleView.setText(mTitleText);
        // 3、为组件设置相应的布局元素
        mLeftParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        mLeftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
        mRightParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        mRightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
        mTitleParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        mTitleParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
        mTitleView.setGravity(Gravity.CENTER);
        // 4、将组件添加进父容器
        addView(mLeftButton, mLeftParams);
        addView(mRightButton, mRightParams);
        addView(mTitleView, mTitleParams);
        // 5、定义接口
        // 6、暴露接口给调用者
        mLeftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTopBarClickListener != null){
                    mTopBarClickListener.leftClick();
                }
            }
        });
        mRightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTopBarClickListener != null){
                    mTopBarClickListener.rightClick();
                }
            }
        });
        // 7、其他方法
        setButtonVisable(true);
    }

    public void setButtonVisable(boolean visable) {
        if (visable) {
            mLeftButton.setVisibility(View.VISIBLE);
            mRightButton.setVisibility(View.VISIBLE);
        } else {
            mLeftButton.setVisibility(View.GONE);
            mRightButton.setVisibility(View.GONE);
        }
    }

    private void initAttrs(AttributeSet attrs) {
        if (attrs != null ){
            TypedArray ta = mContext.obtainStyledAttributes(attrs, R.styleable.TopBar);
            mLeftText = ta.getString(R.styleable.TopBar_leftText);
            mRightText = ta.getString(R.styleable.TopBar_rightText);
            mTitleText = ta.getString(R.styleable.TopBar_titleText);
            ta.recycle();
        }
    }
}
