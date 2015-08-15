<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@taglib prefix="s" uri="/struts-tags"%>



<!----------------------->




<table  width="766" cellspacing="0" cellpadding="0" border="0" align="center" bgColor="#FDB546">
<tr>

<td width="220" ><jsp:include page="member-left.jsp" flush="true"></jsp:include>
</td><td width="556"><table>
<!--收货人的基本信息 -->
<tr><td>订单号: <s:property value="%{memberOrderBean.orderyiBean.orderyiid}"/></td></tr>
<tr><td>收货人姓名: <s:property value="%{memberOrderBean.orderyiBean.realname}"/></td></tr>
<tr><td>地址: <s:property value="%{memberOrderBean.orderyiBean.address}"/></td></tr>
<tr><td>联系电话: <s:property value="%{memberOrderBean.orderyiBean.telphone}"/></td></tr>
<tr><td>邮编: <s:property value="%{memberOrderBean.orderyiBean.post}"/></td></tr>

<tr><td>配送模式: <s:property value="%{memberOrderBean.orderyiBean.model}"/></td></tr>
<tr><td>留言: <s:property value="%{memberOrderBean.orderyiBean.message}"/></td></tr>
<tr><td>总价: <s:property value="%{memberOrderBean.orderyiBean.summoney}"/></td></tr>


</table>
<table>
<!-- 购买的商品表单 -->
<tr>
<th>商品编号</th>
<th>商品名称</th>
<th>数量</th>
<th>单价</th>
<th>小计</th>
</tr>
<s:iterator id="memberOrderBean" value="memberOrderBean.odtList" status="st">
<tr>
<td><s:property value="id"/></td>
<td><s:property value="yiitem"/></td>
<td><s:property value="number"/></td>

<td><s:property value="price/number"/></td>
<td><s:property value="price"/></td>
</tr>
</s:iterator>

</table></td>
</tr>
</table>








<!----------------------->
