package org.hch.yhw.auction.action;

import java.util.List;
import java.util.Map;

import org.hch.yhw.auction.action.base.BaseAction;
import org.hch.yhw.auction.business.CartBean;
import org.hch.yhw.auction.service.AuctionManagerToYiItem;

import com.opensymphony.xwork2.ActionContext;

public class DeleteCartAction extends BaseAction {
private int	yiitemId;
private List<CartBean> fromList;
//private AuctionManagerToYiItem mgryiItem;
private int number;


public int getNumber() {
	return number;
}



public void setNumber(int number) {
	this.number = number;
}



public int getYiitemId() {
	return yiitemId;
}



public void setYiitemId(int yiitemId) {
	this.yiitemId = yiitemId;
}



public List<CartBean> getFromList() {
	return fromList;
}



public void setFromList(List<CartBean> fromList) {
	this.fromList = fromList;
}


/*
public AuctionManagerToYiItem getMgryiItem() {
	return mgryiItem;
}



public void setMgryiItem(AuctionManagerToYiItem mgryiItem) {
	this.mgryiItem = mgryiItem;
}

*/

public String execute()  throws Exception{
	System.out.println("yiitemId的之"+yiitemId);
	System.out.println("number在的DeleteCartAction值"+number);
	if(fromList==null){
	System.out.println("fromList的之NULL");}
	//fromList=mgryiItem.removeCartBeanById(new Integer(yiitemId), fromList);
	Map session = ActionContext.getContext().getSession();
	fromList=(List<CartBean>)session.get("fromList");
	fromList=mgryiItem.removeCartBeanById(new Integer(yiitemId), fromList);
	setNumber(0);
	setFromList(fromList);
	session.put("fromList", fromList);
	return SUCCESS;
}


}
