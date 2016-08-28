package com.ligang.mvp_upgrade.view.fragment;

import com.ligang.mvp_upgrade.R;
import com.ligang.mvp_upgrade.adapter.RecommentAdapter;
import com.ligang.mvp_upgrade.bean.Reconmmentbean;
import com.ligang.mvp_upgrade.presenter.RecommentPresenter;
import com.ligang.mvp_upgrade.view.ReconmmentView;

import java.util.List;

/**
 * 作者: 李刚 on 2016/8/28 11:48.
 * 邮箱: kylin_javac@outlook.com
 * 描述:
 */
public class RecommentFragment extends BaseFragment<ReconmmentView,RecommentPresenter> {
    @Override
    public RecommentPresenter CreatePresenter() {
        return new RecommentPresenter();
    }

    @Override
    public void loadData() {
        presenter.getPresenterData(myUrl);

    }

    @Override
    public int getUrl() {
        return -1;
    }

    @Override
    public void showData(Reconmmentbean reconmmentbean) {
        List<Reconmmentbean.DataBean.NewsBean> news = reconmmentbean.getData().getNews();
        RecommentAdapter adapter = new RecommentAdapter(new int[]{R.layout.item_recomment_0, R.layout.item_recomment_1}, news);
        listView.setAdapter(adapter);
    }

}
