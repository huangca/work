<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>

<html>
  <head>       
    <title>My JSP 'adminmain.jsp' starting page</title>  
  </head>
    <body>
    <table width="766" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
  <td colspan="2" ><jsp:include page="adminlogo.jsp" flush="true"/></td>  </tr>
  <tr>
    <td width="220"  background="images/bg2.jpg" ><jsp:include page="adminleft.jsp" flush="true"/></td>
    <td width="556"  background="images/bg2.jpg">管理后台主页</td>
  </tr>
  <tr>
    <td colspan="2"><jsp:include page="../user/fg-bottom.jsp" flush="true"/></td>
  </tr>
</table>   
  </body>
</html>
