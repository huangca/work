package org.hch.yhw.auction.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Item entity. @author MyEclipse Persistence Tools
 */

public class Item implements java.io.Serializable {

	// Fields

	private Integer id;
	private Admin owner;
	private State itemState;
	private AuctionUser winer;
	private Kind kind;
	private Bigkind bigkind;
	private String itemRemark;
	private String itemName;
	private String itemDesc;
	private Date addtime;
	private Date endtime;
	private double initPrice;
	private double maxPrice;
	private float zengfu;//要求竞拍增幅多大
	private String picname;
	private Set<Bid> bids = new HashSet<Bid>();
	private Set<Orderi> orderis = new HashSet<Orderi>();

	 

	// Constructors

	/** default constructor */
	public Item() {
	}

	/** full constructor */
	//初始化全部基本属性的构造器
	public Item(Integer id , String itemRemark , String itemName , 
		String itemDesc , Date addtime , Date endtime , 
		double initPrice , double maxPrice , Admin owner)
	{
		this.id = id;
		this.itemRemark = itemRemark;
		this.itemName = itemName;
		this.itemDesc = itemDesc;
		this.addtime = addtime;
		this.endtime = endtime;
		this.initPrice = initPrice;
		this.maxPrice = maxPrice;
		this.owner = owner;
	}
	// Property accessors

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Bigkind getBigkind() {
		return bigkind;
	}

	public void setBigkind(Bigkind bigkind) {
		this.bigkind = bigkind;
	}

	public Admin getOwner() {
		return owner;
	}

	public void setOwner(Admin owner) {
		this.owner = owner;
	}

	public State getItemState() {
		return itemState;
	}

	public void setItemState(State itemState) {
		this.itemState = itemState;
	}

	public AuctionUser getWiner() {
		return winer;
	}

	public void setWiner(AuctionUser winer) {
		this.winer = winer;
	}

	public Kind getKind() {
		return kind;
	}

	public void setKind(Kind kind) {
		this.kind = kind;
	}

	public String getItemRemark() {
		return itemRemark;
	}

	public void setItemRemark(String itemRemark) {
		this.itemRemark = itemRemark;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public double getInitPrice() {
		return initPrice;
	}

	public void setInitPrice(double initPrice) {
		this.initPrice = initPrice;
	}

	public double getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}

	public float getZengfu() {
		return zengfu;
	}

	public void setZengfu(float zengfu) {
		this.zengfu = zengfu;
	}

	public String getPicname() {
		return picname;
	}

	public void setPicname(String picname) {
		this.picname = picname;
	}

	public Set<Bid> getBids() {
		return bids;
	}

	public void setBids(Set<Bid> bids) {
		this.bids = bids;
	}

	public Set<Orderi> getOrderis() {
		return orderis;
	}

	public void setOrderis(Set<Orderi> orderis) {
		this.orderis = orderis;
	}




}