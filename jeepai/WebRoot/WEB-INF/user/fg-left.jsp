<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<table width="207" border="0" align="left" cellspacing="0" cellpadding="0">
  <tr>
    <td  width="207" >
    <!--左侧01-->
	<%if(session.getAttribute("username")==null){%>		
	<table width="207" align="left" height="138"  border="0" cellpadding="0" cellspacing="0" background="images/fg_left01.jpg">
      <tr>
        <td valign="top"><table width="100%"  border="0" cellpadding="0" cellspacing="0">
		 <tr>
            <td height="16">&nbsp;</td>
          </tr>
        </table>
        <form name="form" method="post" action="userprocessLogin">
          <table width="185" border="0" align="center">
            <tr>
              <td width="60" height="25">用户名：</td>
              <td width="115"> <input name="username" type="text" size="17"></td>
            </tr>
            <tr>
              <td height="25">密&nbsp;&nbsp;码：</td>
              <td><input name="password" type="password" size="17"></td>
            </tr>
			 <tr>
              <td height="26"><s:submit type="image" src="images/fg-land.gif" theme="simple"/></td>
              <td height="26">  &nbsp;&nbsp;<a href="userregedit.action">注册</a>&nbsp;&nbsp;<a href="usergotofindpsw.action">找回密码？</a></td>
			 </tr>	  
          </table>
		  </form>
		  </td>
      </tr>
    </table>
	<%}else{
	  	%>

	<table width="207" align="left" height="138"  border="0" cellpadding="0" cellspacing="0" background="images/fg_left01.jpg">
      <tr>
        <td valign="top"><table width="207"  border="0" cellpadding="0" cellspacing="0">
		 <tr>
            <td height="30">&nbsp;</td>
          </tr>
        </table>
       
          <table width="167" border="0" align="center">
            <tr>
              <td width="161" height="75"><font color="#FB6801"><s:property value="#session.username"/>,</font>欢迎回来</td>
              </tr>
 
			  <tr>
              <td height="20" align="right" valign="middle"><a href="userQuit.action">安全退出</a></td>
              </tr>	
          </table>
	  </td>
     </tr>
    </table>
		<%}%></td>
  </tr>
  <tr>
    <td  ><table width="207" align="left" height="194" border="0" background="images/fg_left02.jpg">
          <tr>
            <td valign="top"><table width="150" border="0">
              <tr>
                <td height="32">&nbsp;</td>
              </tr>
            </table>
              <table width="179" border="0" align="center">
                <tr>
                  <td width="171" height="143">
				  <marquee direction="up" height="114" onmouseout="this.start()" 
             onmouseover="this.stop()" scrollAmount="1" scrollDelay="1">	  

					<a href="#">	<img src="images/sign.gif"/>最新公告1</a><br/><br/>
					<a href="#">	<img src="images/sign.gif">最新公告2</a><br/><br/>
					<a href="#">	<img src="images/sign.gif">最新公告3</a><br/><br/>
					<a href="#">	<img src="images/sign.gif">最新活动4</a><br/><br/>
					<a href="#">	<img src="images/sign.gif">最新活动5</a><br/><br/>
					<a href="#">    <img src="images/sign.gif">最新活动6</a><br/><br/>
            </marquee>			  
			
			    </td>
                </tr>
              </table></td>
          </tr>
        </table>	   
	    </td>
  </tr>
  <tr>
   <td  ><table width="207" align="left" height="250" border="0" cellpadding="0" cellspacing="0" background="images/fg_left05.jpg">
          <tr>
            <td valign="top"><table width="173">
              <tr>
                <td height="35"></td>
              </tr>
            </table>
              <table width="186" align="center">
                <tr>
                  <td height="41">  <a href="http://www.alipay.com.cn">  <img src="images/alipay.jpg" width="175" height="41" />
				  </a>
				  </td>
                </tr>	                <tr>
                  <td height="41"><a href="http://www.alipay.com.cn">     <img src="images/kdf.jpg" width="175" height="41" />
				  </a>
				  </td>
                </tr>
			  <tr>      <td height="41">  <a href="http://www.alipay.com.cn">  <img src="images/okf.jpg" width="175" height="41" /></a>
			  </td>
                </tr>
				  <tr>    <td height="41"> <a href="http://www.taobao.com.cn"><img src="images/taobao.jpg" width="175" height="41" /></a></td>
                </tr>
				                <tr>
                  <td height="43"> <a href="http://www.alipay.com.cn"><img src="images/dongfang.jpg" width="175" height="41" /></a></td>
                </tr>
				             

              </table></td>
          </tr>
      </table></td>
  </tr>
</table>
    

