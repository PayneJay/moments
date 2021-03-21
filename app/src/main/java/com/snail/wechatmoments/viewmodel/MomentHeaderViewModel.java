package com.snail.wechatmoments.viewmodel;

import android.content.Context;

import androidx.databinding.ObservableField;

import com.snail.base.BaseViewModel;
import com.snail.common.Constants;

/**
 * 朋友圈头部ViewModel
 */
public class MomentHeaderViewModel extends BaseViewModel {
    public ObservableField<String> bgImgUrl = new ObservableField<>("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fb.zol-img.com.cn%2Fdesk%2Fbizhi%2Fimage%2F1%2F1680x1050%2F1349289433496.jpg&refer=http%3A%2F%2Fb.zol-img.com.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1618760309&t=7c996bce70aafc3ee71177ccae71c515");
    public ObservableField<String> headImgUrl = new ObservableField<>("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=178721898,4183522783&fm=26&gp=0.jpg");
    public ObservableField<String> name = new ObservableField<>("ThoughtWorks");

    public MomentHeaderViewModel(Context context) {
        super(context);
        setViewType(Constants.RecyclerItemType.MOMENT_HEADER_ITEM_TYPE);
    }
}
