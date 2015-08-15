package org.hch.yhw.auction.schedule;

import java.util.TimerTask;

import org.hch.yhw.auction.exception.AuctionException;
import org.hch.yhw.auction.service.AuctionManager;
import org.hch.yhw.auction.service.AuctionManagerToYiItem;
/**
 * Description:
 * <br/>地址: <a href="http://www.sise.com.cn">华软高效</a> 
 * <br/>Copyright (C), 2010-201?, 黄灿华   余宏伟
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:20100301-20100401
 * @author  hch0612@scse.com.cn
 * @version  1.0
 */
public class CheckWiner extends TimerTask
{
	//该任务所依赖业务逻辑组件
	private AuctionManager mgr;

	//依赖注入业务逻辑组件必须的setter方法
	public void setMgr(AuctionManager mgr)
	{
		this.mgr = mgr;
	}
	//该任务的执行体
	public void run()
	{
		try
		{
			mgr.updateWiner();
			
		}
		catch (AuctionException ae)
		{
			ae.printStackTrace();
		}
	}
}
