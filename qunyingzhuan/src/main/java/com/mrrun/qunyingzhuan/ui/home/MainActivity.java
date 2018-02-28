package com.mrrun.qunyingzhuan.ui.home;

import android.view.View;

import com.mrrun.lib.androidbase.base.activity.BaseActivity;
import com.mrrun.qunyingzhuan.R;
import com.mrrun.qunyingzhuan.ui.chapter12.Chapter12Activity;
import com.mrrun.qunyingzhuan.ui.chapter13.Chapter13Activity;
import com.mrrun.qunyingzhuan.ui.chapter14.Chapter14Activity;
import com.mrrun.qunyingzhuan.ui.chapter3.Chapter3Activity;
import com.mrrun.qunyingzhuan.ui.chapter4.Chapter4Activity;
import com.mrrun.qunyingzhuan.ui.chapter6.Chapter6Activity;
import com.mrrun.qunyingzhuan.ui.chapter7.Chapter7Activity;

import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Override
    protected void setupViewAndData() {
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @OnClick({R.id.btn_chapter3, R.id.btn_chapter4, R.id.btn_chapter6,
            R.id.btn_chapter7, R.id.btn_chapter12, R.id.btn_chapter13,
            R.id.btn_chapter14})
    @Override
    public void setupViewOnClick(View view) {
        switch (view.getId()){
            case R.id.btn_chapter3:
                jumpToActivity(Chapter3Activity.class);
                break;
            case R.id.btn_chapter4:
                jumpToActivity(Chapter4Activity.class);
                break;
            case R.id.btn_chapter6:
                jumpToActivity(Chapter6Activity.class);
                break;
            case R.id.btn_chapter7:
                jumpToActivity(Chapter7Activity.class);
                break;
            case R.id.btn_chapter12:
                jumpToActivity(Chapter12Activity.class);
                break;
            case R.id.btn_chapter13:
                jumpToActivity(Chapter13Activity.class);
                break;
            case R.id.btn_chapter14:
                jumpToActivity(Chapter14Activity.class);
                break;
            default:
                break;
        }
    }
}
