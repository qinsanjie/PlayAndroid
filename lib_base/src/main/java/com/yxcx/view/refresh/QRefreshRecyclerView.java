package com.yxcx.view.refresh;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.yxcx.view.refresh.listener.ILoadMoreView;
import com.yxcx.view.refresh.listener.IStateView;
import com.yxcx.view.refresh.listener.OnScrollChangedListener;
import com.yxcx.view.refresh.listener.OnScrollStateChangedListener;
import com.yxcx.view.refresh.stateview.LoadingState;
import com.yxcx.view.refresh.stateview.MultiStateView;


/**
 * @author qinsanjie
 * @date 18/4/2.
 * @desc
 */

public class QRefreshRecyclerView extends QRefreshLayout implements ILoadMoreView, IStateView {

    private QRecyclerView mRecyclerView;

    private BaseListAdapter adapter;
    /**
     * 注意，如果想监听空view点击,可以通过get方法，然后findviewbyid找到相应控件设置点击
     */
    private MultiStateView stateView;

    private OnAutoLoadListener onAutoLoadListener;


    public QRefreshRecyclerView(Context context) {
        super(context);
        initView(context, null);
    }

    public QRefreshRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public QRefreshRecyclerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }


    private void initView(Context context, AttributeSet attrs) {
        mRecyclerView = new QRecyclerView(context, attrs);
        mRecyclerView.setBackgroundResource(android.R.color.white);
        mRecyclerView.setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        setLayoutManager(new LinearLayoutManager(context));

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
            mRecyclerView.setId(ViewIdUtils.generateViewId());
        } else {
            mRecyclerView.setId(View.generateViewId());
        }
        setRefreshContent(mRecyclerView);
    }

    /**
     * 返回各种空状态的view
     *
     * @return
     */
    public MultiStateView getStateView() {
        return stateView;
    }

    public void setLayoutManager(RecyclerView.LayoutManager manager) {
        mRecyclerView.setLayoutManager(manager);
    }


    public BaseQuickAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(BaseListAdapter adapter) {
        this.adapter = adapter;
        initAdapter();
    }

    @Override
    public void onComplete(boolean isRefresh, boolean isSuccess) {
        if (isRefresh) {
            finishRefresh();
            if (adapter != null) {
                if (isSuccess) {
                    stateView.setLoadingState(LoadingState.EMPTY);
                } else {
                    stateView.setLoadingState(LoadingState.ERROR);
                }
            }
        } else {
            if (adapter != null) {
                if (!isSuccess) {
                    adapter.loadMoreFail();
                } else {
                    adapter.loadMoreComplete();
                }
            }
        }

    }

    public RecyclerView getRecyclerView() {
        return mRecyclerView;
    }

    /**
     * 设置recyclerview滚动状态变化监听
     *
     * @param listener
     */
    public void setOnScrollStateChangedListener(OnScrollStateChangedListener listener) {
        mRecyclerView.setOnScrollStateChangedListener(listener);
    }

    /**
     * 设置recyclerview滚动变化监听
     *
     * @param listener
     */
    public void setOnScrollChangeListener(OnScrollChangedListener listener) {
        mRecyclerView.setOnScrollChangedListener(listener);
    }

    public RecyclerView.LayoutManager getLayoutManager() {
        return mRecyclerView.getLayoutManager();
    }

    /**
     * 设置动画
     *
     * @param animator
     */
    public void setItemAnimator(RecyclerView.ItemAnimator animator) {
        mRecyclerView.setItemAnimator(animator);
    }

    public RecyclerView.ItemAnimator getItemAnimator() {
        return mRecyclerView.getItemAnimator();
    }

    /**
     * 设置decoration
     *
     * @param decor
     */
    public void addItemDecoration(RecyclerView.ItemDecoration decor) {
        mRecyclerView.addItemDecoration(decor);
    }

    public void setStateView(MultiStateView stateView) {
        this.stateView = stateView;
        initAdapter();
    }

    private void initAdapter() {
        if (mRecyclerView != null) {
            mRecyclerView.setAdapter(adapter);
            if (stateView == null) {
                stateView = new MultiStateView(getContext());
            }
            if (adapter != null) {
                adapter.setEmptyView(mRecyclerView, stateView);
            }
        }
        setOnAutoLoadListener(onAutoLoadListener);
    }

    @Override
    public void setHasMore(boolean hasMore) {
        if (adapter != null) {
            if (!hasMore) {
                adapter.loadMoreEnd(false);
            } else {
                adapter.setEnableLoadMore(true);
            }
        }
    }

    @Override
    public void setOnAutoLoadListener(OnAutoLoadListener listener) {
        if (adapter == null) {
            throw new IllegalArgumentException("adapter must be set before setOnAutoLoadListener");
        }
        this.onAutoLoadListener = listener;
        if (onAutoLoadListener != null) {
            adapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
                @Override
                public void onLoadMoreRequested() {
                    if (onAutoLoadListener != null) {
                        onAutoLoadListener.onAutoLoad();
                    }
                }
            }, mRecyclerView);
            adapter.disableLoadMoreIfNotFullPage();
            adapter.setEnableLoadMore(false);
        }
    }

    @Override
    public void showEmptyView() {

    }

    @Override
    public void showErrorView() {

    }

    @Override
    public void loadingView() {
        if(stateView != null){
            stateView.setLoadingState(LoadingState.LOADING);
        }
    }
}
