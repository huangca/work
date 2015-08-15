<%--
/**
 * Description:
 * <br/>地址: <a href="http://www.sise.com.cn">华软高效</a> 
 * <br/>Copyright (C), 2010-201?, 黄灿华   余宏伟
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:20100301-20100401
 * @author  hch0612@scse.com.cn
 * @version  1.0
 */
--%>

<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>









<h3 align="center">添加新一口价品</h3>
<div align="center">
<s:actionerror/>
<s:form action="adminproAddYiItem" method="post" enctype="multipart/form-data">
<s:textfield name="name" label="商品名字"/>
<s:textfield name="desc" label="商品描述"/>
<s:textfield name="remark" label="商品备注"/>
<s:file name="upload" label="选择要上传的图片"/>
<s:textfield name="number" label="库存"/>
<s:textfield name="initPrice" label="价格"/>
<s:select name="avail" list="#{'1':'一天','2':'二天','3':'三天','4':'四天',
	'5':'五天','6':'一个星期','7':'一个月','8':'一年'}"
	label="有效时间"/>
  <s:doubleselect label="选择种类" list="#session.bigkinds" listKey="bigkindId" 
listValue="bigkindname" name="bigkind"
doubleList="#session.bigkinds.get(bigkindId-1).kinds" doubleListKey="id"
 doubleListValue="kindName" doubleName="kind" > 
</s:doubleselect> 
<s:textfield name="vercode" label="验证码"/>
<s:submit value="添加"/>
</s:form>
验证码：<img name="d" src="authImg.jpg"/>
</div>



