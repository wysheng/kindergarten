$(document).ready(function(){
	var pageNo = getParam("pno");
	var ntitle = getParam("ntitle");
	if(!pageNo){
		pageNo = 1;
	}
	var pageSize = 10;
	getKecheng(pageNo, pageSize, ntitle);
	
	$("#search").click(function(){
		var ntitle = $("#ntitle").val();
		if($.trim(ntitle)==null || $.trim(ntitle)=="输入名称关键字查询" || $.trim(ntitle)==""){
			ntitle="";
		}
		window.location.href="/kindergarten/pages/kecheng.jsp?pno=1&ntitle="+encodeURIComponent(encodeURIComponent(ntitle));
	});
	
	$("#addkecheng").click(function(){
		addkecheng();
	});
});
//默认课程显示
function getKecheng(pageNo, pageSize, ntitle){
	var acqx = $("#acqx").val();
	var former = '/kindergarten/pages/kecheng';
	var acid = $("#acid").val();
	var latter = '.jsp';
	var str = '';
	$.post('/kindergarten/kecheng/getKechengList?ttid=' + Math.random(), {pageNo:pageNo, pageSize:pageSize, acid:acid, title:ntitle}, function(json, textStatus){
		if(json == null)
			return;
		try {
			var list = json.list;
			var count = json.count;
			var pageCount = json.pageCount;
			$.each(list, function(index, data){
				str += '<tr><td width="5%" align="center" class=sec1><input type="checkbox"></td>';
				str += '<td width="9%" align="center" class=sec1>'+data.kch+'</td>';
				str += '<td width="10%" align="center" class=sec1>'+data.kcm+'</td>';
				str += '<td width="11%" align="center" class=sec1>'+data.kcsj+'</td>';
				str += '<td width="9%" align="center" class=sec1>'+data.teid+'</td>';
				str += '<td width="6%" align="center" class=sec1>'+data.kcnj+'</td>';
				str += '<td width="6%" align="center" class=sec1>'+data.kcnf+'</td>';
				/*str += '<td width="9%" align="center" class=sec1>'+data.kczy+'</td>';
				str += '<td width="6%" align="center" class=sec1>'+data.kcxf+'</td>';*/
				str += '<td width="9%" align="center" class=sec1>'+data.kclb+'</td>';
				str += '<td width="9%" align="center" class=sec1>'+data.kckh+'</td>';
				if(acqx == 0){
					str += '<td width="9%" align="center" class=sec1><a href="javascript:updatekecheng('+data.id+')">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:delkecheng('+data.id+')">删除</a></td>';
				}
				str += '</tr>';
			});
			str += '<tr><td colspan="11"><div id="kkpager"></div></td></tr>';
			$("#tabhtml").html(str);
			fenye(pageNo, pageCount, count, former, latter, ntitle);
		} catch (e) {
			alert(e);
		}
	}, 'json');
}
//添加课程页面
function addkecheng(){
	var dialog = art.dialog({id:'N3960', title:'正在加载', lock:true, resize:false, drag:false, esc:true });
	$.post('/kindergarten/pages/addkecheng.jsp', {},function(json, textStatus){
		dialog.title('添加课程');
		dialog.content(json);
	});
}
//单个删除课程
function delkecheng(id){
	if(confirm("确定删除吗？")){
		window.location.href = '/kindergarten/kecheng/delKecheng/' + id;
	}
}
//修改课程信息
function updatekecheng(id){
	window.location.href = '/kindergarten/kecheng/getKechengById/' + id + '-updatekecheng';
}