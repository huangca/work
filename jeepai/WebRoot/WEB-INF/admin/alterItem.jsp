<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>

<script language="JavaScript" type="text/JavaScript"> 
function changTempValue() { 
var tf=document.forms["viewSortForm"];
tf.action="alterItem.action";
tf.submit();
} 
</script>

    <table  width="556" border="0" align="center" cellpadding="0" cellspacing="0"><tr><td>
<form name="viewSortForm"  method="post" >
<s:select list="kinds" label="�������" name="id"
	listKey="id"
	listValue="kindName" headerKey="0"  headerValue="--ȫ��--" onchange="changTempValue()"/>
</form>
</td></tr></table>
<table width="556" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td>ͼƬ</td>
    <td>���</td>
    <td>����</td>
    <td>����</td>
    <td>��ʼ�۸�</td>
    <td >��ǰ�۸�</td>
    <td>����</td>
    <td>����</td>
    <td>����ʱ��</td>
    <td>����ʱ��</td>
    <td>״̬</td>
    <td>����</td>
  </tr>
  <s:iterator id="item" value="availableItems" status="st">
  <tr>
    <td width="45" height="45" ><img height="45px" width="45px" src="images/<s:property value="picname"/>"/></td>
    <td width="40" height="45"><s:property value="id" /></td>
    <td width="40"><s:property value="name"/></td>
    <td width="40"><s:property value="desc"/></td>
    <td width="57" ><s:property value="initPrice" /></td>
    <td width="57"><s:property value="maxPrice"/></td>
    <td width="40"><s:property value="bigkind" /></td>
    <td width="40"><s:property value="kind" /></td>
    <td width="57"><s:date name="addTime"  format="yyyy-MM-dd"/>    </td>
    <td width="57"><s:date name="endTime"  format="yyyy-MM-dd"/>  </td>
    <td width="40"><s:property value="state" /></td>
    <td width="40"><a href="adminalterItemDetail.action?itemId=<s:property value='id'/>&kid=<s:property value='kid'/>&bigkid=<s:property value='bigkid'/>">�޸�</a></td>
  </tr>
   </s:iterator>
   
</table>
