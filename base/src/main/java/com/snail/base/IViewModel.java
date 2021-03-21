package com.snail.base;

import android.content.Intent;

public interface IViewModel {
    void onAttach();

    void onDetach();

    void onResume();

    void onPause();

    void onStop();

    void onNewIntent(Intent intent);

    void onVisible(boolean isVisibleToUser);

    boolean onKeyDown();
}
