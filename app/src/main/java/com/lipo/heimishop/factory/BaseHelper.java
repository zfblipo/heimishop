package com.lipo.heimishop.factory;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;

import com.lipo.heimishop.R;


/**
 * Created by lipo on 2017/3/13.
 */
public class BaseHelper {

    protected Activity context;
    protected View mainView;
    protected Resources resources;

    public BaseHelper(Activity context,View mainView){
        this.context = context;
        this.mainView = mainView;
        resources = context.getResources();
    }

    public View findViewById(int id){
        return mainView.findViewById(id);
    }

    public void finish(){
        context.finish();
        context.overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
    }

}
