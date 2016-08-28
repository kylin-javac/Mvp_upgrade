package com.ligang.mvp_upgrade.view.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.ligang.mvp_upgrade.R;
import com.ligang.mvp_upgrade.adapter.MyFragmenterAdapter;
import com.ligang.mvp_upgrade.view.fragment.BaseFragment;
import com.ligang.mvp_upgrade.view.fragment.CCCFragment;
import com.ligang.mvp_upgrade.view.fragment.CarFragment;
import com.ligang.mvp_upgrade.view.fragment.ComputerFragment;
import com.ligang.mvp_upgrade.view.fragment.GameFragment;
import com.ligang.mvp_upgrade.view.fragment.ItCricleFragment;
import com.ligang.mvp_upgrade.view.fragment.MovieFragment;
import com.ligang.mvp_upgrade.view.fragment.PhoneFragment;
import com.ligang.mvp_upgrade.view.fragment.RecommentFragment;
import com.ligang.mvp_upgrade.view.fragment.SofeWareFragment;
import com.ligang.mvp_upgrade.view.fragment.TVFragment;
import com.ligang.mvp_upgrade.view.fragment.TuiJianFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String[] titles = {"推荐", "最新", "手机", "IT圈", "汽车", "科学", "游戏", "电脑", "影音", "软件", "数码", "家电", "详情"};
    private List<BaseFragment> list;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private MyFragmenterAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        list = new ArrayList<>();
        RecommentFragment recommentFragment = new RecommentFragment();
        list.add(recommentFragment);
        list.add(new CarFragment());
        list.add(new CCCFragment());
        list.add(new ComputerFragment());
        list.add(new GameFragment());
        list.add(new ItCricleFragment());
        list.add(new MovieFragment());
        list.add(new PhoneFragment());
        list.add(new SofeWareFragment());
        list.add(new TuiJianFragment());
        list.add(new TVFragment());


        adapter = new MyFragmenterAdapter(getSupportFragmentManager(), list, titles);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
