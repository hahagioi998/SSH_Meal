﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<TITLE>Untitled Page</TITLE>
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
{
	FONT-SIZE: 12px
}
.gridView {
	BORDER-RIGHT: #bad6ec 1px; BORDER-TOP: #bad6ec 1px; BORDER-LEFT: #bad6ec 1px; COLOR: #566984; BORDER-BOTTOM: #bad6ec 1px; FONT-FAMILY: Courier New
}
.gridViewHeader {
	BORDER-RIGHT: #bad6ec 1px solid; BORDER-TOP: #bad6ec 1px solid; BACKGROUND-IMAGE: url(../images/bg_th.gif); BORDER-LEFT: #bad6ec 1px solid; LINE-HEIGHT: 27px; BORDER-BOTTOM: #bad6ec 1px solid
}
.gridViewItem {
	BORDER-RIGHT: #bad6ec 1px solid; BORDER-TOP: #bad6ec 1px solid; BORDER-LEFT: #bad6ec 1px solid; LINE-HEIGHT: 32px; BORDER-BOTTOM: #bad6ec 1px solid; TEXT-ALIGN: center
}
.cmdField {
	BORDER-RIGHT: 0px; BORDER-TOP: 0px; BACKGROUND-IMAGE: url(../images/bg_rectbtn.png); OVERFLOW: hidden; BORDER-LEFT: 0px; WIDTH: 67px; COLOR: #364c6d; LINE-HEIGHT: 27px; BORDER-BOTTOM: 0px; BACKGROUND-REPEAT: repeat-x; HEIGHT: 27px; BACKGROUND-COLOR: transparent; TEXT-DECORATION: none
}
.buttonBlue {
	BORDER-RIGHT: 0px; BORDER-TOP: 0px; BACKGROUND-IMAGE: url(../images/bg_button_blue.gif); BORDER-LEFT: 0px; WIDTH: 78px; COLOR: white; BORDER-BOTTOM: 0px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 21px
}
</STYLE>

</HEAD>
<BODY 
style="BACKGROUND-POSITION-Y: -120px; BACKGROUND-IMAGE: url(../images/bg.gif); BACKGROUND-REPEAT: repeat-x">

<SCRIPT src="EmployeeMgr.files/WebResource.axd" type=text/javascript></SCRIPT>
<SCRIPT src="EmployeeMgr.files/ScriptResource.axd" 
type=text/javascript></SCRIPT>

</SCRIPT>
<DIV >
  <TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%" border=0>
    <TBODY>
      <TR 
  style="BACKGROUND-IMAGE: url(images/bg_header.gif); BACKGROUND-REPEAT: repeat-x" 
  height=47>
        <TD width=10><SPAN 
      style="FLOAT: left; BACKGROUND-IMAGE: url(images/main_hl.gif); WIDTH: 15px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 47px"></SPAN></TD>
        <TD><SPAN 
      style="FLOAT: left; BACKGROUND-IMAGE: url(images/main_hl2.gif); WIDTH: 15px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 47px"></SPAN><SPAN 
      style="PADDING-RIGHT: 10px; PADDING-LEFT: 10px; FLOAT: left; BACKGROUND-IMAGE: url(images/main_hb.gif); PADDING-BOTTOM: 10px; COLOR: white; PADDING-TOP: 10px; BACKGROUND-REPEAT: repeat-x; HEIGHT: 47px; TEXT-ALIGN: center; 0px: ">用户管理 </SPAN><SPAN 
      style="FLOAT: left; BACKGROUND-IMAGE: url(houtaifile/images/main_hr.gif); WIDTH: 60px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 47px"></SPAN></TD>
        <TD 
    style="BACKGROUND-POSITION: 50% bottom; BACKGROUND-IMAGE: url(images/main_rc.gif)" 
    width=10></TD>
      </TR>
      <TR>
        <TD style="BACKGROUND-IMAGE: url(houtaifile/images/main_ls.gif)">&nbsp;</TD>
        <TD 
    style="PADDING-RIGHT: 10px; PADDING-LEFT: 10px; PADDING-BOTTOM: 10px; COLOR: #566984; PADDING-TOP: 10px; BACKGROUND-COLOR: white" 
    vAlign=top align=middle>
          <DIV>
            <TABLE class=gridView id=ctl00_ContentPlaceHolder2_GridView1 
      style="WIDTH: 100%; BORDER-COLLAPSE: collapse" cellSpacing=0 rules=all 
      border=1>
              <TBODY>
                <TR>
                  <TH class=gridViewHeader style="WIDTH: 50px" scope=col>&nbsp;</TH>
                  <TH class=gridViewHeader scope=col>用户名</TH>
                  <TH class=gridViewHeader scope=col>密码</TH>
                  <TH class=gridViewHeader scope=col>真实姓名</TH>
                  <TH class=gridViewHeader scope=col>邮箱</TH>
                   <TH class=gridViewHeader scope=col>电话号码</TH>
                  <TH class=gridviewHeader scope=col>地址</TH>
                <!--   <TH class=gridviewHeader scope=col>QQ账号</TH>
                  <TH class=gridviewHeader scope=col>QQ密码</TH>
                  <TH class=gridviewHeader scope=col>微博账号</TH>
                  <TH class=gridviewHeader scope=col>微博密码</TH> -->
                  <TH class=gridviewHeader scope=col>修改</TH>
                  <TH class=gridviewHeader scope=col>删除</TH>
                </TR>
                
                <s:iterator  id="user" value="#session.userlist">
               <TR>
                  <TD class=gridViewItem style="WIDTH: 50px">
                  <IMG src="EmployeeMgr.files/bg_users.gif"> </TD>
            	  <td class=gridViewItem>${user.loginName}</td>
            	  <td class=gridViewItem>${user.loginPwd}</td>
            	  <td class=gridViewItem>${user.trueName}</td>
            	  <td class=gridViewItem>${user.eamil}</td>
            	  <td class=gridViewItem>${user.phone}</td>
            	  <td class=gridViewItem>${user.address}</td>
            	<%--   <td class=gridViewItem>${user.qqnumber}</td>
            	  <td class=gridViewItem>${user.qqpws}</td>
            	  <td class=gridViewItem>${user.weibonumber}</td>
            	  <td class=gridViewItem>${user.weibopws}</td> --%>
            	  <td class=gridViewItem ><a href="toUpdateUser?updateId=${user.id}"><font color=" #566984"> 修改</font></a></td>
            	  <td class=gridViewItem> <a href="todeleteUser?updateId=${user.id}"><font color=" #566984"> 删除</font></a></td>           	     
                </TR>
                </s:iterator>
                <tr>                
                	<td colspan="13"  class=gridViewItem>
                		<a href="adminnextuser?pager.curPage=${request.rowcount}">尾页</a>
                		<a href="adminnextuser?pager.curPage=${pager.curPage+1}">下一页</a>
                		<a href="adminnextuser?pager.curPage=${pager.curPage-1}">上一页</a>
                		<a href="adminnextuser?pager.curPage=1">首页</a>
                	   共${pager.curPage}/${request.rowcount}页
                	</td>
                	
                </tr>
               	
              
               
              </TBODY>
            </TABLE>
          </DIV>
        </TD>
        <TD style="BACKGROUND-IMAGE: url(../images/main_rs.gif)"></TD>
      </TR>
      <TR 
  style="BACKGROUND-IMAGE: url(../images/main_fs.gif); BACKGROUND-REPEAT: repeat-x" 
  height=10>
        <TD style="BACKGROUND-IMAGE: url(../images/main_lf.gif)"></TD>
        <TD style="BACKGROUND-IMAGE: url(../images/main_fs.gif)"></TD>
        <TD 
style="BACKGROUND-IMAGE: url(../images/main_rf.gif)"></TD>
      </TR>
    </TBODY>
  </TABLE>
</DIV>

</BODY>
</HTML>
