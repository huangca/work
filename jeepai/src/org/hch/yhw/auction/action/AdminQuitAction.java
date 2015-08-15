package org.hch.yhw.auction.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class AdminQuitAction {
public String execute(){
	
	Map session =ActionContext.getContext().getSession();
	session.put("adminId",null);
	return "success";
}
}
