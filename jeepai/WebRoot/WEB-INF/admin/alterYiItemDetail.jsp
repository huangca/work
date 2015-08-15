<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

  
  

<!-- --------------------------- -->

<s:form action="adminalterYiItemSTwo" enctype="multipart/form-data" method="post" validate="true">
<table width="556" align="center" cellpadding="0" 
	cellspacing="0" style="border:1px solid black">
<tr bgcolor="#e1e1e1" >
	<td colspan="2"><div>您浏览的物品详细信息</div></td> 
</tr>
<tr height="24">
	<td height="15">商品名字</td>
	<td><s:textfield name="name" value="%{yiItemBean.name}" /></td>
</tr>
<tr  height="24">
	<td>商品描述</td>
	
	<td><s:textfield name="desc" value="%{yiItemBean.desc}" /></td>
</tr>
<tr  height="24">
	<td>商品备注</td>
	
	<td><s:textfield name="remark" value="%{yiItemBean.remark}" /></td>
</tr>
<tr  height="24">
	<td>商品库存</td>
	
	<td><s:textfield name="initnumber" value="%{yiItemBean.initnumber}" /></td>
</tr>
<tr  height="24">
	<td>商品价格</td>
	<td> <s:textfield name="initPrice" value="%{yiItemBean.initPrice}" /></td>
</tr>
<tr  height="24">
	<td>商品开始时间</td>
	<td>  						<sx:datetimepicker name="yiItemBean.addTime" label="起拍时间"
							displayFormat="yyyy-MM-dd hh:mm:ss" /> </td>
</tr><tr  height="24">
	<td>商品结束时间</td>
	<td> 						<sx:datetimepicker name="yiItemBean.endTime" label="结束时间"
							displayFormat="yyyy-MM-dd hh:mm:ss"  /></td>
</tr><tr  height="24">
	<td>商品种类</td>
	<td> 
							<s:doubleselect label="选择种类" list="#session.bigkinds"
							listKey="bigkindId" listValue="bigkindname" name="bigkind"
							doubleList="#session.bigkinds.get(bigkindId-1).kinds"
							doubleListKey="id" doubleListValue="kindName" doubleName="kind" value="%{bigkid}" doubleValue="%{kid}">
						</s:doubleselect>
	
	</td>
</tr>
<tr  height="24">
	<td>商品状态</td>
	<td><s:select  name="state"   list="#{'4':'上架','5':'下架','6':'到货通知'}" value="%{state.id}"></s:select></td>
</tr>

  
<tr  height="24">
	<td>商品图片</td>
	<td> <img height="100px" width="100px" src="images/<s:property value='yiItemBean.picname'/>"/> 
	<s:file name="upload" label="选择要上传的图片" ></s:file></td>
</tr>
<tr><td colspan="2"><s:submit value="修改" /></td></tr>
</table>
</s:form>



<!-- --------------------------- -->





