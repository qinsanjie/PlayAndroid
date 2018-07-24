package com.qinsanjie.playandroid.mvp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class CategoryFragment extends BaseFragment {
    @BindView(R.id.text)
    TextView text;

    @Override
    public void setupFragmentComponent(@NonNull AppComponent appComponent) {

    }

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home_layout, container, false);
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
        BaseFragment fragment = new CategoryFragment();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }

}
