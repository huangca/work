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
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<html >
<head>
<title><decorator:title default="基于Java轻量级的拍卖系统"/></title>
<!-- 使用s:head标签引入Struts 2标签的CSS样式文件 -->
<link href="css/css.css" rel="stylesheet" type="text/css"/>
<s:head/><sx:head/>
</head>

<body>
 <table width="766" border="0" align="center" cellpadding="0" cellspacing="0">
 <tr> <td colspan="2" valign="top">
  <jsp:include page="../WEB-INF/admin/adminlogo.jsp"></jsp:include>
 </td></tr>
 
  <tr> 
  <td width="220"> <jsp:include page="../WEB-INF/admin/adminleft.jsp"></jsp:include></td>
  <td  valign="top">
  <decorator:body/>
 </td></tr>
 
 <tr> <td colspan="2" valign="top">
  <jsp:include page="../WEB-INF/user/fg-bottom.jsp"></jsp:include>
 </td></tr>
 </table>

</body>
</html>