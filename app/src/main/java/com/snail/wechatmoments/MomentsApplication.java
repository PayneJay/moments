package com.snail.wechatmoments;

import com.snail.base.BaseApplication;
import com.snail.common.Constants;

public class MomentsApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        Constants.sApplication = this;
    }
}
