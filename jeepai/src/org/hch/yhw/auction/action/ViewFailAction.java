package org.hch.yhw.auction.action;

import java.util.*;
import com.opensymphony.xwork2.ActionContext;

import org.hch.yhw.auction.action.base.BaseAction;
import org.hch.yhw.auction.exception.AuctionException;
import org.hch.yhw.auction.service.AuctionManager;
/**
 * Description:
 * <br/>��ַ: <a href="http://www.sise.com.cn">�����Ч</a> 
 * <br/>Copyright (C), 2010-201?, �Ʋӻ�   ���ΰ
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:20100301-20100401
 * @author  hch0612@scse.com.cn
 * @version  1.0
 */
public class ViewFailAction extends BaseAction
{
	private List failItems;

	public String execute()throws Exception
	{
		setFailItems(mgr.getFailItems());
		return SUCCESS;
	}

	public void setFailItems(List failItems)
	{
		this.failItems = failItems;
	}
	public List getFailItems()
	{
		 return this.failItems;
	}
}