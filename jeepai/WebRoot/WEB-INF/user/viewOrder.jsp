<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>



<!----------------------->






<table  width="766" cellspacing="0" cellpadding="0" border="0" align="center" bgColor="#FDB546">
<tr>

<td width="220" valign="top">
<jsp:include page="member-left.jsp" flush="true"></jsp:include>
</td><td width="556"><table width="556" align="center" cellspacing="0">
<tr>
<td valign="top">
<br />
<s:actionerror/>
<table border="1" align="center">

  <tr >
    <td>订单号</td>
    <td>收货人姓名</td>
   
    <td>生成时间</td>
    <td>总价</td>
    <td>订单确认</td>
    <td>到货确认</td>
    <td>付款确认</td>
    
     <td>操作</td>
  </tr>
<s:iterator id="orderyi" value="order" status="st">

<tr>
<td><a href='viewOrderDetail.action?orderId=<s:property value="orderyiid"/>'>
<s:property value="orderyiid"/></a></td>


<td><s:property value="post"/></td>
<td><s:date name="createtime" format="yyyy-MM-dd"/></td>
<td><s:property value="summoney"/></td>
<td><s:if test="cinfimsign==0" >未确认</s:if><s:else>已确认</s:else></td>

<td><s:if test="sign==0" >未发货</s:if><s:else>已发货</s:else></td>
<!--cinfimsign==1 表示订单已确认，可以付款了 -->
<td><s:if test="cinfimsign==1&&fukuansign==0" ><a href='payoffOrder.action?orderId=<s:property value="orderyiid"/>'>付款</a></s:if>
<s:elseif test="cinfimsign==1&&fukuansign==1">已付款</s:elseif>
<s:else>未付款</s:else></td>
<!--fukuansign==0 表示订单未付款，可以删除了 -->
<td><s:if test="fukuansign==0" ><a href='cancelOrder.action?orderId=<s:property value="orderyiid"/>'>
<img src="images/b-delete.gif"/></a></s:if><s:elseif test="sign==0"><img src="images/cannodo.gif"/></s:elseif><s:else><img src="images/standard_msg_ok.gif"/></s:else></td>
</tr>
</s:iterator>
</table>
</td>
</tr>
</table></td>
</tr>
</table>






<!----------------------->
