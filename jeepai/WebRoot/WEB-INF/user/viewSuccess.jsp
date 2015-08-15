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



<!----------------------->




<table  width="766" cellspacing="0" cellpadding="0" border="0" align="center" >
<tr>

<td width="220" bgColor="#FDB546">
<jsp:include page="member-left.jsp" flush="true"></jsp:include>
</td><td width="546" valign="top" bgColor="#FDB546">

<table width="556" border="1" align="center" cellpadding="0" cellspacing="0"  style="border:1px solid red ">
 <tr>
     <td  colspan="10" align="center">您所赢取的商品：</td></tr>
  <tr>
     <td width="60" align="center">订单号</td>
    <td width="60" align="center">商品名字</td>
    <td width="60" align="center">收货人</td>
    <td width="60" align="center">出价</td>
    <td width="60" align="center">订单价格</td>
    <td width="60" align="center">是否确认</td>
    <td width="60" align="center">是否付款</td>
    <td width="60" align="center">是否到货</td>
    <td width="60" align="center">操作</td>
  </tr>
   <s:iterator value="orderiBeans" id="orderiBean" status="st">
<tr  height="24" <s:if test="#st.odd">
	style="background-color:#dddddd"</s:if>
<s:else>style="background-color:#eeeeee"</s:else>>
     <td><a href='userviewOrderidetail.action?orderiBean.orderId=<s:property value="orderId"/>'><s:property value="orderId"/></a></td>
    <td><s:property value="item"/></td>
    <td><s:property value="realname"/></td>
    <td><s:property value="price"/></td>
    <td><s:property value="summoney"/></td>
<td><s:if test="cinfimsign==0" ><a href='userviewOrderidetail.action?orderiBean.orderId=<s:property value="orderId"/>'>确认</a></s:if><s:else>已确认</s:else></td>
<td><s:if test="cinfimsign==1&&fukuansign==0" ><a href='userpayoffOrderi.action?orderiBean.orderId=<s:property value="orderId"/>'>付款</a></s:if>
<s:elseif test="cinfimsign==1&&fukuansign==1">已付款</s:elseif>
<s:else>未付款</s:else></td>
<td ><s:if test="sign==1">已发货</s:if><s:else>未发货 </s:else></td>
<td><s:if test="fukuansign==0" ><a href='usercancelOrderi.action?orderiBean.orderId=<s:property value="orderId"/>'>
<img src="images/b-delete.gif"/></a>
</s:if> <s:else><img src="images/standard_msg_ok.gif"/></s:else></td>
</tr>
</s:iterator>
</table>
</td>
</tr>
</table>









<!----------------------->
