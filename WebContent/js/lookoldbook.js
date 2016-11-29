$(document).ready(function(){
//	var pageNo = getParam("pno");
//	var ntitle = getParam("ntitle");
	var id = getParam("id");
	var bs = getParam("bs");
	
//	if(!pageNo)
//		pageNo = 1;
//	
//	var pageSize = 10;
	
//	$("#search").click(function(){
//		var ntitle = $("#ntitle").val();
//		ntitle = $.trim(ntitle);
//		if(ntitle == null || ntitle == "" || ntitle == "输入名称关键字查询")
//			ntitle = '';
//		window.location.href = '/kindergarten/pages/oldbook.jsp?pno=1&ntitle=' + encodeURIComponent(encodeURIComponent(ntitle));
//	});
	getBookList(id, bs);
	
});

function getBookList(id, bs){
	var str = '';
	$.post('/kindergarten/book/getStudBookList?ttid=' + Math.random(), {id:id, bs:bs}, function(json, textStatus){
		if(json == '')
			return;
		try{
			var list = json.list;
			$.each(list, function(index, datas){
				var data = datas.book;
				var c = index + 1;
				str += '<tr><td width="8%" align="center" class=sec1><input type="checkbox"></td>';
				str += '<td width="10%" align="center" class=sec1>' + c + '</td>';
				str += '<td width="10%" align="center" class=sec1>' + data.name + '</td>';
				str += '<td width="10%" align="center" class=sec1>' + data.author + '</td>';
				str += '<td width="10%" align="center" class=sec1>' + data.bocbs + '</td>';
				str += '<td width="10%" align="center" class=sec1>' + data.bonj + '</td>';
				str += '<td width="10%" align="center" class=sec1>' + data.bonf + '</td>';
				str += '<td width="10%" align="center" class=sec1>' + data.bodj + '</td>';
				str += '<td width="10%" align="center" class=sec1>' + data.bozkj + '</td>';
				str += '<td width="10%" align="center" class=sec1>' + data.boremark + '</td>';
			});
			$("#tabhtml").html(str);
		}catch(e){
			alert(e);
		}
	}, 'json');
}
