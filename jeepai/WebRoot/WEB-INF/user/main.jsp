<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>无标题文档</title>
</head>
<body>
<table width="766" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr >
  <td  valign="top"> <jsp:include page="fg-logo.jsp"/> </td>
  </tr>
  <tr> <td  valign="top">
<!-- --------------- -->



<table width="766" border="0" align="center" cellpadding="0" cellspacing="0" background="images/bg2.jpg">

<tr><td width="220" valign="top" >

<table width="207" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td  >
    
    <jsp:include page="fg-left.jsp"></jsp:include>
    </td>



<td width="556" valign="top"><table width="556" border="0" align="center" cellpadding="0" cellspacing="0" >
  <tr>
    <td height="42" background="images/fg_right01.jpg"></td>
  </tr>
  <tr>
    <td>
	<table width="556" border="0" align="center" cellpadding="0" cellspacing="0" background="images/bg2.jpg">
	<s:iterator id="list" value="yiitems" ><tr><s:iterator id="yiItem" value="list"><td width="182" height="80">
	<table width="182" height="80" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td rowspan="3"width="80"><a href="userviewYiitemDetailPai.action?itemId=<s:property value='id'/>"><img src='images/<s:property value="picname"/>' width="80" height="78" /> </a>           </td> 
    <td height="26">名称:<s:property value="itemName"/></td>
  </tr>
  <tr>
    <td height="26">一口价</td>
  </tr>
  <tr>
  <td height="26">价格:<s:property value="initPrice"/></td>
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
     <td><table width="556" border="0" align="center" cellpadding="0" cellspacing="0" background="images/bg2.jpg">
	<s:iterator id="list" value="items"><tr><s:iterator id="item" value="list"><td width="182" height="80">
	<table width="182" height="80" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td rowspan="3"width="80"><a href="userviewJingPaiPai.action?itemId=<s:property value='id'/>"><img src='images/<s:property value="picname"/>' width="80" height="78" /> </a>      </td> 
    <td height="26">名称:<s:property value="itemName"/></td>
  </tr>
  <tr>
    <td height="26">竞拍</td>
  </tr>
  <tr>
  <td height="26">当前最高价:<s:property value="maxPrice"/></td>
  </tr>
</table>
</td>
	</s:iterator >
      </tr> </s:iterator >
	</table></td>
  </tr>
</table>
</td></tr></table>




<!-- ----------------------- -->
  </td>
  </tr>
  <tr>
    <td  valign="top"><jsp:include page="fg-bottom.jsp"/>  </td>
  </tr>
</table>






</body>
</html>
