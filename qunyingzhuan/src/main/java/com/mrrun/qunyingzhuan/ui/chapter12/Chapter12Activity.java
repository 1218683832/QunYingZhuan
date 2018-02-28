package com.mrrun.qunyingzhuan.ui.chapter12;

import android.view.View;

import com.mrrun.lib.androidbase.base.activity.BaseActivity;
import com.mrrun.qunyingzhuan.R;

import butterknife.OnClick;

public class Chapter12Activity extends BaseActivity {

    @Override
    protected void setupViewAndData() {
    }

    @Override
    protected int layoutId() {
        return R.layout.chapter12_activity;
    }

    @OnClick({R.id.btn1})
    @Override
    public void setupViewOnClick(View view) {
        switch (view.getId()){
            case R.id.btn1:
                jumpToActivity(Chapter12Activity1.class);
                break;
            default:
                break;
        }
    }
}
