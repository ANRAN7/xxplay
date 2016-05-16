package com.xxplay.service.gameCenter;

/**
 * 游戏批量任务服务 接口
 * 
 * @Author:chenssy
 * @date:2016年5月14日 下午3:01:36
 * 
 */
public interface IGameBathTaskService {

	/**
	 * 执行游戏批量任务<br>
	 * 处理逻辑如下：<br>
	 * 1.获取未开始的批量任务，并且将任务状态更改为“正在进行中”<br>
	 * 2.获取该批次任务的详情情况，分布执行详情的任务，每次执行完一个就保存到数据库中<br>
	 * 3.根据任务详情执行的情况设置批次任务的状态<br>
	 * 【注：这里必须要注意三部，每个步骤都需要手动提交事务，所以这个时候不能将事务交给spring来管理，同时为了效率问题，启用多线程来执行详细任务，所以一定要控制好线程】
	 * @author:chenssy
	 * @date : 2016年5月14日 下午3:44:19
	 */
	void excuteGameBathTask();

}
