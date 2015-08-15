package org.hch.yhw.auction.business;

import java.util.List;

public class MemberOrderBean {
private OrderyiBean orderyiBean;
private List<OrderdetailBean> odtList;


public MemberOrderBean() {
	super();
}
public OrderyiBean getOrderyiBean() {
	return orderyiBean;
}
public void setOrderyiBean(OrderyiBean orderyiBean) {
	this.orderyiBean = orderyiBean;
}
public List<OrderdetailBean> getOdtList() {
	return odtList;
}
public void setOdtList(List<OrderdetailBean> odtList) {
	this.odtList = odtList;
}

}
