package com.ligang.mvp_upgrade.presenter;

import com.google.gson.Gson;
import com.ligang.mvp_upgrade.bean.Reconmmentbean;
import com.ligang.mvp_upgrade.model.RecommentModel;
import com.ligang.mvp_upgrade.view.ReconmmentView;

/**
 * 作者: 李刚 on 2016/8/28 11:08.
 * 邮箱: kylin_javac@outlook.com
 * 描述:
 */
public class RecommentPresenter extends  BasePresenter<ReconmmentView,RecommentModel> {
    @Override
    public RecommentModel CreateModel() {
        return new RecommentModel();
    }

    public void getPresenterData(String path){
        model.getData(path, new RecommentModel.OncompletedLoad() {
            @Override
            public void onCompleted(byte[] bs, String path) {
                try{
                String json = new String(bs);
                Reconmmentbean reconmmentbean = new Gson().fromJson(json, Reconmmentbean.class);
                getView().showData(reconmmentbean);
                }catch (Exception e){

                }
            }
        });
    }

}
