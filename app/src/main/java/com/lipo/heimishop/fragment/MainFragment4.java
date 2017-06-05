package com.lipo.heimishop.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.lipo.heimishop.R;
import com.lipo.heimishop.utils.MyHttpConn;

/**
 * Created by lipo on 2017/6/5.
 */

public class MainFragment4 extends BaseFragment {

    private View mainView;
    private boolean isFrist = true;
    private MyHttpConn httpConn;
    private Gson gson;
    private int page;
    private boolean isShowing;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return mainView = inflater.inflate(R.layout.main_fragment4, null);
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

    }

}
