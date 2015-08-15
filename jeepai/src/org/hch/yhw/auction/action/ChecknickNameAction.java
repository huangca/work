package org.hch.yhw.auction.action;

import java.io.IOException;

import org.hch.yhw.auction.action.base.BaseAction;
import org.hch.yhw.auction.dao.AuctionUserDao;
import org.hch.yhw.auction.dao.impl.AuctionUserDaoHibernate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.*;
import org.apache.struts2.ServletActionContext;
public class ChecknickNameAction extends BaseAction {
private HttpServletRequest request;
private HttpServletResponse response;

public String execute(){
	
	request=ServletActionContext.getRequest();
	String nickname=request.getParameter("nickname");
	System.out.println("nickname====="+nickname);
	 int result=0;
	try{if(auserMgr.findAuctionUserByUserName(nickname)){
		 //该用户名字存在
		result=1;
	}
	
	}catch (Exception e) {
		e.printStackTrace();
		// TODO: handle exception
	}
	String resultXML=toXml(result);
	response=ServletActionContext.getResponse();
	
	response.setContentType("text/xml");
	try {
		response.getWriter().write(resultXML);
		System.out.print(resultXML);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	//返回NULL为必要
	return null;
}
public boolean check(String username){
	AuctionUserDao userDao=new AuctionUserDaoHibernate();
	return	userDao.isExctUser(username);
	}

public String toXml(int result)
{
	StringBuffer xmlDoc = new StringBuffer();
	xmlDoc.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
	
	
		xmlDoc.append("<NICKNAME>\n");
	   //设置返回内容
		xmlDoc.append("<IsUse>\n");
		xmlDoc.append(result);
		xmlDoc.append("</IsUse>\n");
		xmlDoc.append("</NICKNAME>\n");

	return xmlDoc.toString();

}

	
	
}
