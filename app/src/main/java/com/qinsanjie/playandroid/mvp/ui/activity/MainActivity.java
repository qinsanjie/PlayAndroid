package com.qinsanjie.playandroid.mvp.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.FrameLayout;

import com.jess.arms.di.component.AppComponent;
import com.qinsanjie.playandroid.R;
import com.qinsanjie.playandroid.base.ui.BaseActivity;
import com.qinsanjie.playandroid.base.ui.BaseFragment;
import com.qinsanjie.playandroid.mvp.ui.fragment.MainFragment;

import butterknife.BindView;

public class MainActivity extends BaseActivity {


    @BindView(R.id.fl_main_content)
    FrameLayout mFlMainContent;

    BaseFragment baseFragment;

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {

    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

        if (findFragment(MainFragment.class) == null) {
            baseFragment = MainFragment.newInstance();
            loadRootFragment(R.id.fl_main_content, baseFragment);
        }
    }

}
