package com.snail.wechatmoments.viewmodel;

import android.content.Context;

import androidx.databinding.ObservableBoolean;

import com.snail.base.BaseViewModel;
import com.snail.wechatmoments.R;

public class RefreshListViewModel extends BaseViewModel {
    public ObservableBoolean refreshing = new ObservableBoolean();

    public RefreshListViewModel(Context context) {
        super(context);
    }

    /**
     * 配置下拉刷新颜色
     *
     * @return
     */
    public int[] getColors() {
        return new int[]{R.color.purple_200, R.color.purple_700, R.color.teal_200};
    }

    /**
     * 请求服务器
     */
    protected void requestServer() {
    }

    /**
     * 创建ViewModel
     */
    protected void createViewModel() {
    }
}
