package com.ligang.mvp_upgrade.adapter;

import android.support.annotation.LayoutRes;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * 作者: 李刚 on 2016/8/28 13:58.
 * 邮箱: kylin_javac@outlook.com
 * 描述: 对adpapter的高级抽取
 */
public abstract class MyBaseAdapter<T> extends BaseAdapter {
    private List<T> list;
    @LayoutRes
    private int id[];

    public MyBaseAdapter(int id[],List<T> list) {
        this.id=id;
        this.list = list;
    }


    @Override
    public int getCount() {
        return list==null?0:list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int currentID=id[getItemViewType(position)];
        MyHolder holder=MyHolder.getHolder(convertView,parent.getContext(),currentID);
        fillData(position,holder);
        return holder.getView();
    }






    public abstract void fillData(int position, MyHolder myHolder);//填充数据

    public abstract int getType(int position);//返回当前条目应该加在的视图

    @Override
    public int getItemViewType(int position) {
        return getType(position);
    }
}
