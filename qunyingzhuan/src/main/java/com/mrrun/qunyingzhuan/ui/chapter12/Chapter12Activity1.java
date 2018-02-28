package com.mrrun.qunyingzhuan.ui.chapter12;

import android.app.ActivityOptions;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.mrrun.lib.androidbase.base.activity.BaseActivity;
import com.mrrun.qunyingzhuan.R;

import butterknife.BindView;
import butterknife.OnClick;

public class Chapter12Activity1 extends BaseActivity {

    @BindView(R.id.iv_shareimg)
    ImageView mShareImg;

    @Override
    protected void setupViewAndData() {
    }

    @Override
    protected int layoutId() {
        return R.layout.chapter12_activity1;
    }

    @OnClick({R.id.btn_explode, R.id.btn_slide, R.id.btn_fade,
            R.id.btn_share})
    @Override
    public void setupViewOnClick(View view) {
        switch (view.getId()) {
            case R.id.btn_explode:
                explode();
                break;
            case R.id.btn_slide:
                slide();
                break;
            case R.id.btn_fade:
                fade();
                break;
            case R.id.btn_share:
                share();
                break;
            default:
                break;
        }
    }

    /**
     * 共享元素动画
     */
    private void share() {
        Intent intent = new Intent(this, Chapter12Activity2.class);
        intent.putExtra("flag", 3);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this,
                mShareImg, "shareimg").toBundle());
    }

    /**
     * 淡出动画
     */
    private void fade() {
        Intent intent = new Intent(this, Chapter12Activity2.class);
        intent.putExtra("flag", 2);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }

    /**
     * 滑动动画
     */
    private void slide() {
        Intent intent = new Intent(this, Chapter12Activity2.class);
        intent.putExtra("flag", 1);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }

    /**
     * 分解动画
     */
    private void explode() {
        Intent intent = new Intent(this, Chapter12Activity2.class);
        intent.putExtra("flag", 0);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }
}
