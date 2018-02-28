package com.mrrun.qunyingzhuan.ui.chapter6;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.mrrun.lib.androidbase.base.adapter.simpleadapter.BaseSimpleAdapter;
import com.mrrun.qunyingzhuan.R;

import java.util.List;

/**
 * Created by lipin on 2017/10/17.
 */

public class MyAdapter1 extends BaseSimpleAdapter<String, MyAdapter1.MyViewHolder1> {

    public MyAdapter1(Context context, List<String> datas, int layoutId) {
        super(context, datas, layoutId);
    }

    @Override
    protected void onBindViewData(MyViewHolder1 viewHolder, final int position) {
        viewHolder.editText.setText(mDatas.get(position));
        viewHolder.editText.addTextChangedListener(new TextWatcher() {

            String text;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                text = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
                mDatas.remove(position);
                mDatas.add(position, text);
            }
        });
    }

    @Override
    protected MyViewHolder1 buildViewHolder(View convertView, int position) {
        return new MyViewHolder1(convertView, position);
    }

    public class MyViewHolder1 extends BaseSimpleAdapter.ViewHolder {

        EditText editText;

        public MyViewHolder1(View view, int index) {
            super(view, index);
            editText = (EditText) view.findViewById(R.id.edit);
        }
    }
}
