<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

  
  

<!-- --------------------------- -->

<s:form action="adminalterYiItemSTwo" enctype="multipart/form-data" method="post" validate="true">
<table width="556" align="center" cellpadding="0" 
	cellspacing="0" style="border:1px solid black">
<tr bgcolor="#e1e1e1" >
	<td colspan="2"><div>���������Ʒ��ϸ��Ϣ</div></td> 
</tr>
<tr height="24">
	<td height="15">��Ʒ����</td>
	<td><s:textfield name="name" value="%{yiItemBean.name}" /></td>
</tr>
<tr  height="24">
	<td>��Ʒ����</td>
	
	<td><s:textfield name="desc" value="%{yiItemBean.desc}" /></td>
</tr>
<tr  height="24">
	<td>��Ʒ��ע</td>
	
	<td><s:textfield name="remark" value="%{yiItemBean.remark}" /></td>
</tr>
<tr  height="24">
	<td>��Ʒ���</td>
	
	<td><s:textfield name="initnumber" value="%{yiItemBean.initnumber}" /></td>
</tr>
<tr  height="24">
	<td>��Ʒ�۸�</td>
	<td> <s:textfield name="initPrice" value="%{yiItemBean.initPrice}" /></td>
</tr>
<tr  height="24">
	<td>��Ʒ��ʼʱ��</td>
	<td>  						<sx:datetimepicker name="yiItemBean.addTime" label="����ʱ��"
							displayFormat="yyyy-MM-dd hh:mm:ss" /> </td>
</tr><tr  height="24">
	<td>��Ʒ����ʱ��</td>
	<td> 						<sx:datetimepicker name="yiItemBean.endTime" label="����ʱ��"
							displayFormat="yyyy-MM-dd hh:mm:ss"  /></td>
</tr><tr  height="24">
	<td>��Ʒ����</td>
	<td> 
							<s:doubleselect label="ѡ������" list="#session.bigkinds"
							listKey="bigkindId" listValue="bigkindname" name="bigkind"
							doubleList="#session.bigkinds.get(bigkindId-1).kinds"
							doubleListKey="id" doubleListValue="kindName" doubleName="kind" value="%{bigkid}" doubleValue="%{kid}">
						</s:doubleselect>
	
	</td>
</tr>
<tr  height="24">
	<td>��Ʒ״̬</td>
	<td><s:select  name="state"   list="#{'4':'�ϼ�','5':'�¼�','6':'����֪ͨ'}" value="%{state.id}"></s:select></td>
</tr>

  
<tr  height="24">
	<td>��ƷͼƬ</td>
	<td> <img height="100px" width="100px" src="images/<s:property value='yiItemBean.picname'/>"/> 
	<s:file name="upload" label="ѡ��Ҫ�ϴ���ͼƬ" ></s:file></td>
</tr>
<tr><td colspan="2"><s:submit value="�޸�" /></td></tr>
</table>
</s:form>



<!-- --------------------------- -->





