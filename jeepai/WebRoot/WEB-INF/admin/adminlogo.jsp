<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>

<%@taglib prefix="s" uri="/struts-tags"%>
<table width="766" height="66" border="0" align="center" cellpadding="0" cellspacing="0" background="images/bg_01.jpg">
  <tr>
    <td valign="top"><table width="766" border="0" align="center">
      <tr >
        <td width="423" height="53" valign="bottom"><div align="right"></div></td>
        <td width="343" valign="bottom" align="right"><font color="#FFFFFF"><a href="#" class="a2">����JAVA������������ϵͳ</a>| <a href="#" class="a2">������ҳ</a></font></td>
      </tr>
    </table></td>
  </tr>
</table>
<table width="766" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#000000">
  <tr>
    <td width="15" height="25">&nbsp;</td>
    <td width="545"><font color="#FFFFFF">��ǰ��¼:<s:property value="#session.adminname"/></font></td>
    <s:bean id="counttime" name="org.hch.yhw.auction.tool.CountTime" />
    <td width="206"><font color="#FFFFFF">������:<s:property value="#counttime.currentlyTime()"/></font></td>
  </tr>
</table>