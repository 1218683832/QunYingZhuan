package com.mrrun.qunyingzhuan.ui.chapter13;

import android.view.View;

import com.mrrun.lib.androidbase.base.activity.BaseActivity;
import com.mrrun.qunyingzhuan.R;
import com.mrrun.qunyingzhuan.ui.chapter12.Chapter12Activity1;

import butterknife.OnClick;

public class Chapter13Activity extends BaseActivity {

    @Override
    protected void setupViewAndData() {
    }

    @Override
    protected int layoutId() {
        return R.layout.chapter13_activity;
    }

    @OnClick({R.id.btn1})
    @Override
    public void setupViewOnClick(View view) {
        switch (view.getId()){
            case R.id.btn1:
                jumpToActivity(Chapter13Activity1.class);
                break;
            default:
                break;
        }
    }
}
