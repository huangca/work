<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@taglib prefix="s" uri="/struts-tags"%>

>
<!------------------------------------->



 <table width="556" align="center">
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
<th>操作</th>
</tr>
<s:iterator id="memberOrderBean" value="memberOrderBean.odtList" status="st">
<s:form action="adminupdateorderyiaction">
<tr>
<td width="50"><s:hidden name="orderyi" value="%{orderyi}"/><s:property value="id"/></td>
<td width="60"><s:property value="yiitem"/></td>
<td width="20"><s:textfield theme="simple" name="number" value="%{number}" size="2"/></td>
<td width="30"><s:property value="price/number"/></td>
<td width="50"><s:property value="price"/></td>
<td><s:submit value="提交" theme="simple"/><a href="admindeleteordera.action?orderyi=<s:property value='orderyi'/>">删除</a></td>
</tr></s:form>

</s:iterator>

</table>






<!------------------------------------->


