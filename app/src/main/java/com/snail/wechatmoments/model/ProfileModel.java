package com.snail.wechatmoments.model;

import com.google.gson.Gson;
import com.snail.common.network.NetworkCallback;
import com.snail.common.network.OkHttp;
import com.snail.wechatmoments.callback.IResponseCallback;

public class ProfileModel {
    private ProfileModel() {
    }

    private static ProfileModel sInstance;

    public static ProfileModel getInstance() {
        if (sInstance == null) {
            sInstance = new ProfileModel();
        }
        return sInstance;
    }

    /**
     * 获取Profile数据
     *
     * @param callback
     */
    public void getProfile(IResponseCallback callback) {
        OkHttp.getInstance().sendGetRequest("/user/jsmith", new NetworkCallback() {
            @Override
            public void onSuccess(String responseStr) {
                ProfileBean profileBean = new Gson().fromJson(responseStr, ProfileBean.class);
                if (callback != null) {
                    callback.onSuccess(profileBean);
                }
            }

            @Override
            public void onFailure(String msg) {
            }
        });
    }
}
