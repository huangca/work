<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@taglib prefix="s" uri="/struts-tags"%>



<!----------------------->





<table  width="766" cellspacing="0" cellpadding="0" border="0" align="center" bgColor="#FDB546">
<tr>
<td width="220" height="240">
<jsp:include page="member-left.jsp" flush="true"></jsp:include>
</td><td>
<!----�м����------------------->



  <s:form action="confimOrderi" validate="true">
    <table width="400" align="center" cellspacing="0" cellpadding="0" bgColor="#00ffff">
<!--�ջ��˵Ļ�����Ϣ -->
<tr><th>��������2��</th></tr>
<s:hidden name="orderiBean.orderId" value="%{orderiBean.orderId}"/>
<tr><td align="center"><s:label label="�������" value="%{orderiBean.orderId}" ></s:label></td></tr>
<tr><td>
<s:textfield   name="orderiBean.realname" label="�ջ�������" value="%{orderiBean.realname}"/></td>
</tr>
<!--  <tr><td><s:textfield   name="orderiBean.email" label="��������" value="%{orderBean.memberbean.email}"/></td></tr>-->
<tr><td><s:textfield   name="orderiBean.telphone" label="��ϵ�绰" value="%{orderiBean.telphone}"/></td></tr>
<tr><td><s:textfield   name="orderiBean.address" label="�ջ��˵�ַ" value="%{orderiBean.address}"/></td></tr>
<tr><td><s:textfield   name="orderiBean.post" label="��������" value="%{orderiBean.post}"/></td></tr>
<tr><td> <s:textarea  name="orderiBean.message" label="����"></s:textarea></td></tr>
<tr><td ><s:if test="orderiBean.cinfimsign==0" >
<s:radio name="orderiBean.model" list="#{'EMS':'EMS','���':'���','��ͨ����':'��ͨ����'}" label="ѡ�����ͷ�ʽ"
labelposition="top" listKey="key" value="'EMS'" listValue="value" onclick="changeMo()"/></s:if>
<s:else>
<s:label label="���ͷ�ʽ" value="%{orderiBean.model}"/> 
</s:else>


</td></tr>
<tr><td>
<table align="center">
<!-- �������Ʒ�� -->
<tr>

<th align="center">��Ʒ����</th>
<th align="center">����</th>
<th align="center">�ɽ���</th>
</tr>
<tr>
<td align="center"><s:property value="orderiBean.item"/></td>
<td align="center"><s:property value="orderiBean.number"/></td>
<td align="center"><s:property value="orderiBean.price"/></td>

</tr>

</table>

</td></tr>
<tr><td>
<table align="right">
<tr><td align="right">��Ʒ��� <div id="jiner"><s:property value="orderiBean.price"/></div>     </td></tr>
<tr><td align="right">���ͷ���:<div id="youfei"><s:property value="orderiBean.summoney-orderiBean.price"/></div></td></tr>
<tr><td align="right">�������  :<div id="zongjia"><s:property value="orderiBean.summoney"/></div></td></tr>
<tr><td align="center"><s:if test="orderiBean.cinfimsign==0" >
<s:submit value="��Ϣȷ�������ύ" theme="simple"/></s:if>
</td></tr>

</table>

</td></tr>
</table>
</s:form>
<script type="text/javascript">

function changeMo(){

var zongjia=document.getElementById("zongjia");
var youfei=document.getElementById("youfei");
var jiner=document.getElementById("jiner");
var modelm=document.getElementsByName("orderiBean.model");
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
</td>
</tr>
</table>






<!----------------------->

