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
<table>
	<tr>
		<td align="center" width="460">
			<select id="selst" onchange="selectst()">
				<option value="1" selected="selected">学生</option>
				<option value="2">老师</option>
			</select>
		</td>
	</tr>
</table>
<div id="student">
	<form action="/kindergarten/account/addOrUpdateStudent" method="post" onsubmit="return checkstudent()">
	<input type="hidden" id="" name="account.id" value="${t_account.id }"/>
	<input type="hidden" name="account.acqx" value="1"/>
		<table>
			<tr>
				<th>用户名</th>
				<td><input type="text" name="account.loginname" id="loginname" value="${t_account.loginname }"/></td>
				<th>密码</th>
				<td><input type="text" name="account.loginpass" id="loginpass" value="${t_account.loginpass }"></td>
			</tr>
			<tr>
				<th>姓名</th>
				<td><input type="text" name="account.acname" id="acname" value="${t_account.acname }"/></td>
				<th>性别</th>
				<td><select  name="account.acsex" id="acsex">
					<option value="1">男</option>
					<option value="2">女</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>年级班级</th>
				<td><input type="text" name="account.acnj" id="acnj" value="${t_account.acnj }"/>
					<!-- <select name="account.acnj" id="acnj">
					
					</select -->
				</td>
				<th>学号</th>
				<td><input type="text" name="account.acxh" id="acxh" value="${t_account.acxh }"/></td>
			</tr>
			<tr>
				<th>母亲联系方式</th>
				<td><input type="text" name="account.acbj" id="acbj" value="${t_account.acbj }"/></td>   
				<th>父亲联系方式</th>
				<td><input type="text" name="account.aczy" id="acxy" value="${t_account.aczy }"/></td>
			</tr>
			<tr>
				<th>家庭住址</th>
				<td colspan="3"><input type="text" name="account.acxy" id="aczy" value="${t_account.acxy }"/></td>
			</tr>
			
			<tr>
				<td colspan="4" align="center"><input type="submit" value="提交" name="submit"/>&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置">&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="返回" onclick="javascript:history.go(0)"/></td>
			</tr>
		</table>
		</form>
	</div>
		
	<div id="teacher" style="display:none">
		<form id="form2" action="/kindergarten/account/addOrUpdateStudent" method="post" onsubmit="return checkteacher()">
		<input type="hidden" id="" name="account.acqx" value="2"/>
		<input type="hidden" id="id" name="account.id" value="${t_account.id }"/>
		<table>
			<tr>
				<th>用户名</th>
				<td><input type="text" name="account.loginname" id="lsloginname" value="${t_account.loginname }"/></td>
				<th>密码</th>
				<td><input type="text" name="account.loginpass" id="lsloginpass" value="${t_account.loginpass }"></td>
			</tr>
			<tr>
				<th>姓名</th>
				<td><input type="text" name="account.acname" id="lsname" value="${t_account.acname }"/></td>
				<th>性别</th>
				<td><select  name="account.acsex" id="lssex">
					<option value="1">男</option>
					<option value="2">女</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>教工号</th>
				<td><input type="text" name="account.acxh" id="lsgh" value="${t_account.acxh }"/></td>
				<th>代课名称</th>
				<td><input type="text" name="account.aczy" id="lsgh" value="${t_account.aczy }"/></td>
			</tr>
			<tr>
				<th>联系方式</th>
				<td><input type="text" name="account.acxy" id="lsxy" value="${t_account.acxy }"/></td>
			</tr>
			<tr>
				<td colspan="4" align="center"><input type="submit" value="提交" name="submit"/>&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置">&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="返回" onclick="javascript:history.go(0)"/></td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>
