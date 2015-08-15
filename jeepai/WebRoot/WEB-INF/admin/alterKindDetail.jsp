<%@ page language="java" contentType="text/html"
    pageEncoding="GBK"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>


  </head>
  
  <body>
  修改种类详细信息表
<s:form action="adminalterKindSTwo" validate="true">
<table>



<!-- <tr><td><s:select list="bigkind" listKey="bigkindId" listValue="bigkindname" name="bigkind" value="%{bigkid}" ></s:select> </td> </tr>-->
<tr><td>种类ID： <s:property value="kind.id" /></td></tr>
<tr><td><s:textfield name="kindName" label="种类名" value="%{kind.kindName}" required="true"  /></td></tr>
<tr><td><s:textfield name="kindDesc" label="种类描述" value="%{kind.kindDesc}" required="true"  /></td></tr>

<s:submit value="修改"/>
</table>

</s:form>
  </body>
</html>
