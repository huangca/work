<%--
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
--%>

<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>ѡ����Ʒ����</title>
</head>
<body>
<table width="560" align="center" cellspacing="0">
<tr>
<td>
<s:actionerror/>
<table width="80%" align="center" cellpadding="0"
	cellspacing="1" style="border:1px solid black">
<tr>
	<td colspan="4"><div class="mytitle">��ѡ����Ҫ�������Ʒ����</div></td> 
</tr>
<s:iterator id="kind" value="kinds" status="st">
<tr height="24" <s:if test="#st.odd">
	style="background-color:#dddddd"</s:if>
	<s:else>style="background-color:#eeeeee"</s:else>>
<td>������</td>
<td><a href='userviewItem.action?kindId=<s:property value="id"/>'>
<s:property value="kindName"/></a></td>
</tr>
<tr height="24" <s:if test="#st.odd">
	style="background-color:#dddddd"</s:if>
	<s:else>style="background-color:#eeeeee"</s:else>>
<td>��������</td>
<td><s:property value="kindDesc"/></td>
</tr>
</s:iterator>
</table>
</td>
</tr>
</table>
</body>
</html>