package org.hch.yhw.auction.business;

public class OrderdetailBean {

	private int number;
	private double price;
	private Integer id;
	private String yiitem;
	private Integer orderyi;
	
	//private Integer 
	
	
	public OrderdetailBean() {

	}
	
	public OrderdetailBean(int number, double price, Integer id, String yiitem,
			Integer orderyi) {
		super();
		this.number = number;
		this.price = price;
		this.id = id;
		this.yiitem = yiitem;
		this.orderyi = orderyi;
	}

	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getYiitem() {
		return yiitem;
	}
	public void setYiitem(String yiitem) {
		this.yiitem = yiitem;
	}
	public Integer getOrderyi() {
		return orderyi;
	}
	public void setOrderyi(Integer orderyi) {
		this.orderyi = orderyi;
	}
	
	
	
}
