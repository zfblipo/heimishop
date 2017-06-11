package com.lipo.heimishop.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.lipo.heimishop.R;
import com.lipo.heimishop.adapter.GoodsGridAdapter;
import com.lipo.heimishop.adapter.HotRecommendAdapter;
import com.lipo.heimishop.beans.GoodsInfo;
import com.lipo.heimishop.beans.ImageInfo;
import com.lipo.heimishop.factory.ImagePagerFactory;
import com.lipo.heimishop.factory.MainDirectMoreFactory;
import com.lipo.heimishop.factory.PullScrollViewHelper;
import com.lipo.heimishop.utils.MyHttpConn;
import com.lipo.views.NoScrollGirdView;
import com.lipo.views.NoScrollListview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lipo on 2017/6/7.
 */

public class Main1ItemFragment1 extends BaseFragment {

    private View mainView1;

    private boolean isFrist = true;
    private MyHttpConn httpConn;
    private Gson gson;
    private int page;
    private boolean isShowing;

    private PullScrollViewHelper pullHelper;

    private View contentView, main1_item1_image_pager,main1_item1_hot,main1_item1_guess;
    private NoScrollListview main1_item1_hot_list;
    private NoScrollGirdView main1_item1_guess_grid;

    private ImagePagerFactory imageFactory;
    private MainDirectMoreFactory moreFactory1,moreFactory2;

    private List<ImageInfo> imageInfoList;
    private List<GoodsInfo> goodsInfoList1,goodsInfoList2;

    private HotRecommendAdapter hotAdapter;
    private GoodsGridAdapter goodsAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return mainView1 = inflater.inflate(R.layout.cell_pull_scroll, null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        isShowing = false;
        imageInfoList = new ArrayList<ImageInfo>();
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
        contentView = LayoutInflater.from(mContext).inflate(R.layout.main1_item_fragment1,null);
        pullHelper = new PullScrollViewHelper(mContext,mainView1,contentView) {
            @Override
            protected void pullRefersh() {
                pullHelper.onRefreshComplete();
            }

            @Override
            protected void pullMore() {
                pullHelper.onRefreshComplete();
            }
        };

        main1_item1_image_pager = contentView.findViewById(R.id.main1_item1_image_pager);
        main1_item1_hot = contentView.findViewById(R.id.main1_item1_hot);
        main1_item1_guess = contentView.findViewById(R.id.main1_item1_guess);
        main1_item1_hot_list = (NoScrollListview) contentView.findViewById(R.id.main1_item1_hot_list);
        main1_item1_guess_grid = (NoScrollGirdView) contentView.findViewById(R.id.main1_item1_guess_grid);


        moreFactory1 = new MainDirectMoreFactory(mContext,main1_item1_hot) {
            @Override
            public void onClick() {

            }
        };
        moreFactory2 = new MainDirectMoreFactory(mContext,main1_item1_guess,"猜你喜欢") {
            @Override
            public void onClick() {

            }
        };

        for (int i = 0; i <6; i++) {
            goodsInfoList1.add(new GoodsInfo());
            goodsInfoList2.add(new GoodsInfo());
            imageInfoList.add(new ImageInfo());
        }

        imageFactory = new ImagePagerFactory(mContext,main1_item1_image_pager,imageInfoList);
        initHotAdapter();
        initGoodsAdapter();

    }

    private void initHotAdapter(){
        if(hotAdapter == null){
            hotAdapter = new HotRecommendAdapter(mContext,goodsInfoList1);
            main1_item1_hot_list.setAdapter(hotAdapter);
        }else{
            hotAdapter.notifyDataSetChanged();
        }
    }

    private void initGoodsAdapter(){
        if(goodsAdapter == null){
            goodsAdapter = new GoodsGridAdapter(mContext,goodsInfoList2);
            main1_item1_guess_grid.setAdapter(goodsAdapter);
        }else{
            goodsAdapter.notifyDataSetChanged();
        }
    }


}
