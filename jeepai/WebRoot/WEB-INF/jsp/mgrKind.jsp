<%--
/**
 * Description:
 * <br/>��ַ: <a href="http://www.sise.com.cn">�����Ч</a> 
 * <br/>Copyright (C), 2010-201?, �Ʋӻ�   ���ΰ
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:20100301-20100401
 * @author  hch0612@scse.com.cn
 * @version  1.0
 */ 
--%>

<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>



<table width="556" align="center" 
	cellspacing="0" >
<tr>
<td>
<br />

</td>
</tr>
<tr>
<td>
<br />
<h3>���������</h3>
<div align="center">
<s:actionerror cssClass="error"/>
<s:form action="adminproAddKind" validate="true">
<s:textfield name="name" label="������" required="true"/>
<s:textfield name="desc" label="��������" required="true"/>
<s:select name="bigkind" list="bigkinds" listValue="bigkindname" label="ѡ�����" listKey="bigkindId"></s:select>
<s:textfield name="vercode" label="��֤��" required="true"/>
<s:submit value="���"/>
</s:form>
��֤�룺<img name="d" src="authImg.jpg">
</div>
</td>
</tr>
</table>


