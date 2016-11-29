$(document).ready(function(){
	var pageNo = getParam("pno");
	var ntitle = getParam("ntitle");
	if(!pageNo){
		pageNo = 1;
	}
	var pageSize = 10;
	getRegularMeetingList(pageNo, pageSize, ntitle);
	
	$("#search").click(function(){
		var ntitle = $("#ntitle").val();
		if($.trim(ntitle)==null || $.trim(ntitle)=="输入名称关键字查询"){
			ntitle="";
		}
		window.location.href="/kindergarten/pages/notice.jsp?pno=1&ntitle="+encodeURIComponent(encodeURIComponent(ntitle));
	});
	
	$("#addRegularMeeting").click(function(){
		addRegularMeeting();
	});
});
//默认周会主题记录
function getRegularMeetingList(pageNo, pageSize, title){
	var acqx = $("#acqx").val();
	var former = '/kindergarten/pages/notice';
	var latter = '.jsp';
	var str = '';
	$.post('/kindergarten/regularMeeting/getRegularMeetingList?ttid=' + Math.random(), {pageNo:pageNo, pageSize:pageSize, title:title}, function(json, textStatus){
		if(json == null)
			return;
		try {
			var regularMeetingList = json.regularMeetingList;
			var count = json.count;
			var pageCount = json.pageCount;
			$.each(regularMeetingList, function(index, data){
				var c = index + 1;
				str += '<tr><td width="5%" align="center" class=sec1><input type="checkbox"></td>';
				str += '<td width="5%" align="center" class=sec1>'+c+'</td>';
				str += '<td width="10%" align="center" class=sec1>'+data.meetingTitle+'</td>';
				str += '<td width="10%" align="center" class=sec1>'+data.meetingCompere+'</td>';
				str += '<td width="10%" align="center" class=sec1>'+data.meetingAttendee+'</td>';
				str += '<td width="10%" align="center" class=sec1>'+data.meetingAttendeeNum+'</td>';
				str += '<td width="25%" align="center" class=sec1>'+data.meetingContent+'</td>';
				str += '<td width="15%" align="center" class=sec1>'+data.recordTime+'</td>';
				if(acqx == 0){
					str += '<td width="20%" align="center" class=sec1><a href="javascript:updateRegularMeeting('+data.id+')">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:delRegularMeeting('+data.id+')">删除</a></td>';
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

function addRegularMeeting(){
	var dialog = art.dialog({id:'N3960', title:'正在加载', lock:true, resize:false, drag:false, esc:true });
	$.post('/kindergarten/pages/dailyAffairs/addRegularMeeting.jsp', {},function(json, textStatus){
		dialog.title('添加学生事故');
		dialog.content(json);
	});
}
//单个删除周会记录
function delRegularMeeting(id){
	if(confirm("确定删除吗？")){
		window.location.href = '/kindergarten/regularMeeting/delRegularMeeting/' + id;
	}
}
//修改周会记录
function updateRegularMeeting(id){
	window.location.href = '/kindergarten/regularMeeting/getRegularMeetingById/' + id + '-updateRegularMeeting';
}
//查看周会主题记录
function viewNotice(id){
	window.location.href = '/kindergarten/notice/getNoticeById/' + id + '-lookupnotice';
}