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
				<th>书名</th>
				<td><input type="text" name="acount.loginname" id="loginname" value=""/></td>
				<th>作者</th>
				<td><input type="text" name="acount.loginpass" id="loginpass"></td>
			</tr>
			<tr>
				<th>出版社</th>
				<td><input type="text" name="notice.ntitle" id="ntitle" value="${notice.ntitle }"/></td>
				<th>定价</th>
				<td><input type="text" name="notice.ntitle" id="ntitle" value="${notice.ntitle }"/></td>
			</tr>
			<tr>
				<th>折扣价</th>
				<td><input type="text" name="notice.ntitle" id="ntitle" value="${notice.ntitle }"/></td>
				<th>班级折扣价</th>
				<td><input type="text" name="notice.ntitle" id="ntitle" value="${notice.ntitle }"/></td>
			</tr>
			<tr>
				<th>年级</th>
				<td><input type="text" name="notice.ntitle" id="ntitle" value="${notice.ntitle }"/></td>
				<th>学期</th>
				<td><input type="text" name="notice.ntitle" id="ntitle" value="${notice.ntitle }"/></td>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="submit" value="提交" name="submit"/>&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置">&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="返回" onclick="javascript:history.go(-1)"/></td>
			</tr>
		</table>
		</form>
</body>
</html>
