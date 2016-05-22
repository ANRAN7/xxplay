package com.xxplay.service.base;

import java.util.List;
import java.util.Map;

import com.xxplay.core.exception.ServiceException;
import com.xxplay.pojo.admin.Admin;
import com.xxplay.pojo.base.Menu;
import com.xxplay.pojo.base.MenuItem;

/**
 * 系统菜单服务类 接口
 * 
 * @Author:chenssy
 * @date:2016年4月10日
 * 
 */
public interface IMenuService {

	/**
	 * 获取系统菜单
	 *
	 * @return
	 *
	 * @author:chenssy
	 * @date : 2016年4月10日
	 */
	List<Menu> queryMenuList();

	/**
	 * 获取管理员可操作菜单
	 *
	 * @param admin
	 * @return
	 *
	 * @author:chenssy
	 * @throws ServiceException 
	 * @date : 2016年4月10日
	 */
	List<MenuItem> getAdminMenuItem(Admin admin) throws ServiceException;

	/**
	 * 获取所有的菜单<br>
	 * map形式为 id_name ---> list
	 * @author:chenssy
	 * @data : 2016年5月22日 上午10:02:41
	 *
	 * @return
	 */
	Map<Menu, List<MenuItem>> getMenuMap();

}
