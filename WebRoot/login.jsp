﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登陆页面</title>
</head>
<style type="text/css">
body{margin:0px; padding:0px}
</style>
<body style="margin:0px; padding:0px;" >
<div style=" background:url(image/logo.png); height:605px; width:1366px; position: absolute;top: 0px;">
	<!----------------------------------------------------------------------美食家用户登录------------------------->
    <s:if test="#parameters.role[0]=='user'">
    <form action="validateLogin?type=userlogin" method="post" name="ufrm">
    <div style="position:absolute; top:212px; left:490px;">
    <div>
    <img src="image/user.png"  />
     </div>
     <div style="position:absolute; top:2px; left:41px; width:120px;">
     <font style="font-family:华文楷体; font-size:24px">美食账号：</font>
     </div>
     <div style="position:absolute; top:1px; left:160px;">
     <input type="text" name="loginName" size="30" style="height:30px; width:210px; "  />
     </div>
     
     <div style="position:absolute; top:60px; left:1px; width:120px;">
    <img src="image/pwd.png"  />
     </div>
     <div style="position:absolute; top:60px; left:41px; width:120px;">
     <font style="font-family:华文楷体; font-size:24px">美食密码：</font>
     </div>
     <div style="position:absolute; top:62px; left:160px;">
     <input type="password" name="loginPwd" size="30" style="height:30px; width:210px; "  />
     </div>
     <div style="position:absolute; top:100px; left:158px;">
     <input type="checkbox"  />
     </div>
     <div style="position:absolute; top:100px; left:184px; width:200px;">
     <font style="font-size:14px">记住密码</font>
     </div>
     <div style="position:absolute; top:125px; left:160px; width:200px;">
     <input type="submit" value="登陆"  style="height:30px; width:212px; background:#E83204;" />
     </div>
     <div style="position:absolute; top:160px; left:160px;">
     <div style=" position:absolute; width:80px; top:5px; left:0px;"><a><font color="#20CCDF">[忘记密码]</font></a></div>
     <div style=" position:absolute; width:100px; left:90px; top:5px;"><a><font  color="#20CCDF">[注册新用户]</font></a></div>
     </div>
     <div  style=" position:absolute; width:100px; left:1px; top:185px; ">
     <hr size="3" style="width:370px;" />
     </div>
     <div  style=" position:absolute; width:300px; left:160px; top:200px; ">
     <font style="font-size:14px">使用合作网站账号登陆</font>
     </div>
     <div style=" position:absolute; width:300px; left:160px; top:230px; ">
      <a> <img  src="image/wei6.png"/></a>
      <a> <img  src="image/zhi.png"/></a>
      <a> <img src="image/q.png" /></a>
     </div>
     </div>
    </form>
    </s:if>
   <!----------------------------------------------------------------------管理员用户登录------------------------->
     <s:if test="#parameters.role[0]=='admin'">
     <form action="validateLogin?type=adminlogin" method="post" name="ufrm">
    <div style="position:absolute; top:212px; left:490px;">
    <div>
    <img src="image/user.png"  />
     </div>
     <div style="position:absolute; top:2px; left:41px; width:120px;">
     <font style="font-family:华文楷体; font-size:24px">管理账号：</font>
     </div>
     <div style="position:absolute; top:1px; left:160px;">
     <input type="text" name="loginName" size="30" style="height:30px; width:210px; "  />
     </div>
     
     <div style="position:absolute; top:60px; left:1px; width:120px;">
    <img src="image/pwd.png"  />
     </div>
     <div style="position:absolute; top:60px; left:41px; width:120px;">
     <font style="font-family:华文楷体; font-size:24px">管理密码：</font>
     </div>
     <div style="position:absolute; top:62px; left:160px;">
     <input type="password" name="loginPwd" size="30" style="height:30px; width:210px; "  />
     </div>
     <div style="position:absolute; top:100px; left:158px;">
     <input type="checkbox"  />
     </div>
     <div style="position:absolute; top:100px; left:184px; width:200px;">
     <font style="font-size:14px">记住密码</font>
     </div>
     <div style="position:absolute; top:125px; left:160px; width:200px;">
     <input type="submit" value="登陆"  style="height:30px; width:212px; background:#E83204;" />
     </div>
     <div style="position:absolute; top:160px; left:160px;">
     <div style=" position:absolute; width:80px; top:5px; left:0px;"><a><font color="#20CCDF">[忘记密码]</font></a></div>
     <div style=" position:absolute; width:100px; left:90px; top:5px;"><a><font  color="#20CCDF">[注册新用户]</font></a></div>
     </div>
     <div  style=" position:absolute; width:100px; left:1px; top:185px; ">
     <hr size="3" style="width:370px;" />
     </div>
     <div  style=" position:absolute; width:300px; left:160px; top:200px; ">
     <font style="font-size:14px">使用合作网站账号登陆</font>
     </div>
     <div style=" position:absolute; width:300px; left:160px; top:230px; ">
      <a> <img  src="image/wei6.png"/></a>
      <a> <img  src="image/zhi.png"/></a>
      <a> <img src="image/q.png" /></a>
     </div>
     </div>
    </form>
    </s:if>
    <!----------------------------------------------------------------------QQ登录------------------------->
     <s:if test="#parameters.role[0]=='qquser'">
    <form action="validateLogin?type=qqlogin" method="post" name="ufrm">
    <div style="position:absolute; top:212px; left:490px;">
    <div>
    <img src="image/qqq.png"  />
     </div>
     <div style="position:absolute; top:2px; left:41px; width:120px;">
     <font style="font-family:华文楷体; font-size:24px">QQ账号：</font>
     </div>
     <div style="position:absolute; top:1px; left:160px;">
     <input type="text" name="loginName" size="30" style="height:30px; width:210px; "  />
     </div>
     
     <div style="position:absolute; top:60px; left:1px; width:120px;">
    <img src="image/pwd.png"  />
     </div>
     <div style="position:absolute; top:60px; left:41px; width:120px;">
     <font style="font-family:华文楷体; font-size:24px">QQ密码：</font>
     </div>
     <div style="position:absolute; top:62px; left:160px;">
     <input type="password" name="loginPwd" size="30" style="height:30px; width:210px; "  />
     </div>
     <div style="position:absolute; top:100px; left:158px;">
     <input type="checkbox"  />
     </div>
     <div style="position:absolute; top:100px; left:184px; width:200px;">
     <font style="font-size:14px">记住密码</font>
     </div>
     <div style="position:absolute; top:125px; left:160px; width:200px;">
     <input type="submit" value="登陆"  style="height:30px; width:212px; background:#E83204;" />
     </div>
     <div style="position:absolute; top:160px; left:160px;">
     <div style=" position:absolute; width:80px; top:5px; left:0px;"><a><font color="#20CCDF">[忘记密码]</font></a></div>
     <div style=" position:absolute; width:100px; left:90px; top:5px;"><a><font  color="#20CCDF">[注册新用户]</font></a></div>
     </div>
     <div  style=" position:absolute; width:100px; left:1px; top:185px; ">
     <hr size="3" style="width:370px;" />
     </div>
     <div  style=" position:absolute; width:300px; left:160px; top:200px; ">
     <font style="font-size:14px">使用合作网站账号登陆</font>
     </div>
     <div style=" position:absolute; width:300px; left:160px; top:230px; ">
      <a> <img  src="image/wei6.png"/></a>
      <a> <img  src="image/zhi.png"/></a>
      <a> <img src="image/q.png" /></a>
     </div>
     </div>
    </form>
    </s:if>
     <!----------------------------------------------------------------------微博登录------------------------->
       <s:if test="#parameters.role[0]=='weibouser'">
      <form action="validateLogin?type=weilogin" method="post" name="ufrm">
    <div style="position:absolute; top:212px; left:490px;">
    <div>
    <img src="image/ww.png"  />
     </div>
     <div style="position:absolute; top:2px; left:41px; width:120px;">
     <font style="font-family:华文楷体; font-size:24px">微博账号：</font>
     </div>
     <div style="position:absolute; top:1px; left:160px;">
     <input type="text" name="loginName" size="30" style="height:30px; width:210px; "  />
     </div>
     
     <div style="position:absolute; top:60px; left:1px; width:120px;">
    <img src="image/pwd.png"  />
     </div>
     <div style="position:absolute; top:60px; left:41px; width:120px;">
     <font style="font-family:华文楷体; font-size:24px">微博密码：</font>
     </div>
     <div style="position:absolute; top:62px; left:160px;">
     <input type="password" name="loginPwd" size="30" style="height:30px; width:210px; "  />
     </div>
     <div style="position:absolute; top:100px; left:158px;">
     <input type="checkbox"  />
     </div>
     <div style="position:absolute; top:100px; left:184px; width:200px;">
     <font style="font-size:14px">记住密码</font>
     </div>
     <div style="position:absolute; top:125px; left:160px; width:200px;">
     <input type="submit" value="登陆"  style="height:30px; width:212px; background:#E83204;" />
     </div>
     <div style="position:absolute; top:160px; left:160px;">
     <div style=" position:absolute; width:80px; top:5px; left:0px;"><a><font color="#20CCDF">[忘记密码]</font></a></div>
     <div style=" position:absolute; width:100px; left:90px; top:5px;"><a><font  color="#20CCDF">[注册新用户]</font></a></div>
     </div>
     <div  style=" position:absolute; width:100px; left:1px; top:185px; ">
     <hr size="3" style="width:370px;" />
     </div>
     <div  style=" position:absolute; width:300px; left:160px; top:200px; ">
     <font style="font-size:14px">使用合作网站账号登陆</font>
     </div>
     <div style=" position:absolute; width:300px; left:160px; top:230px; ">
      <a> <img  src="image/wei6.png"/></a>
      <a> <img  src="image/zhi.png"/></a>
      <a> <img src="image/q.png" /></a>
     </div>
     </div>
    </form>
    </s:if>
</div>
</body>
</html>
