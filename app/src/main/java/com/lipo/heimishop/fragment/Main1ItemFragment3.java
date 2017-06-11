package com.lipo.heimishop.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.lipo.heimishop.R;
import com.lipo.heimishop.adapter.GoodsGridAdapter;
import com.lipo.heimishop.beans.GoodsInfo;
import com.lipo.heimishop.factory.MainDirectMoreFactory;
import com.lipo.heimishop.factory.PullScrollViewHelper;
import com.lipo.heimishop.utils.MyHttpConn;
import com.lipo.views.NoScrollGirdView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lipo on 2017/6/7.
 */

public class Main1ItemFragment3 extends BaseFragment {

    private View mainView3;

    private boolean isFrist = true;
    private MyHttpConn httpConn;
    private Gson gson;
    private int page;
    private boolean isShowing;

    private PullScrollViewHelper pullHelper;

    private View contentView;

    private View main1_item3_hot,main1_item3_new;
    private NoScrollGirdView main1_item3_hot_grid,main1_item3_new_grid;

    private MainDirectMoreFactory moreFactory1,moreFactory2;

    private List<GoodsInfo> goodsInfoList1,goodsInfoList2;
    private GoodsGridAdapter goodsAdapter1,goodsAdapter2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return mainView3 = inflater.inflate(R.layout.cell_pull_scroll, null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        isShowing = false;
        goodsInfoList1 = new ArrayList<GoodsInfo>();
        goodsInfoList2 = new ArrayList<GoodsInfo>();
        httpConn = new MyHttpConn(mContext);
        gson = new Gson();
        page = 1;

        initView();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden & isFrist ) {
//            getData();
        }
    }

    private void initView(){
        contentView = LayoutInflater.from(mContext).inflate(R.layout.main1_item_fragment3,null);
        pullHelper = new PullScrollViewHelper(mContext,mainView3,contentView) {

            @Override
            protected void pullRefersh() {
                pullHelper.onRefreshComplete();
            }

            @Override
            protected void pullMore() {
                pullHelper.onRefreshComplete();
            }
        };

        main1_item3_hot = contentView.findViewById(R.id.main1_item3_hot);
        main1_item3_new = contentView.findViewById(R.id.main1_item3_new);
        main1_item3_hot_grid = (NoScrollGirdView) contentView.findViewById(R.id.main1_item3_hot_grid);
        main1_item3_new_grid = (NoScrollGirdView) contentView.findViewById(R.id.main1_item3_new_grid);

        moreFactory1 = new MainDirectMoreFactory(mContext,main1_item3_hot,"推荐关注",true) {
            @Override
            public void onClick() {

            }
        };
        moreFactory2 = new MainDirectMoreFactory(mContext,main1_item3_new,"全部新品",true) {
            @Override
            public void onClick() {

            }
        };

        for (int i = 0; i <6; i++) {
            goodsInfoList1.add(new GoodsInfo());
            goodsInfoList2.add(new GoodsInfo());
        }

        initHotAdapter();
        initNewAdapter();

    }

    private void initHotAdapter(){
        if(goodsAdapter1 == null){
            goodsAdapter1 = new GoodsGridAdapter(mContext,goodsInfoList1);
            main1_item3_hot_grid.setAdapter(goodsAdapter1);
        }else{
            goodsAdapter1.notifyDataSetChanged();
        }
    }

    private void initNewAdapter(){
        if(goodsAdapter2 == null){
            goodsAdapter2 = new GoodsGridAdapter(mContext,goodsInfoList2);
            main1_item3_new_grid.setAdapter(goodsAdapter2);
        }else{
            goodsAdapter2.notifyDataSetChanged();
        }
    }

}
