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
<div id="student">
	<form action="/kindergarten/classes/addOrUpdateClasses" method="post" onsubmit="return checkStuSick()">
	<input type="hidden" id="" name="classes.id" value="${t_classes.id }"/>
	<!-- <input type="hidden" name="classes.acqx" value="1"/> -->
		<table>
			<tr>
				<th>班级名称</th>
				<td><input type="text" name="classes.classesname" id="classes" value="${t_classes.classesname }"/><span>**请用数字表示</span></td>
			</tr>
			<tr>
				<th>班级人数</th>
				<td><input type="text" name="classes.stunum" id="stunum" value="${t_classes.stunum }"></td>
			</tr>
			<tr>
				<th>班主任</th>
				<td><input type="text" name="classes.headmaster" id="headmaster" value="${t_classes.headmaster }"/></td>
			</tr>
			<tr>
				<th>备注</th>
				<td><textarea cols="80" rows="10" name="classes.remark" id="remark" ></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="4" align="center"><input type="submit" value="提交" name="submit"/>&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置">&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="返回" onclick="javascript:history.go(0)"/></td>
			</tr>
		</table>
		</form>
	</div>
		
</body>
</html>
