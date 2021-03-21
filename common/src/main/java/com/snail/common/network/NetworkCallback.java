package com.snail.common.network;


public interface NetworkCallback {

    void onSuccess(String responseStr);

    void onFailure(String msg);

}
