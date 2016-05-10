package com.xxplay.pojo.exportExcel;

import java.util.List;

public class GameInfoExcelModel {
	private String id;

	private String gameName;

	private String showGameName;
	
	private String keys;
	
	private String tabs;
	
	private String category;
	
	private String isOnline;
	
	private String gameDesc;
	
	private String picList;
	
	private String apkName;

	private List<String> picListPath;
	
	private String categoryTxt;
	
	private String isOnlineTxt;
	
	private String errorTips;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getShowGameName() {
		return showGameName;
	}

	public void setShowGameName(String showGameName) {
		this.showGameName = showGameName;
	}

	public String getKeys() {
		return keys;
	}

	public void setKeys(String keys) {
		this.keys = keys;
	}

	public String getTabs() {
		return tabs;
	}

	public void setTabs(String tabs) {
		this.tabs = tabs;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(String isOnline) {
		this.isOnline = isOnline;
	}

	public String getGameDesc() {
		return gameDesc;
	}

	public void setGameDesc(String gameDesc) {
		this.gameDesc = gameDesc;
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

	public List<String> getPicListPath() {
		return picListPath;
	}

	public void setPicListPath(List<String> picListPath) {
		this.picListPath = picListPath;
	}

	public String getCategoryTxt() {
		return categoryTxt;
	}

	public void setCategoryTxt(String categoryTxt) {
		this.categoryTxt = categoryTxt;
	}

	public String getIsOnlineTxt() {
		return isOnlineTxt;
	}

	public void setIsOnlineTxt(String isOnlineTxt) {
		this.isOnlineTxt = isOnlineTxt;
	}

	public String getErrorTips() {
		return errorTips;
	}

	public void setErrorTips(String errorTips) {
		this.errorTips = errorTips;
	}
}
