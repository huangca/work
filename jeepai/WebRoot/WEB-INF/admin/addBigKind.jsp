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

<h3 align="center">添加新大类</h3>
<div align="center">
<s:actionerror cssClass="error"/>
<s:form action="adminproAddBigKind">
<s:textfield name="bigkindname" label="大类名字"/>
<s:textfield name="kinddesc" label="大类描述"/>
<s:textfield name="vercode" label="验证码"/>
<s:submit value="添加"/>
</s:form>
验证码：<img name="d" src="authImg.jpg"/>
</div>
</td>
</tr>
</table>




<!-- ----------------------- -->














