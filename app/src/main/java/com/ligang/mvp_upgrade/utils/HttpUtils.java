package com.ligang.mvp_upgrade.utils;

import android.os.Handler;
import android.os.Looper;

import com.ligang.mvp_upgrade.model.RecommentModel;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 作者: 李刚 on 2016/8/28 11:14.
 * 邮箱: kylin_javac@outlook.com
 * 描述:
 */
public class HttpUtils {
    private static OkHttpClient okHttpClient=new OkHttpClient();
    private static Handler handler=new Handler(Looper.getMainLooper());
    public static  void  getLoadData(final String path, final RecommentModel.OncompletedLoad oncompletedLoad){
        Request.Builder builder=new Request.Builder().get().url(path);
        Request request = builder.build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    final byte[] bytes = response.body().bytes();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            oncompletedLoad.onCompleted(bytes,path);
                        }
                    });

                }
            }
        });

    }

}
