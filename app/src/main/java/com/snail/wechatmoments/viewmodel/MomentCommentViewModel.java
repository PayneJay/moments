package com.snail.wechatmoments.viewmodel;

import android.content.Context;

import androidx.databinding.ObservableField;

import com.snail.base.BaseViewModel;
import com.snail.common.Constants;

/**
 * 评论ViewModel
 */
public class MomentCommentViewModel extends BaseViewModel {
    public ObservableField<String> sender = new ObservableField<>("张三");
    public ObservableField<String> content = new ObservableField<>("：Unlike many proprietary big data processing platform different," +
            " Spark is built on a unified abstract RDD, making it possible to deal with different ways consistent with large data processing scenarios," +
            " including MapReduce, Streaming, SQL, Machine Learning and Graph so on. To understand the Spark, you have to understand the RDD. ");

    public MomentCommentViewModel(Context context) {
        super(context);
        setViewType(Constants.RecyclerItemType.MOMENT_COMMENT_ITEM_TYPE);
    }

    public void viewSender() {
        Constants.showToast();
    }

}
