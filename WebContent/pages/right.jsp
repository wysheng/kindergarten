<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>幼儿园管理系统</title>
<link rel="stylesheet" type="text/css" href="/kindergarten/css/kkpager.css">
<script type="text/javascript" src="/kindergarten/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/kindergarten/plugins/artDialog/artDialog.js?skin=twitter" ></script>	
<script type="text/javascript" src="/kindergarten/plugins/artDialog/plugins/iframeTools.js"></script>
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
						<td height="31"><div class="titlebt">欢迎页面</div></td>
					</tr>
				</table></td>
			<td width="16" valign="top" background="/kindergarten/pages/images/mail_rightbg.gif"><img
				src="/kindergarten/pages/images/nav-right-bg.gif" width="16" height="29" /></td>
		</tr>
		<tr>
			<td valign="middle" background="/kindergarten/pages/images/mail_leftbg.gif">&nbsp;</td>
			<td valign="top" bgcolor="#F7F8F9">
			<input type="hidden" id="stid" value="${id }">
				<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
				<tr>
					<td>&nbsp;</td>
				</tr>
				</table>
				<table width="" border="1" align="center" cellpadding="0" cellspacing="0" >
					<tr>
						<td colspan="2"><h3>${username}
						<c:if test="${acqx == 1 }">
						同学
						</c:if>
						<c:if test="${acqx == 2 }">
						老师
						</c:if>
						欢迎您使用幼教信息管理系统
						
						</h3></td>
					</tr>
					<tr>
						<th>姓名：</th>
						<td align="center">${username}</td>
					</tr>
					<tr>
						<th>性别：</th>
						<td align="center">${acsex}</td>
					</tr>
					<c:if test="${acqx == 1 }">
					<tr>
						<th>学号：</th>
						<td align="center">${acxh}</td>
					</tr>
					<tr>
						<th>年级：</th>
						<td align="center">${acnj}</td>
					</tr>
					<tr>
						<th>学院：</th>
						<td align="center">${acxy}</td>
					</tr>
					<tr>
						<th>专业：</th>
						<td align="center">${aczy}</td>
					</tr>
					</c:if>
					<c:if test="${acqx == 2 }">
					<tr>
						<th>工号：</th>
						<td align="center">${acxh}</td>
					</tr>
					<tr>
						<th>学院：</th>
						<td align="center">${acxy}</td>
					</tr>
					</c:if>
					<c:if test="${acqx != 1 }">
					<tr>
						<th>权限：</th>
						<td align="center">管理员</td>
					</tr>
					</c:if>
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
