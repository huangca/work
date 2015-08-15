package org.hch.yhw.auction.action;

import java.util.List;
import java.util.Map;

import org.hch.yhw.auction.action.base.BaseAction;
import org.hch.yhw.auction.business.*;
import org.hch.yhw.auction.service.AuctionManagerToAuctionUser;
import com.opensymphony.xwork2.ActionContext;

public class CreateOrderAction extends BaseAction{
	
	private OrderBean orderBean;


	public OrderBean getOrderBean() {
		return orderBean;
	}


	public void setOrderBean(OrderBean orderBean) {
		this.orderBean = orderBean;
	}


	@Override
    public String execute() throws Exception{
		System.out.println("来到CreateOrderAction");
	Map session = ActionContext.getContext().getSession();
	List<CartBean> toList=(List<CartBean>)session.get("fromList");
	if(toList!=null){	System.out.println("来到CreateOrderAction2");}
	Double summoney=(Double)session.get("summoney");
	if(summoney!=null){	System.out.println("来到CreateOrderAction3summoney的值"+summoney.doubleValue());}
	Integer memberId=(Integer)session.get("userId");
	if(memberId!=null){	System.out.println("来到CreateOrderAction4");}
	if(orderBean==null){orderBean=new OrderBean();}
	orderBean.setCartBeanList(toList);
	System.out.println("来到CreateOrderAction5");
	orderBean.setSummoney(summoney.doubleValue());
    if(auserMgr!=null){System.out.println("auserMgr这是不为空啊，郁闷");}
	AuctionUserBean memberbean=auserMgr.findAuctionBeanByUserId(memberId);
	orderBean.setMemberbean(memberbean);
	//为转发做准备
	setOrderBean(orderBean);
	return SUCCESS;
}
	
	
}
