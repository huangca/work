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
    <td>������</td>
    <td>�ջ�������</td>
   
    <td>����ʱ��</td>
    <td>�ܼ�</td>
    <td>����ȷ��</td>
    <td>����ȷ��</td>
    <td>����ȷ��</td>
    
     <td>����</td>
  </tr>
<s:iterator id="orderyi" value="order" status="st">

<tr>
<td><a href='viewOrderDetail.action?orderId=<s:property value="orderyiid"/>'>
<s:property value="orderyiid"/></a></td>


<td><s:property value="post"/></td>
<td><s:date name="createtime" format="yyyy-MM-dd"/></td>
<td><s:property value="summoney"/></td>
<td><s:if test="cinfimsign==0" >δȷ��</s:if><s:else>��ȷ��</s:else></td>

<td><s:if test="sign==0" >δ����</s:if><s:else>�ѷ���</s:else></td>
<!--cinfimsign==1 ��ʾ������ȷ�ϣ����Ը����� -->
<td><s:if test="cinfimsign==1&&fukuansign==0" ><a href='payoffOrder.action?orderId=<s:property value="orderyiid"/>'>����</a></s:if>
<s:elseif test="cinfimsign==1&&fukuansign==1">�Ѹ���</s:elseif>
<s:else>δ����</s:else></td>
<!--fukuansign==0 ��ʾ����δ�������ɾ���� -->
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
