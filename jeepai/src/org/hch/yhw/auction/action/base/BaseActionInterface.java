package org.hch.yhw.auction.action.base;

import com.opensymphony.xwork2.Action;

import org.hch.yhw.auction.service.AuctionManager;
import org.hch.yhw.auction.service.AuctionManagerToAuctionUser;
import org.hch.yhw.auction.service.AuctionManagerToOrder;
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
public class BaseActionInterface implements Action
{
	protected AuctionManager mgr;
	protected AuctionManagerToAuctionUser auserMgr;
	protected AuctionManagerToOrder mgrOrder;

	public void setMgrOrder(AuctionManagerToOrder mgrOrder) {
		this.mgrOrder = mgrOrder;
	}


	public void setMgr(AuctionManager mgr)
	{
		this.mgr = mgr;
	}
	/*protected AuctionManagerToYiItem mgryiItem;
	public void setMgryiItem(AuctionManagerToYiItem mgryiItem) {
		this.mgryiItem = mgryiItem;
	}
*/
	
	
	public String execute() throws Exception
	{
		return SUCCESS;
	}


	public void setAuserMgr(AuctionManagerToAuctionUser auserMgr) {
		this.auserMgr = auserMgr;
	}
}