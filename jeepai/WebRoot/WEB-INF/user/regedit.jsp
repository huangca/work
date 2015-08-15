<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>




<!----------------------->




<table width="766" align="center" cellspacing="0" >
<tr>
<td >
<h3 align="center">用户注册</h3>

<!--<s:actionerror cssClass="error"/> --><!-- 
<s:form action="regeditPage" >
  <s:textfield  name="username" label="用户名" required="true" id="nickname"/>
  <div id="mynickname">
  <input type="button" value="检查" onclick="checknickname()"/>
  </div>
	<s:password name="password" label="密码" required="true"/>
	<s:password name="repassword" label="确认密码" required="true"/>
	<s:textfield name="realname" label="真实姓名" required="true"/>
	<s:textfield name="email" label="Email"/>
	<s:textfield name="address" label="地址" required="true"></s:textfield>
	<s:textfield name="postcode" label="邮编" />
	<s:textfield name="telphone" label="电话" required="true"/>
	<s:select  name="questionid" list="#{'1':'最喜欢的电影','2':'最尊敬的人'}" label="密码问题" />
	<s:textfield name="answer" label="回答" />
	<s:submit type="image" src="images/save.jpg"></s:submit>
</s:form>
 -->
<s:form action="regeditPage">
<table width="766" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr><td width="200">&nbsp;</td>
    <td width="366"><s:textfield  name="username" label="用户名" required="true" id="nickname" />
    </td>
    <td width="200" ></td>
  </tr>
  <tr><td>&nbsp;</td>
    <td align="left"><s:password name="password" label="密码" required="true"><div id="mynickname" >
    <input type="button" value="检查用户名" onclick="checknickname()"/></div></s:password></td>
    <td>&nbsp;</td>
  </tr>
  <tr><td>&nbsp;</td>
    <td><s:password name="repassword" label="确认密码" required="true"/></td>
    <td>&nbsp;</td>
  </tr>
  <tr><td>&nbsp;</td>
    <td><s:textfield name="realname" label="真实姓名" required="true"/></td>
    <td>&nbsp;</td>
  </tr>
  <tr><td>&nbsp;</td>
    <td><s:textfield name="email" label="Email" required="true"/></td>
    <td>&nbsp;</td>
  </tr>
  <tr><td>&nbsp;</td>
    <td><s:textfield name="address" label="地址" required="true"/></td>
    <td>&nbsp;</td>
  </tr>
  <tr><td>&nbsp;</td>
    <td><s:textfield name="postcode" label="邮编" required="true"/></td>
    <td>&nbsp;</td>
  </tr>
  <tr><td>&nbsp;</td>
    <td><s:textfield name="telphone" label="电话" required="true"/></td>
    <td>&nbsp;</td>
  </tr>
  <tr><td>&nbsp;</td>
    <td><s:select  name="questionid" list="#{'1':'最喜欢的电影','2':'最尊敬的人'}" label="密码问题" /></td>
    <td>&nbsp;</td>
  </tr>
  <tr><td>&nbsp;</td>
    <td><s:textfield name="answer" label="回答" /></td>
    <td>&nbsp;</td>
  </tr>
  <tr><td>&nbsp;</td>
    <td><s:submit type="image" src="images/save.jpg" align="center"/></td>
    <td>&nbsp;</td>
  </tr>
</table>

</s:form>
</td>
</tr>
</table>







<!----------------------->
  