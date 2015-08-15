<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@taglib prefix="s" uri="/struts-tags"%>




<!----------------------->



  
  <table  width="766" cellspacing="0" cellpadding="0" border="0" align="center" bgColor="#FDB546">
<tr>

<td width="220" >
<jsp:include page="../user/fg-left.jsp" flush="true"></jsp:include>
</td><td width="556"><form id="form1" name="form1" method="post" action="useraddCartAction">
  <table width="556" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td width="200" height="500" rowspan="6">
      
      <s:hidden name="itemId" value="%{yiItemBean.id}"/>
       <s:hidden name="number" value="1"/>
      
      <img width="180" height="180" src="images/<s:property value='yiItemBean.picname'/>"/>
      </td>
      <td>商品编号:<s:property value="yiItemBean.id"/></td>
    </tr>
    <tr>
      <td>商品名称:<s:property value="yiItemBean.name"/></td>
    </tr>
    <tr>
      <td>一口价:<s:property value="yiItemBean.initPrice"/>￥</td>
    </tr>
    <tr>
      <td>数量:<s:property value="yiItemBean.initnumber"/></td>
    </tr>
    <tr>
      <td>商品描述:<s:property value="yiItemBean.desc"/></td>
    </tr>
    <tr>
      <td><s:submit type="image" src="images/2.jpg" theme="simple"/></td>
    </tr>
  </table>
</form></td>
</tr>
</table>
  









<!----------------------->
