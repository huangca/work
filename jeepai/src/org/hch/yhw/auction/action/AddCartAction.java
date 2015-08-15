package org.hch.yhw.auction.action;

import java.util.ArrayList;
import java.util.Map;



import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


import org.hch.yhw.auction.action.base.BaseAction;
import org.hch.yhw.auction.business.*;
import org.hch.yhw.auction.service.AuctionManagerToYiItem;
import java.util.*;
public class AddCartAction extends BaseAction {
private int number;//���������
private int itemId;//���ݵ�ĳ����Ʒ��id;
private List<CartBean> fromList;
//private AuctionManagerToYiItem mgryiItem;
@Override
public String execute()  throws Exception{
	// TODO Auto-generated method stub
	
	//���ж�һ��itemId��number��ȷ��

	System.out.println("number ��ֵ��AddCartActionΪ"+number);
    
	Map session = ActionContext.getContext().getSession();
	fromList=(List<CartBean>)session.get("fromList");
	if(fromList==null){
		fromList=new ArrayList<CartBean>();
		}
	  if(number<=0&&itemId<=0){
    	return SUCCESS;
    }
	  
	  if(number<=0){
	    	
	    	double summomey=mgryiItem.summomey(fromList);
	    	session.put("summoney", summomey);
	    	return SUCCESS;
	  }

	fromList=mgryiItem.putCartBeans(number, itemId, fromList);

	double summomey=mgryiItem.summomey(fromList);

	setFromList(fromList);
	session.put("fromList", fromList);
	session.put("summoney",new Double(summomey));

	return SUCCESS;
}
//����֤�û���½�Ƿ�

public List<CartBean> getFromList() {
	return fromList;
}

public void setFromList(List<CartBean> fromList) {
	this.fromList = fromList;
}



public int getNumber() {
	return number;
}
public void setNumber(int number) {
	this.number = number;
}
public int getItemId() {
	return itemId;
}
public void setItemId(int itemId) {
	this.itemId = itemId;
}

/*
 * ͨ�����ID���������Ʒ�������Ϣ�������б����
 * session.put("cartgoodlist",cartgoods);
 * */
	
	
	
}
