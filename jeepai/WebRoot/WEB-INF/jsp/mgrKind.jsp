<%--
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
--%>

<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>



<table width="556" align="center" 
	cellspacing="0" >
<tr>
<td>
<br />

</td>
</tr>
<tr>
<td>
<br />
<h3>添加新种类</h3>
<div align="center">
<s:actionerror cssClass="error"/>
<s:form action="adminproAddKind" validate="true">
<s:textfield name="name" label="种类名" required="true"/>
<s:textfield name="desc" label="种类描述" required="true"/>
<s:select name="bigkind" list="bigkinds" listValue="bigkindname" label="选择大类" listKey="bigkindId"></s:select>
<s:textfield name="vercode" label="验证码" required="true"/>
<s:submit value="添加"/>
</s:form>
验证码：<img name="d" src="authImg.jpg">
</div>
</td>
</tr>
</table>


