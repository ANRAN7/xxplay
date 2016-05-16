package com.xxplay.pojo.admin;

/**
 * 管理员角色
 * 
 * @Author:chenssy
 * @date:2016年4月9日
 * 
 */
public class Role {
    private String id;

    private String roleName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }
}