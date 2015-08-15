package org.hch.yhw.auction.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import org.hch.yhw.auction.action.base.BaseAction;
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
		//取出Session中的userId
	Integer userId = (Integer)session.get("userId");
	if(userId!=null)
	{mgryiItem.updateWiner(new Integer(itemId), userId);
	return SUCCESS;
	}
	else {
		addActionError("系统处理出错！请稍后。。。");
	return INPUT;}
	
	}
}
