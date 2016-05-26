package com.xxplay.service.admin.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xxplay.dao.admin.IRoleDao;
import com.xxplay.model.dto.page.PageBean;
import com.xxplay.model.dto.page.PageParams;
import com.xxplay.model.persistent.admin.Role;
import com.xxplay.service.admin.IRoleService;

/**
 * 用户权限服务 实现类
 * 
 * @Author:chenssy
 * @date:2016年4月16日
 * 
 */
@Service("roleService")
public class RoleServiceImpl implements IRoleService{
	@Resource
	private IRoleDao roleDao;

	@Override
	public List<Role> getRoleSelectModal() {
		return roleDao.getRoleList(null);
	}

	@Override
	public PageBean getRoleListPage(int pageNo) {
		PageParams params = PageParams.getInstance(pageNo);
		
		List<Role> roles = roleDao.getRoleListPage(params);
		Integer totalNo = roleDao.getRoleCountPage();
		
		
		return new PageBean(totalNo, roles, pageNo);
	}

	@Override
	public void updateRole(Role role) {
		roleDao.updateByPrimaryKeySelective(role);
	}

}
