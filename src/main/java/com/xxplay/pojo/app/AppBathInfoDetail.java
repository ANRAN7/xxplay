package com.xxplay.pojo.app;

public class AppBathInfoDetail {
    private Integer id;

    private Integer infoid;

    private String appName;

    private String showName;

    private String searchKeys;

    private String apptag;

    private String appType;

    private String isonline;

    private String piclist;

    private String pakName;

    private String appdesc;

    private Integer evilLevel;

    private String recommFlag;

    private Integer recommLevel;

    private String recommWord;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInfoid() {
        return infoid;
    }

    public void setInfoid(Integer infoid) {
        this.infoid = infoid;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName == null ? null : showName.trim();
    }

    public String getSearchKeys() {
        return searchKeys;
    }

    public void setSearchKeys(String searchKeys) {
        this.searchKeys = searchKeys == null ? null : searchKeys.trim();
    }

    public String getApptag() {
        return apptag;
    }

    public void setApptag(String apptag) {
        this.apptag = apptag == null ? null : apptag.trim();
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType == null ? null : appType.trim();
    }

    public String getIsonline() {
        return isonline;
    }

    public void setIsonline(String isonline) {
        this.isonline = isonline == null ? null : isonline.trim();
    }

    public String getPiclist() {
        return piclist;
    }

    public void setPiclist(String piclist) {
        this.piclist = piclist == null ? null : piclist.trim();
    }

    public String getPakName() {
        return pakName;
    }

    public void setPakName(String pakName) {
        this.pakName = pakName == null ? null : pakName.trim();
    }

    public String getAppdesc() {
        return appdesc;
    }

    public void setAppdesc(String appdesc) {
        this.appdesc = appdesc == null ? null : appdesc.trim();
    }

    public Integer getEvilLevel() {
        return evilLevel;
    }

    public void setEvilLevel(Integer evilLevel) {
        this.evilLevel = evilLevel;
    }

    public String getRecommFlag() {
        return recommFlag;
    }

    public void setRecommFlag(String recommFlag) {
        this.recommFlag = recommFlag == null ? null : recommFlag.trim();
    }

    public Integer getRecommLevel() {
        return recommLevel;
    }

    public void setRecommLevel(Integer recommLevel) {
        this.recommLevel = recommLevel;
    }

    public String getRecommWord() {
        return recommWord;
    }

    public void setRecommWord(String recommWord) {
        this.recommWord = recommWord == null ? null : recommWord.trim();
    }
}