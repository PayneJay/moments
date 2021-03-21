package com.snail.base;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.view.View;

import androidx.databinding.BaseObservable;

public abstract class BaseViewModel extends BaseObservable implements IViewModel {
    private int mViewType = -1;
    private int itemPosition = -1;
    protected Context context;
    protected Handler mHandler;

    public BaseViewModel(Context context) {
        this.context = context;
        mHandler = new Handler(Looper.getMainLooper());
    }

    public int getViewType() {
        return mViewType;
    }

    public void setViewType(int mViewType) {
        this.mViewType = mViewType;
    }

    public int getItemPosition() {
        return itemPosition;
    }

    public void setItemPosition(int itemPosition) {
        this.itemPosition = itemPosition;
    }

    public final void onViewAttachedToWindow(View view) {
        onAttach();
    }

    @Override
    public void onAttach() {
    }

    @Override
    public void onDetach() {
        if (mHandler != null) {
            mHandler.removeCallbacks(null);
            mHandler = null;
        }
    }

    @Override
    public void onResume() {
    }

    @Override
    public void onPause() {
    }

    @Override
    public void onStop() {

    }

    @Override
    public void onNewIntent(Intent intent) {

    }

    @Override
    public void onVisible(boolean isVisibleToUser) {
    }

    @Override
    public boolean onKeyDown() {
        return false;
    }

    public final void onViewDetachedFromWindow(View view) {
        onDetach();
    }

}
