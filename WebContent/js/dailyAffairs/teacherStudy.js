$(document).ready(function(){
	var pageNo = getParam("pno");
	var ntitle = getParam("ntitle");
	if(!pageNo){
		pageNo = 1;
	}
	var pageSize = 10;
	getTeacherStudy(pageNo, pageSize, ntitle);
	
	$("#search").click(function(){
		var ntitle = $("#ntitle").val();
		if($.trim(ntitle)==null || $.trim(ntitle)=="输入名称关键字查询"){
			ntitle="";
		}
		window.location.href="/kindergarten/pages/notice.jsp?pno=1&ntitle="+encodeURIComponent(encodeURIComponent(ntitle));
	});
	
	$("#addTeacherStudy").click(function(){
		addTeacherStudy();
	});
});
//默认教师外出学习显示
function getTeacherStudy(pageNo, pageSize, title){
	var acqx = $("#acqx").val();
	var former = '/kindergarten/pages/notice';
	var latter = '.jsp';
	var str = '';
	$.post('/kindergarten/teacherStudy/getTeacherStudyList?ttid=' + Math.random(), {pageNo:pageNo, pageSize:pageSize, title:title}, function(json, textStatus){
		if(json == null)
			return;
		try {
			var teacherStudyList = json.teacherStudyList;
			var count = json.count;
			var pageCount = json.pageCount;
			$.each(teacherStudyList, function(index, data){
				var c = index + 1;
				str += '<tr><td width="5%" align="center" class=sec1><input type="checkbox"></td>';
				str += '<td width="5%" align="center" class=sec1>'+c+'</td>';
				str += '<td width="10%" align="left" class=sec1>'+data.teacherName+'</td>';
				str += '<td width="10%" align="left" class=sec1>'+data.course+'</td>';
				str += '<td width="15%" align="left" class=sec1>'+data.studyContent+'</td>';
				str += '<td width="25%" align="left" class=sec1>'+data.studyDetail+'</td>';
				str += '<td width="15%" align="center" class=sec1>'+data.recordTime+'</td>';
				if(acqx == 0){
					str += '<td width="20%" align="center" class=sec1><a href="javascript:updateTeacherStudy('+data.id+')">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:delTeacherStudy('+data.id+')">删除</a></td>';
				}
				str += '</tr>';
			});
			str += '<tr><td colspan="5"><div id="kkpager"></div></td></tr>';
			$("#tabhtml").html(str);
			fenye(pageNo, pageCount, count, former, latter, title);
		} catch (e) {
			alert(e);
		}
	}, 'json');
}

function addTeacherStudy(){
	var dialog = art.dialog({id:'N3960', title:'正在加载', lock:true, resize:false, drag:false, esc:true });
	$.post('/kindergarten/pages/dailyAffairs/addTeacherStudy.jsp', {},function(json, textStatus){
		dialog.title('添加学生事故');
		dialog.content(json);
	});
}
//单个删除教师外出去学习
function delTeacherStudy(id){
	if(confirm("确定删除吗？")){
		window.location.href = '/kindergarten/teacherStudy/delTeacherStudy/' + id;
	}
}
//修改教师外出学习
function updateTeacherStudy(id){
	window.location.href = '/kindergarten/teacherStudy/getTeacherStudyById/' + id + '-updateTeacherStudy';
}
//查看公告内容
function viewNotice(id){
	window.location.href = '/kindergarten/notice/getNoticeById/' + id + '-lookupnotice';
}