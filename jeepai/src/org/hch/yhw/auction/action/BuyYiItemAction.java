package org.hch.yhw.auction.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import org.hch.yhw.auction.action.base.BaseAction;
import org.hch.yhw.auction.service.AuctionManagerToYiItem;
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
public class BuyYiItemAction extends BaseAction{
	private int itemId;
	//private AuctionManagerToYiItem mgryiItem;
	
	
	public int getItemId() {
		return itemId;
	}


	public void setItemId(int itemId) {
		this.itemId = itemId;
	}


	/*public AuctionManagerToYiItem getMgryiItem() {
		return mgryiItem;
	}


	public void setMgryiItem(AuctionManagerToYiItem mgryiItem) {
		this.mgryiItem = mgryiItem;
	}


*/

	public String execute() throws Exception{
		
		Map session = ActionContext.getContext().getSession();
		//ȡ��Session�е�userId
	Integer userId = (Integer)session.get("userId");
	if(userId!=null)
	{mgryiItem.updateWiner(new Integer(itemId), userId);
	return SUCCESS;
	}
	else {
		addActionError("ϵͳ����������Ժ󡣡���");
	return INPUT;}
	
	}
}
