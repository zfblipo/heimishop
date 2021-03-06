package com.lipo.heimishop.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.lipo.heimishop.R;
import com.lipo.heimishop.factory.PullScrollViewHelper;
import com.lipo.heimishop.utils.MyHttpConn;

/**
 * Created by lipo on 2017/6/7.
 */

public class Main1ItemFragment2 extends BaseFragment {

    private View mainView2;

    private boolean isFrist = true;
    private MyHttpConn httpConn;
    private Gson gson;
    private int page;
    private boolean isShowing;

    private PullScrollViewHelper pullHelper;

    private View contentView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return mainView2 = inflater.inflate(R.layout.cell_pull_scroll, null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        isShowing = false;

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
        contentView = LayoutInflater.from(mContext).inflate(R.layout.main1_item_fragment2,null);
        pullHelper = new PullScrollViewHelper(mContext,mainView2,contentView) {
            @Override
            protected void pullRefersh() {

            }

            @Override
            protected void pullMore() {

            }
        };
    }

}