<%@ page language="java" contentType="text/html"
    pageEncoding="GBK"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>


  </head>
  
  <body>
  �޸�������ϸ��Ϣ��
<s:form action="adminalterKindSTwo" validate="true">
<table>



<!-- <tr><td><s:select list="bigkind" listKey="bigkindId" listValue="bigkindname" name="bigkind" value="%{bigkid}" ></s:select> </td> </tr>-->
<tr><td>����ID�� <s:property value="kind.id" /></td></tr>
<tr><td><s:textfield name="kindName" label="������" value="%{kind.kindName}" required="true"  /></td></tr>
<tr><td><s:textfield name="kindDesc" label="��������" value="%{kind.kindDesc}" required="true"  /></td></tr>

<s:submit value="�޸�"/>
</table>

</s:form>
  </body>
</html>
