package com.xxplay.pojo.base;

/**
 * 系统菜单
 * 
 * @Author:chenssy
 * @date:2016年4月9日
 */
public class Menu {
    private String id;

    private String menuCode;

    private String menuDesc;

    private String menuIsleaf;

    private String menuName;

    private Integer menuSeqno;

    private String menuParentid;

    private String menuStatus;

    private String menuUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode == null ? null : menuCode.trim();
    }

    public String getMenuDesc() {
        return menuDesc;
    }

    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc == null ? null : menuDesc.trim();
    }

    public String getMenuIsleaf() {
        return menuIsleaf;
    }

    public void setMenuIsleaf(String menuIsleaf) {
        this.menuIsleaf = menuIsleaf == null ? null : menuIsleaf.trim();
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public Integer getMenuSeqno() {
        return menuSeqno;
    }

    public void setMenuSeqno(Integer menuSeqno) {
        this.menuSeqno = menuSeqno == null ? null : menuSeqno;
    }

    public String getMenuParentid() {
        return menuParentid;
    }

    public void setMenuParentid(String menuParentid) {
        this.menuParentid = menuParentid == null ? null : menuParentid.trim();
    }

    public String getMenuStatus() {
        return menuStatus;
    }

    public void setMenuStatus(String menuStatus) {
        this.menuStatus = menuStatus == null ? null : menuStatus.trim();
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl == null ? null : menuUrl.trim();
    }
}