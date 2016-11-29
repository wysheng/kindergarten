<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>幼儿园管理系统</title>
<link href="/kindergarten/pages/images/skin.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/kindergarten/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/kindergarten/plugins/artDialog/artDialog.js?skin=twitter" ></script>	
<script type="text/javascript" src="/kindergarten/plugins/artDialog/plugins/iframeTools.js"></script>
<script type="text/javascript" src="/kindergarten/js/public.js"></script>
<script type="text/javascript" src="/kindergarten/js/public2.js"></script>
</head>

<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #EEF2FB;
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
						<td height="31"><div class="titlebt">修改课程</div></td>
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
					<td>&nbsp;</td>
				</tr>
				</table>
					
	<form action="/kindergarten/kecheng/addOrUpdateKecheng" method="post" onsubmit="return chekecheng()">
	<input type="hidden" id="" name="kecheng.id" value="${kecheng.id }"/>
		<table>
			<tr>
				<th>课程号</th>
				<td><input type="text" name="kecheng.kch" id="kch" value="${kecheng.kch }"/></td>
				<th>课程名</th>
				<td><input type="text" name="kecheng.kcm" id="kcm" value="${kecheng.kcm }"></td>
			</tr>
			<tr>
				<th>课程书籍</th>
				<td><input type="text" name="kecheng.kcsj" id="kcsj" value="${kecheng.kcsj }"/></td>
				<th>任课老师</th>
				<td><input type="text" name="kecheng.teid" id="rkls" value="${kecheng.teid }"/></td>
			</tr>
			<tr>
				<th>年级</th>
				<td><input type="text" name="kecheng.kcnj" id="kcnj" value="${kecheng.kcnj }"/></td>
				<th>专业</th>
				<td><input type="text" name="kecheng.kczy" id="kczy" value="${kecheng.kczy }"/></td>
			</tr>
			<tr>
				<th>学分</th>
				<td><input type="text" name="kecheng.kcxf" id="kcxf" value="${kecheng.kcxf }"/></td>
				<th>课程类别</th>
				<td><input type="text" name="kecheng.kclb" id="kclb" value="${kecheng.kclb }"/></td>
			</tr>
			<tr>
				<th>考核方式</th>
				<td colspan="3"><input type="text" id="khfs" name="kecheng.kckh" value="${kecheng.kckh }"/></td>
			</tr>
			
			<tr>
				<td colspan="4" align="center"><input type="submit" value="提交" name="submit"/>&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="返回" onclick="javascript:history.go(-1)"/></td>
			</tr>
		</table>
		</form>
		
					
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
