package com.mrrun.qunyingzhuan.ui.chapter7.wrapper;

import android.widget.Button;

/**
 * Created by lipin on 2017/10/26.
 * Button按钮的包装类，实现倒计时
 */

public class TimerBtnWrapper {

    private Button mBtn;
    private int time;// 以秒为单位的时间比如:60

    public TimerBtnWrapper(Button button) {
        this.mBtn = button;
    }

    public void setTime(int time) {
        this.time = time;
        this.mBtn.setText(time + "s");
    }

    /**
     * 设置按钮是否可以点击
     * @param isClick
     */
    public void setIsClick(boolean isClick){
        mBtn.setClickable(isClick);
    }

    /**
     * 设值动画结束后显示的内容
     * @param text
     */
    public void setTimeEndText(String text){
        mBtn.setText(text);
    }
}
