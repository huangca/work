<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@taglib prefix="s" uri="/struts-tags"%>



<table width="556" align="center">
<!--�ջ��˵Ļ�����Ϣ -->
<tr><td>������: <s:property value="%{orderiBean.orderId}"/></td></tr>
<tr><td>�ջ�������: <s:property value="%{orderiBean.realname}"/></td></tr>
<tr><td>��ַ: <s:property value="%{orderiBean.address}"/></td></tr>
<tr><td>��ϵ�绰: <s:property value="%{orderiBean.telphone}"/></td></tr>
<tr><td>�ʱ�: <s:property value="%{orderiBean.post}"/></td></tr>
<tr><td>����ģʽ: <s:property value="%{orderiBean.model}"/></td></tr>
<tr><td>����: <s:property value="%{orderiBean.message}"/></td></tr>
<tr><td>�ܼ�: <s:property value="%{orderiBean.summoney}"/></td></tr>


</table>
<table>
<!-- �������Ʒ�� -->
<tr>
<th>��Ʒ���</th>
<th>��Ʒ����</th>
<th>����</th>
<th>����</th>


</tr>
<tr>
<td><s:property value="%{orderiBean.itemId}"/></td>
<td><s:property value="%{orderiBean.item}"/></td>
<td><s:property value="%{orderiBean.number}"/></td>
<td><s:property value="%{orderiBean.price}"/></td>


</tr>
 </table>   
    
    
    