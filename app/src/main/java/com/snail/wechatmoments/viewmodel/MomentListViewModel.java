package com.snail.wechatmoments.viewmodel;

import android.content.Context;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.databinding.ObservableList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.snail.base.BaseActivity;
import com.snail.base.BaseViewModel;
import com.snail.common.Constants;
import com.snail.common.utils.ResourceUtil;
import com.snail.wechatmoments.BR;
import com.snail.wechatmoments.R;
import com.snail.wechatmoments.model.MomentBean;

import java.util.ArrayList;
import java.util.List;

import me.tatarka.bindingcollectionadapter2.OnItemBind;

/**
 * 朋友圈列表ViewModel
 */
public class MomentListViewModel extends RefreshListViewModel {
    public ObservableField<String> title = new ObservableField<>();
    public ObservableBoolean firstItemVisible = new ObservableBoolean(true);
    public RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            int position = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
            setItemPosition(position);
            if (position > 0) {
                title.set(ResourceUtil.getString(R.string.moments));
                firstItemVisible.set(false);
            } else {
                title.set("");
                firstItemVisible.set(true);
            }
        }
    };

    public ObservableList<BaseViewModel> items = new ObservableArrayList<>();
    public OnItemBind<BaseViewModel> momentItemBind = (itemBinding, position, item) -> {
        switch (item.getViewType()) {
            case Constants.RecyclerItemType.MOMENT_COMMON_ITEM_TYPE:
                itemBinding.set(BR.momentItemVM, R.layout.item_moment_layout);
                break;
            case Constants.RecyclerItemType.MOMENT_HEADER_ITEM_TYPE:
                itemBinding.set(BR.headerVM, R.layout.item_moment_header_layout);
                break;
            case Constants.RecyclerItemType.NO_MORE_ITEM_TYPE:
                itemBinding.set(BR.noMoreVM, R.layout.item_no_more_layout);
                break;
            case Constants.RecyclerItemType.BLANK_TYPE:
                itemBinding.set(BR.vmBlank, R.layout.item_blank_layout);
                break;
        }
    };

    private final List<MomentBean> mData = new ArrayList<>();

    public SwipeRefreshLayout.OnRefreshListener onRefreshListener = () -> {
        refreshing.set(true);
        requestServer();
    };

    public MomentListViewModel(Context context) {
        super(context);
        requestServer();
    }

    /**
     * 返回
     */
    public void goBack() {
        ((BaseActivity) context).finish();
    }

    /**
     * 拍照发朋友圈
     */
    public void takePhoto() {

    }

    /**
     * 加载更多
     */
    public void loadMore() {
        requestServer();
    }

    @Override
    protected void createViewModel() {
        super.createViewModel();

        if (items.isEmpty()) {
            MomentHeaderViewModel headerViewModel = new MomentHeaderViewModel(context);
            items.add(headerViewModel);
        }
        for (MomentBean momentBean : mData) {
            if (momentBean != null) {
                MomentItemViewModel itemViewModel = new MomentItemViewModel(context);
                itemViewModel.content.set(momentBean.getName());
                items.add(itemViewModel);
            }
        }
    }

    @Override
    protected void requestServer() {
        super.requestServer();

        for (int i = 0; i < 10; i++) {
            mData.add(new MomentBean("这是第" + (mData.size() + 1) + "个条目"));
        }
        refreshing.set(false);
        createViewModel();
    }
}
