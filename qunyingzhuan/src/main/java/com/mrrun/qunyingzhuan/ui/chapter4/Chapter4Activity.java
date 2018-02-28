package com.mrrun.qunyingzhuan.ui.chapter4;

import android.view.View;
import android.widget.Button;

import com.mrrun.lib.androidbase.base.activity.BaseActivity;
import com.mrrun.qunyingzhuan.R;

import butterknife.BindView;
import butterknife.OnClick;


public class Chapter4Activity extends BaseActivity {

    @BindView(R.id.btn1)
    Button mBtn1;

    @Override
    protected void setupViewAndData() {
    }

    @Override
    protected int layoutId() {
        return R.layout.chapter4_activity;
    }

    @OnClick({R.id.btn1})
    @Override
    public void setupViewOnClick(View view) {
        switch (view.getId()){
            case R.id.btn1:
                jumpToActivity(Chapter4Activity1.class);
                break;
            default:
                break;
        }
    }
}
