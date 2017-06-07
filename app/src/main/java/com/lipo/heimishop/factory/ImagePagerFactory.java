package com.lipo.heimishop.factory;

import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.lipo.heimishop.R;
import com.lipo.heimishop.adapter.ImagePagerNewAdapter;
import com.lipo.heimishop.beans.ImageInfo;
import com.lipo.heimishop.views.MyPagerIndicator;

import java.util.List;

/**
 * Created by lipo on 2017/6/7.
 */

public class ImagePagerFactory extends BaseHelper {

    private ViewPager cell_image_pager_view;
    private MyPagerIndicator cell_image_pager_indicator;

    private List<ImageInfo> imageInfoList;

    /**
     * cell_image_pager
     * @param context
     * @param mainView
     */
    public ImagePagerFactory(Activity context, View mainView) {
        super(context, mainView);
        initView();
    }

    /**
     * cell_image_pager
     * @param context
     * @param mainView
     */
    public ImagePagerFactory(Activity context, View mainView,List<ImageInfo> imageInfoList) {
        this(context, mainView);
    }

    private void initView(){
        cell_image_pager_view = (ViewPager) findViewById(R.id.cell_image_pager_view);
        cell_image_pager_indicator = (MyPagerIndicator) findViewById(R.id.cell_image_pager_indicator);

        cell_image_pager_view.setAdapter(new ImagePagerNewAdapter(context,imageInfoList,1));

        cell_image_pager_indicator.setPager(cell_image_pager_view,imageInfoList.size());

    }



}
