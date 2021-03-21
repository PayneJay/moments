package com.snail.wechatmoments.viewmodel;

import android.content.Context;

import androidx.databinding.ObservableField;

import com.snail.base.BaseViewModel;
import com.snail.common.Constants;

/**
 * 照片九宫格ViewModel
 */
public class MomentImageViewModel extends BaseViewModel {
    public ObservableField<String> thumbnailUrl = new ObservableField<>("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2Fa%2F59bb6e64148ac.jpg%3Fdown&refer=http%3A%2F%2Fpic1.win4000.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1618897034&t=91160ec73de596be3529da0b9a5626d1");

    public MomentImageViewModel(Context context) {
        super(context);
        setViewType(Constants.RecyclerItemType.MOMENT_IMAGE_ITEM_TYPE);
    }

    public void viewLargeImage() {
        Constants.showToast();
    }
}
