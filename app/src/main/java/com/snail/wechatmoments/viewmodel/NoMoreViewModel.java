package com.snail.wechatmoments.viewmodel;

import android.content.Context;

import androidx.databinding.ObservableField;

import com.snail.base.BaseViewModel;
import com.snail.common.Constants;
import com.snail.common.utils.ResourceUtil;
import com.snail.wechatmoments.R;

/**
 * 通用没有更多ViewModel
 */
public class NoMoreViewModel extends BaseViewModel {
    public ObservableField<String> desc = new ObservableField<>();

    public NoMoreViewModel(Context context) {
        super(context);
        setViewType(Constants.RecyclerItemType.NO_MORE_ITEM_TYPE);
        desc.set(ResourceUtil.getString(R.string.no_more_data));
    }
}
