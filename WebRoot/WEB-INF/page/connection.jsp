<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    <title></title>
	
  </head>
  
  <body onload="javascript:document.forms[0].submit()">
  	<!--测试网管 http://tech.yeepay.com:8080/robot/debug.action -->
  	<!-- https://www.yeepay.com/app-merchant-proxy/node -->
	<form name="yeepay" action=" https://www.yeepay.com/app-merchant-proxy/node" method='post'>	
		<input type='hidden' name='p0_Cmd'   value="${messageType}"> <!-- 请求命令,在线支付固定为Buy -->
		<input type='hidden' name='p1_MerId' value="${p1_MerId}"> <!-- 商家ID -->
		<input type="hidden" name="p2_Order" value="${orderid}"> <!-- 商家的交易定单号 -->
		<input type='hidden' name='p3_Amt'   value="${amount}"> <!-- 订单金额 -->
		<input type='hidden' name='p4_Cur'   value="${currency}"> <!-- 货币单位 -->
		<input type='hidden' name='p5_Pid'   value="${productId}"> <!-- 商品ID -->
		<input type='hidden' name='p6_Pcat'  value="${productCat}"> <!-- 商品种类 -->
		<input type='hidden' name='p7_Pdesc' value="${productDesc}"> <!-- 商品描述 -->
		<input type='hidden' name='p8_Url'   value="${merchantCallbackURL}"> <!-- 交易结果通知地址 -->
		<input type='hidden' name='p9_SAF'   value="${addressFlag}"> <!-- 需要填写送货信息 0：不需要 1:需要 -->
		<input type='hidden' name='pa_MP'    value="${sMctProperties}"> <!-- 商家扩展信息 -->
		<input type='hidden' name='pd_FrpId' value="${pd_FrpId}"> <!-- 银行ID -->
		<!-- 应答机制 为“1”: 需要应答机制;为“0”: 不需要应答机制 -->
		<input type="hidden" name="pr_NeedResponse"  value="0">
		<input type='hidden' name='hmac' value="${md5mac}"><!-- MD5-hmac验证码 -->
		
	</form>
	
  </body>
</html>
