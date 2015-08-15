package org.hch.yhw.auction.action;
import java.util.*;
import com.opensymphony.xwork2.*;

import org.hch.yhw.auction.action.base.BaseAction;
import org.hch.yhw.auction.business.*;
import org.hch.yhw.auction.dao.OrderyiDao;
import org.hch.yhw.auction.exception.AuctionException;
import org.hch.yhw.auction.model.*;
import org.hch.yhw.auction.service.AuctionManager;
public class AdminSendOrderAction extends BaseAction {
	private String orderId;
/*
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}*/
	
	
	
	public String execute()throws Exception
	{
		
		Orderyi orderyi=mgrOrder.getOrderByOrderyiid(orderId);
		orderyi.setSign(true);
		mgrOrder.updateOrderyi(orderyi);
		return SUCCESS;
		
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	//确认订单
	public String confimOrderyi()throws Exception
	{
		
		Orderyi orderyi=mgrOrder.getOrderByOrderyiid(orderId);
		orderyi.setCinfimsign(true);
		mgrOrder.updateOrderyi(orderyi);
		return SUCCESS;
		
	}
	//删除订单
	public String cancelOrderyi()throws Exception
	{
		

		mgrOrder.deleteOrderyiByModel(orderId);
		return SUCCESS;
		
	}

	//付款
	public String payoffOrderyi()throws Exception
	{
		
		Orderyi orderyi=mgrOrder.getOrderByOrderyiid(orderId);
		orderyi.setFukuansign(true);
		mgrOrder.updateOrderyi(orderyi);
		return SUCCESS;
		
	}
}
