package org.hch.yhw.auction.action;

import java.util.*;
import com.opensymphony.xwork2.*;

import org.hch.yhw.auction.action.base.BaseActionInterface;
import org.hch.yhw.auction.business.*;
import org.hch.yhw.auction.exception.AuctionException;
import org.hch.yhw.auction.model.*;
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
public class ViewDetailAction extends BaseActionInterface
{
	//封装用户请求参数的属性
	private int itemId;
	private ItemBean item;
	//封装系统错误提示的属性
	private String errMsg;
	//处理用户请求
	public String execute()throws Exception
	{
		if (itemId <= 0)
		{
			setErrMsg("您选择物品种类不是一个有效的物品种类！");
			return ERROR;
		}
		else
		{
			setItem(mgr.getItem(itemId));
			return SUCCESS;
		}
	}

	public void setItemId(int itemId)
	{
		this.itemId = itemId;
	}
	public int getItemId()
	{
		 return this.itemId;
	}

	public void setItem(ItemBean item)
	{
		this.item = item;
	}
	public ItemBean getItem()
	{
		 return this.item;
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