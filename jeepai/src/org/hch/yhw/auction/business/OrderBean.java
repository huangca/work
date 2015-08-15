package org.hch.yhw.auction.business;

import java.util.List;

public class OrderBean {
    //会员的信息BEAN
	private AuctionUserBean memberbean;
	
	private List<CartBean> cartBeanList;
	//订单的ID
    private Integer orderid;
	//配送方式 ： EMS，快递，普通包裹
	
	private String model;
	//支付方式 ：支付宝 ， 网银  由于时间关系暂忽略
	//订单表总价字段
	private double summoney;
	private String message;
	public OrderBean(){}
	
	
	public Integer getOrderid() {
		return orderid;
	}


	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}


	public double getSummoney() {
		return summoney;
	}


	public void setSummoney(double summoney) {
		this.summoney = summoney;
	}


	public AuctionUserBean getMemberbean() {
		return memberbean;
	}
	public void setMemberbean(AuctionUserBean memberbean) {
		this.memberbean = memberbean;
	}



	public List<CartBean> getCartBeanList() {
		return cartBeanList;
	}


	public void setCartBeanList(List<CartBean> cartBeanList) {
		this.cartBeanList = cartBeanList;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
	
}
