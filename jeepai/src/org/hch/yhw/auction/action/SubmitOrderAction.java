package org.hch.yhw.auction.action;

import java.util.List;
import java.util.Map;

import org.hch.yhw.auction.action.base.BaseAction;
import org.hch.yhw.auction.business.*;
import org.hch.yhw.auction.tool.ModelTool;
import com.opensymphony.xwork2.ActionContext;

public class SubmitOrderAction extends BaseAction{
private OrderBean orderBean;
//��������
private String message;
//�������ͷ�ʽ	
private String model;
public OrderBean getOrderBean() {
	return orderBean;
}
public void setOrderBean(OrderBean orderBean) {
	this.orderBean = orderBean;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public String getModel() {
	return model;
}
public void setModel(String model) {
	this.model = model;
}
	
public String execute() throws Exception{
	
	try{
		System.out.println("����SubmitOrderAction");
	Map session = ActionContext.getContext().getSession();
	List<CartBean> fromList=(List<CartBean>)session.get("fromList");
	
	Integer useiId=(Integer)session.get("userId");
	double money=ModelTool.getModelMoney(getModel());
	double summoney=(Double)session.get("summoney");
	summoney+=money;//��ö����ܼ�
	orderBean.setCartBeanList(fromList);
	orderBean.setModel(model);
	orderBean.setMessage(message);
	orderBean.getMemberbean().setId(useiId);
	orderBean.setSummoney(summoney);
	System.out.println("��ʼ�־û�����");
mgrOrder.addOrderyiAtOneTime(orderBean);
     //int i=	mgrOrder.addOrderyiOnOrderBean(orderBean);
//
//	orderBean.setOrderid(new Integer(i));
	//mgrOrder.addOrderdetailOnOrderBean(orderBean);
	
	System.out.println("�־û��������");
	session.put("fromList", null);
	session.put("summoney",0);
	
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return SUCCESS;
}	


}
