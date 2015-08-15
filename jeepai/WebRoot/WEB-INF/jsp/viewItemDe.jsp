<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@taglib prefix="s" uri="/struts-tags"%>



<!----------------------->



 <table  width="766" cellspacing="0" cellpadding="0" border="0" align="center" bgColor="#FDB546">
<tr>

<td width="220" >
<jsp:include page="../user/fg-left.jsp" flush="true"></jsp:include>
</td>

<td>
  <table width="556" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td width="200"  rowspan="7" ><img width="180" height="180" src="images/<s:property value='itemBean.picname'/>"/> </td>
      <td>商品编号:<s:property value="itemBean.id"/></td>
    </tr>
    <tr>
      <td>商品名称:<s:property value="itemBean.name"/></td>
    </tr>
    <tr>
      <td>模式:竞拍</td>
    </tr>
       <tr>
      <td>结束时间:<s:property value="itemBean.endTime"/></td>
    </tr>
    <tr>
      <td>当前最高价:<s:property value="itemBean.maxPrice"/>￥</td>
    </tr>
    <tr>
      <td >商品描述:<s:property value="itemBean.desc"/></td>
    </tr>
    <tr>
      <td><a href='userviewDetail.action?itemId=<s:property value="itemBean.id"/>'><img src="images/jp2.gif" alt="" width="100" height="20"/></a> </td>
    </tr>
  </table>
</td>
</tr></table>
  
  
  








<!----------------------->
  
