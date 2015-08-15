package org.hch.yhw.auction.model;

import java.util.HashSet;
import java.util.Set;

/**
 * AuctionUser entity. @author MyEclipse Persistence Tools
 */

public class AuctionUser implements java.io.Serializable {

	// Fields

	private Integer id;
	private String username;
	private String realName;
	private String userpass;
	private String email;
	private String postcode;
	private String address;
	private String telphone;
	private Integer questionid;
	private String answer;
	private Set orderyis = new HashSet();
	private Set<Bid>  bids = new HashSet<Bid>();
	private Set<Item> itemsByWiner = new HashSet<Item>();
	private Set<Orderi> orderis = new HashSet<Orderi>();
	// Constructors

	/** default constructor */
	public AuctionUser() {
	}

	/** minimal constructor */
	public AuctionUser(String username, String realName, String userpass,
			String address, String telphone) {
		this.username = username;
		this.realName = realName;
		this.userpass = userpass;
		this.address = address;
		this.telphone = telphone;
	}

	/** full constructor */
	public AuctionUser(String username, String realName, String userpass,
			String email, String postcode, String address, String telphone,
			Integer questionid, String answer) {
		this.username = username;
		this.realName = realName;
		this.userpass = userpass;
		this.email = email;
		this.postcode = postcode;
		this.address = address;
		this.telphone = telphone;
		this.questionid = questionid;
		this.answer = answer;

	}

	// Property accessors

	

	public String getUsername() {
		return this.username;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getUserpass() {
		return this.userpass;
	}

	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
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

	public Integer getQuestionid() {
		return this.questionid;
	}

	public void setQuestionid(Integer questionid) {
		this.questionid = questionid;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Set getOrderyis() {
		return this.orderyis;
	}

	public void setOrderyis(Set orderyis) {
		this.orderyis = orderyis;
	}

	public Set<Bid> getBids() {
		return bids;
	}

	public void setBids(Set<Bid> bids) {
		this.bids = bids;
	}

	public Set<Item> getItemsByWiner() {
		return itemsByWiner;
	}

	public void setItemsByWiner(Set<Item> itemsByWiner) {
		this.itemsByWiner = itemsByWiner;
	}

	public Set<Orderi> getOrderis() {
		return orderis;
	}

	public void setOrderis(Set<Orderi> orderis) {
		this.orderis = orderis;
	}




}