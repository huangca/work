package org.hch.yhw.auction.action.base;

import com.opensymphony.xwork2.ActionSupport;

import org.hch.yhw.auction.exception.AuctionException;
import org.hch.yhw.auction.service.AuctionManager;
import org.hch.yhw.auction.service.AuctionManagerToAuctionUser;
import org.hch.yhw.auction.service.AuctionManagerToYiItem;
import org.hch.yhw.auction.service.AuctionManagerToOrder;
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
public class BaseAction extends ActionSupport
{
	protected AuctionManager mgr;
	protected AuctionManagerToAuctionUser auserMgr;
	protected AuctionManagerToOrder mgrOrder;
	protected AuctionManagerToYiItem mgryiItem;
	public void setMgr(AuctionManager mgr)
	{
		this.mgr = mgr;
	}
	public AuctionManager getMgr()
	{
		return this.mgr;
	}
	
	

	public AuctionManagerToAuctionUser getAuserMgr() {
		return auserMgr;
	}
	public void setAuserMgr(AuctionManagerToAuctionUser auserMgr) {
		this.auserMgr = auserMgr;
	}
	public AuctionManagerToOrder getMgrOrder() {
		return mgrOrder;
	}
	public void setMgrOrder(AuctionManagerToOrder mgrOrder) {
		this.mgrOrder = mgrOrder;
	}
	
	public AuctionManagerToYiItem getMgryiItem() {
		return mgryiItem;
	}
	public void setMgryiItem(AuctionManagerToYiItem mgryiItem) {
		this.mgryiItem = mgryiItem;
	}



}