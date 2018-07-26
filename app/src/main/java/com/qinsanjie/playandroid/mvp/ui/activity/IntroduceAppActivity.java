package com.qinsanjie.playandroid.mvp.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.SPUtils;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.jess.arms.di.component.AppComponent;
import com.qinsanjie.playandroid.R;
import com.qinsanjie.playandroid.base.ui.BaseActivity;
import com.qinsanjie.playandroid.constant.PreferenceKeys;
import com.qinsanjie.playandroid.mvp.ui.fragment.IntroduceAppFragment;
import com.qinsanjie.playandroid.utils.AppRouter;
import com.yxcx.entity.TabEntity;
import com.yxcx.view.adapter.CommonFragmentPageAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class IntroduceAppActivity extends BaseActivity {


    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.tab_indicator)
    CommonTabLayout tabIndicator;
    @BindView(R.id.bt_start_app)
    Button btStartApp;

    private List<Fragment> fragments = new ArrayList<>();
    private ArrayList<CustomTabEntity> indicator = new ArrayList<>();

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {

    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_introduce_app;
    }

    @OnClick(R.id.bt_start_app)
    public void onClick(View v) {
        SPUtils.getInstance().put(PreferenceKeys.LAST_SHOW_INTRODUCE_VERSION, AppUtils.getAppVersionName());
        AppRouter.loginRoute(this);
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        fragments.add(IntroduceAppFragment.newInstance(R.color.red));
        fragments.add(IntroduceAppFragment.newInstance(R.color.green));
        fragments.add(IntroduceAppFragment.newInstance(R.color.blue));
        fragments.add(IntroduceAppFragment.newInstance(R.color.green));

        for (int i = 0; i < fragments.size(); i++) {
            indicator.add(new TabEntity("", R.drawable.introduce_indicator_select, R.drawable.introduce_indicator_unselect));
        }
        tabIndicator.setTabData(indicator);
        viewpager.setAdapter(new CommonFragmentPageAdapter(getSupportFragmentManager(), fragments));
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tabIndicator.setCurrentTab(position);
                btStartApp.setVisibility(position == fragments.size() - 1 ? View.VISIBLE : View.GONE);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        tabIndicator.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                viewpager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
    }

}
