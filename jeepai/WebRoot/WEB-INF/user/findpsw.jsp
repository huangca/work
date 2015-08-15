<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
  <head>   
    <title>找回密码</title>


  </head>
  
  <body>
<s:form validate="true" action="userfindpsw">
   <table width="766"  border="0" cellspacing="0" cellpadding="0" align="center">
    <tr>
      <td align="center">找回密码 </td>
    </tr>
    <tr>      
      <td align="center"> <s:textfield name="username" label="会员昵称" required="true"/></td>
    </tr>
    <tr>
      
      <td align="center"><s:select  name="questionid" list="#{'1':'最喜欢的电影','2':'最尊敬的人'}" label="密码问题" /> </td>
    </tr>
    <tr>
       
      <td align="center">
        <s:textfield name="answer" label="回答" required="true"/>
     </td>
    </tr>
    <tr>
    
      <td align="center"><s:submit type="image" src="images/save.jpg" align="center"/> </td>
    </tr>
  </table>
  </s:form>
  </body>
</html>
