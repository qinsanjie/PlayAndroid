package com.yxcx.view.refresh;

/**
 * @author qinsanjie
 * @date 18/4/2.
 * @desc
 */

public interface IRefreshLayout {

    /**
     * 设置下拉刷新监听
     *
     * @param listener
     */
    void setOnPullRefreshListener(OnPullRefreshListener listener);

    /**
     * 自动刷新
     */
    void doAutoRefresh();



    /**
     * 加载完成
     */
    void onComplete(boolean isRefresh, boolean isSuccess);
}
