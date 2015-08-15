package org.hch.yhw.auction.action;

import java.util.*;
import com.opensymphony.xwork2.ActionContext;

import org.hch.yhw.auction.action.base.BaseAction;
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
public class ViewKindAction extends BaseAction
{
	private List kinds;
	private String errMsg;

	public String execute()throws Exception
	{
		setKinds(mgr.getAllKind());
		return SUCCESS;
	}

	public void setKinds(List kinds)
	{
		this.kinds = kinds;
	}

	public List getKinds()
	{
		 return this.kinds;
	}

	public void setErrMsg(String errMsg)
	{
		this.errMsg = errMsg;
	}
	public String getErrMsg()
	{
		 return this.errMsg;
	}
}