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
		window.location.href = '/kindergarten/pages/stmoney.jsp?pno=1&ntitle=' + encodeURIComponent(encodeURIComponent(ntitle));
	});
	getMoneyList(pageNo, pageSize, ntitle);
});

function getMoneyList(pageNo, pageSize, ntitle){
	var acqx = $("#acqx").val();
	var id = $("#id").val();
	var str = '';
	var former = '/kindergarten/pages/stmoney';
	var latter = '.jsp';
	$.post('/kindergarten/bost/getStMoneyList?ttid=' + Math.random(), {pageNo:pageNo, pageSize:pageSize, ntitle:ntitle, acqx:acqx, id:id}, function(json, textStatus){
		if(json == '')
			return;
		try{
			var count = json.count;
			var pageCount = json.pageCount;
			var list = json.list;
			$.each(list, function(index, data){
				var price = data.price;
				var num = data.num;
				var ac = data.ac;
				var bost = data.bost;
				var c = index + 1;
				str += '<tr><td width="4%" align="center" class=sec1><input type="checkbox"></td>';
				str += '<td width="4%" align="center" class=sec1>' + c + '</td>';
				str += '<td width="8%" align="center" class=sec1>' + ac.acname + '</td>';
				str += '<td width="8%" align="center" class=sec1>' + ac.acxh + '</td>';
				str += '<td width="8%" align="center" class=sec1>' + ac.acsex + '</td>';
				str += '<td width="8%" align="center" class=sec1>' + ac.acnj + '</td>';
				if(acqx == 1){
				str += '<td width="8%" align="center" class=sec1>' + bost.bonf + '</td>';
				}else{
					str += '<td width="8%" align="center" class=sec1>2015</td>';					
				}
				str += '<td width="8%" align="center" class=sec1>' + ac.acxy + '</td>';
				str += '<td width="8%" align="center" class=sec1>' + ac.aczy + '</td>';
				str += '<td width="10%" align="center" class=sec1>' + num + '</td>';
				str += '<td width="10%" align="center" class=sec1>' + price + '</td>';
				str += '<td width="14%" align="center" class=sec1>';
				str += '<a href="javascript:lookBook('+ac.id+',1)">订书情况</a>';
				if(acqx == 0){
					str += '&nbsp;&nbsp;<a href="javascript:lookBook('+ac.id+',2)">历年订书情况</a>';
				}
				str += '</td>';
			});
			str += '<tr><td colspan="11"><div id="kkpager"></div></td></tr>';
			$("#tabhtml").html(str);
			if(acqx != 1){
				fenye(pageNo, pageCount, count, former, latter, ntitle);				
			}
		}catch(e){
			alert(e);
		}
	}, 'json');
}
//查看班级订阅情况
function lookBook(id, bs){
	window.location = '/kindergarten/pages/lookoldbook.jsp?id='+id+'&bs='+bs;
}