package com.qinsanjie.playandroid.mvp.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.jess.arms.di.component.AppComponent;
import com.qinsanjie.playandroid.base.ui.BaseActivity;
import com.qinsanjie.playandroid.utils.AppRouter;

public class SplashActivity extends BaseActivity {

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {

    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return 0;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        AppRouter.loginRoute(this);
    }
}
