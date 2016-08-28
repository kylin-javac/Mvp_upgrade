package com.ligang.mvp_upgrade.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.ligang.mvp_upgrade.view.fragment.BaseFragment;

import java.util.List;

/**
 * 作者: 李刚 on 2016/8/28 12:05.
 * 邮箱: kylin_javac@outlook.com
 * 描述:
 */
public class MyFragmenterAdapter extends FragmentStatePagerAdapter {
    private List<BaseFragment>list;
    private String title[];

    public MyFragmenterAdapter(FragmentManager fm, List<BaseFragment> list, String[] title) {
        super(fm);
        this.list = list;
        this.title = title;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list==null?0:list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
