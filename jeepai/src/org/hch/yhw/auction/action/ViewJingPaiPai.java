package org.hch.yhw.auction.action;

import org.hch.yhw.auction.action.base.BaseAction;
import org.hch.yhw.auction.business.ItemBean;
import org.hch.yhw.auction.exception.AuctionException;

public class ViewJingPaiPai extends BaseAction{
private int itemId;
private ItemBean itemBean;

public int getItemId() {
	return itemId;
}

public void setItemId(int itemId) {
	this.itemId = itemId;
}

public ItemBean getItemBean() {
	return itemBean;
}

public void setItemBean(ItemBean itemBean) {
	this.itemBean = itemBean;
}

public String execute () throws AuctionException{
	
	 setItemBean(mgr.getItem(itemId));
	return SUCCESS;
}
}
