<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
  <head>   
    <title>�һ�����</title>


  </head>
  
  <body>
<s:form validate="true" action="userfindpsw">
   <table width="766"  border="0" cellspacing="0" cellpadding="0" align="center">
    <tr>
      <td align="center">�һ����� </td>
    </tr>
    <tr>      
      <td align="center"> <s:textfield name="username" label="��Ա�ǳ�" required="true"/></td>
    </tr>
    <tr>
      
      <td align="center"><s:select  name="questionid" list="#{'1':'��ϲ���ĵ�Ӱ','2':'���𾴵���'}" label="��������" /> </td>
    </tr>
    <tr>
       
      <td align="center">
        <s:textfield name="answer" label="�ش�" required="true"/>
     </td>
    </tr>
    <tr>
    
      <td align="center"><s:submit type="image" src="images/save.jpg" align="center"/> </td>
    </tr>
  </table>
  </s:form>
  </body>
</html>
