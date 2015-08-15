package org.hch.yhw.auction.action;

import org.hch.yhw.auction.action.base.BaseAction;

public class UpdateorderyiAction extends BaseAction{
private Integer orderyi;//订单详情的ID
private int number;//该记录下的数量
public Integer getOrderyi() {
	return orderyi;
}
public void setOrderyi(Integer orderyi) {
	this.orderyi = orderyi;
}
public int getNumber() {
	return number;
}
public void setNumber(int number) {
	this.number = number;
}

public String updateO(){
	mgrOrder.updateO(orderyi, number);
	return SUCCESS;
}
public String deleteO(){
	mgrOrder.deleteO(orderyi);
	return SUCCESS;
}
}
