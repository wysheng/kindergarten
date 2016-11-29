<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>幼儿园管理系统</title>
<link rel="stylesheet" type="text/css" href="/kindergarten/css/datePicker.css" />
<script type="text/javascript" src="/kindergarten/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/kindergarten/plugins/artDialog/artDialog.js?skin=twitter" ></script>	
<script type="text/javascript" src="/kindergarten/plugins/artDialog/plugins/iframeTools.js"></script>
<script src="/kindergarten/js/jquery-1.3.2.min.js" type="text/javascript"></script>
<script src="/kindergarten/js/jquery.datePicker-min.js" type="text/javascript"></script>
<!--[if IE]><script type="text/javascript" src="demo/js/jquery.bgiframe.min.js"></script><![endif]-->
<script type="text/javascript">
	$(window).ready(function(){
		$('.date-pick').datePicker({clickInput:true});
	});
</script>
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
	<form action="/kindergarten/stuSickCheck/addOrUpdateStuSickCheck" method="post" onsubmit="return checkStuSick()">
	<input type="hidden" name="id" id="nid" value="">
		<table>
			<tr>
				<th>班级：</th>
				<td><input type="text" name="stuSickCheck.classes" id="classes" value=""/><span>**请用数字表示</span></td>
				
			</tr>
			<tr>
				<th>严重程度：</th>
				<td><select name="stuSickCheck.sickLevel" id="sickLevel">
				<option value="0">正常</option>
				<option value="1">弱</option>
				<option value="2">中</option>
				<option value="3">强</option>
				</select></td>
			</tr>
			<tr>
				<th>学生姓名：</th>
				<td><input type="text" name="stuSickCheck.stuname" id="stuname" value=""/></td>
			</tr>
			<tr>
				<th>信息来源：</th>
				<td>
				<select name="stuSickCheck.isMorningCheck" id="isMorningCheck">
				<option value="0">晨检</option>
				<option value="1">家长嘱托</option>
				<option value="1">其他</option>
				</select>
			</tr>
			<tr>
				<th>是否吃药：</th>
				<td>
				<select name="stuSickCheck.isTakePills" id="isTakePills">
				<option value="0">未吃药</option>
				</select>
			</tr>
			<tr>
				<th>情况描述：</th>
				<td><textarea rows="15" cols="80" name="stuSickCheck.sickcontent" id="sickcontent"></textarea></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="提交" name="submit"/>&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置">&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="返回" onclick="javascript:history.go(0)"/></td>
			</tr>
		</table>
	</form>
</body>
</html>
