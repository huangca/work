package org.hch.yhw.auction.model;

/**
 * Orderdetail entity. @author MyEclipse Persistence Tools
 */

public class Orderdetail implements java.io.Serializable {

	// Fields

	private Integer id;
	private YiItem yiitem;
	private Orderyi orderyi;
	private int number;
	private double price;

	// Constructors

	/** default constructor */
	public Orderdetail() {
	}

	/** minimal constructor */
	public Orderdetail(YiItem yiitem, Orderyi orderyi, int number) {
		this.yiitem = yiitem;
		this.orderyi = orderyi;
		this.number = number;
	}

	/** full constructor */
	public Orderdetail(YiItem yiitem, Orderyi orderyi, int number,
			double price) {
		this.yiitem = yiitem;
		this.orderyi = orderyi;
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

	public YiItem getYiitem() {
		return this.yiitem;
	}

	public void setYiitem(YiItem yiitem) {
		this.yiitem = yiitem;
	}

	public Orderyi getOrderyi() {
		return this.orderyi;
	}

	public void setOrderyi(Orderyi orderyi) {
		this.orderyi = orderyi;
	}

	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}