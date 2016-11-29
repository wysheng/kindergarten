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
	<form action="/kindergarten/kecheng/addOrUpdateKecheng" method="post" onsubmit="">
	<input type="hidden" id="" name="kecheng.id" value=""/>
		<table>
			<tr>
				<th>课程号</th>
				<td><input type="text" name="kecheng.kch" id="kch" value=""/></td>
				<th>课程名</th>
				<td><input type="text" name="kecheng.kcm" id="kcm" value=""></td>
			</tr>
			<tr>
				<th>课程书籍</th>
				<td><input type="text" name="kecheng.kcsj" id="kcsj" value=""/></td>
				<th>任课老师</th>
				<td><input type="text" name="kecheng.teid" id="rkls" value=""/></td>
			</tr>
			<tr>
				<th>年级</th>
				<td><input type="text" name="kecheng.kcnj" id="kcnj" value=""/></td>
			</tr>
			<tr>
				<th>课程类别</th>
				<td><input type="text" name="kecheng.kclb" id="kclb" value=""/></td>
			</tr>
			<tr>
				<th>考核方式</th>
				<td colspan="3"><input type="text" id="khfs" name="kecheng.kckh" value=""/></td>
			</tr>
			
			<tr>
				<td colspan="4" align="center"><input type="submit" value="提交" name="submit"/>&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置">&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="返回" onclick="javascript:history.go(0)"/></td>
			</tr>
		</table>
		</form>
</body>
</html>
