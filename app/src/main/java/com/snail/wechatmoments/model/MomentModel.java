package com.snail.wechatmoments.model;

import com.google.gson.Gson;
import com.snail.common.network.NetworkCallback;
import com.snail.common.network.OkHttp;
import com.snail.wechatmoments.callback.IResponseCallback;

import java.util.Arrays;
import java.util.List;

public class MomentModel {
    private MomentModel() {
    }

    private static MomentModel sInstance;

    public static MomentModel getInstance() {
        if (sInstance == null) {
            sInstance = new MomentModel();
        }
        return sInstance;
    }

    /**
     * 获取tweet列表数据
     *
     * @param callback
     */
    public void getTweets(IResponseCallback callback) {
        OkHttp.getInstance().sendGetRequest("/user/jsmith/tweets", new NetworkCallback() {
            @Override
            public void onSuccess(String responseStr) {
                MomentBean[] array = new Gson().fromJson(responseStr, MomentBean[].class);
                List<MomentBean> list = Arrays.asList(array);
                if (callback != null) {
                    callback.onSuccess(list);
                }
            }

            @Override
            public void onFailure(String msg) {

            }
        });
    }
}
