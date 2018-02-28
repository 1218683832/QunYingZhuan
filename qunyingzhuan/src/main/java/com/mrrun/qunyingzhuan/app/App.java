package com.mrrun.qunyingzhuan.app;

import com.mrrun.lib.androidbase.base.app.BaseApp;
import com.mrrun.lib.androidbase.util.Utils;

/**
 * Created by lipin on 2017/11/3.
 */

public class App extends BaseApp {

    @Override
    public void initConfings() {
        Utils.init(appContext);
    }
}
