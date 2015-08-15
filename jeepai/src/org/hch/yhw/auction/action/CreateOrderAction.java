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
		System.out.println("����CreateOrderAction");
	Map session = ActionContext.getContext().getSession();
	List<CartBean> toList=(List<CartBean>)session.get("fromList");
	if(toList!=null){	System.out.println("����CreateOrderAction2");}
	Double summoney=(Double)session.get("summoney");
	if(summoney!=null){	System.out.println("����CreateOrderAction3summoney��ֵ"+summoney.doubleValue());}
	Integer memberId=(Integer)session.get("userId");
	if(memberId!=null){	System.out.println("����CreateOrderAction4");}
	if(orderBean==null){orderBean=new OrderBean();}
	orderBean.setCartBeanList(toList);
	System.out.println("����CreateOrderAction5");
	orderBean.setSummoney(summoney.doubleValue());
    if(auserMgr!=null){System.out.println("auserMgr���ǲ�Ϊ�հ�������");}
	AuctionUserBean memberbean=auserMgr.findAuctionBeanByUserId(memberId);
	orderBean.setMemberbean(memberbean);
	//Ϊת����׼��
	setOrderBean(orderBean);
	return SUCCESS;
}
	
	
}
