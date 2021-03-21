package com.snail.wechatmoments.model;

import com.google.gson.annotations.SerializedName;
import com.snail.base.BaseBean;

public class ProfileBean extends BaseBean {

    /**
     * profile-image : http://img2.findthebest.com/sites/default/files/688/media/images/Mingle_159902_i0.png
     * avatar : http://info.thoughtworks.com/rs/thoughtworks2/images/glyph_badge.png
     * nick : John Smith
     * username : jsmith
     */

    @SerializedName("profile-image")
    private String profileimage;
    private String avatar;
    private String nick;
    private String username;

    public String getProfileimage() {
        return profileimage == null ? "" : profileimage;
    }

    public void setProfileimage(String profileimage) {
        this.profileimage = profileimage == null ? "" : profileimage;
    }

    public String getAvatar() {
        return avatar == null ? "" : avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? "" : avatar;
    }

    public String getNick() {
        return nick == null ? "" : nick;
    }

    public void setNick(String nick) {
        this.nick = nick == null ? "" : nick;
    }

    public String getUsername() {
        return username == null ? "" : username;
    }

    public void setUsername(String username) {
        this.username = username == null ? "" : username;
    }
}
