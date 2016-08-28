package com.ligang.mvp_upgrade.adapter;

import android.view.View;

import com.ligang.mvp_upgrade.R;
import com.ligang.mvp_upgrade.bean.Reconmmentbean;

import java.util.List;

/**
 * 作者: 李刚 on 2016/8/28 14:47.
 * 邮箱: kylin_javac@outlook.com
 * 描述:
 */
public class RecommentAdapter extends  MyBaseAdapter <Reconmmentbean.DataBean.NewsBean>{
    private List<Reconmmentbean.DataBean.NewsBean>list;
    public RecommentAdapter(int[] id, List<Reconmmentbean.DataBean.NewsBean> list) {
        super(id, list);
        this.list=list;
    }

    @Override
    public void fillData(int position, MyHolder myHolder) {
        Reconmmentbean.DataBean.NewsBean newsBean = list.get(position);
        int type = getType(position);
        myHolder.setText(R.id.title, newsBean.getTitle());
        myHolder.setText(R.id.author, newsBean.getEditor());
        myHolder.setText(R.id.time, newsBean.getPub_time() + "");
        myHolder.setText(R.id.commentcount, newsBean.getReview_count() + "");
        if(type==0){//只有一张图片
            myHolder.findView(R.id.pic).setVisibility(View.VISIBLE);
            if(newsBean.getShowtype()==0){
                myHolder.findView(R.id.pic).setVisibility(View.GONE);
            }else{
                myHolder.setImage(R.id.pic,newsBean.getImgs().get(0));
            }
        }else{
            myHolder.setImage(R.id.first,newsBean.getImgs().get(0));
            myHolder.setImage(R.id.second,newsBean.getImgs().get(1));
            myHolder.setImage(R.id.third,newsBean.getImgs().get(2));
        }

    }

    /**
     * 根据返回数据来显示不同数目的照片
     * @param position
     * @return
     */
    @Override
    public int getType(int position) {
        Reconmmentbean.DataBean.NewsBean newsBean = list.get(position);
        int showtype = newsBean.getShowtype();
        int currentId=0;
        switch (showtype){
            case 1:
                currentId=0;
                break;
            case  3:
                currentId=1;
                break;
        }
        return currentId;
    }
}
