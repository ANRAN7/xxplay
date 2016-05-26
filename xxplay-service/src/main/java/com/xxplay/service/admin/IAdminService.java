package com.xxplay.service.admin;

import java.util.Map;

import com.xxplay.common.exception.ServiceException;
import com.xxplay.model.dto.page.PageBean;
import com.xxplay.model.persistent.admin.Admin;

/**
 * 管理员服务层 接口
 * 
 * @Author:chenssy
 * @date:2016年4月9日
 */
public interface IAdminService {
	
	/**
	 * 根据用户名获取管理员
	 *
	 * @param userName
	 * @return
	 *
	 * @author:chenssy
	 * @date : 2016年4月9日
	 */
	public Admin getAdminByUserName(String userName);

	/**
	 * 用户登录过程
	 *
	 * @param userName
	 * @param params
	 *
	 * @author:chenssy
	 * @throws ServiceException 
	 * @date : 2016年4月9日
	 */
	public Admin adminTranLogin(String userName,String password) throws ServiceException;

	/**
	 * 获取管理员列表，分页处理
	 *
	 * @param params
	 * 				查询参数
	 * @return
	 *
	 * @author:chenssy
	 * @date : 2016年4月16日
	 */
	public PageBean queryAdminListPage(Map<String, String> params);

	/**
	 * 增加管管理员
	 *
	 * @param admin
	 * 				管理员基本信息
	 *
	 * @author:chenssy
	 * @throws ServiceException 
	 * @date : 2016年4月17日
	 */
	public void addAdmin(Admin admin) throws ServiceException;

	/**
	 * 更改管理员状态 
	 *
	 * @param id
	 * 				管理员ID
	 * @param status
	 * 				更改状态
	 *
	 * @author:chenssy
	 * @date : 2016年4月17日
	 */
	public void updateAdminStatus(String id, String status);

	/**
	 * 删除管理员<br>
	 * 删除管理员的基本信息<br>
	 * 删除管理员的所以菜单信息
	 *
	 * @param id
	 *
	 * @author:chenssy
	 * @date : 2016年4月17日
	 */
	public void deleteAdmin(String id);

	/**
	 * 根据ID获取管理员信息
	 *
	 * @param id
	 * @return
	 *
	 * @author:chenssy
	 * @date : 2016年4月19日
	 */
	public Admin getAdminById(String id);

	/**
	 * 修改管理员基本信息
	 * 
	 * @param admin
	 *
	 * @author:chenssy
	 * @date : 2016年4月19日
	 */
	public void updateAdmin(Admin admin);
}
