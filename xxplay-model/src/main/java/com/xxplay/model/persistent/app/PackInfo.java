package com.xxplay.model.persistent.app;

import java.util.Date;

public class PackInfo {
    private String packid;

    private String appinfoId;

    private String isMainver;

    private String showName;

    private String issueFlag;

    private String gainsType;

    private Integer downTimes;

    private Integer downTimesreal;

    private Integer commentTimes;

    private Integer commentScore;

    private String iconPicurl;

    private String packFrom;

    private Integer packSize;

    private Integer verCode;

    private String verName;

    private String signCode;

    private String packUrl;

    private String packMd5;

    private String compDesc;

    private String updateDesc;

    private String remarks;

    private String packUrl2;

    private String dpi;

    private String qrcodeUrl;

    private String hasad;

    private String platForm;

    private String partPackMd5;

    private Date createTime;

    private Date updateTime;

    private String status;
    
    private String packageName;
    
    //icon图片临时保存路径
    private String iconTempUrl;

    public String getPackid() {
        return packid;
    }

    public void setPackid(String packid) {
        this.packid = packid == null ? null : packid.trim();
    }

    public String getAppinfoId() {
        return appinfoId;
    }

    public void setAppinfoId(String appinfoId) {
        this.appinfoId = appinfoId == null ? null : appinfoId.trim();
    }

    public String getIsMainver() {
        return isMainver;
    }

    public void setIsMainver(String isMainver) {
        this.isMainver = isMainver == null ? null : isMainver.trim();
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName == null ? null : showName.trim();
    }

    public String getIssueFlag() {
        return issueFlag;
    }

    public void setIssueFlag(String issueFlag) {
        this.issueFlag = issueFlag == null ? null : issueFlag.trim();
    }

    public String getGainsType() {
        return gainsType;
    }

    public void setGainsType(String gainsType) {
        this.gainsType = gainsType == null ? null : gainsType.trim();
    }

    public Integer getDownTimes() {
        return downTimes;
    }

    public void setDownTimes(Integer downTimes) {
        this.downTimes = downTimes;
    }

    public Integer getDownTimesreal() {
        return downTimesreal;
    }

    public void setDownTimesreal(Integer downTimesreal) {
        this.downTimesreal = downTimesreal;
    }

    public Integer getCommentTimes() {
        return commentTimes;
    }

    public void setCommentTimes(Integer commentTimes) {
        this.commentTimes = commentTimes;
    }

    public Integer getCommentScore() {
        return commentScore;
    }

    public void setCommentScore(Integer commentScore) {
        this.commentScore = commentScore;
    }

    public String getIconPicurl() {
        return iconPicurl;
    }

    public void setIconPicurl(String iconPicurl) {
        this.iconPicurl = iconPicurl == null ? null : iconPicurl.trim();
    }

    public String getPackFrom() {
        return packFrom;
    }

    public void setPackFrom(String packFrom) {
        this.packFrom = packFrom == null ? null : packFrom.trim();
    }

    public Integer getPackSize() {
        return packSize;
    }

    public void setPackSize(Integer packSize) {
        this.packSize = packSize;
    }

    public Integer getVerCode() {
        return verCode;
    }

    public void setVerCode(Integer verCode) {
        this.verCode = verCode;
    }

    public String getVerName() {
        return verName;
    }

    public void setVerName(String verName) {
        this.verName = verName == null ? null : verName.trim();
    }

    public String getSignCode() {
        return signCode;
    }

    public void setSignCode(String signCode) {
        this.signCode = signCode == null ? null : signCode.trim();
    }

    public String getPackUrl() {
        return packUrl;
    }

    public void setPackUrl(String packUrl) {
        this.packUrl = packUrl == null ? null : packUrl.trim();
    }

    public String getPackMd5() {
        return packMd5;
    }

    public void setPackMd5(String packMd5) {
        this.packMd5 = packMd5 == null ? null : packMd5.trim();
    }

    public String getCompDesc() {
        return compDesc;
    }

    public void setCompDesc(String compDesc) {
        this.compDesc = compDesc == null ? null : compDesc.trim();
    }

    public String getUpdateDesc() {
        return updateDesc;
    }

    public void setUpdateDesc(String updateDesc) {
        this.updateDesc = updateDesc == null ? null : updateDesc.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getPackUrl2() {
        return packUrl2;
    }

    public void setPackUrl2(String packUrl2) {
        this.packUrl2 = packUrl2 == null ? null : packUrl2.trim();
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi == null ? null : dpi.trim();
    }

    public String getQrcodeUrl() {
        return qrcodeUrl;
    }

    public void setQrcodeUrl(String qrcodeUrl) {
        this.qrcodeUrl = qrcodeUrl == null ? null : qrcodeUrl.trim();
    }

    public String getHasad() {
        return hasad;
    }

    public void setHasad(String hasad) {
        this.hasad = hasad == null ? null : hasad.trim();
    }

    public String getPlatForm() {
        return platForm;
    }

    public void setPlatForm(String platForm) {
        this.platForm = platForm == null ? null : platForm.trim();
    }

    public String getPartPackMd5() {
        return partPackMd5;
    }

    public void setPartPackMd5(String partPackMd5) {
        this.partPackMd5 = partPackMd5 == null ? null : partPackMd5.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getIconTempUrl() {
		return iconTempUrl;
	}

	public void setIconTempUrl(String iconTempUrl) {
		this.iconTempUrl = iconTempUrl;
	}
}