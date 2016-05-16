package com.xxplay.service.base.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.xxplay.core.base.AppContextUtils;
import com.xxplay.core.exception.ServiceException;
import com.xxplay.dao.base.IMenuDao;
import com.xxplay.pojo.admin.Admin;
import com.xxplay.pojo.base.AdminMenu;
import com.xxplay.pojo.base.Menu;
import com.xxplay.pojo.base.MenuItem;
import com.xxplay.service.base.IAdminMenuService;
import com.xxplay.service.base.IMenuService;

/**
 * 系统菜单服务类 实现类
 * 
 * @Author:chenssy
 * @date:2016年4月10日
 * 
 */
@Service("menuService")
public class MenuServiceImpl implements IMenuService{
	
	@Resource
	private IMenuDao menuDao;
	
	@Resource
	private IAdminMenuService adminMenuService;

	@Override
	public List<Menu> queryMenuList() {
		return menuDao.queryMenuList();
	}

	@Override
	public List<MenuItem> getAdminMenuItem(Admin admin) throws ServiceException {
		//获取该管理员所有的可操作菜单
		List<AdminMenu> menu1 = adminMenuService.getAdminMenus(admin.getId());
		if(menu1 == null || menu1.size() < 1){
			throw new ServiceException("", "您没有指定可操作的功能菜单，请联系系统管理员");
		}
		//获取所有菜单
		List<Menu> menu2 = AppContextUtils.getMenus();
		
		//将管理员操作菜单转换为Menu
		List<Menu> menus = new ArrayList<Menu>(menu1.size());
		for(int i = 0 ; i < menu1.size() ; i++){
			for(int j = 0 ; j < menu2.size() ; j++){
				if(menu1.get(i).getMenuId().equals(menu2.get(j).getMenuCode())){
					menus.add(menu2.get(j));
					break;
				}
			}
		}
		
		//构建菜单MenuItem
		return buildMenuItem(menus);
	}

	/**
	 * 构建菜单树<br>
	 * 首先提取出一级菜单，然后根据一级菜单寻找其子菜单
	 *
	 * @param menus
	 * @return
	 *
	 * @author:chenssy
	 * @date : 2016年4月10日
	 */
	private List<MenuItem> buildMenuItem(List<Menu> menus) {
		//获取一级菜单
		List<Menu> firstMenu = new ArrayList<Menu>();
		for(Menu menu : menus){
			if(StringUtils.isBlank(menu.getMenuParentid()) || "0".equals(menu.getMenuParentid())){
				firstMenu.add(menu);
			}
		}
		
		//根据一级菜单构建菜单树
		List<MenuItem> items = new ArrayList<MenuItem>(firstMenu.size());
		MenuItem item = null;
		for(Menu menu : firstMenu){
			item = new MenuItem();
			BeanUtils.copyProperties(menu, item); 		//属性拷贝
			item.setChildList(buildChildItems(item,menus));		//获取起子菜单
			items.add(item);
		}
		
		sortItem(items); 		//排序菜单
		
		return items;
	}

	/**
	 * 构建子菜单
	 *
	 * @param item
	 * @param menus
	 * @return
	 *
	 * @author:chenssy
	 * @date : 2016年4月10日
	 */
	private List<MenuItem> buildChildItems(MenuItem item, List<Menu> menus) {
		List<MenuItem> items = new ArrayList<MenuItem>();
		MenuItem menuItem = null;
		List<MenuItem> childItem = null;
		for(Menu menu : menus){
			//menu的父级code==item的menuCode，则表示menu为Item的子菜单
			if(item.getMenuCode().equals(menu.getMenuParentid())){		
				menuItem = new MenuItem();
				BeanUtils.copyProperties(menu, menuItem);
				
				//迭代菜单
				childItem = buildChildItems(menuItem, menus);
				//对菜单进行排序处理
				sortItem(childItem);
				menuItem.setChildList(childItem);
				
				items.add(menuItem);
			}
		}
		
		if(items.size() < 1){
			items = null;
		}
		
		return items;
	}

	/**
	 * 对菜单进行排序处理
	 *
	 * @param childItem
	 *
	 * @author:chenssy
	 * @date : 2016年4月10日
	 */
	@SuppressWarnings("unchecked")
	private void sortItem(List<MenuItem> items) {
		if(items != null){
			Collections.sort(items, new ComparatorItem());
		}
	}
	
	/**
	 * 菜单排序的比较器
	 * 
	 * @file:MenuServiceImpl.java
	 * @package_name:com.xxplay.service.base.impl
	 * @Project:xxplay
	 *
	 * @Author:chenssy
	 * @Copyright chenssy   2016 All Rights Reserved.
	 * 
	 * @date:2016年4月10日
	 */
	@SuppressWarnings("rawtypes")
	private class ComparatorItem implements Comparator{
		@Override
		public int compare(Object obj1, Object obj2) {
			MenuItem menu1 = (MenuItem) obj1;
			MenuItem menu2 = (MenuItem) obj2;
			return menu1.getMenuSeqno().compareTo(menu2.getMenuSeqno());
		}
		
	}
}
