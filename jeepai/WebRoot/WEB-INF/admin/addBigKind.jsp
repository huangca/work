<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@taglib prefix="s" uri="/struts-tags"%>



<!-- ------------------ -->

<table width="556" align="center" 
	cellspacing="0" >
<tr>
<td>
<br />
<table width="556" align="center" cellpadding="0">
<tr>
	<td colspan="2" ></td> 
</tr>

</table>
</td>
</tr>
<tr>
<td>

<h3 align="center">����´���</h3>
<div align="center">
<s:actionerror cssClass="error"/>
<s:form action="adminproAddBigKind">
<s:textfield name="bigkindname" label="��������"/>
<s:textfield name="kinddesc" label="��������"/>
<s:textfield name="vercode" label="��֤��"/>
<s:submit value="���"/>
</s:form>
��֤�룺<img name="d" src="authImg.jpg"/>
</div>
</td>
</tr>
</table>




<!-- ----------------------- -->














