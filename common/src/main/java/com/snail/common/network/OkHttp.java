package com.snail.common.network;

import android.util.Log;

import com.snail.common.Constants;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class OkHttp {
    private static final String TAG = "*******okhttp*****";
    private static OkHttp sInstance;
    private final OkHttpClient okHttpClient;

    private OkHttp() {
        okHttpClient = new OkHttpClient();
    }

    public void sendGetRequest(String url, NetworkCallback callback) {
        final Request request = new Request.Builder()
                .addHeader("Content-Type", "application/json; charset=utf-8")
                .url(Constants.HOST + url)
                .get()//默认就是GET请求，可以不写
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure: ");
                if (callback != null) {
                    callback.onFailure(e.getMessage());
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                ResponseBody body = response.body();
                if (callback != null && body != null) {
                    String json = body.string();
                    Log.d(TAG, "onResponse: " + json);
                    callback.onSuccess(json);
                }
            }
        });
    }

    public static OkHttp getInstance() {
        if (sInstance == null) {
            sInstance = new OkHttp();
        }
        return sInstance;
    }

}
