<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@taglib prefix="s" uri="/struts-tags"%>



<table width="556" align="center">
<!--收货人的基本信息 -->
<tr><td>订单号: <s:property value="%{orderiBean.orderId}"/></td></tr>
<tr><td>收货人姓名: <s:property value="%{orderiBean.realname}"/></td></tr>
<tr><td>地址: <s:property value="%{orderiBean.address}"/></td></tr>
<tr><td>联系电话: <s:property value="%{orderiBean.telphone}"/></td></tr>
<tr><td>邮编: <s:property value="%{orderiBean.post}"/></td></tr>
<tr><td>配送模式: <s:property value="%{orderiBean.model}"/></td></tr>
<tr><td>留言: <s:property value="%{orderiBean.message}"/></td></tr>
<tr><td>总价: <s:property value="%{orderiBean.summoney}"/></td></tr>


</table>
<table>
<!-- 购买的商品表单 -->
<tr>
<th>商品编号</th>
<th>商品名称</th>
<th>数量</th>
<th>出价</th>


</tr>
<tr>
<td><s:property value="%{orderiBean.itemId}"/></td>
<td><s:property value="%{orderiBean.item}"/></td>
<td><s:property value="%{orderiBean.number}"/></td>
<td><s:property value="%{orderiBean.price}"/></td>


</tr>
 </table>   
    
    
    