package com.xxplay.dao.app;

import java.util.List;

import com.xxplay.model.dto.page.PageParams;
import com.xxplay.model.persistent.app.AppType;

public interface IAppTypeDao {
    int deleteByPrimaryKey(Integer typeId);

    int insert(AppType record);

    int insertSelective(AppType record);

    AppType selectByPrimaryKey(Integer typeId);

    int updateByPrimaryKeySelective(AppType record);

    int updateByPrimaryKey(AppType record);

    /**
     * 获取指定页面的分类
     *
     * @param pageParams
     * @return
     *
     * @author:chenssy
     * @date : 2016年4月22日 下午11:50:16
     */
	List<AppType> getAppListPage(PageParams pageParams);

	/**
	 * 获取分类的总个数
	 *
	 * @return
	 *
	 * @author:chenssy
	 * @date : 2016年4月22日 下午11:50:04
	 */
	int getAppListCountPage();

	/**
	 * 获取分类
	 *
	 * @return
	 *
	 * @author:chenssy
	 * @date : 2016年4月23日 下午6:55:42
	 */
	List<AppType> getAppTypes();
}