package com.mrrun.qunyingzhuan.ui.chapter3;

import com.mrrun.lib.androidbase.base.activity.BaseActivity;
import com.mrrun.lib.androidbase.util.ToastUtils;
import com.mrrun.qunyingzhuan.R;
import com.mrrun.qunyingzhuan.ui.chapter3.view.TopBar;
import com.mrrun.qunyingzhuan.ui.chapter3.view.TopBar.TopBarClickListener;

import butterknife.BindView;


public class Chapter3Activity3 extends BaseActivity {

    @BindView(R.id.topbar)
    protected TopBar mTopBar;

    @Override
    protected void setupViewAndData() {
        mTopBar.setTopBarClickListener(new TopBarClickListener() {
            @Override
            public void leftClick() {
                finish();
            }

            @Override
            public void rightClick() {
                ToastUtils.showToast(mContext, "More");
            }
        });
    }

    @Override
    protected int layoutId() {
        return R.layout.chapter3_activity3;
    }

}
