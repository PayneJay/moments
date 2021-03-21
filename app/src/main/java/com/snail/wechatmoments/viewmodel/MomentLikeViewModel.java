package com.snail.wechatmoments.viewmodel;

import android.content.Context;

import androidx.databinding.ObservableField;

import com.snail.base.BaseViewModel;
import com.snail.common.Constants;

/**
 * 点赞ViewModel
 */
public class MomentLikeViewModel extends BaseViewModel {
    public ObservableField<String> whoLike = new ObservableField<>("张三");

    public MomentLikeViewModel(Context context) {
        super(context);
        setViewType(Constants.RecyclerItemType.MOMENT_LIKE_ITEM_TYPE);
    }

}
