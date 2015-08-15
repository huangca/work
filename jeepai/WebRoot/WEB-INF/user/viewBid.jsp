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




<table bgColor="#FDB546" width="766" cellspacing="0" cellpadding="0" border="0" align="center" >
<tr>

<td width="220" height="240" bgColor="#FDB546" valign="top">
<jsp:include page="member-left.jsp" flush="true"/>
</td><td width="546" valign="top" bgColor="#FDB546">
<table width="546" align="center" cellspacing="0">
<tr>
<td>
<br />
<table bgColor="#FDB546" width="80%" align="center" cellpadding="0" cellspacing="1" style="border:1px solid black" >
  <tr>
    <td colspan="4" ><div >您参与的全部竞价</div></td> 
  </tr>
  <tr  height="30">
    <td>商品名称</td>
    <td>竞标价格</td>
    <td>竞标时间</td>    
  </tr>
<s:iterator value="bids" id="bid" status="st">
<tr  height="24" <s:if test="#st.odd">
	style="background-color:#dddddd"</s:if>
	<s:else>style="background-color:#eeeeee"</s:else>>
	<td><s:property value="item"/></td>
	<td><s:property value="price"/></td>
	
	<td>
	<s:date name="bidDate"  format="yyyy-MM-dd HH:mm:ss"/>
	</td>
</tr>
</s:iterator>
</table>
</td>
</tr>
</table></td>
</tr>
</table>










<!----------------------->
  