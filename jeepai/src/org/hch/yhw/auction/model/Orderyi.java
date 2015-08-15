package org.hch.yhw.auction.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Orderyi entity. @author MyEclipse Persistence Tools
 */

public class Orderyi implements java.io.Serializable {

	// Fields

	private Integer orderId;
	private AuctionUser auctionUser;
	private double summoney;
	private String realname;
	private String address;
	private String telphone;
	private String post;
	private Date createtime;
	private String model;
	private String message;
	private boolean cinfimsign;
	private boolean fukuansign;
	private boolean sign;
	private Set orderdetails = new HashSet();
    private String orderyiid;
	// Constructors

	/** default constructor */
	public Orderyi() {
	}

	/** minimal constructor */
	public Orderyi(AuctionUser auctionUser) {
		this.auctionUser = auctionUser;
	}

	/** full constructor */
	public Orderyi(AuctionUser auctionUser, double summoney, String realname,
			String address, String telphone, String post, Date createtime,
			String model, String message, boolean sign, Set orderdetails) {
		this.auctionUser = auctionUser;
		this.summoney = summoney;
		this.realname = realname;
		this.address = address;
		this.telphone = telphone;
		this.post = post;
		this.createtime = createtime;
		this.model = model;
		this.message = message;
		this.sign = sign;
		this.orderdetails = orderdetails;
	}

	// Property accessors

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public AuctionUser getAuctionUser() {
		return this.auctionUser;
	}

	public void setAuctionUser(AuctionUser auctionUser) {
		this.auctionUser = auctionUser;
	}

	public double getSummoney() {
		return this.summoney;
	}

	public void setSummoney(double summoney) {
		this.summoney = summoney;
	}

	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelphone() {
		return this.telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getPost() {
		return this.post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

       public boolean getCinfimsign() {
		return cinfimsign;
	}

	public void setCinfimsign(boolean cinfimsign) {
		this.cinfimsign = cinfimsign;
	}

	public boolean getFukuansign() {
		return fukuansign;
	}

	public void setFukuansign(boolean fukuansign) {
		this.fukuansign = fukuansign;
	}

	public boolean getSign() {
		return this.sign;
	}

	public void setSign(boolean sign) {
		this.sign = sign;
	}

	public Set getOrderdetails() {
		return this.orderdetails;
	}

	public void setOrderdetails(Set orderdetails) {
		this.orderdetails = orderdetails;
	}

	public String getOrderyiid() {
		return orderyiid;
	}

	public void setOrderyiid(String orderyiid) {
		this.orderyiid = orderyiid;
	}

}