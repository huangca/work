package org.hch.yhw.auction.action;
import java.util.*;
import com.opensymphony.xwork2.*;

import org.hch.yhw.auction.action.base.BaseAction;
import org.hch.yhw.auction.business.*;
import org.hch.yhw.auction.exception.AuctionException;
import org.hch.yhw.auction.model.*;
import org.hch.yhw.auction.service.AuctionManager;


public class CancelOrderAction extends BaseAction {
private String orderId;
/*
public int getOrderId() {
	return orderId;
}

public void setOrderId(int orderId) {
	this.orderId = orderId;
}
*/


public String execute()throws Exception
{
	/*
	if(mgrOrder==null){System.out.println("mgrtoÎª¿Õ");}
	mgrOrder.deleteOrderyiByOid(new Integer(orderId));
	*/
mgrOrder.deleteOrderyiByModel(orderId);
	return SUCCESS;
	
}


public String getOrderId() {
	return orderId;
}


public void setOrderId(String orderId) {
	this.orderId = orderId;
}

}
