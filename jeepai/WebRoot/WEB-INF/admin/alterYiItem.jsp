<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<title>浏览一口价的物品</title>

</head>
<body>
<script language="JavaScript" type="text/JavaScript"> 
function changTempValue() { 
var tf=document.forms["viewSortForm"];
tf.action="alterYiItem.action";
tf.submit();
} 
</script>


    <table width="766" border="0" align="center" cellpadding="0" cellspacing="0">

  <tr>
    <td width="220"  background="images/bg2.jpg" ><jsp:include page="adminleft.jsp" flush="true"/></td>
    <td width="556"  background="images/bg2.jpg">
<s:form name="viewSortForm"  method="post" >
<s:select label="状态分类" name="stateid"
list="#{'0':'全部','4':'上架','5':'下架','6':'到货通知'}" onchange="changTempValue()"
/>
</s:form>
<table width="556" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td>图片</td>
    <td>编号</td>
    <td>名字</td>
    <td>描述</td>
    <td>价格</td>
    <td>库存</td>
    <td>大类</td>
    <td>子类</td>
    <td>状态</td>
    <td>动作</td>
  </tr>
  <s:iterator id="yiItem" value="availableItems" status="st">
  <tr>
   <td width="45" height="45"><img height="45px" width="45px" src="images/<s:property value="picname"/>"/></td>
    <td width="56"><s:property value="id"/></td>
    <td width="56"><s:property value="name"/></td>
    <td width="60"><s:property value="desc"/></td>
    <td width="56"><s:property value="initPrice"/></td>
    <td width="56"><s:property value="initnumber"/></td>
    <td width="60"><s:property value="bigkind"/></td>
    <td width="60"><s:property value="kind"/></td>
    <td width="56"><s:property value="state"/></td>
    <td width="51"><a href='adminalterYiItemDetail.action?itemId=<s:property value="id"/>&kid=<s:property value='kid'/>&bigkid=<s:property value='bigkid'/>'>修改</a></td>
 
  </tr>
  
</s:iterator>

</table>



</td>
  </tr>
  <tr><td colspan="2" align="right">
 <jsp:include page="../jsp/page.jsp"/></td>
 </tr>


</table> 








<!--<s:submit onclick="setInterval('drawTable()',1000)"  type="image" src="decorators/images/d_bu_basket.gif" theme="simple"/>
-->
</body>
</html>