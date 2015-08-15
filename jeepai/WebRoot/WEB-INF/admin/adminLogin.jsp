<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<body>

<table width="100%" height="150px" border="0" cellpadding="0" cellspacing="0">
<tr><td>&nbsp;</td></tr>

</table>


<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td>
	
	
<s:form action="adminLogin" theme="simple" >
<table width="547" height="294" border="0" align="center" cellpadding="0" cellspacing="0" background="images/bg-land.jpg">
  <tr>
    <td width="125">&nbsp;</td>
    <td width="422" valign="bottom"><table width="411" border="0">
      <tr>
        <td width="55" height="38"><font color="#9A6634"><strong>用户名：</strong></font>          </td>
        <td width="104"><s:textfield name="username" theme="simple"/></td>
        <td width="45">&nbsp;<font color="#9A6634"><strong>密码：</strong></font>          </td>
        <td width="113"><s:password name="password" theme="simple"/></td>
        <td width="72"><div align="right">       
<s:submit type="image" src="images/bg-land.gif" />
        </div></td>
      </tr>
      <tr>
        <td height="30" colspan="5"><div align="right"><a href="index.action" class="a1">返回</a>&nbsp;&nbsp;</div></td>
      </tr>
    </table></td>
  </tr>
</table>
</s:form>

	
	
	
	
	
	</td>
  </tr>
</table>
</body>
