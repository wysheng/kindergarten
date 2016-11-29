$(document).ready(function(){
	
	var pageNo = getParam("pno");
	var ntitle = getParam("ntitle");
	if(!pageNo)
		pageNo = 1;
	
	var pageSize = 10;
	
	$("#search").click(function(){
		var ntitle = $("#ntitle").val();
		ntitle = $.trim(ntitle);
		if(ntitle == null || ntitle == "输入名称关键字查询" || ntitle == "")
			ntitle = '';
		window.location.href = '/kindergarten/pages/money.jsp?pno=1&ntitle=' + encodeURIComponent(encodeURIComponent(ntitle));
	});
	$("#addschfee").click(function(){
		addschoolfee();
	});
	getSchoolFeeList(pageNo, pageSize, ntitle);
	
	
});

function addschoolfee(){
	var dialog = art.dialog({id:'N3960', title:'正在加载', lock:true, resize:false, drag:false, esc:true });
	$.post('/kindergarten/pages/schoolfee/addschoolfee.jsp', {},function(json, textStatus){
		dialog.title('添加公告');
		dialog.content(json);
	});
}
function getSchoolFeeList(pageNo, pageSize, ntitle){
	var acqx = $("#acqx").val();
	var str = '';
	var former = '/kindergarten/pages/money';
	var latter = '.jsp';
	$.post('/kindergarten/schoolfee/getSchoolFeeList?ttid=' + Math.random(), {pageNo:pageNo, pageSize:pageSize, ntitle:ntitle}, function(json, textStatus){
		if(json == '')
			return;
		try{
			
			var count = json.count;
			var pageCount = json.pageCount;
			var schoolfeePage = json.schoolfeePage;
			$.each(schoolfeePage, function(index, data){
				var c = index + 1;
				str += '<tr><td width="4%" align="center" class=sec1><input type="checkbox"></td>';
				str += '<td width="4%" align="center" class=sec1>' + c + '</td>';
				str += '<td width="5%" align="center" class=sec1>' + data.grade + '</td>';
				str += '<td width="10%" align="center" class=sec1>' + data.classes + '</td>';
				str += '<td width="5%" align="center" class=sec1>' + data.classnum + '</td>';
				
				str += '<td width="15%" align="center" class=sec1>'+data.projectname+'</td>';
				str += '<td width="5%" align="center" class=sec1>' + data.amount + '</td>';
				str += '<td width="25%" align="center" class=sec1>' + data.remark + '</td>';
				str += '<td width="10%" align="center" class=sec1>' + data.addtime + '</td>';
				if(acqx == 0){
				str += '<td width="10%" align="center" class=sec1><a href="javascript:updateschfee('+data.id+')">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:delnotice('+data.id+')">删除</a></td>';
				}
				str += '</tr>';
			});
			str += '<tr><td colspan="9"><div id="kkpager"></div></td></tr>';
			$("#tabhtml").html(str);
			fenye(pageNo, pageCount, count, former, latter, ntitle);
		}catch(e){
			alert(e);
		}
	}, 'json');
}
//单个删除notice
function delnotice(id){
	if(confirm("确定删除吗？")){
		window.location.href = '/kindergarten/schoolfee/delNotice/' + id;
	}
}
//修改schoolfee
function updateschfee(id){
	window.location.href = '/kindergarten/schoolfee/getschfeeById/' + id + '-updateschoolfee';
}
//查看班级订阅情况
function lookclass(id, bjzkj){
	window.location = '/kindergarten/pages/lookbost.jsp?id='+id+'&bjzkj='+bjzkj;
}