<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@taglib prefix="s" uri="/struts-tags"%>



<!----------------------->





<table  width="766" cellspacing="0" cellpadding="0" border="0" align="center" bgColor="#FDB546">
<tr>
<td width="220" >
<jsp:include page="member-left.jsp" flush="true"></jsp:include>
</td><td >

<table width="556" align="center" cellspacing="0">
<tr>
<td ><h3 align="center">�޸ĸ�����Ϣ</h3>
<div align="center">
<s:actionerror cssClass="error"/>
<s:form action="userchangeDate" validate="true">




<s:textfield name="realName" label="��ʵ����" value="%{auctionUser.realName}" required="true"/>
<s:textfield name="email" label="Email" value="%{auctionUser.email}"/>
<s:textfield name="address" label="��ַ" value="%{auctionUser.address}"/>
<s:textfield name="postcode" label="�ʱ�" value="%{auctionUser.postcode}"/>
<s:textfield name="telphone" label="�绰" value="%{auctionUser.telphone}"/> 
<s:submit type="image" src="images/save.jpg" />

 

</s:form></div>
</td>
</tr>
</table>



</td>
</tr>
</table>






<!----------------------->

