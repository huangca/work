package org.hch.yhw.auction.action.interceptor;

import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.*;
import java.util.Map;

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
public class AuthorityInterceptor extends AbstractInterceptor
{
	//�����û�����
	public String intercept(ActionInvocation invocation) throws Exception
	{
		//ȡ�ø����û���HTTP Session
		Map session = ActionContext.getContext().getSession();
		Object userId = session.get("userId");
		//����û�Session��userId����Ϊnull�����û���δ��¼
		if (userId == null)
		{
			return "login";
		}
		//���򣬼���ִ��Ŀ��Action��execute����
		else
		{
			return invocation.invoke();
		}
	}
}