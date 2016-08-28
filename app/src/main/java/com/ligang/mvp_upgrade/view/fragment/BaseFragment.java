package com.ligang.mvp_upgrade.view.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.ligang.mvp_upgrade.R;
import com.ligang.mvp_upgrade.presenter.BasePresenter;
import com.ligang.mvp_upgrade.utils.GloableInerface;
import com.ligang.mvp_upgrade.view.MvpView;
import com.ligang.mvp_upgrade.view.ReconmmentView;

public abstract class BaseFragment <V extends MvpView,M extends BasePresenter> extends Fragment implements ReconmmentView {
    public M presenter;
    public ListView listView;
    public String myUrl;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_base, container, false);
        listView = ((ListView) view.findViewById(R.id.listview));
        presenter=CreatePresenter();
        myUrl = String.format(GloableInerface.RECOMMENT, getUrl());
        loadData();
        presenter.attch((V) this);
        return  view;
    }

    public  abstract M CreatePresenter();
    public  abstract void loadData();
    public  abstract  int getUrl();

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.deattch();
    }
}
