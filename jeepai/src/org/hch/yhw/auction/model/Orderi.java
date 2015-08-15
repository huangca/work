package org.hch.yhw.auction.model;

import java.util.Date;

/**
 * Orderi entity. @author MyEclipse Persistence Tools
 */

public class Orderi implements java.io.Serializable {

	// Fields

	private Integer id;
	private AuctionUser auctionUser;
	private Item item;
	private String orderiid;
	private String realname;
	private double summoney;
	private String address;
	private String telphone;
	private String post;
	private Date createtime;
	private String model;
	private String message;
	private boolean cinfimsign;
	private boolean fukuansign;
	private boolean sign;
	private Integer number;
	private double price;

	// Constructors

	/** default constructor */
	public Orderi() {
	}

	/** minimal constructor */
	public Orderi(AuctionUser auctionUser, Item item, String orderiid) {
		this.auctionUser = auctionUser;
		this.item = item;
		this.orderiid = orderiid;
	}

	/** full constructor */
	public Orderi(AuctionUser auctionUser, Item item, String orderiid,
			String realname, double summoney, String address, String telphone,
			String post, Date createtime, String model, String message,
			boolean cinfimsign, boolean fukuansign, boolean sign,
			Integer number, double price) {
		this.auctionUser = auctionUser;
		this.item = item;
		this.orderiid = orderiid;
		this.realname = realname;
		this.summoney = summoney;
		this.address = address;
		this.telphone = telphone;
		this.post = post;
		this.createtime = createtime;
		this.model = model;
		this.message = message;
		this.cinfimsign = cinfimsign;
		this.fukuansign = fukuansign;
		this.sign = sign;
		this.number = number;
		this.price = price;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AuctionUser getAuctionUser() {
		return this.auctionUser;
	}

	public void setAuctionUser(AuctionUser auctionUser) {
		this.auctionUser = auctionUser;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getOrderiid() {
		return this.orderiid;
	}

	public void setOrderiid(String orderiid) {
		this.orderiid = orderiid;
	}

	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public double getSummoney() {
		return this.summoney;
	}

	public void setSummoney(double summoney) {
		this.summoney = summoney;
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
		return this.cinfimsign;
	}

	public void setCinfimsign(boolean cinfimsign) {
		this.cinfimsign = cinfimsign;
	}

	public boolean getFukuansign() {
		return this.fukuansign;
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

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}