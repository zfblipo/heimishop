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

public class GoodsGridAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<GoodsInfo> list;
    private Resources resources;

    public GoodsGridAdapter(Context context, List<GoodsInfo> list) {
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
            convertView = inflater.inflate(R.layout.item_goods_grid, null);
            initHolder(holder, convertView);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        initData(holder, position);
        return convertView;
    }

    private class ViewHolder {
        ImageView item_goods_grid_image;
        TextView item_goods_grid_label,item_goods_grid_name,item_goods_grid_adv,item_goods_grid_price;
    }

    private void initHolder(ViewHolder holder, View convertView) {
        holder.item_goods_grid_image = (ImageView) convertView.findViewById(R.id.item_goods_grid_image);
        holder.item_goods_grid_label = (TextView) convertView.findViewById(R.id.item_goods_grid_label);
        holder.item_goods_grid_name = (TextView) convertView.findViewById(R.id.item_goods_grid_name);
        holder.item_goods_grid_adv = (TextView) convertView.findViewById(R.id.item_goods_grid_adv);
        holder.item_goods_grid_price = (TextView) convertView.findViewById(R.id.item_goods_grid_price);

        convertView.setTag(holder);
    }

    private void initData(ViewHolder holder, int position) {
        GoodsInfo info = list.get(position);
    }

}
