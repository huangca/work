package org.hch.yhw.auction.action.interceptor;

import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.*;
import java.util.Map;

/**
 * Description:
 * <br/>地址: <a href="http://www.sise.com.cn">华软高效</a> 
 * <br/>Copyright (C), 2010-201?, 黄灿华   余宏伟
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:20100301-20100401
 * @author  hch0612@scse.com.cn
 * @version  1.0
 */
public class AuthorityInterceptor extends AbstractInterceptor
{
	//拦截用户请求
	public String intercept(ActionInvocation invocation) throws Exception
	{
		//取得跟踪用户的HTTP Session
		Map session = ActionContext.getContext().getSession();
		Object userId = session.get("userId");
		//如果用户Session中userId属性为null，即用户还未登录
		if (userId == null)
		{
			return "login";
		}
		//否则，继续执行目标Action的execute方法
		else
		{
			return invocation.invoke();
		}
	}
}