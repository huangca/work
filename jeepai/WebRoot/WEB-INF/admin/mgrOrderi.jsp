<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@taglib prefix="s" uri="/struts-tags"%>

    


    
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
    <td align="center">��������</td>
	<td align="center">����</td>
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
<!-- ���ھ�����˵ȷ�����û�����ȷ�ϲ���������ط����͸���Ʒ -->
<td><s:if test="cinfimsign==0" >δȷ��</s:if><s:else>��ȷ��</s:else></td>
<td ><s:if test="fukuansign==0" >δ����</s:if><s:else>�Ѹ���</s:else></td>
<td ><s:if test="fukuansign==1&&cinfimsign==1&&sign==0" ><a href='adminSendOrderi.action?orderiBean.orderId=<s:property value="orderId"/>'>
����</a></s:if><s:elseif test="sign==0">δ����</s:elseif> <s:else>�ѷ���  </s:else></td>
<td><s:if test="fukuansign==0" ><a href='admincancelOrderi.action?orderiBean.orderId=<s:property value="orderId"/>'>
<img src="images/b-delete.gif"/></a>
</s:if> <s:else><img src="images/standard_msg_ok.gif"/></s:else></td>
</tr>
  </s:iterator>
 </table>
    
    
    
    
    

