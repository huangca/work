<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>



<!----------------------->




  <table width="766" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr> <td colspan="8" bgcolor="#00CC66">�������Ʒ</td>
    </tr>
    <tr> <td width="90" bgcolor="#00CC66">ͼƬ</td>
      <td width="110" bgcolor="#00CC66">��Ʒ���</td>
      <td width="110" bgcolor="#00CC66">��Ʒ����</td>
      <td width="90" bgcolor="#00CC66">ģʽ</td>
      <td width="90" bgcolor="#00CC66">�۸�</td>
      <td width="90" bgcolor="#00CC66">����</td>
      <td width="90" bgcolor="#00CC66">С��</td>
      <td width="96" bgcolor="#00CC66">����</td>
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
      <a href='userdeleteCartAction.action?yiitemId=<s:property value="yiitemId"/>'> ɾ��</a></td>
    </tr>
	  <tr> <td height="2" colspan="8" bgcolor="#33CC66"></td>
    </tr>
    </s:iterator>
    <tr> <td colspan="8" align="right">�ϼƣ�<s:property value="#session.summoney"/>Ԫ</td>
    </tr>
	    <tr> <td colspan="8" align="right"><a href="userviewFullYiItem.action">��������|</a><a href="userclearCartAction.action">�����Ʒ|</a><a href="usercreateOrderAction.action">��һ��</a></td>
    </tr>
  </table>








<!----------------------->
  