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
		window.location.href = '/kindergarten/pages/book.jsp?pno=1&ntitle=' + encodeURIComponent(encodeURIComponent(ntitle));
	});
	getBookList(pageNo, pageSize, ntitle);
	
	$("#addbook").click(function(){
		addbook();
	});
});

function getBookList(pageNo, pageSize, ntitle){
	var stid = $("#stid").val();
	var acqx = $("#acqx").val();
	var acnj = $("#acnj").val();
	var str = '';
	var former = '/kindergarten/pages/book';
	var latter = '.jsp';
	$.post('/kindergarten/book/getBookList?ttid=' + Math.random(), {pageNo:pageNo, pageSize:pageSize, ntitle:ntitle, acqx:acqx, stid:stid, acnj:acnj}, function(json, textStatus){
		if(json == '')
			return;
		try{
			var count = json.count;
			var pageCount = json.pageCount;
			var bookPage = json.bookPage;
			$.each(bookPage, function(index, data){
				var bosh = ''
				if(data.bosh == 0){
					bosh = '未过审核';
				}else if(data.bosh == 1){
					bosh = '等待审核';
				}else{
					bosh = '通过审核';
				}
				var xg = '';
				var tx = '';
				if(data.stid != null){
					xg = '已选购';
					tx = '退选';
				}else{
					xg = '未定购';
					tx = '选购';
				}
				var c = index + 1;
				str += '<tr><td width="5%" align="center" class=sec1><input type="checkbox"></td>';
				str += '<td width="5%" align="center" class=sec1>' + c + '</td>';
				str += '<td width="10%" align="center" class=sec1>' + data.name + '</td>';
				str += '<td width="10%" align="center" class=sec1>' + data.author + '</td>';
				str += '<td width="10%" align="center" class=sec1>' + data.bocbs + '</td>';
				str += '<td width="5%" align="center" class=sec1>' + data.bonj + '</td>';
				str += '<td width="8%" align="center" class=sec1>' + data.bodj + '</td>';
				str += '<td width="8%" align="center" class=sec1>' + data.bozkj + '</td>';
				str += '<td width="18%" align="center" class=sec1>' + data.boremark + '</td>';   
				str += '<td width="10%" align="center" class=sec1>'+bosh+'</td>'; 
				if(acqx == 0){
					str += '<td width="13%" align="center" class=sec1><a href="javascript:checkbook('+data.id+')">审核</a></td>';
				}
				if(acqx == 2){
					str += '<td width="13%" align="center" class=sec1><a href="javascript:updatebook('+data.id+','+data.bosh+')">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:delbook('+data.id+','+data.bosh+')">删除</a></td>';
				}
			});
			str += '<tr><td colspan="9"><div id="kkpager"></div></td></tr>';
			$("#tabhtml").html(str);
			fenye(pageNo, pageCount, count, former, latter, ntitle);
		}catch(e){
			alert(e);
		}
	}, 'json');
}
//增加书
function addbook(){
	var dialog = art.dialog({id:'N3960', title:'正在加载', lock:true, resize:false, drag:false, esc:true });
	$.post('/kindergarten/pages/addbook.jsp', {},function(json, textStatus){
		dialog.title('添加教材');
		dialog.content(json);
	});
}
//修改书
function updatebook(id, bosh){
	if(bosh == 2){
		alert("通过审核的书不能修改");
	}else{
		window.location.href = '/kindergarten/book/getBookById/' + id + '-updatebook';		
	}
}
//单个删除书
function delbook(id, bosh){
	if(bosh == 2){
		alert("通过审核的书不能删除");
	}else{
		if(confirm("确定删除吗？")){
			window.location.href = '/kindergarten/book/delBook/' + id;
		}
	}
}
//审核
function checkbook(id){
	var dialog = art.dialog({id:'N3960', title:'正在加载', lock:true, resize:false, drag:false, esc:true });
	dialog.title("审核");
	dialog.content("<input type='button' value='通过' onclick='javascript:check("+id+", 2)'>&nbsp;&nbsp;&nbsp;&nbsp;<input type='button' value='退回' onclick='javascript:check("+id+", 0)'>");
}
//审核
function check(id, bosh){
	window.location = '/kindergarten/book/checkBook/' + id + '-' + bosh;
}
//选购
function selectBook(bookid, sid){
	var loginname = $("#stid").val();
	var acbj = $("#acbj").val();
	var acnj = $("#acnj").val();
	if(sid == null){
		sid = '';
	}
	window.location = '/kindergarten/bost/saveBook/'+bookid+'-'+loginname+'-'+acbj+'-'+acnj+'-'+sid;
}
