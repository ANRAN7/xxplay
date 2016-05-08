package com.xxplay.pojo.app;

import org.apache.commons.lang3.StringUtils;

import com.xxplay.core.base.AppContextUtils;

public class AppType {
    private Integer typeId;

    private String typeClass;

    private String typeName;

    private String typeIconurl;

    private String typeStatus;
    
    private String typeStatusTxt;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeClass() {
        return typeClass;
    }

    public void setTypeClass(String typeClass) {
        this.typeClass = typeClass == null ? null : typeClass.trim();
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public String getTypeIconurl() {
        return typeIconurl;
    }

    public void setTypeIconurl(String typeIconurl) {
        this.typeIconurl = typeIconurl == null ? null : typeIconurl.trim();
    }

    public String getTypeStatus() {
        return typeStatus;
    }

    public void setTypeStatus(String typeStatus) {
        this.typeStatus = typeStatus == null ? null : typeStatus.trim();
    }

	public String getTypeStatusTxt() {
		if (StringUtils.isNotBlank(typeStatus)) {
			this.typeStatusTxt = AppContextUtils.getSysAprName("GAME_CATEGORY_STATU", typeStatus);
		}
		return typeStatusTxt;
	}
}