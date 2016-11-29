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
	getMoneyList(pageNo, pageSize, ntitle);
});

function getMoneyList(pageNo, pageSize, ntitle){
	var str = '';
	var former = '/kindergarten/pages/money';
	var latter = '.jsp';
	$.post('/kindergarten/bost/getMoneyList?ttid=' + Math.random(), {pageNo:pageNo, pageSize:pageSize, ntitle:ntitle}, function(json, textStatus){
		if(json == '')
			return;
		try{
			var count = json.count;
			var pageCount = json.pageCount;
			var list = json.list;
			$.each(list, function(index, data){
				var zkj = data.zkj;
				var book = data.book;
				var count = data.count;
				var c = index + 1;
				str += '<tr><td width="4%" align="center" class=sec1><input type="checkbox"></td>';
				str += '<td width="4%" align="center" class=sec1>' + c + '</td>';
				str += '<td width="15%" align="center" class=sec1>' + book.bonj + '</td>';
				str += '<td width="15%" align="center" class=sec1>' + book.name + '</td>';
				str += '<td width="15%" align="center" class=sec1>' + book.author + '</td>';
				
				str += '<td width="15%" align="center" class=sec1><a href="javascript:lookclass('+book.id+','+book.boremark+')">查看班级</a></td>';
				str += '<td width="15%" align="center" class=sec1>' + count + '</td>';
				str += '<td width="15%" align="center" class=sec1>' + zkj + '</td>';
			});
			str += '<tr><td colspan="9"><div id="kkpager"></div></td></tr>';
			$("#tabhtml").html(str);
			fenye(pageNo, pageCount, count, former, latter, ntitle);
		}catch(e){
			alert(e);
		}
	}, 'json');
}
//查看班级订阅情况
function lookclass(id, bjzkj){
	window.location = '/kindergarten/pages/lookbost.jsp?id='+id+'&bjzkj='+bjzkj;
}