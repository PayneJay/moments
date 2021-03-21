package com.snail.base;

public interface MvvmComponent<T extends BaseViewModel> {

    int getLayoutResID();

    T getViewModel();

    int getVariableID();
}