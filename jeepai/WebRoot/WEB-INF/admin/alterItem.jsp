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
<s:select list="kinds" label="种类分类" name="id"
	listKey="id"
	listValue="kindName" headerKey="0"  headerValue="--全部--" onchange="changTempValue()"/>
</form>
</td></tr></table>
<table width="556" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td>图片</td>
    <td>编号</td>
    <td>名字</td>
    <td>描述</td>
    <td>初始价格</td>
    <td >当前价格</td>
    <td>大类</td>
    <td>子类</td>
    <td>起拍时间</td>
    <td>结束时间</td>
    <td>状态</td>
    <td>动作</td>
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
    <td width="40"><a href="adminalterItemDetail.action?itemId=<s:property value='id'/>&kid=<s:property value='kid'/>&bigkid=<s:property value='bigkid'/>">修改</a></td>
  </tr>
   </s:iterator>
   
</table>
