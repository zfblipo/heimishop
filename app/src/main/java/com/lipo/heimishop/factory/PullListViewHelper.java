package com.lipo.heimishop.factory;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.lipo.heimishop.R;

/**
 * Created by lipo on 2017/6/7.
 */

public abstract class PullListViewHelper {

    private Activity mContext;
    private View mainView, footerView;
    private SwipeRefreshLayout swipeLayout;
    private ListView listView;

    private LayoutInflater inflater;
    private boolean isRefreshing = false;
    private boolean isMoreLoading = false;
    private boolean isPullMoreEnable = true;
    private ObjectAnimator anim;

    private ImageView pull_footer_progress;
    private TextView pull_footer_text;
    private View pull_footer_line, pull_footer_more,cell_pull_list_empty_content;

    private View emptyView;

    public PullListViewHelper(Activity mContext, View mainView) {
        this.mContext = mContext;
        this.mainView = mainView;
        isMoreLoading = false;
        inflater = LayoutInflater.from(mContext);

        initView();
    }

    private void initView() {
        swipeLayout = (SwipeRefreshLayout) mainView.findViewById(R.id.cell_pull_list_swipe);
        listView = (ListView) mainView.findViewById(R.id.cell_pull_list_view);
        cell_pull_list_empty_content = mainView.findViewById(R.id.cell_pull_list_empty_content);
        footerView = inflater.inflate(R.layout.pull_footer, null);
        emptyView = inflater.inflate(R.layout.cell_empty, null);
        listView.addFooterView(footerView);

        listView.setEmptyView(emptyView);

        listView.setFooterDividersEnabled(false);

        pull_footer_progress = (ImageView) footerView
                .findViewById(R.id.pull_footer_progress);
        pull_footer_text = (TextView) footerView
                .findViewById(R.id.pull_footer_text);
        pull_footer_line = footerView.findViewById(R.id.pull_footer_line);
        pull_footer_more = footerView.findViewById(R.id.pull_footer_more);
        anim = ObjectAnimator.ofFloat(pull_footer_progress, "rotation", 0F,
                360F);
        anim.setRepeatMode(ObjectAnimator.RESTART);
        anim.setRepeatCount(-1);
        anim.setDuration(800);
        anim.setInterpolator(new LinearInterpolator());
        anim.start();

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
                    if (listView.getLastVisiblePosition() == listView
                            .getCount() - 1) {
                        if (!isMoreLoading && isPullMoreEnable) {
                            isMoreLoading = true;
                            swipeLayout.setEnabled(false);
                            pullMore();
                        }
                    }
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {
            }
        });

        swipeLayout
                .setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

                    @Override
                    public void onRefresh() {
                        isRefreshing = true;
                        isPullMoreEnable = false;
                        footerView.setVisibility(View.GONE);
                        pullRefersh();
                    }
                });

        isPullMoreEnable = false;
        footerView.setVisibility(View.GONE);
    }

    public void setRefreshComplete() {
        if (isRefreshing) {
            isRefreshing = false;
            isPullMoreEnable = true;
            footerView.setVisibility(View.VISIBLE);
        }
        if (isMoreLoading) {
            isMoreLoading = false;
            swipeLayout.setEnabled(true);
        }
        swipeLayout.setRefreshing(false);
    }

    public void setAdapter(BaseAdapter adapter) {
        listView.setAdapter(adapter);
    }

    public void setPullMoreEnable(boolean isPullMoreEnable) {
        this.isPullMoreEnable = isPullMoreEnable;
        if (isPullMoreEnable) {
            pull_footer_progress.setVisibility(View.VISIBLE);
            pull_footer_line.setVisibility(View.GONE);
            pull_footer_text.setText("正在加载...");
        } else {
            pull_footer_progress.setVisibility(View.GONE);
            pull_footer_line.setVisibility(View.VISIBLE);
            pull_footer_text.setText("  数据已加载完  ");
        }
    }

    public void setOnItemClickListener(
            AbsListView.OnItemClickListener onItemClick) {
        listView.setOnItemClickListener(onItemClick);
    }

    public void setDivider(int color,int height){
        ColorDrawable divider = new ColorDrawable(mContext.getResources().getColor(color));
        listView.setDivider(divider);
        listView.setDividerHeight(height);
    }

    public void setEmptyShow(){
        isPullMoreEnable = false;
        cell_pull_list_empty_content.setVisibility(View.VISIBLE);
        footerView.setVisibility(View.GONE);
    }

    public void setEmptyDismiss(){
        isPullMoreEnable = true;
        cell_pull_list_empty_content.setVisibility(View.GONE);
        footerView.setVisibility(View.VISIBLE);
    }

    public void setHeaderDividersEnabled(boolean headerDividersEnabled){
        listView.setHeaderDividersEnabled(headerDividersEnabled);
    }

    public void addHeaderView(View v){
        listView.addHeaderView(v);
    }

    protected abstract void pullRefersh();

    protected abstract void pullMore();


}
