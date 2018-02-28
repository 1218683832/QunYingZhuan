package com.mrrun.qunyingzhuan.ui.chapter12;

import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mrrun.lib.androidbase.base.activity.BaseActivity;
import com.mrrun.qunyingzhuan.R;

import butterknife.BindView;

public class Chapter12Activity2 extends BaseActivity {

    @BindView(R.id.maincontent)
    ViewGroup mMainContent;
    @BindView(R.id.iv_shareimg)
    ImageView mShareImg;
    @BindView(R.id.btn1)
    Button mBtn1;
    @BindView(R.id.tv_text)
    TextView mText;

    @Override
    protected void init() {
        this.getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
    }

    @Override
    protected void setupViewAndData() {
        int flag = getIntent().getExtras().getInt("flag");
        switch (flag) {
            case 0:
                this.getWindow().setEnterTransition(new Explode());
                break;
            case 1:
                this.getWindow().setEnterTransition(new Slide());
                break;
            case 2:
                this.getWindow().setEnterTransition(new Fade());
                break;
            case 3:
                break;
            default:
                break;
        }
    }

    @Override
    protected int layoutId() {
        return R.layout.chapter12_activity2;
    }

}
