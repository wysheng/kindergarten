$(document).ready(function(){
	var pageNo = getParam("pno");
	var ntitle = getParam("ntitle");
	if(!pageNo){
		pageNo = 1;
	}
	var pageSize = 10;
	getStuAccident(pageNo, pageSize, ntitle);
	
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
//默认公告显示
function getStuAccident(pageNo, pageSize, title){
	var acqx = $("#acqx").val();
	var former = '/kindergarten/pages/notice';
	var latter = '.jsp';
	var str = '';
	$.post('/kindergarten/stuAccident/getstuAccidentList?ttid=' + Math.random(), {pageNo:pageNo, pageSize:pageSize, title:title}, function(json, textStatus){
		if(json == null)
			return;
		try {
			var stuAccidentList = json.stuAccidentList;
			var count = json.count;
			var pageCount = json.pageCount;
			$.each(stuAccidentList, function(index, data){
				var level="";
				if(data.level == 0){
					level="弱";
				}else if(data.level==1){
					level="中";
				}else if(data.level==2){
					level="强";
				}else{
					level="待确认";
				}
				var c = index + 1;
				str += '<tr><td width="5%" align="center" class=sec1><input type="checkbox"></td>';
				str += '<td width="10%" align="center" class=sec1>'+c+'</td>';
				str += '<td width="10%" align="left" class=sec1>'+data.classes+'</td>';
				str += '<td width="15%" align="left" class=sec1>'+data.stuName+'</td>';
				str += '<td width="10%" align="left" class=sec1>'+level+'</td>';
				str += '<td width="25%" align="left" class=sec1>'+data.accidentDeatail+'</td>';
				str += '<td width="15%" align="center" class=sec1>'+data.recordTime+'</td>';
				if(acqx != 1){
					str += '<td width="20%" align="center" class=sec1><a href="javascript:updateStuAccident('+data.id+')">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:delStuAccident('+data.id+')">删除</a></td>';
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
//单个删除notice
function delStuAccident(id){
	if(confirm("确定删除吗？")){
		window.location.href = '/kindergarten/stuAccident/delStuAccident/' + id;
	}
}
//修改学生事故
function updateStuAccident(id){
	window.location.href = '/kindergarten/stuAccident/getstuAccidentById/' + id + '-updatestuAccident';
}
//查看公告内容
function viewNotice(id){
	window.location.href = '/kindergarten/notice/getNoticeById/' + id + '-lookupnotice';
}