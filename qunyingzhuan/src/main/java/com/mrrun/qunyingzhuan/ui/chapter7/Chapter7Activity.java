package com.mrrun.qunyingzhuan.ui.chapter7;

import android.view.View;
import android.widget.Button;

import com.mrrun.lib.androidbase.base.activity.BaseActivity;
import com.mrrun.qunyingzhuan.R;

import butterknife.BindView;
import butterknife.OnClick;

public class Chapter7Activity extends BaseActivity {

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

    @Override
    protected void setupViewAndData() {
    }

    @Override
    protected int layoutId() {
        return R.layout.chapter7_activity;
    }

    @OnClick({R.id.btn1, R.id.btn2, R.id.btn3,
            R.id.btn4, R.id.btn5})
    @Override
    public void setupViewOnClick(View view) {
        switch (view.getId()){
            case R.id.btn1:
                jumpToActivity(Chapter7Activity1.class);
                break;
            case R.id.btn2:
                jumpToActivity(Chapter7Activity2.class);
                break;
            case R.id.btn3:
                jumpToActivity(Chapter7Activity3.class);
                break;
            case R.id.btn4:
                jumpToActivity(Chapter7Activity4.class);
                break;
            case R.id.btn5:
                jumpToActivity(Chapter7Activity5.class);
                break;
            default:
                break;
        }
    }
}
