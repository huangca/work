package org.hch.yhw.auction.action;

import java.util.List;
import java.util.Map;


import org.hch.yhw.auction.action.base.BaseAction;
import org.hch.yhw.auction.business.OrderiBean;

import com.opensymphony.xwork2.ActionContext;
/**
 * Description:
 * <br/>��ַ: <a href="http://www.sise.com.cn">�����Ч</a> 
 * <br/>Copyright (C), 2010-201?   ���ΰ
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:20100301-20100401
 * @author   ���ΰ
 * @version  1.0
 */
public class MgrBidOrderAction extends BaseAction{
private OrderiBean orderiBean;
private List<OrderiBean> orderiBeans;
public OrderiBean getOrderiBean() {
	return orderiBean;
}
public List<OrderiBean> getOrderiBeans() {
	return orderiBeans;
}
public void setOrderiBean(OrderiBean orderiBean) {
	this.orderiBean = orderiBean;
}
public void setOrderiBeans(List<OrderiBean> orderiBeans) {
	this.orderiBeans = orderiBeans;
}

/**����Ա�Ĳ������� ɾ����Ӯȡ��¼  */
public String cancelOrderi(){	
	//ɾ��
	System.out.println("������"+orderiBean.getOrderId());
	mgr.deleteOrderi(orderiBean.getOrderId());
	
	return SUCCESS;
}
/**
 * ����Ա�鿴��Ӯȡ�߶���
 * */
public String viewOrderis(){
    setOrderiBeans(mgr.findAllOrderis());
	return SUCCESS;
}
/**
 * ��Ա�鿴�Լ���Ӯȡ����
 * */
public String viewSelfOrderi(){
	Map session =ActionContext.getContext().getSession();
    Integer winer=(Integer)session.get("userId");
    try{setOrderiBeans(mgr.getOrderiByMember(winer));}catch(Exception e){
    	System.out.println("mgr.getOrderiByMember(winer)�쳣");
    }
	return SUCCESS;
}
/**
 * ��Ա����
 * */

public String jingPaiPay(){
	System.out.println("���Ķ�����"+orderiBean.getOrderId());
	mgr.updateOrderiFukuanSign(orderiBean.getOrderId());
	return SUCCESS;
}
/**
 * ��ҷ���
 * */
public String jingpaiSend(){
	mgr.updateOrderiSign(orderiBean.getOrderId());
	return SUCCESS;
}
/**
 * ��Աȷ���Լ���Ӯȡ����
 * */
public String jingpaiConfirm(){

    mgr.updateOrderiCinSign(orderiBean);
	return SUCCESS;
}
/**
 * �鿴Ӯȡ��������ϸ
 * */
public String viewOrderioneDetail(){
	
	setOrderiBean(mgr.getOrderiByOrderId(orderiBean.getOrderId()));
	return SUCCESS;
}


}
