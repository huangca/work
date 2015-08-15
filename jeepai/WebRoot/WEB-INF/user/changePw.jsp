<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>




<!----------------------->





<table  width="766" cellspacing="0" cellpadding="0" border="0" align="center" bgColor="#FDB546">
<tr>
<td width="220" height="240">
<jsp:include page="member-left.jsp" flush="true"></jsp:include>
</td><td height="240">

<table width="556" align="center" cellspacing="0">
<tr>
<td >
<h3 align="center">修改密码</h3>
<div align="center">
<s:actionerror cssClass="error"/>
<s:form action="userchangePw.action" >

	<s:password name="opassword" label="原密码" required="true" />
    <s:password name="npassword" label="新密码" required="true"/>
    <s:password name="againpassword" label="确认新密码" required="true" ></s:password>
	<s:textfield name="vercode" label="验证码" required="true" />
	<s:submit type="image" src="images/save.jpg" />
	

</s:form>
验证码：<img name="d" src="authImg.jpg"/>
</div>
</td>
</tr>
</table>

</td>
</tr>
</table>






<!----------------------->
