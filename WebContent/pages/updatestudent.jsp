<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/kindergarten/pages/images/skin.css" rel="stylesheet" type="text/css" />
<title>幼儿园管理系统</title>
<script type="text/javascript" src="/kindergarten/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/kindergarten/plugins/artDialog/artDialog.js?skin=twitter" ></script>	
<script type="text/javascript" src="/kindergarten/plugins/artDialog/plugins/iframeTools.js"></script>
<script type="text/javascript" src="/kindergarten/js/public.js"></script>
<script type="text/javascript" src="/kindergarten/js/public2.js"></script>
<script type="text/javascript">
function load(){
	$("#acsex").val(${t_account.acsex}) ;
	$("#lssex").val(${t_account.acsex }) ;
}
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
<body onload="load()">

<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="17" valign="top" background="/kindergarten/pages/images/mail_leftbg.gif"><img
				src="/kindergarten/pages/images/left-top-right.gif" width="17" height="29" /></td>
			<td valign="top" background="/kindergarten/pages/images/content-bg.gif"><table
					width="100%" height="31" border="0" cellpadding="0" cellspacing="0"
					class="left_topbg" id="table2">
					<tr>
						<td height="31"><div class="titlebt">修改人员</div></td>
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
				<c:if test="${t_account.acqx == '1' }">
<div id="student">
	<form action="/kindergarten/account/addOrUpdateStudent" method="post" onsubmit="return checkstudent()">
	<input type="hidden" id="id" name="account.id" value="${t_account.id }"/>
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
				<%-- <input type="text" name="account.acsex" id="acsex" value="${t_account.acsex }"/> --%></td>
			</tr>
			<tr>
				<th>年级班级</th>
				<td><input type="text" name="account.acnj" id="acnj" value="${t_account.acnj }"/></td>
				<th>学号</th>
				<td><input type="text" name="account.acxh" id="acxh" value="${t_account.acxh }"/></td>
			</tr>
			<tr>
				<th>母亲联系方式</th>
				<td><input type="text" name="account.acbj" id="acbj" value="${t_account.acbj }"/></td>
				<th>父亲联系方式</th>
				<td colspan="3"><input type="text" name="account.aczy" id="aczy" value="${t_account.aczy }"/></td>
			</tr>
			<tr>
				
				<th>家庭住址</th>
				<td><input type="text" name="account.acxy" id="acxy" value="${t_account.acxy }"/></td>
			</tr>
			<tr>
				<td colspan="4" align="center"><input type="submit" value="提交" name="submit"/>&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="返回" onclick="javascript:history.go(-1)"/></td>
			</tr>
		</table>
		</form>
	</div>
		</c:if>
		
	<c:if test="${t_account.acqx == '2' }">
	<div id="teacher">
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
				<td>
					<select  name="account.acsex" id="lssex">
						<option value="1">男</option>
						<option value="2">女</option>
					</select>
				<%-- <input type="text" name="account.acsex" id="lssex" value="${t_account.acsex }"/></td> --%>
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
				<td colspan="4" align="center"><input type="submit" value="提交" name="submit"/>&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="返回" onclick="javascript:history.go(-1)"/></td>
			</tr>
		</table>
	</form>
	</div>
	</c:if>	
					
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
