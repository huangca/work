<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>



<!----------------------->




  <table width="766" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr> <td colspan="8" bgcolor="#00CC66">购买的商品</td>
    </tr>
    <tr> <td width="90" bgcolor="#00CC66">图片</td>
      <td width="110" bgcolor="#00CC66">商品编号</td>
      <td width="110" bgcolor="#00CC66">商品名称</td>
      <td width="90" bgcolor="#00CC66">模式</td>
      <td width="90" bgcolor="#00CC66">价格</td>
      <td width="90" bgcolor="#00CC66">数量</td>
      <td width="90" bgcolor="#00CC66">小计</td>
      <td width="96" bgcolor="#00CC66">操作</td>
    </tr>
    
    <s:iterator id="cartBean" value="fromList"> 
    <tr> <td height="78">
      <img width="90" height="70" src="images/<s:property value='picname'/>" alt=""/></td>
      <td width="110" align="center"><s:property value="yiitemId"/></td>
      <td width="110"><s:property value="yiitemName"/></td>
      <td width="90"><s:property value="itemmode"/></td>
      <td width="90"><s:property value="initpiece"/></td>
      <td width="90"> 
        <s:textfield name="number" value="%{number}" theme="simple" maxLength="4" size="4" maxlength="4"/></td>
      <td width="90"><s:property value="totalmoney"/></td>
      <td width="96">
      <a href='userdeleteCartAction.action?yiitemId=<s:property value="yiitemId"/>'> 删除</a></td>
    </tr>
	  <tr> <td height="2" colspan="8" bgcolor="#33CC66"></td>
    </tr>
    </s:iterator>
    <tr> <td colspan="8" align="right">合计：<s:property value="#session.summoney"/>元</td>
    </tr>
	    <tr> <td colspan="8" align="right"><a href="userviewFullYiItem.action">继续购物|</a><a href="userclearCartAction.action">清空商品|</a><a href="usercreateOrderAction.action">下一步</a></td>
    </tr>
  </table>








<!----------------------->
  