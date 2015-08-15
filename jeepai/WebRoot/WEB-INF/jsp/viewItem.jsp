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

<html >
<head>
<title>浏览拍卖中的物品</title>
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
    <td>物品名：<s:property value="name"/></td>
  </tr>
  <tr>
   <td>起拍时间：<s:property value="addTime"/></td>
  </tr>
  <tr>
  <td>最高价格：<s:property value="maxPrice"/></td>
  </tr>
  <tr>
    <td>类别：<s:property value="kind"/></td>
  </tr>
  <tr>
 <td>模式：竞拍</td>
  </tr>
  <tr>
 <td>物品备注：<s:property value="remark"/></td>
  </tr>
  <tr>
    <td><a href='userviewDetail.action?itemId=<s:property value="id"/>'>详情</a> 我要竞拍</td>
  </tr>
</table>
</s:iterator>


</table>
</body>
</html>