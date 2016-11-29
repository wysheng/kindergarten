<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>幼儿园管理系统</title>
<link rel="stylesheet" type="text/css" href="/kindergarten/css/kkpager.css">
<script type="text/javascript" src="/kindergarten/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/kindergarten/plugins/artDialog/artDialog.js?skin=twitter" ></script>	
<script type="text/javascript" src="/kindergarten/plugins/artDialog/plugins/iframeTools.js"></script>
<script type="text/javascript" src="/kindergarten/js/kkpager.min.js"></script>
<script type="text/javascript" src="/kindergarten/js/money.js"></script>
<script type="text/javascript" src="/kindergarten/js/public.js"></script>
</head>

<link href="/kindergarten/pages/images/skin.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #EEF2FB;
}
#search{
	width: 43px;
	height: 21px;
}
-->
</style>
<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="17" valign="top" background="/kindergarten/pages/images/mail_leftbg.gif"><img
				src="/kindergarten/pages/images/left-top-right.gif" width="17" height="29" /></td>
			<td valign="top" background="/kindergarten/pages/images/content-bg.gif"><table
					width="100%" height="31" border="0" cellpadding="0" cellspacing="0"
					class="left_topbg" id="table2">
					<tr>
						<td height="31"><div class="titlebt">幼儿园学生费用</div></td>
					</tr>
				</table></td>
			<td width="16" valign="top" background="/kindergarten/pages/images/mail_rightbg.gif"><img
				src="/kindergarten/pages/images/nav-right-bg.gif" width="16" height="29" /></td>
		</tr>
		<tr>
			<td valign="middle" background="/kindergarten/pages/images/mail_leftbg.gif">&nbsp;</td>
			<td valign="top" bgcolor="#F7F8F9">
				<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td>
						<input id="ntitle" value="输入名称关键字查询" onfocus="if(this.value=='输入名称关键字查询'){this.value='';}this.style.color='#999999';" onblur="if(this.value==''||this.value=='输入名称关键字查询'){this.value='输入名称关键字查询';this.style.color='#999999';}"  type="text" name="name" class="input-text lh25" size="50" />
						<button id="search" value="搜索">搜索</button>
						</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
					</tr>
				</table>
				<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
					
					<tr>
						<td width="4%" align="center" class=sec1><input type="checkbox"></td>
						<td width="4%" align="center" class=sec1>序号</td>
						<td width="15%" align="center" class=sec1>年级</td>
						<td width="15%" align="center" class=sec1>书名</td>
						<td width="15%" align="center" class=sec1>作者</td>
						
						<td width="15%" align="center" class=sec1>班级订购情况</td>
						<td width="15%" align="center" class=sec1>年级定购总人数</td>
						<td width="15%" align="center" class=sec1>年级总费用</td>
					</tr>
				</table>
				<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" id="tabhtml">
					
				</table>
				</td>
			<td background="/kindergarten/pages/images/mail_rightbg.gif">&nbsp;</td>
		</tr>
		<tr>
			<td valign="bottom" background="/kindergarten/pages/images/mail_leftbg.gif"><img
				src="/kindergarten/pages/images/buttom_left2.gif" width="17" height="17" /></td>
			<td background="/kindergarten/pages/images/buttom_bgs.gif"><img
				src="/kindergarten/pages/images/buttom_bgs.gif" width="17" height="17"></td>
			<td valign="bottom" background="/kindergarten/pages/images/mail_rightbg.gif"><img
				src="/kindergarten/pages/images/buttom_right2.gif" width="16" height="17" /></td>
		</tr>
	</table>
</body>
</html>
