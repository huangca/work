package org.hch.yhw.auction.business;

import java.util.Date;

public class OrderyiBean {

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
	private Integer orderId;
	private String auctionUser;
	private String orderyiid;
	
	
	public OrderyiBean() {
	
	}
	public OrderyiBean(double summoney, String realname, String address,
			String telphone, String post, Date createtime, String model,
			String message, boolean sign, Integer orderId, String auctionUser,
			boolean cinfimsign,boolean fukuansign) {
	
		this.summoney = summoney;
		this.realname = realname;
		this.address = address;
		this.telphone = telphone;
		this.post = post;
		this.createtime = createtime;
		this.model = model;
		this.message = message;
		this.sign = sign;
		this.orderId = orderId;
		this.cinfimsign=cinfimsign; 
		this.fukuansign= fukuansign;
		this.auctionUser = auctionUser;
	}
	public double getSummoney() {
		return summoney;
	}
	public void setSummoney(double summoney) {
		this.summoney = summoney;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
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
	public boolean isSign() {
		return sign;
	}
	public void setSign(boolean sign) {
		this.sign = sign;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getAuctionUser() {
		return auctionUser;
	}
	public void setAuctionUser(String auctionUser) {
		this.auctionUser = auctionUser;
	}
	public boolean isCinfimsign() {
		return cinfimsign;
	}
	public void setCinfimsign(boolean cinfimsign) {
		this.cinfimsign = cinfimsign;
	}
	public boolean isFukuansign() {
		return fukuansign;
	}
	public void setFukuansign(boolean fukuansign) {
		this.fukuansign = fukuansign;
	}
	public String getOrderyiid() {
		return orderyiid;
	}
	public void setOrderyiid(String orderyiid) {
		this.orderyiid = orderyiid;
	}
	
	
}
