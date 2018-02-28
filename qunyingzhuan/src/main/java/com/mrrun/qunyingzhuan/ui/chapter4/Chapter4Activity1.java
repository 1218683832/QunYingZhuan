package com.mrrun.qunyingzhuan.ui.chapter4;

import android.view.View;
import android.widget.ListView;

import com.mrrun.lib.androidbase.base.activity.BaseActivity;
import com.mrrun.qunyingzhuan.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class Chapter4Activity1 extends BaseActivity {

    @BindView(R.id.listview1)
    ListView mListView1;
    ListView1Adapter mAdapter1;
    List<String> mDatas1;

    @Override
    protected void setupViewAndData() {
        setListView1();
    }

    private void setListView1() {
        mDatas1 = new ArrayList<String>();
        mAdapter1 = new ListView1Adapter(mContext, mDatas1, R.layout.lay_chapter4_listview1_item);
        for (int i = 0; i < 100; i ++) {
            mDatas1.add("具有弹性的ListView" + i);
        }
        mListView1.setAdapter(mAdapter1);
    }

    @Override
    protected int layoutId() {
        return R.layout.chapter4_activity1;
    }

    @Override
    public void setupViewOnClick(View view) {
    }
}
