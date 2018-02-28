package com.mrrun.qunyingzhuan.ui.chapter13;

import android.view.View;

import com.mrrun.lib.androidbase.base.activity.BaseActivity;
import com.mrrun.qunyingzhuan.R;

import butterknife.OnClick;

public class Chapter13Activity1 extends BaseActivity {

    @Override
    protected void setupViewAndData() {
    }

    @Override
    protected int layoutId() {
        return R.layout.chapter13_activity1;
    }

    @OnClick({R.id.btn_explode})
    @Override
    public void setupViewOnClick(View view) {
        switch (view.getId()){
            case R.id.btn_explode:
                break;
            default:
                break;
        }
    }
}
