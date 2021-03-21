package com.snail.common.utils;

import android.widget.Toast;

import com.snail.common.Constants;


public class ToastUtil {
    public static void showMsg(String text) {
        Toast.makeText(Constants.sApplication, text, Toast.LENGTH_SHORT).show();
    }
}
