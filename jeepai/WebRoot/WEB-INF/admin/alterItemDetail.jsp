<%@ page contentType="text/html; charset=GBK" language="java"
	errorPage=""%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>




<!-- -------------------- -->



		<s:form action="adminalterItemSTwo" method="post" enctype="multipart/form-data"
			validate="true">
			<table width="556" align="center" cellpadding="0" cellspacing="1"
				style="border: 1px solid black">
				<tr bgcolor="#e1e1e1">
					<td colspan="2">
						<div class="mytitle">
							�޸ľ�����Ʒ��Ϣ
						</div>
					</td>
				</tr>
				<tr>
					<td>
						��Ʒ��
					</td>
					<td>
						<s:textfield name="name" value="%{item.name}" />
					</td>
				</tr>
				<tr>
					<td>
						��Ʒ����
					</td>

					<td>
						<s:textfield name="desc" value="%{item.desc}" />
					</td>
				</tr>
				<tr>
					<td>
						��Ʒ��ע
					</td>

					<td>
						<s:textfield name="remark" value="%{item.remark}" />
					</td>
				</tr>
				<tr>
					<td>
						����ʱ��
					</td>

					<td>
						<sx:datetimepicker name="item.addTime" label="����ʱ��"
							displayFormat="yyyy-MM-dd" />
					</td>
				</tr>
				<tr>
					<td>
						����ʱ��
					</td>

					<td>
						<sx:datetimepicker name="item.endTime" label="����ʱ��"
							displayFormat="yyyy-MM-dd"  />
					</td>
				</tr>
				<tr>
					<td>
						��Ʒ����
					</td>
					<td>
						<s:doubleselect label="ѡ������" list="#session.bigkinds"
							listKey="bigkindId" listValue="bigkindname" name="bigkind"
							doubleList="#session.bigkinds.get(bigkindId-1).kinds"
							doubleListKey="id" doubleListValue="kindName" doubleName="kind"  value="%{bigkid}" doubleValue="%{kid}">
						</s:doubleselect>

					</td>
				</tr>


				<tr>
					<td>
						��ƷͼƬ
					</td>
					<td>
						<img height="100px" width="100px"
							src="images/<s:property value='item.picname'/>" />
						<br />
						<br />
						<s:file name="upload" label="ѡ��Ҫ�ϴ���ͼƬ" />
					</td>
				</tr>
				<s:submit value="�޸�" />
			</table>
		</s:form>






<!-- -------------------- -->





















