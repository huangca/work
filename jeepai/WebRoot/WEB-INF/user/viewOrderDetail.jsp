<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@taglib prefix="s" uri="/struts-tags"%>



<!----------------------->




<table  width="766" cellspacing="0" cellpadding="0" border="0" align="center" bgColor="#FDB546">
<tr>

<td width="220" ><jsp:include page="member-left.jsp" flush="true"></jsp:include>
</td><td width="556"><table>
<!--�ջ��˵Ļ�����Ϣ -->
<tr><td>������: <s:property value="%{memberOrderBean.orderyiBean.orderyiid}"/></td></tr>
<tr><td>�ջ�������: <s:property value="%{memberOrderBean.orderyiBean.realname}"/></td></tr>
<tr><td>��ַ: <s:property value="%{memberOrderBean.orderyiBean.address}"/></td></tr>
<tr><td>��ϵ�绰: <s:property value="%{memberOrderBean.orderyiBean.telphone}"/></td></tr>
<tr><td>�ʱ�: <s:property value="%{memberOrderBean.orderyiBean.post}"/></td></tr>

<tr><td>����ģʽ: <s:property value="%{memberOrderBean.orderyiBean.model}"/></td></tr>
<tr><td>����: <s:property value="%{memberOrderBean.orderyiBean.message}"/></td></tr>
<tr><td>�ܼ�: <s:property value="%{memberOrderBean.orderyiBean.summoney}"/></td></tr>


</table>
<table>
<!-- �������Ʒ�� -->
<tr>
<th>��Ʒ���</th>
<th>��Ʒ����</th>
<th>����</th>
<th>����</th>
<th>С��</th>
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
