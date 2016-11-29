<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>幼儿园管理系统</title>
<link href="/kindergarten/pages/images/skin.css" rel="stylesheet" type="text/css" />
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
<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="17" valign="top" background="/kindergarten/pages/images/mail_leftbg.gif"><img
				src="/kindergarten/pages/images/left-top-right.gif" width="17" height="29" /></td>
			<td valign="top" background="/kindergarten/pages/images/content-bg.gif"><table
					width="100%" height="31" border="0" cellpadding="0" cellspacing="0"
					class="left_topbg" id="table2">
					<tr>
						<td height="31"><div class="titlebt">查看课表</div></td>
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
					
	<form action="#" method="post">
		<table border="1" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<th width="200px">标题</th>
				<td width="363px" align="center">${paike.title }</td>
				<th width="200px">年级</th>
				<td width="364px" align="center">${paike.pknj }</td>
			</tr>
			<tr>
				<th width="200px">学院</th>
				<td width="363px" align="center">${paike.pkxy }</td>
				<th width="200px">专业</th>			
				<td width="364px" align="center">${paike.zypk }</td>
			</tr>
		</table>
		<table border="1" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<th width="225px"></th>
				<th width="225px">第一节</th>
				<th width="225px">第二节</th>
				<th width="225px">第三节</th>
				<th width="225px">第四节</th>
			</tr>
			<c:forEach items="${pkval }" var="item" varStatus="ite">
			<tr>
				<c:forEach items="${welist }" var="items" varStatus="ites">
					<c:if test="${ite.index == ites.index }">
						<th width="225px">${items.week }</th>
					</c:if>
				</c:forEach>
				<td width="225px" align="center">${item.pkva_1 }</td>
				<td width="225px" align="center">${item.pkva_2 }</td>
				<td width="225px" align="center">${item.pkva_3 }</td>
				<td width="225px" align="center">${item.pkva_4 }</td>
			</tr>
			</c:forEach>
		</table>
		<table border="1" align="center" cellpadding="0" cellspacing="0" id="tabweek"></table>
		<table width="1137px" border="1" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td align="center"><input type="button" value="返回" onclick="javascript:history.go(-1)"/></td>
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
