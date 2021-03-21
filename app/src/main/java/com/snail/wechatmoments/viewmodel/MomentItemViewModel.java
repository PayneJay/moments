package com.snail.wechatmoments.viewmodel;

import android.content.Context;

import androidx.databinding.ObservableField;

import com.snail.base.BaseViewModel;
import com.snail.common.Constants;

/**
 * 盆友圈列表每一项ViewModel
 */
public class MomentItemViewModel extends BaseViewModel {
    public ObservableField<String> content = new ObservableField<>();

    public MomentItemViewModel(Context context) {
        super(context);
        setViewType(Constants.RecyclerItemType.MOMENT_COMMON_ITEM_TYPE);
    }
}
