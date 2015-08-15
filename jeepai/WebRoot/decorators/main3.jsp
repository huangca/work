<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<html>
  <head><decorator:head/>
   <s:head/><sx:head/>
    

<link href="css/css.css" rel="stylesheet" type="text/css" />

  </head>
  
  <body  >
  
 <table width="766" border="0" align="center" cellpadding="0" cellspacing="0">
 <tr> <td colspan="2" valign="top">
  <jsp:include page="../WEB-INF/user/fg-logo.jsp"></jsp:include>
 </td></tr>
 
  <tr> 
  <td width="220"> <jsp:include page="../WEB-INF/user/fg-left.jsp"></jsp:include></td>
  <td  valign="top">
  <decorator:body/>
 </td></tr>
 
 <tr> <td colspan="2" valign="top">
  <jsp:include page="../WEB-INF/user/fg-bottom.jsp"></jsp:include>
 </td></tr>
 </table>
  </body>
</html>
