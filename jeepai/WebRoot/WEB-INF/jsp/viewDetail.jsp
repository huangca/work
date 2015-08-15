<%--
/**
 * Description:
 * <br/>地址: <a href="http://www.sise.com.cn">华软高效</a> 
 * <br/>Copyright (C), 2010-201?, 黄灿华   余宏伟
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
	<td colspan="2"><div class="mytitle">您浏览的物品详细信息</div></td> 
</tr>
<tr height="24">
	<td>物品名</td>
	<td><s:property value="item.name"/></td>
</tr>
<tr  height="24">
	<td>物品描述</td>
	<td><s:property value="item.desc"/></td>
</tr>
<tr  height="24">
	<td>物品备注</td>
	<td><s:property value="item.remark"/></td>
</tr>
<tr  height="24">
	<td>物品种类</td>
	<td><s:property value="item.kind"/></td>
</tr>
<tr  height="24">
	<td>物品所有者</td>
	<td bgcolor="#FFFFFF"><s:property value="item.owner"/></td>
</tr>
<tr  height="24">
	<td>物品起拍价</td>
	<td><s:property value="item.initPrice"/></td>
</tr>
<tr  height="24">
	<td>物品最高价</td>
	<td><s:property value="item.maxPrice"/></td>
</tr>
<tr  height="24">
	<td>物品起拍时间</td>
	<td><s:property value="item.addTime"/></td>
</tr>
<tr  height="24">
	<td>物品结束时间</td>
	<td><s:property value="item.endTime"/></td>
</tr>
<tr  height="24">
	<td>物品图片</td>
	<td> <img height="150px" width="150px" src="images/<s:property value="item.picname"/>"/> 
	
</tr>
<tr  height="32">
	<td colspan="2">&nbsp;</td>
</tr>
<tr  height="24">
	<td colspan="2" align="center">
	如果您有兴趣参与该物品竞价，请输入价格后提交。
	请注意，您的价格应大于物品的最高价
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
		<s:textfield name="bidPrice" label="竞拍价"/>
		<s:textfield name="vercode" label="验证码"/>
		<s:submit value="竞价"/>
	</s:form>
	验证码：<img name="d" src="authImg.jpg"/>
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


