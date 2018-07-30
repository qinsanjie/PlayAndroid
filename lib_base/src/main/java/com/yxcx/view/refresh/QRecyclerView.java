package com.yxcx.view.refresh;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.yxcx.view.refresh.listener.OnScrollChangedListener;
import com.yxcx.view.refresh.listener.OnScrollStateChangedListener;


/**
 * 作者：陈磊
 * 日期：16/1/7
 */
public class QRecyclerView extends RecyclerView {


    private OnScrollStateChangedListener onScrollStateChangedListener;
    private OnScrollChangedListener onScrollChangedListener;

    public QRecyclerView(Context context) {
        super(context);
        init(context);
    }

    public QRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public QRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        setLayoutManager(new LinearLayoutManager(context));
    }

    public void setOnScrollStateChangedListener(OnScrollStateChangedListener listener) {
        this.onScrollStateChangedListener = listener;
    }

    public void setOnScrollChangedListener(OnScrollChangedListener listener) {
        this.onScrollChangedListener = listener;
    }

    @Override
    public void onScrolled(int dx, int dy) {
        super.onScrolled(dx, dy);
        if (onScrollChangedListener != null) {
            onScrollChangedListener.onScrollChanged(dx, dy, 0, 0);
        }
    }

    @Override
    public void onScrollStateChanged(int state) {
        super.onScrollStateChanged(state);
        if (onScrollStateChangedListener != null) {
            onScrollStateChangedListener.onScrollStateChanged(state);
        }
    }

}
