package com.xxplay.pojo.base;

/**
 * 系统错误码
 * 
 * @file:PubError.java
 * @package_name:com.xxplay.pojo.base
 * @Project:xxplay
 *
 * @Author:陈明
 * @Copyright 陈明   2016 All Rights Reserved.
 * 
 * @data:2016年4月9日
 */
public class PubError {
    private String id;

    private String code;

    private String showmsg;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getShowmsg() {
        return showmsg;
    }

    public void setShowmsg(String showmsg) {
        this.showmsg = showmsg == null ? null : showmsg.trim();
    }
}