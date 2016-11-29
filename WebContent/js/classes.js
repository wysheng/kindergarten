$(document).ready(function(){
	var pageNo = getParam("pno");
	var ntitle = getParam("ntitle");
	if(!pageNo){
		pageNo = 1;
	}
	var pageSize = 10;
	getClasses(pageNo, pageSize, ntitle);
	
	$("#search").click(function(){
		var ntitle = $("#ntitle").val();
		if($.trim(ntitle)==null || $.trim(ntitle)=="输入名称关键字查询"){
			ntitle="";
		}
		window.location.href="/kindergarten/pages/person/classes.jsp?pno=1&ntitle="+encodeURIComponent(encodeURIComponent(ntitle));
	});
	
	$("#addclasses").click(function(){
		addclasses();
	});
});
//默认公告显示
function getClasses(pageNo, pageSize, title,noticeType){
	var acqx = $("#acqx").val();
	var former = '/kindergarten/pages/person';
	var latter = '.jsp';
	var str = '';
	$.post('/kindergarten/classes/getClassesList?ttid=' + Math.random(), {pageNo:pageNo, pageSize:pageSize, title:title}, function(json, textStatus){
		if(json == null)
			return;
		try {
			var classesList = json.classesList;
			var count = json.count;
			var pageCount = json.pageCount;
			$.each(classesList, function(index, data){
				var c = index + 1;
				str += '<tr><td width="5%" align="center" class=sec1><input type="checkbox"></td>';
				str += '<td width="10%" align="left" class=sec1>'+data.classesname+'</td>';
				str += '<td width="10%" align="center" class=sec1>'+data.stunum+'</td>';
				str += '<td width="15%" align="center" class=sec1>'+data.headmaster+'</td>';
				str += '<td width="30%" align="center" class=sec1>'+data.remark+'</td>';
				str += '<td width="20%" align="center" class=sec1><a href="javascript:updateClasses('+data.id+')">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:delnotice('+data.id+')">删除</a></td>';
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

function addclasses(){
	var dialog = art.dialog({id:'N3960', title:'正在加载', lock:true, resize:false, drag:false, esc:true });
	$.post('/kindergarten/pages/person/addnclasses.jsp', {},function(json, textStatus){
		dialog.title('添加班级');
		dialog.content(json);
	});
}
//单个删除notice
function delnotice(id){
	if(confirm("确定删除吗？")){
		window.location.href = '/kindergarten/notice/delNotice/' + id;
	}
}
//修改notice
function updateClasses(id){
	window.location.href = '/kindergarten/classes/getCalssesById/' + id + '-updateclasses';
}
//查看公告内容
function viewNotice(id){
	window.location.href = '/kindergarten/notice/getNoticeById/' + id + '-lookupnotice';
}