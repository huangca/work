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
<s:select list="#{'1':'δ����','2':'�ѷ���'}" label="��������" name="sign"
 headerKey="0"  headerValue="--ȫ��--" onchange="changTempValue()"/>
</form>
</td></tr></table>

<br />
<s:actionerror/>
<!-- ������� -->

<table border="1" align="center" width="556" cellpadding="0" cellspacing="0">
  <tr >
    <td align="center">������</td>
    <td align="center">�ռ�������</td>
    <td align="center">��ַ</td>
    <td align="center">�ʱ�</td>
    <td align="center">��������ʱ��</td>
    <td align="center">�ܼ�</td>
    <td align="center">����ȷ��</td>
    <td align="center">����ȷ��</td>
    <td align="center">����</td>
	<td align="center">����22</td>
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
 <td><s:if test="cinfimsign==0" ><a href="#">δȷ��</a></s:if><s:else>��ȷ��</s:else></td>

<td><s:if test="sign==0" >δ����</s:if><s:else>�ѷ���</s:else></td>
cinfimsign==1 ��ʾ������ȷ�ϣ����Ը�����
<td><s:if test="cinfimsign==1" ><a href="#">����</a></s:if><s:else>δ����</s:else></td>
fukuansign==0 ��ʾ����δ�������ɾ����
<td><s:if test="fukuansign==0" ><a href='cancelOrder.action?orderId=<s:property value="orderId"/>'>
<img src="images/b-delete.gif"/></a></s:if><s:elseif test="fukuansign==1"><img src="images/standard_msg_ok.gif"/></s:elseif><s:else>��������</s:else></td>
-->
<td><s:if test="cinfimsign==0" ><a href='adminconfimOrder.action?orderId=<s:property value="orderyiid"/>'>ȷ��</a></s:if><s:else>��ȷ��</s:else></td>
<td ><s:if test="fukuansign==0" >δ����</s:if><s:else>�Ѹ���</s:else></td>
<td ><s:if test="fukuansign==1&&cinfimsign==1&&sign==0" ><a href='adminSendOrder.action?orderId=<s:property value="orderyiid"/>'>
����</a></s:if><s:elseif test="sign==0">δ����</s:elseif> <s:else>�ѷ���  </s:else></td>
<td><s:if test="fukuansign==0" ><a href='admincancelOrder.action?orderId=<s:property value="orderyiid"/>'>
<img src="images/b-delete.gif"/></a>
</s:if> <s:else><img src="images/standard_msg_ok.gif"/></s:else></td>
</tr>
</s:iterator>
</table>



