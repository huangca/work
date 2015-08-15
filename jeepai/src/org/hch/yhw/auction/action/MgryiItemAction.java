package org.hch.yhw.auction.action;

import java.util.*;
import com.opensymphony.xwork2.*;

import org.hch.yhw.auction.action.base.BaseAction;
import org.hch.yhw.auction.exception.AuctionException;
import org.hch.yhw.auction.service.AuctionManagerToYiItem;;

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
public class MgryiItemAction extends BaseAction
{
	//private List yiitems;
	//private List kinds;
	//private List bigkinds
	

	public String execute() throws Exception
	{
		Map session = ActionContext.getContext().getSession();
		//Integer userId = (Integer)session.get("adminId");
		//setYiitems(mgryiItem.getYiItemsByOwner(userId));
		//setKinds(mgryiItem.getAllKind());
		session.put("bigkinds",mgr.getAllBigKindNotOther());
		return SUCCESS;
	}

	/*public List getYiitems() {
		return yiitems;
	}

	public void setYiitems(List yiitems) {
		this.yiitems = yiitems;
	}*/
/*
	public void setKinds(List kinds)
	{
		this.kinds = kinds;
	}
	public List getKinds()
	{
		 return this.kinds;
	}*/
}