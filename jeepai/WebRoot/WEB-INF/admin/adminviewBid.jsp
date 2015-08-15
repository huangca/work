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





<table  width="766" cellspacing="0" cellpadding="0" border="0" align="center" bgColor="#FDB546">
<tr>
<td width="220" height="240">
<jsp:include page="../user/member-left.jsp" flush="true"></jsp:include>
</td><td bgColor="#FDB546">


<table width="556" align="center" cellspacing="0">
<tr>
<td>
<br />
<table width="80%" align="center" cellpadding="0" cellspacing="1" style="border:1px solid black">
  <tr>
    <td colspan="4" ><div class="mytitle">您参与的全部竞价</div></td> 
  </tr>
  <tr  height="30">
    <th>物品名</th>
    <th>竞标价格</th>
    <th>竞标时间</th>
    <th>竞标人</th>
  </tr>
<s:iterator value="bids" id="bid" status="st">
<tr  height="24" <s:if test="#st.odd">
	style="background-color:#dddddd"</s:if>
	<s:else>style="background-color:#eeeeee"</s:else>>
	<td><s:property value="item"/></td>
	<td><s:property value="price"/></td>
	<td><s:property value="bidDate"/></td>
	<td><s:property value="user"/></td>
</tr>
</s:iterator>
</table>
</td>
</tr>
</table>




</td>
</tr>
</table>






<!----------------------->
 