$(document).ready(function(){
	var pageNo = getParam("pno");
	var ntitle = getParam("ntitle");
	if(!pageNo){
		pageNo = 1;
	}
	var pageSize = 10;
	getPaike(pageNo, pageSize, ntitle);
	
	$("#search").click(function(){
		var ntitle = $("#ntitle").val();
		if($.trim(ntitle)==null || $.trim(ntitle)=="输入名称关键字查询" || $.trim(ntitle)==""){
			ntitle="";
		}
		window.location.href="/kindergarten/pages/paike.jsp?pno=1&ntitle="+encodeURIComponent(encodeURIComponent(ntitle));
	});
	
	$("#addpaike").click(function(){
		addpaike();
	});
});
//默认人员显示
function getPaike(pageNo, pageSize, ntitle){
	var acqx = $("#acqx").val();
	var former = '/kindergarten/pages/paike';
	var latter = '.jsp';
	var acid = $("#acid").val();
	var str = '';
	$.post('/kindergarten/paike/getPaikeList?ttid=' + Math.random(), {pageNo:pageNo, pageSize:pageSize, acid:acid, title:ntitle}, function(json, textStatus){
		if(json == null)
			return;
		try {
			var paikeList = json.paikeList;
			var count = json.count;
			var pageCount = json.pageCount;
			$.each(paikeList, function(index, data){
				var c = index + 1;
				str += '<tr><td width="4%" align="center" class=sec1><input type="checkbox"></td>';
				str += '<td width="4%" align="center" class=sec1>'+c+'</td>';
				str += '<td width="15%" align="center" class=sec1><a href="javascript:lookpaike('+data.id+')">'+data.title+'</a></td>';
				str += '<td width="15%" align="center" class=sec1>'+data.pknj+'</td>';
				str += '<td width="15%" align="center" class=sec1>'+data.pknf+'</td>';
				str += '<td width="15%" align="center" class=sec1>'+data.zypk+'</td>';
				str += '<td width="15%" align="center" class=sec1>'+data.createtime+'</td>';
				if(acqx != 1){
				str += '<td width="15%" align="center" class=sec1><a href="javascript:updatepaike('+data.id+')">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:delpaike('+data.id+')">删除</a></td>';
				}
				str += '</tr>';
			});
			str += '<tr><td colspan="7"><div id="kkpager"></div></td></tr>';
			$("#tabhtml").html(str);
			fenye(pageNo, pageCount, count, former, latter, ntitle);
		} catch (e) {
			alert(e);
		}
	}, 'json');
}
//添加课程表
function addpaike(){
	window.location = '/kindergarten/pages/addpaike.jsp';
}
//单个删除人员
function delpaike(id){
	if(confirm("确定删除吗？")){
		window.location.href = '/kindergarten/paike/delPaike/' + id;
	}
}
//修改课程表
function updatepaike(id){
	window.location.href = '/kindergarten/paike/lookPaike/' + id + '-updatepaike';
}
//查看课程表
function lookpaike(id){
	window.location.href = '/kindergarten/paike/lookPaike/' + id + '-lookpaike';
}
