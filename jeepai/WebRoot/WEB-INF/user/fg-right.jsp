<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>

<title>无标题文档</title>
</head>

<body>
<table width="546" border="0" align="center" cellpadding="0" cellspacing="0" bgColor="#ffffff">
  <tr>
    <td height="42" background="images/fg_right01.jpg"></td>
  </tr>
  <tr>
    <td>
	<table width="546" border="0" align="center" cellpadding="0" cellspacing="0">
	<s:iterator id="list" value="yiitems" ><tr><s:iterator id="yiItem" value="list"><td width="182" height="80">
	<table width="182" height="80" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td rowspan="3"width="80"><img src="images/1195001047171.jpg"  width="80" height="78" />       </td> 
    <td height="26">名称:</td>
  </tr>
  <tr>
    <td height="26">一口价:</td>
  </tr>
  <tr>
  <td height="26">价格:</td>
  </tr>
</table>
</td>
	</s:iterator >
      </tr> </s:iterator >
	</table>
     
	  
	
	
	
	
	
	</td>
  </tr>
  <tr>
    <td background="images/fg_right02.jpg" height="42"></td>
  </tr>
  <tr>
     <td><table width="546" border="0" align="center" cellpadding="0" cellspacing="0">
	<s:iterator id="list" value="items"><tr><s:iterator id="item" value="list"><td width="182" height="80">
	<table width="182" height="80" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td rowspan="3"width="80"><img src="images/1195001047171.jpg"  width="80" height="78" />       </td> 
    <td height="26">名称:</td>
  </tr>
  <tr>
    <td height="26">竞拍:</td>
  </tr>
  <tr>
  <td height="26">价格:</td>
  </tr>
</table>
</td>
	</s:iterator >
      </tr> </s:iterator >
	</table></td>
  </tr>
</table>


</body>
</html>
