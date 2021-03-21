package com.snail.wechatmoments.model;

/**
 * 朋友圈数据实体类
 */
public class MomentBean {
    private String name;

    public MomentBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name == null ? "" : name;
    }
}
