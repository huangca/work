<%@ page language="java" contentType="text/html"
    pageEncoding="GBK"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>


  </head>
  
  <body>
  <s:form action="adminalterBigKindSTwo" validate="true">
<table>



<tr><td>种类ID： <s:property value="bigkind.bigkindId" /></td></tr>
<tr><td><s:textfield name="bigkindname" label="种类名" value="%{bigkind.bigkindname}" required="true"  /></td></tr>
<tr><td><s:textfield name="kinddesc" label="种类描述" value="%{bigkind.kinddesc}" required="true"  /></td></tr>

<s:submit value="修改"/>
</table>

</s:form>
  </body>
</html>
