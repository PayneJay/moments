package com.snail.wechatmoments.viewmodel;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.recyclerview.widget.GridLayoutManager;

import com.snail.base.BaseViewModel;
import com.snail.common.Constants;
import com.snail.wechatmoments.BR;
import com.snail.wechatmoments.R;

import java.util.List;

import me.tatarka.bindingcollectionadapter2.OnItemBind;

/**
 * 盆友圈列表每一项ViewModel
 */
public class MomentItemViewModel extends BaseViewModel {
    //名字
    public ObservableField<String> name = new ObservableField<>("张三");
    //头像
    public ObservableField<String> headUrl = new ObservableField<>("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fpic1.zhimg.com%2F50%2Fv2-ec4d5ace8b6f8a9cce99a5632323450a_hd.jpg&refer=http%3A%2F%2Fpic1.zhimg.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1618900321&t=90517c80580cbbbd622d70b0bda34554");
    //文本内容
    public ObservableField<String> contentDesc = new ObservableField<>("大江东去，浪淘尽，千古风流人物。\n" +
            "故垒西边，人道是，三国周郎赤壁。\n" +
            "乱石穿空，惊涛拍岸，卷起千堆雪。\n" +
            "江山如画，一时多少豪杰。\n" +
            "遥想公瑾当年，小乔初嫁了，雄姿英发。\n" +
            "羽扇纶巾，谈笑间，樯橹灰飞烟灭。\n" +
            "故国神游，多情应笑我，早生华发。");
    //地点
    public ObservableField<String> location = new ObservableField<>("北京·天安门");
    //时间
    public ObservableField<String> date = new ObservableField<>("2小时前");
    //图片内容
    public ObservableList<BaseViewModel> imageItems = new ObservableArrayList<>();
    public OnItemBind<BaseViewModel> momentImageBind = (itemBinding, position, item) -> {
        setItemPosition(position);
        if (item.getViewType() == Constants.RecyclerItemType.MOMENT_IMAGE_ITEM_TYPE) {
            itemBinding.set(BR.momentImageVM, R.layout.item_moment_image_layout);
        }
    };

    //评论和点赞内容
    public ObservableList<BaseViewModel> commentItems = new ObservableArrayList<>();
    public OnItemBind<BaseViewModel> momentCommentBind = (itemBinding, position, item) -> {
        setItemPosition(position);
        switch (item.getViewType()) {
            case Constants.RecyclerItemType.MOMENT_LIKE_ITEM_TYPE:
                itemBinding.set(BR.likeVM, R.layout.item_moment_like_layout);
                break;
            case Constants.RecyclerItemType.MOMENT_COMMENT_ITEM_TYPE:
                itemBinding.set(BR.commentVM, R.layout.item_moment_comment_layout);
                break;
            case Constants.RecyclerItemType.MOMENT_REPLY_COMMENT_ITEM_TYPE:
                itemBinding.set(BR.commentReplyVM, R.layout.item_moment_reply_comment_layout);
                break;
        }
    };

    public MomentItemViewModel(Context context, List<String> images) {
        super(context);
        setViewType(Constants.RecyclerItemType.MOMENT_COMMON_ITEM_TYPE);
        setImages(images);
        setComments();
    }

    private void setComments() {
        for (int i = 0; i < 3; i++) {
            commentItems.add(new MomentCommentViewModel(context));
        }
    }

    private void setImages(List<String> images) {
        for (String imgUrl : images) {
            if (!TextUtils.isEmpty(imgUrl)) {
                MomentImageViewModel imageViewModel = new MomentImageViewModel(context);
                imageViewModel.thumbnailUrl.set(imgUrl);
                this.imageItems.add(imageViewModel);
            }
        }
    }

    public GridLayoutManager getGlManager() {
        return new GridLayoutManager(context, getSpanCount());
    }

    private int getSpanCount() {
        int size = imageItems.size();
        if (size == 4) {
            return 2;
        } else {
            return 3;
        }
    }

    /**
     * 更多操作
     */
    public void optionMore() {
    }

    public void clickHead() {
    }
}
