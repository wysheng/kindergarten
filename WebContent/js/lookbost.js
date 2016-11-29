$(document).ready(function(){
//	var pageNo = getParam("pno");
//	var ntitle = getParam("ntitle");
//	if(!pageNo)
//		pageNo = 1;
//	
//	var pageSize = 10;
//	
//	$("#").click(function(){
//		var ntitle = $("#ntitle").val();
//		ntitle = $.trim(ntitle);
//		if(ntitle == null || ntitle == "")
//			ntitle = '';
//		window.locaton.href = '/kindergarten/pages/book.jsp?pno=1&ntitle=' + encodeURIComponent(encodeURIComponent(ntitle));
//	});
//	getBookList(pageNo, pageSize, ntitle);
//	
//	$("#addbook").click(function(){
//		addbook();
//	});
	
	var id = getParam("id");
	var bjzkj = getParam("bjzkj");
	getClsCount(id, bjzkj);
	
});

function getClsCount(id, bjzkj){
	var str = '';
	var former = '';
	var latter = '.jsp';
	$.post('/kindergarten/bost/getClsCount?ttid=' + Math.random(), {boid:id, bjzkj:bjzkj}, function(json, textStatus){
		if(json == '')
			return;
		try{
			var list = json.list;
			$.each(list, function(index, data){
				var c = index + 1;
				str += '<tr><td width="8%" align="center" class=sec1><input type="checkbox"></td>';
				str += '<td width="18%" align="center" class=sec1>' + c + '</td>';
				str += '<td width="18%" align="center" class=sec1>' + data.bt.bj + '</td>';
				str += '<td width="18%" align="center" class=sec1>' + bjzkj + '</td>';
				str += '<td width="18%" align="center" class=sec1>' + data.count + '</td>';
				str += '<td width="18%" align="center" class=sec1>' + data.zkj + '</td>';
			});
			$("#tabhtml").html(str);
		}catch(e){
			alert(e);
		}
	}, 'json');
}