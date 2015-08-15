package org.hch.yhw.auction.business;

import java.util.Date;

public class OrderiBean {
	private Integer id;
	private double summoney;
	private String realname;
	private String address;
	private String telphone;
	private String post;
	private Date createtime;
	private String model;
	private String message;
	private boolean sign;
	private boolean cinfimsign;
	private boolean fukuansign;
	private String orderId;
	private int number;//拍卖品的件数是一个常量1
	private String item;
    private double price;
    private Integer itemId;
    //会员ID没用
	public OrderiBean() {
		
	}
	
	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getId() {
		return id;
	}
	public double getSummoney() {
		return summoney;
	}
	public String getRealname() {
		return realname;
	}
	public String getAddress() {
		return address;
	}
	public String getTelphone() {
		return telphone;
	}
	public String getPost() {
		return post;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public String getModel() {
		return model;
	}
	public String getMessage() {
		return message;
	}
	public boolean getSign() {
		return sign;
	}
	public boolean getCinfimsign() {
		return cinfimsign;
	}
	public boolean getFukuansign() {
		return fukuansign;
	}
	public String getOrderId() {
		return orderId;
	}
	public int getNumber() {
		return number;
	}
	public String getItem() {
		return item;
	}
	public double getPrice() {
		return price;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setSummoney(double summoney) {
		this.summoney = summoney;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setSign(boolean sign) {
		this.sign = sign;
	}
	public void setCinfimsign(boolean cinfimsign) {
		this.cinfimsign = cinfimsign;
	}
	public void setFukuansign(boolean fukuansign) {
		this.fukuansign = fukuansign;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public void setPrice(double price) {
		this.price = price;
	}
    
}
