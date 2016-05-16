package com.xxplay.service.gameCenter;

import java.util.List;
import java.util.Map;

import com.xxplay.core.exception.ServiceException;
import com.xxplay.core.pojo.PageBean;
import com.xxplay.pojo.app.AppType;

/**
 * 
 * 游戏分类服务层  接口
 * 
 * @Author:chenssy
 * @date:2016年4月22日 下午11:36:58
 * 
 */
public interface IGameCategoryService {

	/**
	 * 获取游戏分类列表
	 *
	 * @param params
	 * @return
	 *
	 * @author:chenssy
	 * @date : 2016年4月22日 下午11:39:37
	 */
	PageBean queryGameCategoryList(Map<String, String> params);

	/**
	 * 更改游戏分类信息表
	 *
	 * @param appType
	 *
	 * @author:chenssy
	 * @throws ServiceException 
	 * @date : 2016年4月23日 上午12:16:38
	 */
	void updateGameCategory(AppType appType) throws ServiceException;

	/**
	 * 获取游戏分类
	 *
	 * @return
	 *
	 * @author:chenssy
	 * @date : 2016年4月23日 下午6:54:58
	 */
	List<AppType> getGameCategorys();
	
	/**
	 * 获取游戏分类,
	 * 
	 * @return 游戏分类，结果技为map，categoryId --> categoryName
	 *
	 * @author:chenssy
	 * @date : 2016年5月10日 下午10:14:54
	 */
	public Map<Integer, String> getGameCategoryMaps();

}
