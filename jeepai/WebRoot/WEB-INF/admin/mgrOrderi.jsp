<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@taglib prefix="s" uri="/struts-tags"%>

    


    
 <table border="1" align="center" width="556" cellpadding="0" cellspacing="0">
  <tr >
    <td align="center">订单号</td>
    <td align="center">收件人姓名</td>
    <td align="center">地址</td>
    <td align="center">邮编</td>
    <td align="center">订单生成时间</td>
    <td align="center">总价</td>
    <td align="center">订单确认</td>
    <td align="center">付款确认</td>
    <td align="center">发货处理</td>
	<td align="center">动作</td>
  </tr>
  
  <s:iterator id="orderiBean" value="orderiBeans" status="st">
 <tr>
<td ><a href='adminviewOrderiDetailBack.action?orderiBean.orderId=<s:property value="orderId"/>'>
<s:property value="orderId"/></a></td>

<td ><s:property value="realname"/></td>
<td ><s:property value="address"/></td>
<td ><s:property value="post"/></td>
<td >

<s:date name="createtime"  format="yyyy-MM-dd HH:mm:ss"/></td>
<td ><s:property value="summoney"/></td>
<!-- 对于竞拍来说确认由用户者来确认并付款，而主控方则发送该商品 -->
<td><s:if test="cinfimsign==0" >未确认</s:if><s:else>已确认</s:else></td>
<td ><s:if test="fukuansign==0" >未付款</s:if><s:else>已付款</s:else></td>
<td ><s:if test="fukuansign==1&&cinfimsign==1&&sign==0" ><a href='adminSendOrderi.action?orderiBean.orderId=<s:property value="orderId"/>'>
发货</a></s:if><s:elseif test="sign==0">未发货</s:elseif> <s:else>已发货  </s:else></td>
<td><s:if test="fukuansign==0" ><a href='admincancelOrderi.action?orderiBean.orderId=<s:property value="orderId"/>'>
<img src="images/b-delete.gif"/></a>
</s:if> <s:else><img src="images/standard_msg_ok.gif"/></s:else></td>
</tr>
  </s:iterator>
 </table>
    
    
    
    
    

