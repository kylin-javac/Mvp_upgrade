package com.ligang.mvp_upgrade.presenter;

import com.ligang.mvp_upgrade.model.BaseModel;
import com.ligang.mvp_upgrade.view.MvpView;

import java.lang.ref.WeakReference;

/**
 * 作者: 李刚 on 2016/8/28 11:02.
 * 邮箱: kylin_javac@outlook.com
 * 描述:
 */
public abstract class BasePresenter<V extends MvpView,M extends BaseModel> {
    private WeakReference<V> weakReference;
    public M model;

    public BasePresenter() {
        this.model = CreateModel();
    }

    public abstract   M  CreateModel() ;

    public void attch(V v){
        weakReference=new WeakReference<V>(v);
    }
    public V getView(){
        if (weakReference != null) {
            V v = weakReference.get();
            return v;
        }
        return  null;
    }
    public void deattch(){
        if (weakReference != null) {
            weakReference.clear();
            weakReference=null;
        }
    }




}
