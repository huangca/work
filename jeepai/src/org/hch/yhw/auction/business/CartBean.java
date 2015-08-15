package org.hch.yhw.auction.business;
import java.io.Serializable;
public class CartBean {
private String picname;
private Integer yiitemId;
private String yiitemName;
private String itemmode;
private double initpiece;
private int number;
private double totalmoney;
public CartBean(){}

public CartBean(String picname, Integer yiitemId, String yiitemName,
		String itemmode, double initpiece, int number, double totalmoney) {

	this.picname = picname;
	this.yiitemId = yiitemId;
	this.yiitemName = yiitemName;
	this.itemmode = itemmode;
	this.initpiece = initpiece;
	this.number = number;
	this.totalmoney = totalmoney;
}

public String getPicname() {
	return picname;
}
public void setPicname(String picname) {
	this.picname = picname;
}
public Integer getYiitemId() {
	return yiitemId;
}
public void setYiitemId(Integer yiitemId) {
	this.yiitemId = yiitemId;
}
public String getYiitemName() {
	return yiitemName;
}
public void setYiitemName(String yiitemName) {
	this.yiitemName = yiitemName;
}
public String getItemmode() {
	return itemmode;
}
public void setItemmode(String itemmode) {
	this.itemmode = itemmode;
}
public double getInitpiece() {
	return initpiece;
}
public void setInitpiece(double initpiece) {
	this.initpiece = initpiece;
}
public int getNumber() {
	return number;
}
public void setNumber(int number) {
	this.number = number;
}
public double getTotalmoney() {
	return totalmoney;
}
public void setTotalmoney(double totalmoney) {
	this.totalmoney = totalmoney;
}

@Override
public boolean equals(Object obj) {
	// TODO Auto-generated method stub
	CartBean cartBeanObj=(CartBean)obj;
	if(cartBeanObj.getYiitemId().intValue()==this.getYiitemId().intValue()){
		return true;
	}else
		return false;
}

}
