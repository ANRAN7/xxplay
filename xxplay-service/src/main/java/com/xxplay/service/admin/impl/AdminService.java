package com.xxplay.service.admin.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.xxplay.common.core.AppContextUtils;
import com.xxplay.common.exception.ServiceException;
import com.xxplay.common.utils.xxplay.Des;
import com.xxplay.common.utils.xxplay.IConstant;
import com.xxplay.dao.admin.IAdminDao;
import com.xxplay.model.dto.page.PageBean;
import com.xxplay.model.dto.page.PageParams;
import com.xxplay.model.persistent.admin.Admin;
import com.xxplay.service.admin.IAdminService;
import com.xxplay.service.admin.IPasswordService;
import com.xxplay.service.base.IAdminMenuService;

/**
 * 管理员服务 实现类
 * 
 * @Author:chenssy
 * @date:2016年4月9日
 * 
 */
@Service("adminService")
public class AdminService implements IAdminService{
	private static Logger logger = LoggerFactory.getLogger(AdminService.class);
	@Resource
	private IAdminDao adminDao;

	@Resource
	private IAdminMenuService adminMenuService;
	
	@Resource
	private IPasswordService passwordService;
	
	@Override
	public Admin getAdminByUserName(String userName) {
		return adminDao.queryAdminByUserName(userName);
	}

	@Override
	public Admin adminTranLogin(String userName, String password) throws ServiceException {
		Admin admin = getAdminByUserName(userName);
		if(admin == null){
			throw new ServiceException("EC10001");
		}
		//密码解码
		password = Des.strDec(password,AppContextUtils.getPropertiesValue("login-key"),null,null);
		passwordService.checkAdminPassword(password,admin.getPassword());

		return admin;
	}

	@Override
	public PageBean queryAdminListPage(Map<String, String> params) {
		int pageNo = Integer.valueOf(params.get("pageNo"));
		PageParams pageParams = PageParams.getInstance(pageNo,params);
		
		List<Admin> admins = adminDao.queryAdminListPage(pageParams);
		int totalNo = adminDao.queryAdminCountPage(pageParams);
		
		return new PageBean(totalNo, admins, pageNo);
	}

	@Override
	public void addAdmin(Admin admin) throws ServiceException {
		Admin admin1 = getAdminByUserName(admin.getUserName());
		if(admin1 != null){
			throw new ServiceException("","该管理员用户名已经存在了，请重新输入");
		}
		admin.setCreateTime(new Date());
		admin.setStatus(IConstant.ADMIN_STUTS_USING);		//用户状态：启用 
		//处理登录密码
		admin.setPassword(passwordService.getUserLoginPassword(admin.getPassword()));
		adminDao.insert(admin);
	}

	@Override
	public void updateAdminStatus(String id, String status) {
		Admin admin = new Admin();
		admin.setId(id);
		admin.setStatus(status);
		
		try {
			adminDao.updateByPrimaryKeySelective(admin);
		} catch (Exception e) {
			logger.error("更改管理员状态失败。管理员编号：" + id);
		}
	}

	@Override
	public void deleteAdmin(String id) {
		//删除管理员的基本信息
		adminDao.deleteByPrimaryKey(id);
		//删除管理员的菜单
		adminMenuService.deleteAdminMenu(id);
	}

	@Override
	public Admin getAdminById(String id) {
		return adminDao.selectByPrimaryKey(id);
	}

	@Override
	public void updateAdmin(Admin admin) {
		try {
			adminDao.updateByPrimaryKeySelective(admin);
		} catch (Exception e) {
			logger.error("修改管理员基本信息失败。管理员编号：" + admin.getId());
		}
	}
}
