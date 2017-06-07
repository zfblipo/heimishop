package com.lipo.heimishop.factory;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.lipo.heimishop.R;

/**
 * Created by lipo on 2017/6/7.
 */

public abstract class MainDirectMoreFactory extends BaseHelper {

    private TextView cell_main_direct_text;
    private String textContent;

    /**
     * cell_main_direct
     * @param context
     * @param mainView
     */
    public MainDirectMoreFactory(Activity context, View mainView) {
        super(context, mainView);
        initView();
    }

    public MainDirectMoreFactory(Activity context, View mainView,String textContent) {
        this(context, mainView);

        cell_main_direct_text.setText(textContent);
    }

    private void initView(){
        cell_main_direct_text = (TextView) findViewById(R.id.cell_main_direct_text);

        mainView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainDirectMoreFactory.this.onClick();
            }
        });
    }

    public abstract void onClick();

}
