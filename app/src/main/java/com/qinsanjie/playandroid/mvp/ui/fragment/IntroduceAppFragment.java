package com.qinsanjie.playandroid.mvp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.jess.arms.di.component.AppComponent;
import com.qinsanjie.playandroid.R;
import com.qinsanjie.playandroid.base.ui.BaseFragment;

import butterknife.BindView;

/**
 * @author qinsanjie
 * @date 18/7/24.
 * @desc
 */

public class IntroduceAppFragment extends BaseFragment {
    @BindView(R.id.iv_introduce)
    ImageView mIvIntroduce;

    @Override
    public void setupFragmentComponent(@NonNull AppComponent appComponent) {

    }



    @Override
    public void initView() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.splash_layout;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        int res = getArguments().getInt("background");
        mIvIntroduce.setBackgroundResource(res);
    }

    @Override
    public void setData(@Nullable Object data) {

    }

    public static BaseFragment newInstance(int res) {
        Bundle args = new Bundle();
        IntroduceAppFragment fragment = new IntroduceAppFragment();
        args.putInt("background", res);
        fragment.setArguments(args);
        return fragment;
    }
}
