package com.ligang.mvp_upgrade.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ligang.mvp_upgrade.model.RecommentModel;
import com.ligang.mvp_upgrade.utils.HttpUtils;

/**
 * 作者: 李刚 on 2016/8/28 14:06.
 * 邮箱: kylin_javac@outlook.com
 * 描述: 对Holder进行抽取
 */
public class MyHolder {
    private View contentView;
    private int id;
    private SparseArray<View> sparseArray = new SparseArray<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MyHolder(int id) {
        this.id = id;
    }

    public MyHolder(Context context, int id) {
        contentView= LayoutInflater.from(context).inflate(id,null);
        this.id=id;
        contentView.setTag(this);

    }

    public static  MyHolder getHolder(View contentView, Context context, @LayoutRes int id){
        MyHolder myHolder=null;
        if(contentView==null){
            myHolder=new MyHolder(context,id);
        }else{
            myHolder= (MyHolder) contentView.getTag();
            if(myHolder.id!=id){
                myHolder=new MyHolder(context,id);
            }
        }
        return  myHolder;
    }

    public View getView(){
        return  contentView;
    }

    /**
     * 查找控件
     * @param id
     * @return
     */
    public View  findView(@IdRes int id){
      View view=sparseArray.get(id);
        if(view==null){
            view=contentView.findViewById(id);
            sparseArray.put(id,view);
        }
        return view;
    }
    /**
     * 设置文本
     */
    public void setText(@IdRes int id,String text){
        ((TextView) findView(id)).setText(text);
    }
    /**
     * 设置图片内容
     */
    public void setImage(@IdRes int id,String path){
        final ImageView imageView = (ImageView) findView(id);
        imageView.setTag(path);
        HttpUtils.getLoadData(path, new RecommentModel.OncompletedLoad() {
            @Override
            public void onCompleted(byte[] bs, String path) {
                Bitmap bitmap = BitmapFactory.decodeByteArray(bs, 0, bs.length);
                imageView.setImageBitmap(bitmap);
            }
        });
    }





}
