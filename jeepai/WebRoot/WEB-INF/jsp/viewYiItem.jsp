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


<script  type="text/javascript" language="javascript">
var timercounter=3;
function drawTable(){
var mytable=document.getElementById("mytable1");
var innerhtm="<table width='200' border='0' align='center' cellpadding='0' cellspacing='0'><tr>";
  innerhtm+= "<td width='200' height='200' bgcolor='#669900'><p>���Ժ󡣡���</p>";
   innerhtm+= "<img src='decorators/images/7.gif' width='15' height='15' /></td> </tr></table>"
   mytable.innerHTML=innerhtm;


if(timercounter>0){timercounter--;}
}
</script>
<script language="JavaScript" type="text/JavaScript"> 
function changTempValue() { 
var tf=document.forms["viewSortForm"];
tf.action="userviewFullYiItem.action";
tf.submit();
} 
</script>



<!-- --------------- -->
  
  <table width="766" border="0" cellspacing="0" cellpadding="0" background="images/bg2.jpg">

  <tr>
    <td rowspan="2" width="220" valign="top" >
    <jsp:include page="../user/fg-left.jsp"/></td>
    <td width="546" valign="top"><table width="546" border="1" align="center" cellpadding="0" cellspacing="0" background="images/bg2.jpg">
  
  <form name="viewSortForm"  method="post" >
<s:select list="kinds" label="�������" name="id"
	listKey="id"
	listValue="kindName" headerKey="0"  headerValue="--ȫ��--" onchange="changTempValue()"/>
</form></td>

<s:iterator id="yiItem" value="availableItems" status="st">

<form  method="post" action="useraddCartAction">
<tr>
    <td width="120" rowspan="4" align="center"><img src='images/<s:property value="picname"/>' width="120" height="80" /></td>
    <td height="20" width="230"  align="right">��Ʒ����:</td>
    <td  width="196"><s:property value="name"/></td>
  </tr>
  <tr>
    <td height="20" align="right">һ�ڼ�:��</td>
    <td><s:property value="initPrice"/></td>
  </tr>
  <tr>
    <td height="20" align="right">��ע:</td>
    <td><s:property value="remark"/></td>
  </tr>
  <tr>
    <td height="20"><s:hidden name="number" value="1"></s:hidden>  <input type="hidden" name="itemId" value="<s:property value='id'/>"/></td>
    <td align="right"><s:submit  type="image" src="images/2.jpg" theme="simple"/></td>
  </tr>
  <tr>
  
</form>

  </s:iterator>
  <!--��ҳ����  --><!--  
      <tr align="right">
    	<td colspan="9">
    		��<s:property value="totalRows"/>��&nbsp;
    		��<s:property value="currentPage"/>ҳ&nbsp;
    		��<s:property value="pager.getTotalPages()"/>ҳ&nbsp;
    		<a href="<s:url value="viewFullYiItem.action">
    			<s:param name="currentPage" value="currentPage"/>
    			<s:param name="pagerMethod" value="'first'"/>
    			
    		</s:url>">��ҳ</a>
    		<a href="<s:url value="viewFullYiItem.action">
    			<s:param name="currentPage" value="currentPage"/>
    			<s:param name="pagerMethod" value="'previous'"/>
    		</s:url>">��һҳ</a>
    		<a href="<s:url value="viewFullYiItem.action">
    			<s:param name="currentPage" value="currentPage"/>
    			<s:param name="pagerMethod" value="'next'"/>
    		</s:url>">��һҳ</a>
    		<a href="<s:url value="viewFullYiItem.action">
    			<s:param name="currentPage" value="currentPage"/>
    			<s:param name="pagerMethod" value="'last'"/>
    		</s:url>">βҳ</a>
    	</td>
    </tr>	-->
  <!--��ҳ����  -->
  </table></td>
  </tr>
  <tr>
    <td><jsp:include page="page.jsp"/></td>
  </tr>
</table>

<!-- ----------------------- -->
 