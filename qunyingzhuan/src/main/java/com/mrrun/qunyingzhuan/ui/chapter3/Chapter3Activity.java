package com.mrrun.qunyingzhuan.ui.chapter3;

import android.view.View;
import android.widget.Button;

import com.mrrun.lib.androidbase.base.activity.BaseActivity;
import com.mrrun.qunyingzhuan.R;

import butterknife.BindView;
import butterknife.OnClick;


public class Chapter3Activity extends BaseActivity {

    @BindView(R.id.btn1)
    Button mBtn1;
    @BindView(R.id.btn2)
    Button mBtn2;
    @BindView(R.id.btn3)
    Button mBtn3;
    @BindView(R.id.btn4)
    Button mBtn4;

    @Override
    protected void setupViewAndData() {
    }

    @Override
    protected int layoutId() {
        return R.layout.chapter3_activity;
    }

    @OnClick({R.id.btn1, R.id.btn2, R.id.btn3,
            R.id.btn4})
    @Override
    public void setupViewOnClick(View view) {
        switch (view.getId()){
            case R.id.btn1:
                jumpToActivity(Chapter3Activity1.class);
                break;
            case R.id.btn2:
                jumpToActivity(Chapter3Activity2.class);
                break;
            case R.id.btn3:
                jumpToActivity(Chapter3Activity3.class);
                break;
            case R.id.btn4:
                jumpToActivity(Chapter3Activity4.class);
                break;
            default:
                break;
        }
    }
}
