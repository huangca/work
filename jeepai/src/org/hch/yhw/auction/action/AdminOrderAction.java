package org.hch.yhw.auction.action;
import java.util.List;

import org.hch.yhw.auction.action.base.BaseAction;
import org.hch.yhw.auction.model.*;
public class AdminOrderAction extends BaseAction {
	private int sign;
	private List<Orderyi> order;
	
	
	

	public List<Orderyi> getOrder() {
		return order;
	}

	public void setOrder(List<Orderyi> order) {
		this.order = order;
	}

	public int getSign() {
		return sign;
	}

	public void setSign(int sign) {
		this.sign = sign;
	}
	 
	
	public String execute()throws Exception
	{
		if (sign <= 0)
		  { System.out.println("Id 的值Id 的值Id 的值Id 的值"+getSign());
            setOrder(mgrOrder.getAllOrderyi());
				return SUCCESS;
				
			}
		else
		{
			if(sign==1)
			{
				setOrder(mgrOrder.getOrderyiBySign(false));
				 return SUCCESS;
			}
			else {
				setOrder(mgrOrder.getOrderyiBySign(true));
				return SUCCESS;
			}
		}
	
	}
}
