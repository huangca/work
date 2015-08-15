<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>



<h3 align="center">添加新物品</h3>
<div align="center">
<s:actionerror/>
<s:form action="adminproAddItem" method="post" enctype="multipart/form-data">
<s:textfield name="name" label="物品名"/>
<s:textfield name="desc" label="物品描述"/>
<s:textfield name="remark" label="物品备注"/>
<s:file name="upload" label="选择要上传的图片"></s:file>
<s:textfield name="initPrice" label="起拍价格"/>
<s:select name="avail" list="#{'1':'一天','2':'二天','3':'三天','4':'四天',
	'5':'五天','6':'一个星期','7':'一个月','8':'一年'}"
	label="有效时间"/>
  <s:doubleselect label="选择种类" list="#session.bigkinds" listKey="bigkindId" 
listValue="bigkindname" name="bigkind"
doubleList="#session.bigkinds.get(bigkindId-1).kinds" doubleListKey="id"
 doubleListValue="kindName" doubleName="kind" > 
</s:doubleselect> 
<s:textfield name="zengfu" value="10" label="增幅百分比" size="3"/>
<s:textfield name="vercode" label="验证码"/>
<s:submit value="添加"/>
</s:form>
验证码：<img name="d" src="authImg.jpg"/>
</div>



