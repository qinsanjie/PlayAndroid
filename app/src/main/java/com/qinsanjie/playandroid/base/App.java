package com.qinsanjie.playandroid.base;

import android.content.Context;

import com.blankj.utilcode.util.Utils;
import com.jess.arms.base.BaseApplication;

/**
 * @author qinsanjie
 * @date 18/7/15.
 * @desc
 */

public class App extends BaseApplication{
    private static App mContext;

    public static Context getInstance() {
        return mContext;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        mContext = this;
    }
}
