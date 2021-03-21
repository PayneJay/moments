package com.snail.wechatmoments.view;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.Nullable;

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
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        setTransparentForWindow(this);
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

    public void setTransparentForWindow(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
        } else {
            activity.getWindow()
                    .setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
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