<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@taglib prefix="s" uri="/struts-tags"%>



<!----------------------->





<table  width="766" cellspacing="0" cellpadding="0" border="0" align="center" bgColor="#FDB546">
<tr>
<td width="220" height="240">
<jsp:include page="member-left.jsp" flush="true"></jsp:include>
</td><td>
<!----中间代码------------------->



  <s:form action="confimOrderi" validate="true">
    <table width="400" align="center" cellspacing="0" cellpadding="0" bgColor="#00ffff">
<!--收货人的基本信息 -->
<tr><th>订单详情2：</th></tr>
<s:hidden name="orderiBean.orderId" value="%{orderiBean.orderId}"/>
<tr><td align="center"><s:label label="订单编号" value="%{orderiBean.orderId}" ></s:label></td></tr>
<tr><td>
<s:textfield   name="orderiBean.realname" label="收货人姓名" value="%{orderiBean.realname}"/></td>
</tr>
<!--  <tr><td><s:textfield   name="orderiBean.email" label="电子邮箱" value="%{orderBean.memberbean.email}"/></td></tr>-->
<tr><td><s:textfield   name="orderiBean.telphone" label="联系电话" value="%{orderiBean.telphone}"/></td></tr>
<tr><td><s:textfield   name="orderiBean.address" label="收货人地址" value="%{orderiBean.address}"/></td></tr>
<tr><td><s:textfield   name="orderiBean.post" label="邮政编码" value="%{orderiBean.post}"/></td></tr>
<tr><td> <s:textarea  name="orderiBean.message" label="留言"></s:textarea></td></tr>
<tr><td ><s:if test="orderiBean.cinfimsign==0" >
<s:radio name="orderiBean.model" list="#{'EMS':'EMS','快递':'快递','普通包裹':'普通包裹'}" label="选择配送方式"
labelposition="top" listKey="key" value="'EMS'" listValue="value" onclick="changeMo()"/></s:if>
<s:else>
<s:label label="配送方式" value="%{orderiBean.model}"/> 
</s:else>


</td></tr>
<tr><td>
<table align="center">
<!-- 购买的商品表单 -->
<tr>

<th align="center">商品名称</th>
<th align="center">数量</th>
<th align="center">成交价</th>
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
<tr><td align="right">商品金额 <div id="jiner"><s:property value="orderiBean.price"/></div>     </td></tr>
<tr><td align="right">配送费用:<div id="youfei"><s:property value="orderiBean.summoney-orderiBean.price"/></div></td></tr>
<tr><td align="right">订单金额  :<div id="zongjia"><s:property value="orderiBean.summoney"/></div></td></tr>
<tr><td align="center"><s:if test="orderiBean.cinfimsign==0" >
<s:submit value="信息确认无误，提交" theme="simple"/></s:if>
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

