package com.ligang.mvp_upgrade.utils;


public interface GloableInerface {
    String SERVERURL = "http://dt.kkeji.com/api/1/";
    String RECOMMENT = SERVERURL + "contents?article_type=%d&sign=-477263451&min_show_time=0&xaid=7b920b9704f24c3b&udid=5186261861683913428";
    String MOREPAGE = SERVERURL + "contents?article_type=%d&sign=-477263451&xaid=7b920b9704f24c3b&udid=5186261861683913428&max_show_time=%d";
    String DETAILURL = SERVERURL+"contents/details?sign=-477263451&nids=%d&xaid=7b920b9704f24c3b&udid=5186261861683913428";
}
