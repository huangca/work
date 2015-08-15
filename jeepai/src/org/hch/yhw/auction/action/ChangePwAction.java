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
		//ǿ��ϵͳ�����ɵ������֤��ʧЧ
		session.put("rand" , null);
		String username = (String)session.get("username");
		//����û��������֤����ϵͳ�����������֤����ͬ
		if (vercode.equals(ver2))
		{
		boolean b1= mgr.checkPw(username, opassword, npassword);
		if(b1==true){
			session.put("username", null);
			return SUCCESS;
		}
		else{
			addActionError("ԭ�������");
			return INPUT;
		}
		}
		else
		{
			addActionError("��֤�벻ƥ��,����������");
			return INPUT;
		}
	}
	
}
