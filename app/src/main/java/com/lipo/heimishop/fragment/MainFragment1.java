package com.lipo.heimishop.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lipo.heimishop.R;
import com.lipo.heimishop.utils.MyHttpConn;

/**
 * Created by lipo on 2017/6/5.
 */

public class MainFragment1 extends BaseFragment {

    private boolean isFrist = true;
    private MyHttpConn httpConn;
    private Gson gson;
    private int page;
    private boolean isShowing;

    private View main1_title_scan,main1_title_news,main1_search;
    private TextView main1_item1,main1_item2,main1_item3;
    private View main1_line;
    private ViewPager main1_pager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return mainView = inflater.inflate(R.layout.main_fragment1, null);
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
        main1_title_scan = findViewById(R.id.main1_title_scan);
        main1_title_news = findViewById(R.id.main1_title_news);
        main1_search = findViewById(R.id.main1_search);
        main1_line = findViewById(R.id.main1_line);
        main1_item1 = (TextView) findViewById(R.id.main1_item1);
        main1_item2 = (TextView) findViewById(R.id.main1_item2);
        main1_item3 = (TextView) findViewById(R.id.main1_item3);
        main1_pager = (ViewPager) findViewById(R.id.main1_pager);
    }



}
