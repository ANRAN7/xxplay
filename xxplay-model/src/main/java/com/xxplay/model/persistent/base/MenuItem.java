package com.xxplay.model.persistent.base;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单集合
 * 
 * @Author:chenssy
 * @date:2016年4月10日
 * 
 */
public class MenuItem {
    private String id;

    private String menuCode;

    private String menuDesc;

    private String menuIsleaf;

    private String menuName;

    private String menuSeqno;

    private String menuParentid;

    private String menuStatus;

    private String menuUrl;
    
    private List<MenuItem> childList;
    
    /**
     * 增加子菜单  
     *
     * @param menuItem
     *
     * @author:chenssy
     * @date : 2016年4月10日
     */
    public void addMenu(MenuItem menuItem){
    	if(childList == null){
    		childList = new ArrayList<MenuItem>();
    	}
    	childList.add(menuItem);
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public String getMenuDesc() {
		return menuDesc;
	}

	public void setMenuDesc(String menuDesc) {
		this.menuDesc = menuDesc;
	}

	public String getMenuIsleaf() {
		return menuIsleaf;
	}

	public void setMenuIsleaf(String menuIsleaf) {
		this.menuIsleaf = menuIsleaf;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuSeqno() {
		return menuSeqno;
	}

	public void setMenuSeqno(String menuSeqno) {
		this.menuSeqno = menuSeqno;
	}

	public String getMenuParentid() {
		return menuParentid;
	}

	public void setMenuParentid(String menuParentid) {
		this.menuParentid = menuParentid;
	}

	public String getMenuStatus() {
		return menuStatus;
	}

	public void setMenuStatus(String menuStatus) {
		this.menuStatus = menuStatus;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public List<MenuItem> getChildList() {
		return childList;
	}

	public void setChildList(List<MenuItem> childList) {
		this.childList = childList;
	}
}
