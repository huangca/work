package org.hch.yhw.auction.action;

import com.opensymphony.xwork2.ActionContext;

import java.util.*;
import org.hch.yhw.auction.action.base.BaseAction;
import org.hch.yhw.auction.exception.AuctionException;
import org.hch.yhw.auction.service.AuctionManager;
/**
 * Description:
 * <br/>��ַ: <a href="http://www.sise.com.cn">�����Ч</a> 
 * <br/>Copyright (C), 2010-201?, �Ʋӻ�   ���ΰ
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:20100301-20100401
 * @author  hch0612@scse.com.cn
 * @version  1.0
 */
public class LoginAction extends BaseAction
{
	private String username;
	private String password;
	//private String vercode;

	@Override
	public String execute() throws Exception
	{
		Map session = ActionContext.getContext().getSession();
	//	String ver2 = (String )session.get("rand");
		//����û�Session�������֤���ַ�����
	//	session.put("rand" , null);
	//	if (vercode.equalsIgnoreCase(ver2))
	//	{
			Integer userId = mgr.validLogin(username,password);
			if (userId != null && userId > 0)
			{
				session.put("userId" , userId);
				session.put("username" , username);
				return SUCCESS;
			}
			else
			{
				addActionError("�û���/���벻ƥ��");
				return "failure";
			}
		}
	//	else
	//	{
	//		addActionError("��֤�벻ƥ��,����������");
	//		return "failure";
	//	}
	//}
	

	//username���Ե�setter��getter����
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getUsername()
	{
		return this.username;
	}

	//password���Ե�setter��getter����
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getPassword()
	{
		return this.password;
	}

	//vercode���Ե�setter��getter����
	/*public void setVercode(String vercode)
	{
		this.vercode = vercode;
	}
	public String getVercode()
	{
		return this.vercode;
	}*/

}