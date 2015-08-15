package org.hch.yhw.auction.action;
import java.util.*;
import com.opensymphony.xwork2.*;

import org.hch.yhw.auction.action.base.BaseActionInterface;
import org.hch.yhw.auction.business.*;
import org.hch.yhw.auction.exception.AuctionException;
import org.hch.yhw.auction.model.*;
import org.hch.yhw.auction.service.AuctionManager;
public class ViewOrderDetailAction extends BaseActionInterface 
{
	private MemberOrderBean memberOrderBean;
	public MemberOrderBean getMemberOrderBean() {
		return memberOrderBean;
	}
	public void setMemberOrderBean(MemberOrderBean memberOrderBean) {
		this.memberOrderBean = memberOrderBean;
	}
/*	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	private int orderId;*/
	private String orderId;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String execute()throws Exception
	{
		
		if(mgrOrder==null){System.out.println("mgrto为空");}
		System.out.println("开始执行");
		setMemberOrderBean(mgrOrder.findOrderByOrderyiid(orderId));
		return SUCCESS;
	}

	

}


