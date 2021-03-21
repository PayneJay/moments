package com.snail.wechatmoments.viewmodel;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.donkingliang.imageselector.utils.ImageSelector;
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
public class MomentListViewModel extends RefreshListViewModel implements View.OnClickListener {
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
    private Dialog mCameraDialog;
    //已选的图片
    private ArrayList<String> selected;

    public MomentListViewModel(Context context) {
        super(context);
        requestServer();
    }

    public ArrayList<String> getSelected() {
        if (selected == null) {
            return new ArrayList<>();
        }
        return selected;
    }

    public void setSelected(ArrayList<String> selected) {
        this.selected = selected;
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
        if (mCameraDialog == null) {
            mCameraDialog = new Dialog(context, R.style.BottomDialog);
        }
        LinearLayout root = (LinearLayout) LayoutInflater.from(context).inflate(
                R.layout.bottom_dialog, null);
        //初始化视图
        root.findViewById(R.id.btn_choose_img).setOnClickListener(this);
        root.findViewById(R.id.btn_open_camera).setOnClickListener(this);
        root.findViewById(R.id.btn_cancel).setOnClickListener(this);
        mCameraDialog.setContentView(root);
        Window dialogWindow = mCameraDialog.getWindow();
        dialogWindow.setGravity(Gravity.BOTTOM);
        WindowManager.LayoutParams lp = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        lp.x = 0; // 新位置X坐标
        lp.y = 0; // 新位置Y坐标
        lp.width = (int) context.getResources().getDisplayMetrics().widthPixels; // 宽度
        root.measure(0, 0);
        lp.height = root.getMeasuredHeight();

        lp.alpha = 9f; // 透明度
        dialogWindow.setAttributes(lp);
        mCameraDialog.show();
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

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_choose_img:
                //限数量的多选(比如最多9张)
                ImageSelector.builder()
                        .useCamera(true) // 设置是否使用拍照
                        .setSingle(false)  //设置是否单选
                        .setMaxSelectCount(9) // 图片的最大选择数量，小于等于0时，不限数量。
                        .setSelected(selected) // 把已选的图片传入默认选中。
                        .canPreview(true) //是否可以预览图片，默认为true
                        .start((Activity) context, Constants.REQUEST_CODE_CHOOSE); // 打开相册

                break;
            case R.id.btn_open_camera:
                //仅拍照
                ImageSelector.builder()
                        .onlyTakePhoto(true)  // 仅拍照，不打开相册
                        .start((Activity) context, Constants.REQUEST_CODE_CHOOSE);
                break;
            case R.id.btn_cancel:
                break;
        }
        mCameraDialog.dismiss();
    }
}
