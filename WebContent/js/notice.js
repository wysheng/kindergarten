$(document).ready(function(){
	var pageNo = getParam("pno");
	var ntitle = getParam("ntitle");
	var noticeType = $("#noticeType").val();
	if(!pageNo){
		pageNo = 1;
	}
	var pageSize = 10;
	getNotice(pageNo, pageSize, ntitle,noticeType);
	
	$("#search").click(function(){
		var ntitle = $("#ntitle").val();
		if($.trim(ntitle)==null || $.trim(ntitle)=="输入名称关键字查询"){
			ntitle="";
		}
		window.location.href="/kindergarten/pages/notice.jsp?pno=1&ntitle="+encodeURIComponent(encodeURIComponent(ntitle));
	});
	
	$("#addnotice").click(function(){
		addnotice();
	});
});
//默认公告显示
function getNotice(pageNo, pageSize, title,noticeType){
	var acqx = $("#acqx").val();
	var former = '/kindergarten/pages/notice';
	var latter = '.jsp';
	var str = '';
	$.post('/kindergarten/notice/getNoticeList?ttid=' + Math.random(), {pageNo:pageNo, pageSize:pageSize, title:title,noticeType:noticeType}, function(json, textStatus){
		if(json == null)
			return;
		try {
			var noticeList = json.noticeList;
			var count = json.count;
			var pageCount = json.pageCount;
			$.each(noticeList, function(index, data){
				var ntype="";
				if(data.ntype == 0){
					ntype="全体工作人员";
				}else if(data.ntype==1){
					ntype="后勤工作人员";
				}else if(data.ntype==2){
					ntype="教务人员";
				}else{
					ntype="废弃数据";
				}
				var c = index + 1;
				str += '<tr><td width="5%" align="center" class=sec1><input type="checkbox"></td>';
				str += '<td width="10%" align="center" class=sec1>'+c+'</td>';
				str += '<td width="28%" align="center" class=sec1><a href="javascript:viewNotice('+data.id+')">'+data.ntitle+'</a></td>';
				str += '<td width="10%" align="center" class=sec1>'+ntype+'</td>';
				str += '<td width="25%" align="center" class=sec1>'+data.ntime+'</td>';
				if(acqx == 0){
					str += '<td width="20%" align="center" class=sec1><a href="javascript:updatenotice('+data.id+')">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:delnotice('+data.id+')">删除</a></td>';
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

function addnotice(){
	var dialog = art.dialog({id:'N3960', title:'正在加载', lock:true, resize:false, drag:false, esc:true });
	$.post('/kindergarten/pages/notice/addnotice.jsp', {},function(json, textStatus){
		dialog.title('添加公告');
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
function updatenotice(id){
	window.location.href = '/kindergarten/notice/getNoticeById/' + id + '-updatenotice';
}
//查看公告内容
function viewNotice(id){
	window.location.href = '/kindergarten/notice/getNoticeById/' + id + '-lookupnotice';
}