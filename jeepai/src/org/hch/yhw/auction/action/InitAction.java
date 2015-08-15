package org.hch.yhw.auction.action;

import java.util.List;

import org.hch.yhw.auction.action.base.BaseAction;
import org.hch.yhw.auction.exception.AuctionException;
import org.hch.yhw.auction.model.Item;
import org.hch.yhw.auction.service.AuctionManagerToYiItem;
import org.hch.yhw.auction.business.*;
public class InitAction  extends BaseAction{
    private List items;//最新的热拍商品Top9
	private List yiitems;//最新的热卖品Top9
	
	
	


	public List getItems() {
		return items;
	}





	public void setItems(List items) {
		this.items = items;
	}





	public List getYiitems() {
		return yiitems;
	}





	public void setYiitems(List yiitems) {
		this.yiitems = yiitems;
	}





	public String execute(){
		System.out.println("comingcomging");
		if(this.getMgryiItem()==null){System.out.println("真的为空");}
		System.out.println("comingcomging2");
		try {
			setYiitems( mgryiItem.getNewSaleYiItemsToList());
		    setItems(mgr.findItemByStateOrderByDate());
			return SUCCESS;
		} catch (AuctionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
	}
}
