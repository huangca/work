<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>



<table width="60%" align="center" cellpadding="0"
	cellspacing="1" style="border:1px solid black">
<tr>
	<td colspan="2" ><div class="mytitle">当前的物品种类如下：</div></td> 
</tr>
<s:iterator id="bigkind" value="bigkinds" status="st">
<tr height="24" <s:if test="#st.odd">
	style="background-color:#dddddd"</s:if>
	<s:else>style="background-color:#eeeeee"</s:else>>

<td><a href='adminalterBigKindDetail.action?bigkindId=<s:property value="bigkindId"/>'>
<s:property value="bigkindname"/></a><br/>

</td>


<td>
<table>
<s:iterator id="kind" value="kinds" >
<tr>
<td>
<a href='adminalterKindDetail.action?id=<s:property value="id"/>&bigkid=<s:property value="bigkindId"/>'>
<s:property value="kindName"/></a>
</td>
</tr>
</s:iterator>
</table>
</td>
</tr>

</s:iterator>
</table>


