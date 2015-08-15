package org.hch.yhw.auction.action;
import java.util.*;

import org.hch.yhw.auction.action.base.BaseAction;
import org.hch.yhw.auction.exception.AuctionException;
import org.hch.yhw.auction.service.AuctionManager;

import com.opensymphony.xwork2.ActionContext;
public class AdminLoginAction extends BaseAction {
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String execute() throws Exception
	{
		Map session = ActionContext.getContext().getSession();
	
		try{session.put("bigkinds", mgr.getAllBigKindNotOther());
		}catch (Exception e) {
		System.out.println("AdminLoginAction have error");
				}
		Integer userId=mgr.adminLogin(username, password);
		if (userId != null && userId > 0)
		{
			session.put("adminId" , userId);
			session.put("adminname" , username);
			return SUCCESS;
		}
		else {
			addActionError("用户名/密码不匹配");
			return INPUT;
		}
		
	}
	

}
