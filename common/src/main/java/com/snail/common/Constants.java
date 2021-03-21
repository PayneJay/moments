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
        /**
         * 空白item
         */
        int BLANK_TYPE = 0;
        /**
         * 朋友圈列表item
         */
        int MOMENT_COMMON_ITEM_TYPE = 1;
        /**
         * 朋友圈头部item
         */
        int MOMENT_HEADER_ITEM_TYPE = 3;
        /**
         * 朋友圈照片item
         */
        int MOMENT_IMAGE_ITEM_TYPE = 4;
        /**
         * 朋友圈点赞item
         */
        int MOMENT_LIKE_ITEM_TYPE = 5;
        /**
         * 朋友圈评论item
         */
        int MOMENT_COMMENT_ITEM_TYPE = 6;
        /**
         * 朋友圈回复评论item
         */
        int MOMENT_REPLY_COMMENT_ITEM_TYPE = 7;
        /**
         * 没有更多item
         */
        int NO_MORE_ITEM_TYPE = -1;
    }

    public interface BitmapTransform {
        int CIRCLE = 100;//圆形图片

        int ROUNDED = 200;//圆角图片

    }

    public interface PageStatus {
        int NO_DATA = 404;    //无数据

        int NETWORK_EXCEPTION = 500;//网络异常

    }

}
