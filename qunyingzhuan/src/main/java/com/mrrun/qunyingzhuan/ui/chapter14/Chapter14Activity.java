package com.mrrun.qunyingzhuan.ui.chapter14;

import android.view.View;

import com.mrrun.lib.androidbase.base.activity.BaseActivity;
import com.mrrun.qunyingzhuan.R;
import com.mrrun.qunyingzhuan.ui.chapter13.Chapter13Activity1;

import butterknife.OnClick;

public class Chapter14Activity extends BaseActivity {

    @Override
    protected void setupViewAndData() {
    }

    @Override
    protected int layoutId() {
        return R.layout.chapter14_activity;
    }

    @OnClick({R.id.btn1, R.id.btn2})
    @Override
    public void setupViewOnClick(View view) {
        switch (view.getId()){
            case R.id.btn1:
                jumpToActivity(Chapter14Activity1.class);
                break;
            case R.id.btn2:
                jumpToActivity(Chapter14Activity2.class);
                break;
            default:
                break;
        }
    }
}
