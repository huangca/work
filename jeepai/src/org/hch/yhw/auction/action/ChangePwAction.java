package org.hch.yhw.auction.action;
import java.util.*;

import com.opensymphony.xwork2.ActionContext;

import org.hch.yhw.auction.service.AuctionManager;
import org.hch.yhw.auction.exception.AuctionException;
import org.hch.yhw.auction.action.base.BaseAction;
public class ChangePwAction extends BaseAction{

	public String getOpassword() {
		return opassword;
	}
	public void setOpassword(String opassword) {
		this.opassword = opassword;
	}
	public String getNpassword() {
		return npassword;
	}
	public void setNpassword(String npassword) {
		this.npassword = npassword;
	}
	public String getVercode() {
		return vercode;
	}
	public void setVercode(String vercode) {
		this.vercode = vercode;
	}
	public String getAgainpassword() {
		return againpassword;
	}
	public void setAgainpassword(String againpassword) {
		this.againpassword = againpassword;
	}
	private String opassword;
	private String npassword;
	private String againpassword;
	
	private String vercode;
	public String execute() throws Exception
	{
		Map session = ActionContext.getContext().getSession();
		String ver2 = (String)session.get("rand");
		//强制系统刚生成的随机验证码失效
		session.put("rand" , null);
		String username = (String)session.get("username");
		//如果用户输入的验证码与系统随机产生的验证码相同
		if (vercode.equals(ver2))
		{
		boolean b1= mgr.checkPw(username, opassword, npassword);
		if(b1==true){
			session.put("username", null);
			return SUCCESS;
		}
		else{
			addActionError("原密码错误");
			return INPUT;
		}
		}
		else
		{
			addActionError("验证码不匹配,请重新输入");
			return INPUT;
		}
	}
	
}
