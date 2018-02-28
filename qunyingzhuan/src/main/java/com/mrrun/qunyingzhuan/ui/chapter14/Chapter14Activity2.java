package com.mrrun.qunyingzhuan.ui.chapter14;

import android.support.v7.widget.Toolbar;

import com.mrrun.lib.androidbase.base.activity.BaseActivity;
import com.mrrun.qunyingzhuan.R;

import butterknife.BindView;

public class Chapter14Activity2 extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolBar;

    @Override
    protected void setupViewAndData() {
        /**
         * 设置状态栏颜色
         * mToolBar.setBackgroundResource(R.color.color_ff0000_red);4.4以上的系统有效。
         * StatusBarUtils.setStatusBarColor(this, R.color.color_ff0000_red);5.0以上的系统有效
         */
        this.setSupportActionBar(mToolBar);
    }

    @Override
    protected int layoutId() {
        return R.layout.chapter14_activity2;
    }
}
