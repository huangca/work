<%--
/**
 * Description:
 * <br/>��ַ: <a href="http://www.sise.com.cn">�����Ч</a> 
 * <br/>Copyright (C), 2010-201?, �Ʋӻ�   ���ΰ
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:20100301-20100401
 * @author  hch0612@scse.com.cn
 * @version  1.0
 */
--%>

<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>









<h3 align="center">�����һ�ڼ�Ʒ</h3>
<div align="center">
<s:actionerror/>
<s:form action="adminproAddYiItem" method="post" enctype="multipart/form-data">
<s:textfield name="name" label="��Ʒ����"/>
<s:textfield name="desc" label="��Ʒ����"/>
<s:textfield name="remark" label="��Ʒ��ע"/>
<s:file name="upload" label="ѡ��Ҫ�ϴ���ͼƬ"/>
<s:textfield name="number" label="���"/>
<s:textfield name="initPrice" label="�۸�"/>
<s:select name="avail" list="#{'1':'һ��','2':'����','3':'����','4':'����',
	'5':'����','6':'һ������','7':'һ����','8':'һ��'}"
	label="��Чʱ��"/>
  <s:doubleselect label="ѡ������" list="#session.bigkinds" listKey="bigkindId" 
listValue="bigkindname" name="bigkind"
doubleList="#session.bigkinds.get(bigkindId-1).kinds" doubleListKey="id"
 doubleListValue="kindName" doubleName="kind" > 
</s:doubleselect> 
<s:textfield name="vercode" label="��֤��"/>
<s:submit value="���"/>
</s:form>
��֤�룺<img name="d" src="authImg.jpg"/>
</div>



