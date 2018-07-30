package com.yxcx.view.refresh;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

/**
 * @author qinsanjie
 * @date 18/4/2.
 * @desc
 */

public class QRefreshLayout extends SmartRefreshLayout implements IRefreshLayout, OnRefreshListener {

    /**
     * 下拉监听
     */
    private OnPullRefreshListener onPullRefreshListener;


    public QRefreshLayout(Context context) {
        super(context);
        initView(context, null, 0);
    }

    public QRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs, 0);

    }

    public QRefreshLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs, defStyleAttr);

    }


    private void initView(Context context, AttributeSet attrs, int defStyleAttr) {
        setOnRefreshListener(this);
        setEnableAutoLoadMore(false);
        setEnableLoadMoreWhenContentNotFull(false);
        setEnableLoadMore(false);
        setEnableNestedScroll(true);
        setEnableOverScrollBounce(false);
        setRefreshHeader(new ClassicsHeader(context));//默认经典刷新头
        setRefreshFooter(new ClassicsFooter(context));//默认经典刷新脚
    }

    @Override
    public void setOnPullRefreshListener(OnPullRefreshListener listener) {
        this.onPullRefreshListener = listener;
    }


    @Override
    public void doAutoRefresh() {
        autoRefresh();
    }


    @Override
    public void onComplete(boolean isRefresh, boolean isSuccess) {
        if (isRefresh) {
            finishRefresh();
        }
    }


    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        if (onPullRefreshListener != null) {
            onPullRefreshListener.onRefresh();
        }
    }


}
