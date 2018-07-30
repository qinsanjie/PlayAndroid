package com.yxcx.view.refresh;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yxcx.view.refresh.stateview.MultiStateView;

import java.util.List;


/**
 * @author qinsanjie
 * @date 18/6/29.
 * @desc
 */

public abstract class BaseListAdapter<T, K extends BaseViewHolder> extends BaseQuickAdapter<T, K> {
    private View loadingView;
    private RecyclerView recyclerView;

    public BaseListAdapter(int layoutResId, @Nullable List<T> data) {
        super(layoutResId, data);
    }

    public BaseListAdapter(@Nullable List<T> data) {
        super(data);
    }

    public BaseListAdapter(int layoutResId) {
        super(layoutResId);
    }

    public void setEmptyView(RecyclerView recyclerView, MultiStateView multiStateView) {
        this.recyclerView = recyclerView;
        loadingView = multiStateView;
        setEmptyView(loadingView);
    }

    @Override
    protected RecyclerView getRecyclerView() {
        if (recyclerView == null) {
            return super.getRecyclerView();
        }
        return recyclerView;
    }

    @Override
    public void loadMoreComplete() {
        super.loadMoreComplete();
    }


}
