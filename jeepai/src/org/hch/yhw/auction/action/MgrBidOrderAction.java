package org.hch.yhw.auction.action;

import java.util.List;
import java.util.Map;


import org.hch.yhw.auction.action.base.BaseAction;
import org.hch.yhw.auction.business.OrderiBean;

import com.opensymphony.xwork2.ActionContext;
/**
 * Description:
 * <br/>地址: <a href="http://www.sise.com.cn">华软高效</a> 
 * <br/>Copyright (C), 2010-201?   余宏伟
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:20100301-20100401
 * @author   余宏伟
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

/**管理员的操作方法 删除此赢取记录  */
public String cancelOrderi(){	
	//删除
	System.out.println("订单号"+orderiBean.getOrderId());
	mgr.deleteOrderi(orderiBean.getOrderId());
	
	return SUCCESS;
}
/**
 * 管理员查看的赢取者订单
 * */
public String viewOrderis(){
    setOrderiBeans(mgr.findAllOrderis());
	return SUCCESS;
}
/**
 * 会员查看自己的赢取订单
 * */
public String viewSelfOrderi(){
	Map session =ActionContext.getContext().getSession();
    Integer winer=(Integer)session.get("userId");
    try{setOrderiBeans(mgr.getOrderiByMember(winer));}catch(Exception e){
    	System.out.println("mgr.getOrderiByMember(winer)异常");
    }
	return SUCCESS;
}
/**
 * 会员付款
 * */

public String jingPaiPay(){
	System.out.println("竞拍订单号"+orderiBean.getOrderId());
	mgr.updateOrderiFukuanSign(orderiBean.getOrderId());
	return SUCCESS;
}
/**
 * 店家发货
 * */
public String jingpaiSend(){
	mgr.updateOrderiSign(orderiBean.getOrderId());
	return SUCCESS;
}
/**
 * 会员确认自己的赢取订单
 * */
public String jingpaiConfirm(){

    mgr.updateOrderiCinSign(orderiBean);
	return SUCCESS;
}
/**
 * 查看赢取订单的明细
 * */
public String viewOrderioneDetail(){
	
	setOrderiBean(mgr.getOrderiByOrderId(orderiBean.getOrderId()));
	return SUCCESS;
}


}
