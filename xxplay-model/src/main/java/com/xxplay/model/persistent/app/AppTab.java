package com.xxplay.model.persistent.app;

public class AppTab {
    private Integer id;

    private String tabName;

    private String tabStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName == null ? null : tabName.trim();
    }

    public String getTabStatus() {
        return tabStatus;
    }

    public void setTabStatus(String tabStatus) {
        this.tabStatus = tabStatus == null ? null : tabStatus.trim();
    }
}