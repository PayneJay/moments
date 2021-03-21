package com.snail.common;

import android.app.Application;

import com.snail.common.utils.ResourceUtil;
import com.snail.common.utils.ToastUtil;


public class Constants {
    public static final int REQUEST_CODE_CHOOSE = 200;
    public static Application sApplication;

    public static final String TAG = "***com.minerva***";

    public static void showToast() {
        ToastUtil.showMsg(ResourceUtil.getString(R.string.toast_engineer_struggling_to_developing));
    }

    public interface RecyclerItemType {
        int BLANK_TYPE = 0; //空白item
        int MOMENT_COMMON_ITEM_TYPE = 1;    //朋友圈列表item
        int MOMENT_HEADER_ITEM_TYPE = 3;   //朋友圈头部item
        int NO_MORE_ITEM_TYPE = 12;   //没有更多item
    }

    public interface BitmapTransform {
        int CIRCLE = 100;//圆形图片

        int ROUNDED = 200;//圆角图片

    }

    public interface PageStatus {
        int NO_DATA = 100;    //无数据

        int NETWORK_EXCEPTION = 200;//网络异常

    }

}
