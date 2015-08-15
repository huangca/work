package org.hch.yhw.auction.action;

import java.util.*;
import com.opensymphony.xwork2.*;

import org.hch.yhw.auction.action.base.BaseActionInterface;
import org.hch.yhw.auction.exception.AuctionException;
import org.hch.yhw.auction.service.AuctionManager;

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
public class MgrItemAction extends BaseActionInterface
{
	private List items;
	//private List kinds;
	//private List bigkind;
	public String execute() throws Exception
	{
		Map session = ActionContext.getContext().getSession();
		Integer userId = (Integer)session.get("userId");
		setItems(mgr.getItemsByOwner(userId));
		//setKinds(mgr.getAllKind());
		session.put("bigkinds", mgr.getAllBigKindNotOther());
		return SUCCESS;
	}
public void setItems(List items)
	{
		this.items = items;
	}
	public List getItems()
	{
		 return this.items;
	}
/*
	public void setKinds(List kinds)
	{
		this.kinds = kinds;
	}
	public List getKinds()
	{
		 return this.kinds;
	}
*/
}