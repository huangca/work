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
 * <br/>��ַ: <a href="http://www.sise.com.cn">�����Ч</a> 
 * <br/>Copyright (C), 2010-201?, �Ʋӻ�   ���ΰ
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:20100301-20100401
 * @author  hch0612@scse.com.cn
 * @version  1.0
 */
public class ViewDetailAction extends BaseActionInterface
{
	//��װ�û��������������
	private int itemId;
	private ItemBean item;
	//��װϵͳ������ʾ������
	private String errMsg;
	//�����û�����
	public String execute()throws Exception
	{
		if (itemId <= 0)
		{
			setErrMsg("��ѡ����Ʒ���಻��һ����Ч����Ʒ���࣡");
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