package com.qinsanjie.playandroid.mvp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.jess.arms.di.component.AppComponent;
import com.qinsanjie.playandroid.R;
import com.qinsanjie.playandroid.base.ui.BaseFragment;
import com.yxcx.entity.TabEntity;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * @author qinsanjie
 * @date 18/7/23.
 * @desc
 */

public class MainFragment extends BaseFragment {
    public static final int FIRST = 0;
    public static final int SECOND = 1;
    public static final int THIRD = 2;
    public static final int FOURTH = 3;


    @BindView(R.id.bottom_bar)
    CommonTabLayout mBottomBar;

    private int prePosition;

    /**
     * tab标题集合
     */
    private String[] mTitles = {"首页", "分类", "更新", "我的"};

    /**
     * 未选中图标
     */
    private int[] mIconUnselectIds = {
            R.mipmap.tab_home_unselect, R.mipmap.tab_speech_unselect,
            R.mipmap.tab_contact_unselect, R.mipmap.tab_more_unselect};
    /**
     * 选中图标
     */
    private int[] mIconSelectIds = {
            R.mipmap.tab_home_select, R.mipmap.tab_speech_select,
            R.mipmap.tab_contact_select, R.mipmap.tab_more_select};
    /**
     * fragment集合
     */
    private BaseFragment[] mFragments = new BaseFragment[4];

    /**
     * tab集合
     */
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    public MainFragment() {
    }

    @Override
    public void setupFragmentComponent(@NonNull AppComponent appComponent) {

    }


    @Override
    public void initView() {
        init();
        mBottomBar.setTabData(mTabEntities);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_main_layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        BaseFragment firstFragment = (BaseFragment) findChildFragment(HomeFragment.class);
        if (firstFragment == null) {
            mFragments[FIRST] = HomeFragment.newInstance("home");
            mFragments[SECOND] = CategoryFragment.newInstance("category");
            mFragments[THIRD] = TrendingFragment.newInstance("trending");
            mFragments[FOURTH] = MyGameFragment.newInstance("myGame");
            loadMultipleRootFragment(R.id.fl_content, FIRST,
                    mFragments[FIRST],
                    mFragments[SECOND],
                    mFragments[THIRD],mFragments[FOURTH]);
        } else {
            // 这里库已经做了Fragment恢复,所有不需要额外的处理了, 不会出现重叠问题
            // 这里我们需要拿到mFragments的引用
            mFragments[FIRST] = firstFragment;
            mFragments[SECOND] = (BaseFragment) findChildFragment(CategoryFragment.class);
            mFragments[THIRD] = (BaseFragment) findChildFragment(TrendingFragment.class);
            mFragments[FOURTH] = (BaseFragment) findChildFragment(MyGameFragment.class);
        }
    }

    private void init() {
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        mBottomBar.setTabData(mTabEntities);
        mBottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                showHideFragment(mFragments[position], mFragments[prePosition]);
                prePosition = position;
            }

            @Override
            public void onTabReselect(int position) {
                prePosition = position;
            }
        });
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

    }

    @Override
    public void setData(@Nullable Object data) {

    }

    /**
     * 获取MainFragment的对象
     *
     * @return
     */
    public static BaseFragment newInstance() {
        Bundle args = new Bundle();
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
