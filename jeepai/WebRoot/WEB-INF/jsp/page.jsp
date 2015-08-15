<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>    
      
      <table width="556" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="262" align="right">共<s:property value="totalRows"/>行</td>
    <td width="45" align="center"> 共<s:property value="pager.getTotalPages()"/>页</td>
    <td width="45" align="center">第<s:property value="currentPage"/>页</td>
    <td width="45" align="center">	<a href="<s:url value="%{actionnameString}">
    			<s:param name="currentPage" value="currentPage"/>
    			<s:param name="pagerMethod" value="'first'"/>
    			
  		</s:url>"><img src="images/first.gif"/></a></td>
    <td width="45" align="center"><a href="<s:url value="%{actionnameString}">
    			<s:param name="currentPage" value="currentPage"/>
    			<s:param name="pagerMethod" value="'previous'"/>
    		</s:url>"><img src="images/backoff.gif"/></a></td>
    <td width="45" align="center"><a href="<s:url value="%{actionnameString}">
    			<s:param name="currentPage" value="currentPage"/>
    			<s:param name="pagerMethod" value="'next'"/>
    		</s:url>"><img src="images/next.gif"/></a></td>
    <td width="69"><a href="<s:url value="%{actionnameString}">
    			<s:param name="currentPage" value="currentPage"/>
    			<s:param name="pagerMethod" value="'last'"/>
    		</s:url>"><img src="images/last.gif"/></a></td>
  </tr>
</table>