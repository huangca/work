<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html>
  <head>


  </head>
  
  <body>

  <s:form action="getTestaction">

  
  <s:doubleselect label="ѡ������" list="#session.bigkinds" listKey="bigkindId" 
listValue="bigkindname" name="bigkind"
doubleList="#session.bigkinds.get(bigkindId-1).kinds" doubleListKey="id"
 doubleListValue="kindName" doubleName="kind" > 
</s:doubleselect> 
<s:submit value="�ύ"></s:submit>
  </s:form>
  </body>
</html>
