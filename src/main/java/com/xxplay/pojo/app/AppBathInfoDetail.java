package com.xxplay.pojo.app;

public class AppBathInfoDetail {
    private Integer id;

    private Integer infoid;

    private String appName;

    private String showName;

    private String searchKeys;

    private String apptag;

    private String appType;

    private String isOnline;

    private String picList;

    private String apkName;

    private String appdesc;

    private Integer evilLevel;

    private String recommFlag;

    private Integer recommLevel;

    private String recommWord;
    
    private String status;
    
    private String errorTips;

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

    public String getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(String isOnline) {
        this.isOnline = isOnline == null ? null : isOnline.trim();
    }

    public String getPicList() {
		return picList;
	}

	public void setPicList(String picList) {
		this.picList = picList;
	}

	public String getApkName() {
		return apkName;
	}

	public void setApkName(String apkName) {
		this.apkName = apkName;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorTips() {
		return errorTips;
	}

	public void setErrorTips(String errorTips) {
		this.errorTips = errorTips;
	}
}