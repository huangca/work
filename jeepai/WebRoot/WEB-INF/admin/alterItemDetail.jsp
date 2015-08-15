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
							修改竞拍商品信息
						</div>
					</td>
				</tr>
				<tr>
					<td>
						商品名
					</td>
					<td>
						<s:textfield name="name" value="%{item.name}" />
					</td>
				</tr>
				<tr>
					<td>
						商品描述
					</td>

					<td>
						<s:textfield name="desc" value="%{item.desc}" />
					</td>
				</tr>
				<tr>
					<td>
						商品备注
					</td>

					<td>
						<s:textfield name="remark" value="%{item.remark}" />
					</td>
				</tr>
				<tr>
					<td>
						起拍时间
					</td>

					<td>
						<sx:datetimepicker name="item.addTime" label="起拍时间"
							displayFormat="yyyy-MM-dd" />
					</td>
				</tr>
				<tr>
					<td>
						结束时间
					</td>

					<td>
						<sx:datetimepicker name="item.endTime" label="结束时间"
							displayFormat="yyyy-MM-dd"  />
					</td>
				</tr>
				<tr>
					<td>
						商品种类
					</td>
					<td>
						<s:doubleselect label="选择种类" list="#session.bigkinds"
							listKey="bigkindId" listValue="bigkindname" name="bigkind"
							doubleList="#session.bigkinds.get(bigkindId-1).kinds"
							doubleListKey="id" doubleListValue="kindName" doubleName="kind"  value="%{bigkid}" doubleValue="%{kid}">
						</s:doubleselect>

					</td>
				</tr>


				<tr>
					<td>
						商品图片
					</td>
					<td>
						<img height="100px" width="100px"
							src="images/<s:property value='item.picname'/>" />
						<br />
						<br />
						<s:file name="upload" label="选择要上传的图片" />
					</td>
				</tr>
				<s:submit value="修改" />
			</table>
		</s:form>






<!-- -------------------- -->





















