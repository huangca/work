package org.hch.yhw.auction.action;

import org.hch.yhw.auction.action.base.BaseAction;

public class UpdateorderyiAction extends BaseAction{
private Integer orderyi;//���������ID
private int number;//�ü�¼�µ�����
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
