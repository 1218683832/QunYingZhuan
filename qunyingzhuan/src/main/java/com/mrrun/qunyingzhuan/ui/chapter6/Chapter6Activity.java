package com.mrrun.qunyingzhuan.ui.chapter6;

import android.view.View;
import android.widget.Button;

import com.mrrun.lib.androidbase.base.activity.BaseActivity;
import com.mrrun.qunyingzhuan.R;

import butterknife.BindView;
import butterknife.OnClick;

public class Chapter6Activity extends BaseActivity {

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
    @BindView(R.id.btn6)
    Button mBtn6;
    @BindView(R.id.btn7)
    Button mBtn7;
    @BindView(R.id.btn8)
    Button mBtn8;
    @BindView(R.id.btn9)
    Button mBtn9;
    @BindView(R.id.btn10)
    Button mBtn10;
    @BindView(R.id.btn11)
    Button mBtn11;

    @Override
    protected void setupViewAndData() {
    }

    @Override
    protected int layoutId() {
        return R.layout.chapter6_activity;
    }

    @OnClick({R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
            R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8,
            R.id.btn9, R.id.btn10, R.id.btn11})
    @Override
    public void setupViewOnClick(View view) {
        switch (view.getId()){
            case R.id.btn1:
                jumpToActivity(Chapter6Activity1.class);
                break;
            case R.id.btn2:
                jumpToActivity(Chapter6Activity2.class);
                break;
            case R.id.btn3:
                jumpToActivity(Chapter6Activity3.class);
                break;
            case R.id.btn4:
                jumpToActivity(Chapter6Activity4.class);
                break;
            case R.id.btn5:
                jumpToActivity(Chapter6Activity5.class);
                break;
            case R.id.btn6:
                jumpToActivity(Chapter6Activity6.class);
                break;
            case R.id.btn7:
                jumpToActivity(Chapter6Activity7.class);
                break;
            case R.id.btn8:
                jumpToActivity(Chapter6Activity8.class);
                break;
            case R.id.btn9:
                jumpToActivity(Chapter6Activity9.class);
                break;
            case R.id.btn10:
                jumpToActivity(Chapter6Activity10.class);
                break;
            case R.id.btn11:
                jumpToActivity(Chapter6Activity11.class);
                break;
            default:
                break;
        }
    }
}
