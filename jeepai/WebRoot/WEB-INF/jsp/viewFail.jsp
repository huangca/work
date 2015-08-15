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

<script language="JavaScript" type="text/JavaScript"> 
function changTempValue() { 
var tf=document.forms["viewSortForm"];
tf.action="userviewJingpaiItem.action";
tf.submit();
} 
</script>






<!----------------------->



<table width="766" border="0" cellspacing="0" cellpadding="0" background="images/bg2.jpg">
  <tr>
    <td rowspan="2" width="220" valign="top">
 <jsp:include page="../user/fg-left.jsp"/></td>
    <td width="546" valign="top"><table width="546" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
<td height="30" width="546">
<form name="viewSortForm"  method="post" >
<s:select list="kinds" label="种类分类" name="id"
	listKey="id"
	listValue="kindName" headerKey="0"  headerValue="--全部--" onchange="changTempValue()"/>
</form></td>
</tr>
</table>
<s:iterator id="item" value="availableItems" status="st">
<table width="546" border="1" align="center" cellpadding="0" cellspacing="0">
  <tr>
       <td width="120" rowspan="7"><img src="images/<s:property value="picname"/>" width="120" height="100" /></td>
    <td width="245" height="15" align="right">商品名称:</td>
    <td width="181"><s:property value="name"/></td>
  </tr>
  <tr>
    <td height="15" align="right">结束时间:</td>
    <td><s:date name="endTime"  format="yyyy-MM-dd"/></td>
  </tr>
  <tr>
    <td height="15" align="right">当前最高价:</td>
    <td><s:property value="maxPrice"/></td>
  </tr>
  <tr>
    <td height="15" align="right">类别:</td>
    <td><s:property value="kind" /></td>
  </tr>
  <tr>
    <td height="15" align="right">模式:</td>
    <td>竞拍</td>
  </tr>
  <tr>
    <td height="15" align="right">商品备注:</td>
    <td><s:property value="remark"/></td>
  </tr>
  <tr>
    <td height="20">&nbsp;</td>
    <td align="right"><a href='userviewDetail.action?itemId=<s:property value="id"/>'><img src="images/jp2.gif" alt="" width="100" height="20"/></a></td>
  </tr>
</table>
</s:iterator></td>
  </tr>
  <tr>
    <td>
 <jsp:include page="page.jsp"/></td>
  </tr>
</table>










<!----------------------->







