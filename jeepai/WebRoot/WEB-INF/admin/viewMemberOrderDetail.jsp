<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@taglib prefix="s" uri="/struts-tags"%>

>
<!------------------------------------->



 <table width="556" align="center">
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
<th>����</th>
</tr>
<s:iterator id="memberOrderBean" value="memberOrderBean.odtList" status="st">
<s:form action="adminupdateorderyiaction">
<tr>
<td width="50"><s:hidden name="orderyi" value="%{orderyi}"/><s:property value="id"/></td>
<td width="60"><s:property value="yiitem"/></td>
<td width="20"><s:textfield theme="simple" name="number" value="%{number}" size="2"/></td>
<td width="30"><s:property value="price/number"/></td>
<td width="50"><s:property value="price"/></td>
<td><s:submit value="�ύ" theme="simple"/><a href="admindeleteordera.action?orderyi=<s:property value='orderyi'/>">ɾ��</a></td>
</tr></s:form>

</s:iterator>

</table>






<!------------------------------------->


