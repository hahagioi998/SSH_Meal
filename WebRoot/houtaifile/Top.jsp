﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD id=Head1>
<TITLE>无标题页</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<!--去除超链接的下划线-->
<style type="text/css">
<!--
a:link {
	text-decoration: none;
}

a:visited {
	text-decoration: none;
	k
}

a:hover {
	text-decoration: none;
}

a:active {
	text-decoration: none;
}
-->
</style>

<STYLE type=text/css> 
*{
	FONT-SIZE: 12px; COLOR: white
}
#logo {
	COLOR: white
}
#logo A {
	COLOR: white
}
FORM {
	MARGIN: 0px
}
</STYLE>
<SCRIPT src="Top.files/Clock.js" type=text/javascript></SCRIPT>
<META content="MSHTML 6.00.2900.5848" name=GENERATOR>
</HEAD>
<BODY 
style="BACKGROUND-IMAGE: url(../images/bg.gif); MARGIN: 0px; BACKGROUND-REPEAT: repeat-x">
<form id="form1">
  <DIV id=logo 
style="BACKGROUND-IMAGE: url(../images/logo.png); BACKGROUND-REPEAT: no-repeat">
    <DIV 
style="PADDING-RIGHT: 50px; BACKGROUND-POSITION: right 50%; DISPLAY: block; PADDING-LEFT: 0px; BACKGROUND-IMAGE: url(../images/bg_banner_menu.gif); PADDING-BOTTOM: 0px; PADDING-TOP: 3px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 30px; TEXT-ALIGN: right">
<A href="#"><IMG src="Top.files/mail.gif" align=absMiddle border=0></A> 您有新消息
<A id=HyperLink1 href="#">5</A>条
 <IMG src="Top.files/menu_seprator.gif" align=absMiddle>
  <A  href="toShowMeal">返回首页</A> 
<IMG src="Top.files/menu_seprator.gif" align=absMiddle>
 <A id=HyperLink3 href="#">退出系统</A> 
 </DIV>
    <DIV style="DISPLAY: block; HEIGHT: 54px"></DIV>
    <DIV 
style="BACKGROUND-IMAGE: url(../images/bg_nav.gif); BACKGROUND-REPEAT: repeat-x; HEIGHT: 30px">
      <TABLE cellSpacing=0 cellPadding=0 width="100%">
        <TBODY>
          <TR>
            <TD>
              <DIV>
              <IMG src="Top.files/nav_pre.gif" align=absMiddle>
              <font style="color: red; font-size: 16px" size="8px">欢迎你:${sessionScope.admin.loginName}</font>
               </DIV>
            </TD>
            <TD align=right width="70%">
            <SPAN style="PADDING-RIGHT: 50px">
            <A  href="javascript:history.go(-1);">
            <IMG src="Top.files/nav_back.gif" align=absMiddle border=0>后退</A> 
      <A href="javascript:history.go(1);">
      <IMG  src="Top.files/nav_forward.gif" align=absMiddle border=0>前进
      </A>
      <A href="#" target=_top>
      <IMG src="Top.files/nav_changePassword.gif" align=absMiddle border=0>重新登录</A>
       <A href="#"  target=mainFrame>
       <IMG src="Top.files/nav_resetPassword.gif" align=absMiddle border=0>修改密码</A>
        <A  href="#" target=mainFrame>
        <IMG  src="Top.files/nav_help.gif" align=absMiddle border=0>帮助</A>
         <IMG src="Top.files/menu_seprator.gif" align=absMiddle> 
        <img  src="Top.files/clock.gif"  width="25" height="25"align=absMiddle />
         <SPAN  id=clock>
       
         </SPAN>
        
         </SPAN>
         
         </TD>
          </TR>
        </TBODY>
      </TABLE>
    </DIV>
  </DIV>
  <SCRIPT type=text/javascript>
    var clock = new Clock();
    clock.display(document.getElementById("clock"));
</SCRIPT>
</form>
</BODY>
</HTML>
