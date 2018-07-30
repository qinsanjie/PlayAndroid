package com.qinsanjie.playandroid.mvp.ui.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseViewHolder;
import com.jess.arms.di.component.AppComponent;
import com.qinsanjie.playandroid.R;
import com.qinsanjie.playandroid.base.ui.BaseFragment;
import com.yxcx.view.refresh.BaseListAdapter;
import com.yxcx.view.refresh.OnAutoLoadListener;
import com.yxcx.view.refresh.OnPullRefreshListener;
import com.yxcx.view.refresh.QRefreshRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @author qinsanjie
 * @date 18/7/24.
 * @desc
 */

public class HomeFragment extends BaseFragment implements OnPullRefreshListener, OnAutoLoadListener {
    @BindView(R.id.refresh_layout)
    QRefreshRecyclerView refreshlayout;
    ListAdapter listAdapter;

    Handler handler = new Handler();

    private int refresh_state = 0;

    private int load_state = 0;

    @Override
    public void setupFragmentComponent(@NonNull AppComponent appComponent) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home_layout;
    }

    @Override
    public void initView() {
        listAdapter = new ListAdapter(null);
        refreshlayout.setAdapter(listAdapter);
        refreshlayout.setOnPullRefreshListener(this);
        refreshlayout.setOnAutoLoadListener(this);
        refreshlayout.getStateView().findViewById(R.id.retry).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refreshlayout.loadingView();
                onRefresh();
            }
        });
        onRefresh();
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        String title = getArguments().getString("title");
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
        BaseFragment fragment = new HomeFragment();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAutoLoad() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(load_state == 0){
                    refreshlayout.onComplete(false,false);
                    load_state++;
                    return;
                }else if(load_state ==1){
                    ArrayList<Object> news = new ArrayList<>();
                    for(int i = 0;i<10;i++){
                        news.add(new Object());
                    }
                    listAdapter.addData(news);
                    refreshlayout.onComplete(false,true);
                    load_state++;
                }else{
                    ArrayList<Object> news = new ArrayList<>();
                    for(int i = 0;i<10;i++){
                        news.add(new Object());
                    }
                    listAdapter.addData(news);
                    refreshlayout.onComplete(false,true);
                    refreshlayout.setHasMore(false);
                    load_state++;
                }


            }
        },2000);
    }

    @Override
    public void onRefresh() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(refresh_state == 0){
                    refreshlayout.onComplete(true,false);
                    refresh_state++;
                    return;
                }else if(refresh_state ==1){
                    refreshlayout.onComplete(true,true);
                    refresh_state++;
                    return;
                }
                ArrayList<Object> news = new ArrayList<>();
                for(int i = 0;i<10;i++){
                    news.add(new Object());
                }
                listAdapter.setNewData(news);
                refreshlayout.onComplete(true,true);
            }
        },2000);
    }

    public class ListAdapter extends BaseListAdapter<Object,BaseViewHolder> {
        public ListAdapter(int layoutResId, @Nullable List<Object> data) {
            super(layoutResId, data);
        }

        public ListAdapter(@Nullable List<Object> data) {
            this(R.layout.home_list_item,data);
        }



        @Override
        protected void convert(BaseViewHolder helper, Object item) {
            helper.setText(R.id.textview,String.valueOf(helper.getAdapterPosition()));
        }
    }


}
