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




<!----------------------->


<table width="766" border="0" align="center" cellpadding="0" cellspacing="0" background="images/bg2.jpg">

<tr><td width="220" valign="top" >

<table width="207" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td  >
    
    <jsp:include page="../user/fg-left.jsp"></jsp:include>
    </td>



<td width="556" valign="top">

<!-- ------------------------------------- -->


<table width="556" align="center" cellpadding="0" 
	cellspacing="1" style="border:1px solid black">
<tr bgcolor="#e1e1e1" >
	<td colspan="2"><div class="mytitle">���������Ʒ��ϸ��Ϣ</div></td> 
</tr>
<tr height="24">
	<td>��Ʒ��</td>
	<td><s:property value="item.name"/></td>
</tr>
<tr  height="24">
	<td>��Ʒ����</td>
	<td><s:property value="item.desc"/></td>
</tr>
<tr  height="24">
	<td>��Ʒ��ע</td>
	<td><s:property value="item.remark"/></td>
</tr>
<tr  height="24">
	<td>��Ʒ����</td>
	<td><s:property value="item.kind"/></td>
</tr>
<tr  height="24">
	<td>��Ʒ������</td>
	<td bgcolor="#FFFFFF"><s:property value="item.owner"/></td>
</tr>
<tr  height="24">
	<td>��Ʒ���ļ�</td>
	<td><s:property value="item.initPrice"/></td>
</tr>
<tr  height="24">
	<td>��Ʒ��߼�</td>
	<td><s:property value="item.maxPrice"/></td>
</tr>
<tr  height="24">
	<td>��Ʒ����ʱ��</td>
	<td><s:property value="item.addTime"/></td>
</tr>
<tr  height="24">
	<td>��Ʒ����ʱ��</td>
	<td><s:property value="item.endTime"/></td>
</tr>
<tr  height="24">
	<td>��ƷͼƬ</td>
	<td> <img height="150px" width="150px" src="images/<s:property value="item.picname"/>"/> 
	
</tr>
<tr  height="32">
	<td colspan="2">&nbsp;</td>
</tr>
<tr  height="24">
	<td colspan="2" align="center">
	���������Ȥ�������Ʒ���ۣ�������۸���ύ��
	��ע�⣬���ļ۸�Ӧ������Ʒ����߼�
	<s:actionerror/>
	</td>
</tr>
<tr  height="32">
	<td colspan="2">
	<div align="center">
	<s:form action="bid">
		<input type="hidden" name="itemId" 
			value="<s:property value='item.id'/>"/>
		<input type="hidden" name="maxPrice"
			value="<s:property value='item.maxPrice'/>"/>
		<s:textfield name="bidPrice" label="���ļ�"/>
		<s:textfield name="vercode" label="��֤��"/>
		<s:submit value="����"/>
	</s:form>
	��֤�룺<img name="d" src="authImg.jpg"/>
	</div>
	</td>
</tr>
</table>




<!-- -----------------------viewdetail.jsp content over -->

</td></tr></table>









<!----------------------->
  </td>
  </tr>
  
</table>


