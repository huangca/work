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

<html >
<head>
<title>��������е���Ʒ</title>
</head>
<body>
<table width="560" align="center" cellspacing="0">
<tr>
<td>
<br />
<s:actionerror/></td>
</tr>

<s:iterator id="item" value="items" status="st">
<table width="200" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td rowspan="7"><img src=""/>picture</td>
    <td>��Ʒ����<s:property value="name"/></td>
  </tr>
  <tr>
   <td>����ʱ�䣺<s:property value="addTime"/></td>
  </tr>
  <tr>
  <td>��߼۸�<s:property value="maxPrice"/></td>
  </tr>
  <tr>
    <td>���<s:property value="kind"/></td>
  </tr>
  <tr>
 <td>ģʽ������</td>
  </tr>
  <tr>
 <td>��Ʒ��ע��<s:property value="remark"/></td>
  </tr>
  <tr>
    <td><a href='userviewDetail.action?itemId=<s:property value="id"/>'>����</a> ��Ҫ����</td>
  </tr>
</table>
</s:iterator>


</table>
</body>
</html>