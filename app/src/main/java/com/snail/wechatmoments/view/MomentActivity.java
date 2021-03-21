package com.snail.wechatmoments.view;

import android.content.Intent;

import com.donkingliang.imageselector.utils.ImageSelector;
import com.snail.base.BaseActivity;
import com.snail.common.Constants;
import com.snail.wechatmoments.BR;
import com.snail.wechatmoments.R;
import com.snail.wechatmoments.viewmodel.MomentListViewModel;

import java.util.ArrayList;

/**
 * 盆友圈主页
 */
public class MomentActivity extends BaseActivity<MomentListViewModel> {
    private MomentListViewModel momentViewModel;

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        momentViewModel.onDetach();
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_moments_layout;
    }

    @Override
    protected MomentListViewModel getViewModel() {
        if (momentViewModel == null) {
            momentViewModel = new MomentListViewModel(this);
        }
        return momentViewModel;
    }

    @Override
    protected int getVariableID() {
        return BR.momentVM;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constants.REQUEST_CODE_CHOOSE && resultCode == RESULT_OK && data != null) {
            //获取选择器返回的数据
            ArrayList<String> images = data.getStringArrayListExtra(ImageSelector.SELECT_RESULT);
            momentViewModel.setSelected(images);

            /**
             * 是否是来自于相机拍照的图片，
             * 只有本次调用相机拍出来的照片，返回时才为true。
             * 当为true时，图片返回的结果有且只有一张图片。
             */
            boolean isCameraImage = data.getBooleanExtra(ImageSelector.IS_CAMERA_IMAGE, false);
        }
    }
}