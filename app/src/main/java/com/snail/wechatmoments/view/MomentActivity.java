package com.snail.wechatmoments.view;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;

import com.snail.base.BaseActivity;
import com.snail.wechatmoments.BR;
import com.snail.wechatmoments.R;
import com.snail.wechatmoments.viewmodel.MomentListViewModel;

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
}