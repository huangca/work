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
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<html >
<head>
<title><decorator:title default="����Java������������ϵͳ"/></title>
<!-- ʹ��s:head��ǩ����Struts 2��ǩ��CSS��ʽ�ļ� -->
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