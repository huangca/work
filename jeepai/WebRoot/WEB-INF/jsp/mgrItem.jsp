<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>



<h3 align="center">�������Ʒ</h3>
<div align="center">
<s:actionerror/>
<s:form action="adminproAddItem" method="post" enctype="multipart/form-data">
<s:textfield name="name" label="��Ʒ��"/>
<s:textfield name="desc" label="��Ʒ����"/>
<s:textfield name="remark" label="��Ʒ��ע"/>
<s:file name="upload" label="ѡ��Ҫ�ϴ���ͼƬ"></s:file>
<s:textfield name="initPrice" label="���ļ۸�"/>
<s:select name="avail" list="#{'1':'һ��','2':'����','3':'����','4':'����',
	'5':'����','6':'һ������','7':'һ����','8':'һ��'}"
	label="��Чʱ��"/>
  <s:doubleselect label="ѡ������" list="#session.bigkinds" listKey="bigkindId" 
listValue="bigkindname" name="bigkind"
doubleList="#session.bigkinds.get(bigkindId-1).kinds" doubleListKey="id"
 doubleListValue="kindName" doubleName="kind" > 
</s:doubleselect> 
<s:textfield name="zengfu" value="10" label="�����ٷֱ�" size="3"/>
<s:textfield name="vercode" label="��֤��"/>
<s:submit value="���"/>
</s:form>
��֤�룺<img name="d" src="authImg.jpg"/>
</div>



