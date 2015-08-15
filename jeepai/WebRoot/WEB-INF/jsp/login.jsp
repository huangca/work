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






<table width="766" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
       <td colspan="2"><img src="images/fg1.jpg" width="766" height="39" /></td>
  </tr>
    <tr>
       <td width="383"><img src="images/bg_022.jpg" width="383" height="25" /></td>
    <td width="383"><img src="images/bg_023.jpg" width="383" height="25" /></td>
  </tr>
      <tr>
       <td bgcolor="#00FF00"><table width="207" align="center" height="138"  border="0" cellpadding="0" cellspacing="0" background="images/fg_left01.jpg">
      <tr>
        <td valign="top"><table width="100%"  border="0" cellpadding="0" cellspacing="0">
		 <tr>
            <td height="16">&nbsp;</td>
          </tr>
        </table>
        <form name="form" method="post" action="userprocessLogin">
          <table width="185" border="0" align="center">
            <tr>
              <td width="60" height="25">用户名：</td>
              <td width="115"> <input name="username" type="text" size="17"></td>
            </tr>
            <tr>
              <td height="25">密&nbsp;&nbsp;码：</td>
              <td><input name="password" type="password" size="17"></td>
            </tr>
			 <tr>
              <td height="26" colspan="2" align="center"><s:submit type="image" src="images/fg-land.gif" theme="simple"/></td>
              </tr>	  
          </table>
		  </form>
		  </td>
      </tr>
    </table></td>
    <td  valign="top">
  
    <s:form action="userregeditPage"  validate="true"><table width="383" border="0" cellpadding="0" cellspacing="0" bgcolor="#33FF00">
  <tr>
    <td align="left">
    <s:textfield name="username" label="用户名" required="true" id="nickname"/>
   </td>
  </tr>
  <tr><td align="left"><s:div id="mynickname" >
    <input type="button" value="检查用户名" onclick="checknickname()" align="right"/></s:div></td></tr>
  <tr>
   
    <td align="left"> <s:password name="password" label="密码" required="true"/></td>
  </tr>
  <tr>
    <td align="left"><s:password name="repassword" label="确认密码" required="true"/></td>
  </tr>
  <tr>
    <td align="left"><s:textfield name="realname" label="真实姓名" required="true"/></td>
  </tr>
  <tr>
    <td align="left"><s:textfield name="email" label="Email" required="true"/></td>
  </tr>
  <tr>
    <td align="left"><s:textfield name="address" label="地址" required="true"/></td>
  </tr>
  <tr>
    <td align="left"><s:textfield name="postcode" label="邮编" required="true"/></td>
  </tr>
  <tr>
    <td align="left"><s:textfield name="telphone" label="电话" required="true"/></td>
  </tr>
  <tr>
    <td align="left"><s:select  name="questionid" list="#{'1':'最喜欢的电影','2':'最尊敬的人'}" label="密码问题" /></td>
  </tr>
  <tr>
    <td align="left"><s:textfield name="answer" label="回答" required="true"/></td>
  </tr>
  <tr>
    <td align="right">

   <s:submit type="image" src="images/save.jpg" align="center"/>

    </td>
  </tr>
</table>
</s:form>
</td>
  </tr>
</table>







<!----------------------->
 


