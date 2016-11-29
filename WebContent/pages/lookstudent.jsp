<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>幼儿园管理系统</title>
<script type="text/javascript" src="/kindergarten/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/kindergarten/plugins/artDialog/artDialog.js?skin=twitter" ></script>	
<script type="text/javascript" src="/kindergarten/plugins/artDialog/plugins/iframeTools.js"></script>
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
	<form action="/kindergarten/notice/addOrUpdateNotice" method="post">
	<input type="hidden" name="notice.id" id="nid" value="${notice.id }">
		<table>
			<tr>
				<th>用户名</th>
				<td></td>
				<th>密码</th>
				<td></td>
			</tr>
			<tr>
				<th>姓名</th>
				<td></td>
				<th>性别</th>
				<td></td>
			</tr>
			<tr>
				<th>年级</th>
				<td></td>
				<th>班级</th>
				<td></td>
			</tr>
			<tr>
				<th>学号</th>
				<td></td>
				<th>类别</th>
				<td></td>
			</tr>
			<tr>
				<th>学院</th>
				<td></td>
				
			</tr>
			
			<tr>
				<td></td>
				<td><input type="button" value="返回" onclick="javascript:history.go(-1)"/></td>
			</tr>
		</table>
	</form>
</body>
</html>
