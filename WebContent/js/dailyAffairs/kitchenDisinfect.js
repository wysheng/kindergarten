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
	
	$("#addKitchenDisinfect").click(function(){
		addKitchenDisinfect();
	});
});
//默认厨房消毒主题记录
function getRegularMeetingList(pageNo, pageSize, title){
	var acqx = $("#acqx").val();
	var former = '/kindergarten/pages/notice';
	var latter = '.jsp';
	var str = '';
	$.post('/kindergarten/kitchenDisinfect/getkitchenDisinfectList?ttid=' + Math.random(), {pageNo:pageNo, pageSize:pageSize, title:title}, function(json, textStatus){
		if(json == null)
			return;
		try {
			var kitchenDisinfectList = json.kitchenDisinfectList;
			var count = json.count;
			var pageCount = json.pageCount;
			$.each(kitchenDisinfectList, function(index, data){
				var c = index + 1;
				str += '<tr><td width="5%" align="center" class=sec1><input type="checkbox"></td>';
				str += '<td width="5%" align="center" class=sec1>'+c+'</td>';
				str += '<td width="10%" align="center" class=sec1>'+data.kitchenNo+'</td>';
				str += '<td width="10%" align="center" class=sec1>'+data.executor+'</td>';
				str += '<td width="10%" align="center" class=sec1>'+data.supervision+'</td>';
				str += '<td width="10%" align="center" class=sec1>'+data.tools+'</td>';
				str += '<td width="25%" align="center" class=sec1>'+data.remark+'</td>';
				str += '<td width="15%" align="center" class=sec1>'+data.recordTime+'</td>';
				if(acqx == 0){
					str += '<td width="20%" align="center" class=sec1><a href="javascript:updatekitchenDisinfect('+data.id+')">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:delkitchenDisinfect('+data.id+')">删除</a></td>';
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

function addKitchenDisinfect(){
	var dialog = art.dialog({id:'N3960', title:'正在加载', lock:true, resize:false, drag:false, esc:true });
	$.post('/kindergarten/pages/dailyAffairs/addKitchenDisinfect.jsp', {},function(json, textStatus){
		dialog.title('添加厨房消毒记录');
		dialog.content(json);
	});
}
//单个删除厨房消毒记录
function delkitchenDisinfect(id){
	if(confirm("确定删除吗？")){
		window.location.href = '/kindergarten/kitchenDisinfect/delkitchenDisinfect/' + id;
	}
}
//修改厨房消毒记录
function updatekitchenDisinfect(id){
	window.location.href = '/kindergarten/kitchenDisinfect/getkitchenDisinfectById/' + id + '-updateKitchenDisinfect';
}
//查看厨房消毒主题记录
function viewNotice(id){
	window.location.href = '/kindergarten/notice/getNoticeById/' + id + '-lookupnotice';
}