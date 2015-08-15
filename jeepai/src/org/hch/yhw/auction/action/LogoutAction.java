package org.hch.yhw.auction.action;

import java.util.Map;

import org.hch.yhw.auction.action.base.BaseAction;

import com.opensymphony.xwork2.ActionContext;

public class LogoutAction extends BaseAction{
	@Override
	public String execute() throws Exception
	{
		Map session = ActionContext.getContext().getSession();
  //   	session.clear();(String )session.get("rand")
		System.out.println("Session username"+session.get("username"));
		session.put("userId" , null);
		session.put("username" , null);
		session.put("fromList" , null);
		session.put("summoney" , 0);
		return SUCCESS;
	}
}
