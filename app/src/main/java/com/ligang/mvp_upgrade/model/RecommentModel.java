package com.ligang.mvp_upgrade.model;

import com.ligang.mvp_upgrade.utils.HttpUtils;

/**
 * 作者: 李刚 on 2016/8/28 10:57.
 * 邮箱: kylin_javac@outlook.com
 * 描述:
 */
public class RecommentModel implements BaseModel {
    public void getData(String path,OncompletedLoad oncompletedLoad){
        HttpUtils.getLoadData(path,oncompletedLoad);

    }
    public  interface OncompletedLoad{
       void  onCompleted(byte[] bs,String path);
    }

}



