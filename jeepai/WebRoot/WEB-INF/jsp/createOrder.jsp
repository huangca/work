<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>




<!----------------------->



<table width="766" border="0" align="center" cellpadding="0" cellspacing="0" bgColor="#00ffff">
  <tr>
    <th width="183" scope="row"> </th>
    <td width="400"><s:form action="usersubmitOrderAction"  >
<table width="400" align="center" cellspacing="0" cellpadding="0" bgColor="#00ffff">
<tr>
<td >
<table width="400" align="center" cellspacing="0" cellpadding="0" bgColor="#00ffff">
<!--�ջ��˵Ļ�����Ϣ -->
<tr><th>�������飺</th></tr>
<tr><td>
<s:textfield   name="orderBean.memberbean.realName" label="�ջ�������" value="%{orderBean.memberbean.realName}"/></td>
</tr>
<tr><td><s:textfield   name="orderBean.memberbean.email" label="��������" value="%{orderBean.memberbean.email}"/></td></tr>
<tr><td><s:textfield   name="orderBean.memberbean.telphone" label="��ϵ�绰" value="%{orderBean.memberbean.telphone}"/></td></tr>
<tr><td><s:textfield   name="orderBean.memberbean.address" label="�ջ��˵�ַ" value="%{orderBean.memberbean.address}"/></td></tr>
<tr><td><s:textfield   name="orderBean.memberbean.postcode" label="��������" value="%{orderBean.memberbean.postcode}"/></td></tr>
<tr><td> <s:textarea  name="message" label="����"></s:textarea></td></tr>
<tr><td ><s:radio name="model" list="#{'EMS':'EMS','���':'���','��ͨ����':'��ͨ����'}" label="ѡ�����ͷ�ʽ"
labelposition="top" listKey="key" listValue="value" onclick="changeMo()"/>
</td></tr>
</table>
</td></tr>
<tr><td>
<table align="center">
<!-- �������Ʒ�� -->
<tr>
<th align="center">��Ʒ���</th>
<th align="center">��Ʒ����</th>
<th align="center">����</th>
<th align="center">����</th>
<th align="center">С��</th>
</tr>
<s:iterator id="cartBean" value="orderBean.cartBeanList" status="st">
<tr>
<td align="center"><s:property value="yiitemId"/></td>
<td align="center"><s:property value="yiitemName"/></td>
<td align="center"><s:property value="number"/></td>
<td align="center"><s:property value="initpiece"/></td>
<td align="center"><s:property value="totalmoney"/></td>
</tr>
</s:iterator>
</table>
</td></tr>
<tr><td align="right">��Ʒ��� <div id="jiner"><s:property value="orderBean.summoney"/></div>     </td></tr>
<tr><td align="right">���ͷ���:<div id="youfei"></div></td></tr>
<tr><td align="right">�������  :<div id="zongjia"><s:property value="orderBean.summoney"/></div></td></tr>
<tr><td align="center">
<s:submit value="ȷ�������ύ����" theme="simple"/>
</td></tr>
</table>
</s:form></td>
    <td width="183"></td>
  </tr>
</table>
<script type="text/javascript">

function changeMo(){

var zongjia=document.getElementById("zongjia");
var youfei=document.getElementById("youfei");
var jiner=document.getElementById("jiner");
var modelm=document.getElementsByName("model");
var howmuch=parseFloat(jiner.innerText);
for(j=0;j<modelm.length;j++)
{
if(modelm[j].checked){
if(j==0){
//youfei.innerHTML=howmuch+25;
youfei.innerText=25;
zongjia.innerText=howmuch+25;
}else if(j==1){youfei.innerText=15;zongjia.innerText=howmuch+15;
}else{youfei.innerText=10;zongjia.innerText=howmuch+10;
}
}
}
}</script>









<!----------------------->

