<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>




<!----------------------->




<table width="766" align="center" cellspacing="0" >
<tr>
<td >
<h3 align="center">�û�ע��</h3>

<!--<s:actionerror cssClass="error"/> --><!-- 
<s:form action="regeditPage" >
  <s:textfield  name="username" label="�û���" required="true" id="nickname"/>
  <div id="mynickname">
  <input type="button" value="���" onclick="checknickname()"/>
  </div>
	<s:password name="password" label="����" required="true"/>
	<s:password name="repassword" label="ȷ������" required="true"/>
	<s:textfield name="realname" label="��ʵ����" required="true"/>
	<s:textfield name="email" label="Email"/>
	<s:textfield name="address" label="��ַ" required="true"></s:textfield>
	<s:textfield name="postcode" label="�ʱ�" />
	<s:textfield name="telphone" label="�绰" required="true"/>
	<s:select  name="questionid" list="#{'1':'��ϲ���ĵ�Ӱ','2':'���𾴵���'}" label="��������" />
	<s:textfield name="answer" label="�ش�" />
	<s:submit type="image" src="images/save.jpg"></s:submit>
</s:form>
 -->
<s:form action="regeditPage">
<table width="766" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr><td width="200">&nbsp;</td>
    <td width="366"><s:textfield  name="username" label="�û���" required="true" id="nickname" />
    </td>
    <td width="200" ></td>
  </tr>
  <tr><td>&nbsp;</td>
    <td align="left"><s:password name="password" label="����" required="true"><div id="mynickname" >
    <input type="button" value="����û���" onclick="checknickname()"/></div></s:password></td>
    <td>&nbsp;</td>
  </tr>
  <tr><td>&nbsp;</td>
    <td><s:password name="repassword" label="ȷ������" required="true"/></td>
    <td>&nbsp;</td>
  </tr>
  <tr><td>&nbsp;</td>
    <td><s:textfield name="realname" label="��ʵ����" required="true"/></td>
    <td>&nbsp;</td>
  </tr>
  <tr><td>&nbsp;</td>
    <td><s:textfield name="email" label="Email" required="true"/></td>
    <td>&nbsp;</td>
  </tr>
  <tr><td>&nbsp;</td>
    <td><s:textfield name="address" label="��ַ" required="true"/></td>
    <td>&nbsp;</td>
  </tr>
  <tr><td>&nbsp;</td>
    <td><s:textfield name="postcode" label="�ʱ�" required="true"/></td>
    <td>&nbsp;</td>
  </tr>
  <tr><td>&nbsp;</td>
    <td><s:textfield name="telphone" label="�绰" required="true"/></td>
    <td>&nbsp;</td>
  </tr>
  <tr><td>&nbsp;</td>
    <td><s:select  name="questionid" list="#{'1':'��ϲ���ĵ�Ӱ','2':'���𾴵���'}" label="��������" /></td>
    <td>&nbsp;</td>
  </tr>
  <tr><td>&nbsp;</td>
    <td><s:textfield name="answer" label="�ش�" /></td>
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
  