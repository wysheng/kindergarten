$(document).ready(function(){
	var pageNo = getParam("pno");
	var ntitle = getParam("ntitle");
	if(!pageNo){
		pageNo = 1;
	}
	var pageSize = 10;
	getProtectMeasuresList(pageNo, pageSize, ntitle);
	
	$("#search").click(function(){
		var ntitle = $("#ntitle").val();
		if($.trim(ntitle)==null || $.trim(ntitle)=="输入名称关键字查询"){
			ntitle="";
		}
		window.location.href="/kindergarten/pages/notice.jsp?pno=1&ntitle="+encodeURIComponent(encodeURIComponent(ntitle));
	});
	
	$("#addProtectMeasures").click(function(){
		addProtectMeasures();
	});
});
//默认防护措施主题记录
function getProtectMeasuresList(pageNo, pageSize, title){
	var acqx = $("#acqx").val();
	var former = '/kindergarten/pages/notice';
	var latter = '.jsp';
	var str = '';
	$.post('/kindergarten/protectMeasures/getProtectMeasuresList?ttid=' + Math.random(), {pageNo:pageNo, pageSize:pageSize, title:title}, function(json, textStatus){
		if(json == null)
			return;
		try {
			var protectMeasuresList = json.protectMeasuresList;
			var count = json.count;
			var pageCount = json.pageCount;
			$.each(protectMeasuresList, function(index, data){
				var c = index + 1;
				str += '<tr><td width="5%" align="center" class=sec1><input type="checkbox"></td>';
				str += '<td width="5%" align="center" class=sec1>'+c+'</td>';
				str += '<td width="10%" align="center" class=sec1>'+data.title+'</td>';
				str += '<td width="10%" align="center" class=sec1>'+data.executor+'</td>';
				str += '<td width="10%" align="center" class=sec1>'+data.supervision+'</td>';
				str += '<td width="25%" align="center" class=sec1>'+data.content+'</td>';
				str += '<td width="15%" align="center" class=sec1>'+data.recordTime+'</td>';
				if(acqx == 0){
					str += '<td width="20%" align="center" class=sec1><a href="javascript:updateProtectMeasurest('+data.id+')">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:delProtectMeasurest('+data.id+')">删除</a></td>';
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

function addProtectMeasures(){
	var dialog = art.dialog({id:'N3960', title:'正在加载', lock:true, resize:false, drag:false, esc:true });
	$.post('/kindergarten/pages/dailyAffairs/addProtectMeasures.jsp', {},function(json, textStatus){
		dialog.title('添加新的防护措施');
		dialog.content(json);
	});
}
//单个删除防护措施记录
function delProtectMeasurest(id){
	if(confirm("确定删除吗？")){
		window.location.href = '/kindergarten/protectMeasures/delProtectMeasures/' + id;
	}
}
//修改防护措施记录
function updateProtectMeasurest(id){
	window.location.href = '/kindergarten/protectMeasures/getProtectMeasuresById/' + id + '-updateProtectMeasurest';
}
//查看防护措施主题记录
function viewNotice(id){
	window.location.href = '/kindergarten/notice/getNoticeById/' + id + '-lookupnotice';
}