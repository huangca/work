<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>



<script language="JavaScript" type="text/JavaScript"> 
function changTempValue() { 
var tf=document.forms["viewSortForm"];
tf.action="mgrOrder.action";
tf.submit();
} 
</script>
<table align="center" width="556" cellspacing="0" cellpadding="0">
<tr><td>
<form name="viewSortForm"  method="post" >
<s:select list="#{'1':'未处理','2':'已发货'}" label="订单分类" name="sign"
 headerKey="0"  headerValue="--全部--" onchange="changTempValue()"/>
</form>
</td></tr></table>

<br />
<s:actionerror/>
<!-- 订单输出 -->

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
    <td align="center">发货</td>
	<td align="center">动作22</td>
  </tr>
<s:iterator id="orderyi" value="order" status="st">

<tr>
<td ><a href='adminviewOrderDetailBack.action?orderId=<s:property value="orderyiid"/>'>
<s:property value="orderyiid"/></a></td>

<td ><s:property value="realname"/></td>
<td ><s:property value="address"/></td>
<td ><s:property value="post"/></td>
<td >

<s:date name="createtime"  format="yyyy-MM-dd HH:mm:ss"/></td>
<td ><s:property value="summoney"/></td>
<!--<s:property value="createtime"/>
 <td><s:if test="cinfimsign==0" ><a href="#">未确认</a></s:if><s:else>以确认</s:else></td>

<td><s:if test="sign==0" >未发货</s:if><s:else>已发货</s:else></td>
cinfimsign==1 表示订单已确认，可以付款了
<td><s:if test="cinfimsign==1" ><a href="#">付款</a></s:if><s:else>未付款</s:else></td>
fukuansign==0 表示订单未付款，可以删除了
<td><s:if test="fukuansign==0" ><a href='cancelOrder.action?orderId=<s:property value="orderId"/>'>
<img src="images/b-delete.gif"/></a></s:if><s:elseif test="fukuansign==1"><img src="images/standard_msg_ok.gif"/></s:elseif><s:else>操作不能</s:else></td>
-->
<td><s:if test="cinfimsign==0" ><a href='adminconfimOrder.action?orderId=<s:property value="orderyiid"/>'>确认</a></s:if><s:else>已确认</s:else></td>
<td ><s:if test="fukuansign==0" >未付款</s:if><s:else>已付款</s:else></td>
<td ><s:if test="fukuansign==1&&cinfimsign==1&&sign==0" ><a href='adminSendOrder.action?orderId=<s:property value="orderyiid"/>'>
发货</a></s:if><s:elseif test="sign==0">未发货</s:elseif> <s:else>已发货  </s:else></td>
<td><s:if test="fukuansign==0" ><a href='admincancelOrder.action?orderId=<s:property value="orderyiid"/>'>
<img src="images/b-delete.gif"/></a>
</s:if> <s:else><img src="images/standard_msg_ok.gif"/></s:else></td>
</tr>
</s:iterator>
</table>



