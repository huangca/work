package org.hch.yhw.auction.business;

import java.util.List;

public class OrderBean {
    //��Ա����ϢBEAN
	private AuctionUserBean memberbean;
	
	private List<CartBean> cartBeanList;
	//������ID
    private Integer orderid;
	//���ͷ�ʽ �� EMS����ݣ���ͨ����
	
	private String model;
	//֧����ʽ ��֧���� �� ����  ����ʱ���ϵ�ݺ���
	//�������ܼ��ֶ�
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
