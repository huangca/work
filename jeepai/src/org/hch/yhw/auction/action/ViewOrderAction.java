package org.hch.yhw.auction.action;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.*;

import org.hch.yhw.auction.action.base.BaseActionInterface;
import org.hch.yhw.auction.exception.AuctionException;
import org.hch.yhw.auction.service.AuctionManager;
public class ViewOrderAction extends BaseActionInterface {
         private List order;
         
         public List getOrder() {
			return order;
		}

		public void setOrder(List order) {
			this.order = order;
		}

		public String execute() throws Exception
     	{
        
			Map session = ActionContext.getContext().getSession();
     		Integer userId = (Integer)session.get("userId");
           System.out.println(userId);
     		//setOrder(mgr.getOrder(userId));
     		setOrder(mgrOrder.getOrderyiByAuctionUserId(userId));
           System.out.println("·µ»Ø³É¹¦");
           return SUCCESS;
  
        	}
}
