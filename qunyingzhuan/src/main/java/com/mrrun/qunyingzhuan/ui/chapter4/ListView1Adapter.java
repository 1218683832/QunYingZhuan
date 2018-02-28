package com.mrrun.qunyingzhuan.ui.chapter4;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.mrrun.lib.androidbase.base.adapter.simpleadapter.BaseSimpleAdapter;
import com.mrrun.qunyingzhuan.R;

import java.util.List;

/**
 * Created by lipin on 2017/10/12.
 */

public class ListView1Adapter extends BaseSimpleAdapter<String, ListView1Adapter.MyViewHolder> {

    public ListView1Adapter(Context context, List<String> datas, int layoutId) {
        super(context, datas, layoutId);
    }

    @Override
    protected void onBindViewData(MyViewHolder viewHolder, int position) {
        if (mDatas != null &&  mDatas.size() > 0) {
            viewHolder.tvText.setText(mDatas.get(position));
        }
    }

    @Override
    protected MyViewHolder buildViewHolder(View convertView, int position) {
        return new MyViewHolder(convertView, position);
    }

    public class MyViewHolder extends BaseSimpleAdapter.ViewHolder {

        protected TextView tvText;

        public MyViewHolder(View view, int index) {
            super(view, index);
            tvText = (TextView) view.findViewById(R.id.tv_text);
        }
    }
}
