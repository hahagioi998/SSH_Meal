<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>
<sx:head />
<link href="css/main.css" type="text/css" rel="stylesheet" media="screen"  />
<!-- <link rel="stylesheet" href="css/fm.tagator.jquery.css"/>
<script src="js/jquery.min.js"></script>
<script src="js/fm.tagator.jquery.js"></script> -->
<!-- <script>
$(function () {
	$('#inputTagator').tagator({
		// 输入以下单词自动补全, 支持中文
		autocomplete: ['first', 'second', 'third', 'fourth', 'fifth', 'sixth', 'seventh', 'eighth', 'ninth', 'tenth', '罗康元', '罗康元你好帅'
		, '罗康元哥哥', '你要找的是罗康元吗', '罗氏集团', '关于落实从严治党', '标签', '标签', '标签', '标签']
	});
});
</script> -->
</head>
<body>
<!---------------------------------------------------------头部部分-------------------------------------------------------------------->

<div class="hend">
<div class="container">
  <div id="search">
 
   <s:form action="toShowMeal" theme="simple" method="post" >
    	<!-- <div id="wrapper" >
	   <input style="width:300px;" id="inputTagator" name="meal.mealName" value="">
       </div>
       <sx:autocompleter showDownArrow="true" autoComplete="true" name="meal.mealName" list="data"></sx:autocompleter> -->
    	<s:textfield name="meal.mealName" ></s:textfield>
    	
    <!-- 	通过隐藏表单域保存用户选择过的菜系编号，可根据菜品名称和菜系组合查询 -->
    	<s:hidden name="meal.mealseries.seriesId" value="%{#request.seriesId}"></s:hidden>
    	<s:submit value="search"  cssClass="cha" ></s:submit>
    </s:form>

  </div>
</div>
<div class="headImage" style="position: absolute;top: 5px; left: 150px;">
	<img src="image/logo2.png" width="219"  height="76"/>
</div>
<s:if test="#session.user==null&&#session.admin==null">
<div class="QQ">
	<div class="qqimage">
	<img  src="image/QQ.png"  width="25" height="25" />
    </div>
    <div class="qqfont">
   <a href="login.jsp?role=qquser"> <font color="#f5eded">QQ登陆</font></a>
    </div>
    <div class="weibo">
    <img src="image/weibo.png" width="25" height="25"  />
    </div>
     <div class="weibofont">
   <a href="login.jsp?role=weibouser"> <font color="#f5eded">微博登陆</font></a>
    </div>
    <div class="login">
    <img  src="image/login.png" width="25" height="25"  />
    </div>
     <div class="loginfont">
   <a href="login.jsp?role=user"> <font color="#f5eded">登陆</font></a>
    </div>
     <div class="register">
    <img  src="image/register.png" width="25" height="25"  />
    </div>
     <div class="registerfont">
   <a href="register.jsp"> <font color="#f5eded">注册</font></a>
    </div>
    <div class="adminregister">
    <img  src="image/register.png" width="25" height="25"  />
    </div>
     <div class="adminregisterfont">
   <a href="login.jsp?role=admin"> <font color="#f5eded">管理员登录</font></a>
    </div>
</div>
</s:if>
<s:if test="#session.user!=null">
<div class="QQ">
	<div class="qqimage">
	<img  src="image/login.png"  width="25" height="25" />
    </div>
    <div class="qqfont">
   <a href="toShowMeal"> <font color="#f5eded">网站首页</font></a>
    </div>
    <div class="weibo">
    <img src="image/person.png" width="25" height="25"  />
    </div>
     <div class="weibofont">
   <a href="modifyMyInfo.jsp"> <font color="#f5eded">个人资料</font></a>
    </div>
    <div class="login">
    <img  src="image/cart.png" width="25" height="25"  />
    </div>
     <div class="loginfont">
   <a href="shopCart.jsp"> <font color="#f5eded">购物车</font></a>
    </div>
     <div class="orderregister">
    <img  src="image/register.png" width="25" height="25"  />
    </div>
     <div class="orderfont">
   <a href="toMyOrders"> <font color="#f5eded">我的订单</font></a>
    </div>
    <div class="welcome">
      <font style="color: #f5eded">欢迎你:${sessionScope.user.trueName}</font>
      &nbsp; &nbsp; &nbsp;
      <a href="logOut?type=userlogout"> <font style="color: #f5eded">注销</font></a>
    </div>
</div>
</s:if>
<s:if test="#session.admin!=null">
<div class="QQ">
	<div class="qqimage">
	<img  src="image/login.png"  width="25" height="25" />
    </div>
    <div class="qqfont">
   <a href="toShowMeal"> <font color="#f5eded">网站首页</font></a>
    </div>
    <div class="weibo">
    <img src="image/person.png" width="25" height="25"  />
    </div>
     <div class="weibofont">
   <a href="toAddMeal"> <font color="#f5eded">添加餐品</font></a>
    </div>
    <div class="login">
    <img  src="image/cart.png" width="25" height="25"  />
    </div>
     <div class="loginfont">
   <a href="toManagerMeal"> <font color="#f5eded">管理餐品</font></a>
    </div>
     <div class="orderregister">
    <img  src="image/register.png" width="25" height="25"  />
    </div>
     <div class="orderfont">
   <a href="toManagerOrders"> <font color="#f5eded">订单处理</font></a>
    </div>
    <div class="welcome">
      <font style="color: #f5eded">欢迎你:${sessionScope.admin.loginName}</font>
      &nbsp; &nbsp; &nbsp;
      <a href="logOut?type=adminlogout"> <font style="color: #f5eded">注销</font></a>
      <a href="adminuser"><font style="color: #f5eded">登录后台</font></a>
    </div>
</div>
</s:if>
</div>

</body>
</html>
