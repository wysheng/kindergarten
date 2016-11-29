<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>幼儿园管理系统</title>
<script src="js/prototype.lite.js" type="text/javascript"></script>
<script src="js/moo.fx.js" type="text/javascript"></script>
<script src="js/moo.fx.pack.js" type="text/javascript"></script>
<style>
body {
	font:12px Arial, Helvetica, sans-serif;
	color: #000;
	background-color: #EEF2FB;
	margin: 0px;
}
#container {
	width: 182px;
}
H1 {
	font-size: 12px;
	margin: 0px;
	width: 182px;
	cursor: pointer;
	height: 30px;
	line-height: 20px;	
}
H1 a {
	display: block;
	width: 182px;
	color: #000;
	height: 30px;
	text-decoration: none;
	moz-outline-style: none;
	background-image: url(/kindergarten/pages/images/menu_bgS.gif);
	background-repeat: no-repeat;
	line-height: 30px;
	text-align: center;
	margin: 0px;
	padding: 0px;
}
.content{
	width: 182px;
	height: 26px;
	
}
.MM ul {
	list-style-type: none;
	margin: 0px;
	padding: 0px;
	display: block;
}
.MM li {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 26px;
	color: #333333;
	list-style-type: none;
	display: block;
	text-decoration: none;
	height: 26px;
	width: 182px;
	padding-left: 0px;
}
.MM {
	width: 182px;
	margin: 0px;
	padding: 0px;
	left: 0px;
	top: 0px;
	right: 0px;
	bottom: 0px;
	clip: rect(0px,0px,0px,0px);
}
.MM a:link {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 26px;
	color: #333333;
	background-image: url(/kindergarten/pages/images/menu_bg1.gif);
	background-repeat: no-repeat;
	height: 26px;
	width: 182px;
	display: block;
	text-align: center;
	margin: 0px;
	padding: 0px;
	overflow: hidden;
	text-decoration: none;
}
.MM a:visited {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 26px;
	color: #333333;
	background-image: url(/kindergarten/pages/images/menu_bg1.gif);
	background-repeat: no-repeat;
	display: block;
	text-align: center;
	margin: 0px;
	padding: 0px;
	height: 26px;
	width: 182px;
	text-decoration: none;
}
.MM a:active {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 26px;
	color: #333333;
	background-image: url(/kindergarten/pages/images/menu_bg1.gif);
	background-repeat: no-repeat;
	height: 26px;
	width: 182px;
	display: block;
	text-align: center;
	margin: 0px;
	padding: 0px;
	overflow: hidden;
	text-decoration: none;
}
.MM a:hover {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 26px;
	font-weight: bold;
	color: #006600;
	background-image: url(/kindergarten/pages/images/menu_bg2.gif);
	background-repeat: no-repeat;
	text-align: center;
	display: block;
	margin: 0px;
	padding: 0px;
	height: 26px;
	width: 182px;
	text-decoration: none;
}
</style>
</head>

<body>
<table width="100%" height="280" border="0" cellpadding="0" cellspacing="0" bgcolor="#EEF2FB">
  <tr>
    <td width="182" valign="top">
    <div id="container">
    <h1 class="type"><a href="/kindergarten/pages/right.jsp" target="main">系统首页</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="/kindergarten/pages/images/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM">
          
        </ul>
      </div>
     <h1 class="type"><a href="javascript:void(0)" target="main">公告管理</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="/kindergarten/pages/images/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM">
        	<c:if test="${acqx == 0}">
        	<li><a href="/kindergarten/pages/notice/notice.jsp" target="main">公告管理</a></li>
        	</c:if>
        	<c:if test="${acqx != 1}">
        	<li><a href="/kindergarten/pages/notice/noticeToSupporter.jsp" target="main">后勤工作人员公告</a></li>
        	<li><a href="/kindergarten/pages/notice/noticeToTeacher.jsp" target="main">教务人员公告</a></li>
        	</c:if>
        	<li><a href="/kindergarten/pages/notice/noticeToAll.jsp" target="main">全体人员公告</a></li>
        </ul>
      </div>
      <c:if test="${acqx != 1}">
	      <h1 class="type"><a href="javascript:void(0)">人员管理</a></h1>
	      <div class="content">
	        <table width="100%" border="0" cellspacing="0" cellpadding="0">
	          <tr>
	            <td><img src="/kindergarten/pages/images/menu_topline.gif" width="182" height="5" /></td>
	          </tr>
	        </table>
	        <ul class="MM">
	        	<li><a href="/kindergarten/pages/person/allPerson.jsp" target="main">人员信息管理</a></li>
	        	<li><a href="/kindergarten/pages/person/student.jsp" target="main">学生信息管理</a></li>
	        	
	        	<li><a href="/kindergarten/pages/person/teacher.jsp" target="main">教师信息管理</a></li>
	        	
	        	<li><a href="/kindergarten/pages/person/classes.jsp" target="main">班级信息管理</a></li>
	        </ul>
	      </div>
      </c:if>
    	<h1 class="type"><a href="javascript:void(0)">教材管理</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="/kindergarten/pages/images/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM">
          <li><a href="/kindergarten/pages/book.jsp" target="main">幼儿园教材</a></li>
          <li><a href="/kindergarten/pages/schoolfee/schoolFee.jsp" target="main">学生费用</a></li>
        </ul>
      </div>
      <h1 class="type"><a href="javascript:void(0)">课表管理</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="/kindergarten/pages/images/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM">
        	<c:if test="${acqx != 1 }">
          <li><a href="/kindergarten/pages/teacpaike.jsp" target="main">教师课表</a></li>
          </c:if>
          <li><a href="/kindergarten/pages/paike.jsp" target="main">学生课表</a></li>
          <li><a href="/kindergarten/pages/kecheng.jsp" target="main">查看课程</a></li>
          <li><a href="/kindergarten/pages/oldkecheng.jsp" target="main">往年课程</a></li>
          <c:if test="${acqx != 1 }">
          <li><a href="/kindergarten/pages/oldtepaike.jsp" target="main">往年教师课表</a></li>
          </c:if>
          <li><a href="/kindergarten/pages/oldpaike.jsp" target="main">往年学生课表</a></li>
        </ul>
      </div>
      <h1 class="type"><a href="javascript:void(0)">日常事务管理</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="/kindergarten/pages/images/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM">
        <c:if test="${acqx != 1 }">
          <li><a href="/kindergarten/pages/stusick/stuSickCheck.jsp" target="main">学生生病记录</a></li>
          <li><a href="/kindergarten/pages/morningCheck/stuMorningCheck.jsp" target="main">学生晨检记录</a></li>
          <li><a href="/kindergarten/pages/stusick/stuNeedTakePills.jsp" target="main">学生喂药记录</a></li>
          <li><a href="/kindergarten/pages/dailyAffairs/stuAccident.jsp" target="main">学生事故记录</a></li>
          </c:if>
          <li><a href="/kindergarten/pages/dailyAffairs/teacherStudy.jsp" target="main">教师参加学习记录</a></li>
          <li><a href="/kindergarten/pages/dailyAffairs/regularMeeting.jsp" target="main">幼儿园周会主题记录</a></li>
          <li><a href="/kindergarten/pages/dailyAffairs/kitchenDisinfect.jsp" target="main">厨房消毒记录</a></li>
          <li><a href="/kindergarten/pages/dailyAffairs/protectMeasures.jsp" target="main">幼儿园防护实施记录</a></li>
        </ul>
      </div>
    </div>
        <script type="text/javascript">
		var contents = document.getElementsByClassName('content');
		var toggles = document.getElementsByClassName('type');
	
		var myAccordion = new fx.Accordion(
			toggles, contents, {opacity: true, duration: 400}
		);
		myAccordion.showThisHideOpen(contents[0]);
	</script>
        </td>
  </tr>
</table>
</body>
</html>
