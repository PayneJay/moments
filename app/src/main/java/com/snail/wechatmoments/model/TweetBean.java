package com.snail.wechatmoments.model;

import com.snail.base.BaseBean;

import java.util.ArrayList;
import java.util.List;

public class TweetBean extends BaseBean {
    private List<MomentBean> tweets;
    private ProfileBean profile;

    public List<MomentBean> getTweets() {
        if (tweets == null) {
            return new ArrayList<>();
        }
        return tweets;
    }

    public void setTweets(List<MomentBean> tweets) {
        this.tweets = tweets;
    }

    public ProfileBean getProfile() {
        return profile;
    }

    public void setProfile(ProfileBean profile) {
        this.profile = profile;
    }
}
