package com.lipo.heimishop.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lipo.heimishop.R;
import com.lipo.heimishop.adapter.MyFragmentPagerAdapter;
import com.lipo.heimishop.utils.MyHttpConn;
import com.lipo.utils.DisplayUtil;

import java.util.ArrayList;
import java.util.List;

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
    private TextView[] textViews = new TextView[3];
    private View main1_line;
    private ViewPager main1_pager;

    private List<Fragment> fragments;

    private int mainLineWidth;
    private DisplayMetrics metrics;
    private int dp20;
    private int seq_temp = 0;

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
        fragments = new ArrayList<Fragment>();
        httpConn = new MyHttpConn(mContext);
        gson = new Gson();
        page = 1;
        metrics = mContext.getResources().getDisplayMetrics();
        dp20 = DisplayUtil.dip2px(mContext,20);
        mainLineWidth = metrics.widthPixels/3-dp20*2;

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
        textViews[0] = main1_item1;
        textViews[1] = main1_item2;
        textViews[2] = main1_item3;

        Main1ItemFragment1 fragment1 = new Main1ItemFragment1();
        Main1ItemFragment2 fragment2 = new Main1ItemFragment2();
        Main1ItemFragment3 fragment3 = new Main1ItemFragment3();

        fragments.add(fragment1);
        fragments.add(fragment2);
        fragments.add(fragment3);

        main1_pager.setOffscreenPageLimit(2);
        main1_pager.setAdapter(new MyFragmentPagerAdapter(getFragmentManager(),fragments));

        main1_line.post(new Runnable() {
            @Override
            public void run() {
                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) main1_line.getLayoutParams();
                params.width = mainLineWidth;
                main1_line.setTranslationX(dp20);
                main1_line.setLayoutParams(params);
            }
        });

        main1_pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                int widthX = metrics.widthPixels / 3 * position + positionOffsetPixels / 3+dp20;
                main1_line.setTranslationX(widthX);
            }

            @Override
            public void onPageSelected(int position) {
                changeLabel(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void changeLabel(int position) {
        textViews[seq_temp].setTextColor(getResources().getColor(R.color.main_text3));
        textViews[position].setTextColor(getResources().getColor(R.color.main_red));
        seq_temp = position;
    }

}
