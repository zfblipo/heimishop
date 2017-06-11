package com.lipo.heimishop.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lipo.heimishop.R;
import com.lipo.heimishop.beans.GoodsInfo;

import java.util.List;

/**
 * Created by lipo on 2017/6/8.
 */

public class HotRecommendAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<GoodsInfo> list;
    private Resources resources;

    public HotRecommendAdapter(Context context, List<GoodsInfo> list) {
        this.context = context;
        this.list = list;
        this.inflater = LayoutInflater.from(context);
        resources = context.getResources();
    }

    @Override
    public int getCount() {
        int count = 0;
        count = list.size();
        return count;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_hot_recommend, null);
            initHolder(holder, convertView);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        initData(holder, position);
        return convertView;
    }

    private class ViewHolder {
        ImageView item_hotr_image;
        TextView item_hotr_label,item_hotr_name,item_hotr_adv,item_hotr_price;
    }

    private void initHolder(ViewHolder holder, View convertView) {
        holder.item_hotr_image = (ImageView) convertView.findViewById(R.id.item_hotr_image);
        holder.item_hotr_label = (TextView) convertView.findViewById(R.id.item_hotr_label);
        holder.item_hotr_name = (TextView) convertView.findViewById(R.id.item_hotr_name);
        holder.item_hotr_adv = (TextView) convertView.findViewById(R.id.item_hotr_adv);
        holder.item_hotr_price = (TextView) convertView.findViewById(R.id.item_hotr_price);

        convertView.setTag(holder);
    }

    private void initData(ViewHolder holder, int position) {
        GoodsInfo info = list.get(position);
    }
}