package org.hch.yhw.auction.action;

import org.hch.yhw.auction.business.YiItemBean;
import org.hch.yhw.auction.exception.AuctionException;
import org.hch.yhw.auction.action.base.BaseAction;
public class ViewYiitemDetailPai extends BaseAction {
	private Integer itemId;//…Ã∆∑±‡∫≈
	private YiItemBean yiItemBean;
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public YiItemBean getYiItemBean() {
		return yiItemBean;
	}
	public void setYiItemBean(YiItemBean yiItemBean) {
		this.yiItemBean = yiItemBean;
	}
	
	
	public String execute() throws AuctionException{
		
		 setYiItemBean(mgryiItem.getYiItem(itemId));
		
		  return SUCCESS;
	}
}
