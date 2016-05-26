package com.xxplay.model.persistent.app;

public class AppPicList {
    private Integer id;

    private Integer orderNo;

    private String picurl;

    private Integer appinfoId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl == null ? null : picurl.trim();
    }

    public Integer getAppinfoId() {
        return appinfoId;
    }

    public void setAppinfoId(Integer appinfoId) {
        this.appinfoId = appinfoId;
    }
}