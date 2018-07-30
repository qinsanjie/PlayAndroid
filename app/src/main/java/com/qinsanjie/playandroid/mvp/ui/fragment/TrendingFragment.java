package com.qinsanjie.playandroid.mvp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.jess.arms.di.component.AppComponent;
import com.qinsanjie.playandroid.R;
import com.qinsanjie.playandroid.base.ui.BaseFragment;

import butterknife.BindView;

/**
 * @author qinsanjie
 * @date 18/7/24.
 * @desc
 */

public class TrendingFragment extends BaseFragment {
    @BindView(R.id.text)
    TextView text;

    @Override
    public void setupFragmentComponent(@NonNull AppComponent appComponent) {

    }


    @Override
    public void initView() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_default;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        String title = getArguments().getString("title");
        text.setText(title);
    }

    @Override
    public void setData(@Nullable Object data) {

    }

    /**
     * 获取MainFragment的对象
     *
     * @return
     */
    public static BaseFragment newInstance(String title) {
        Bundle args = new Bundle();
        BaseFragment fragment = new TrendingFragment();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }

}
