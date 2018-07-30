package com.yxcx.view.refresh.listener;


import com.yxcx.view.refresh.OnAutoLoadListener;

/**
 * @author qinsanjie
 * @date 18/7/28.
 * @desc 加载更多
 */

public interface ILoadMoreView {
    /**
     * 是否还有更多
     * @param hasMore 是否还有更多
     */
    void setHasMore(boolean hasMore);

    void setOnAutoLoadListener(OnAutoLoadListener listener);
}
