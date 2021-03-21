package com.snail.wechatmoments.viewmodel;

import android.content.Context;

import androidx.databinding.ObservableField;

import com.snail.base.BaseViewModel;
import com.snail.common.Constants;

/**
 * 回复评论ViewModel
 */
public class MomentReplyCommentViewModel extends BaseViewModel {
    public ObservableField<String> replyComment = new ObservableField<>("回复：你可真棒！");

    public MomentReplyCommentViewModel(Context context) {
        super(context);
        setViewType(Constants.RecyclerItemType.MOMENT_REPLY_COMMENT_ITEM_TYPE);
    }

    public void viewLargeImage() {
        Constants.showToast();
    }
}
