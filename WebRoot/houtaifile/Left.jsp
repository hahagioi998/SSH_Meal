﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<TITLE>无标题页</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<STYLE type=text/css> 
{
	FONT-SIZE: 12px
}
#menuTree A {
	COLOR: #566984; TEXT-DECORATION: none
}
</STYLE>
<SCRIPT src="Left.files/TreeNode.js" type=text/javascript></SCRIPT>
<SCRIPT src="Left.files/Tree.js" type=text/javascript></SCRIPT>

</HEAD>
<BODY 
style="BACKGROUND-POSITION-Y: -120px; BACKGROUND-IMAGE: url(../images/bg.gif); BACKGROUND-REPEAT: repeat-x">
<TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%">
  <TBODY>
    <TR>
      <TD width=10 height=29><IMG src="Left.files/bg_left_tl.gif"></TD>
      <TD 
    style="FONT-SIZE: 18px; BACKGROUND-IMAGE: url(../images/bg_left_tc.gif); COLOR: white; FONT-FAMILY: system">Main 
        Menu</TD>
      <TD width=10><IMG src="Left.files/bg_left_tr.gif"></TD>
    </TR>
    <TR>
      <TD style="BACKGROUND-IMAGE: url(../images/bg_left_ls.gif)"></TD>
      <TD id=menuTree 
    style="PADDING-RIGHT: 10px; PADDING-LEFT: 10px; PADDING-BOTTOM: 10px; PADDING-TOP: 10px; HEIGHT: 100%; BACKGROUND-COLOR: white" 
    vAlign=top></TD>
      <TD style="BACKGROUND-IMAGE: url(../images/bg_left_rs.gif)"></TD>
    </TR>
    <TR>
      <TD width=10><IMG src="Left.files/bg_left_bl.gif"></TD>
      <TD style="BACKGROUND-IMAGE: url(../images/bg_left_bc.gif)"></TD>
      <TD width=10><IMG src="Left.files/bg_left_br.gif"></TD>
    </TR>
  </TBODY>
</TABLE>
<SCRIPT type=text/javascript>
var tree = null;
var root = new TreeNode('系统菜单');
var fun1 = new TreeNode('人事管理');
var fun2 = new TreeNode('添加用户', 'EmployeeMgr.jsp', 'tree_node.gif', null, 'tree_node.gif', null);
fun1.add(fun2);
var fun3 = new TreeNode('管理员管理', 'EmployeeMgr.jsp', 'tree_node.gif', null, 'tree_node.gif', null);
fun1.add(fun3);
var fun4 = new TreeNode('用户管理', 'EmployeeMgr.jsp', 'tree_node.gif', null, 'tree_node.gif', null);
fun1.add(fun4);
root.add(fun1);
var fun5 = new TreeNode('菜品管理');
var fun6 = new TreeNode('我的菜品', 'toManagerMeal', 'tree_node.gif', null, 'tree_node.gif', null);
fun5.add(fun6);
var fun61 = new TreeNode('菜系管理', 'mealseriesmanager', 'tree_node.gif', null, 'tree_node.gif', null);
fun5.add(fun61);
var fun7 = new TreeNode('添加菜品', 'toAddMeal', 'tree_node.gif', null, 'tree_node.gif', null);
fun5.add(fun7);
var fun8 = new TreeNode('批量添加菜品', 'EmployeeMgr.jsp', 'tree_node.gif', null, 'tree_node.gif', null);
fun5.add(fun8);
root.add(fun5);
var fun9 = new TreeNode('订单管理');
var fun10 = new TreeNode('我的订单', 'toManagerOrders', 'tree_node.gif', null, 'tree_node.gif', null);
fun9.add(fun10);
var fun11 = new TreeNode('未处理订单', 'EmployeeMgr.jsp', 'tree_node.gif', null, 'tree_node.gif', null);
fun9.add(fun11);
var fun12 = new TreeNode('已处理订单', 'EmployeeMgr.jsp', 'tree_node.gif', null, 'tree_node.gif', null);
fun9.add(fun12);
root.add(fun9);
var fun21 = new TreeNode('美食魔方');
var fun211 = new TreeNode('管理美食魔方', 'showMealMofang', 'tree_node.gif', null, 'tree_node.gif', null);
root.add(fun21);
fun21.add(fun211);
var fun22 = new TreeNode('顾客留言');
root.add(fun22);
var fun23 = new TreeNode('当季食谱');
root.add(fun23);
var fun24 = new TreeNode('健康生活');
root.add(fun24);
var fun25 = new TreeNode('妈妈派');
root.add(fun25);
var fun26 = new TreeNode('孩子菜谱');
var fun261 = new TreeNode('孩子菜谱管理', 'showchild', 'tree_node.gif', null, 'tree_node.gif', null);
fun26.add(fun261);
root.add(fun26);
var fun27 = new TreeNode('各地特色');
var fun271 = new TreeNode('各地特色管理', 'showcharact', 'tree_node.gif', null, 'tree_node.gif', null);
root.add(fun27);
fun27.add(fun271);
var fun28 = new TreeNode('食物常识');
root.add(fun28);


var fun13 = new TreeNode('消息管理');
var fun14 = new TreeNode('订单消息', 'EmployeeMgr.jsp', 'tree_node.gif', null, 'tree_node.gif', null);
fun13.add(fun14);
var fun15 = new TreeNode('建议消息', 'EmployeeMgr.jsp', 'tree_node.gif', null, 'tree_node.gif', null);
fun13.add(fun15);
root.add(fun13);
var fun16 = new TreeNode('页面管理');
var fun17 = new TreeNode('页面布局', 'EmployeeMgr.jsp', 'tree_node.gif', null, 'tree_node.gif', null);
fun16.add(fun17);
var fun18 = new TreeNode('页面菜单', 'EmployeeMgr.jsp', 'tree_node.gif', null, 'tree_node.gif', null);
fun16.add(fun18);
var fun19 = new TreeNode('页面图片', 'EmployeeMgr.jsp', 'tree_node.gif', null, 'tree_node.gif', null);
fun16.add(fun19);
var fun20 = new TreeNode('页面风格', 'EmployeeMgr.jsp', 'tree_node.gif', null, 'tree_node.gif', null);
fun16.add(fun20);
root.add(fun16);
var fun21 = new TreeNode('餐品管理');
var fun22 = new TreeNode('添加', 'EmployeeMgr.jsp', 'tree_node.gif', null, 'tree_node.gif', null);
fun21.add(fun22);
var fun23 = new TreeNode('删除', 'EmployeeMgr.jsp', 'tree_node.gif', null, 'tree_node.gif', null);
fun21.add(fun23);
var fun24 = new TreeNode('处理', 'EmployeeMgr.jsp', 'tree_node.gif', null, 'tree_node.gif', null);
fun21.add(fun24);
root.add(fun21);
tree = new Tree(root);
tree.show('menuTree');
</SCRIPT>
</BODY>
</HTML>
