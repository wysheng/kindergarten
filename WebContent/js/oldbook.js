$(document).ready(function(){
	var pageNo = getParam("pno");
	var ntitle = getParam("ntitle");
	
	if(!pageNo)
		pageNo = 1;
	
	var pageSize = 10;
	
	$("#search").click(function(){
		var ntitle = $("#ntitle").val();
		ntitle = $.trim(ntitle);
		if(ntitle == null || ntitle == "" || ntitle == "输入名称关键字查询")
			ntitle = '';
		window.location.href = '/kindergarten/pages/oldbook.jsp?pno=1&ntitle=' + encodeURIComponent(encodeURIComponent(ntitle));
	});
	getBookList(pageNo, pageSize, ntitle);
	
	$("#addbook").click(function(){
		addbook();
	});
});

function getBookList(pageNo, pageSize, ntitle){
	var str = '';
	var former = '/kindergarten/pages/oldbook';
	var latter = '.jsp';
	var acid = $("#acid").val();
	$.post('/kindergarten/book/getOldBookList?ttid=' + Math.random(), {pageNo:pageNo, pageSize:pageSize, ntitle:ntitle, acid:acid}, function(json, textStatus){
		if(json == '')
			return;
		try{
			var count = json.count;
			var pageCount = json.pageCount;
			var bookPage = json.bookPage;
			$.each(bookPage, function(index, data){
				var c = index + 1;
				str += '<tr><td width="5%" align="center" class=sec1><input type="checkbox"></td>';
				str += '<td width="10%" align="center" class=sec1>' + c + '</td>';
				str += '<td width="10%" align="center" class=sec1>' + data.name + '</td>';
				str += '<td width="10%" align="center" class=sec1>' + data.author + '</td>';
				str += '<td width="10%" align="center" class=sec1>' + data.bocbs + '</td>';
				str += '<td width="10%" align="center" class=sec1>' + data.bonj + '</td>';
				str += '<td width="10%" align="center" class=sec1>' + data.bonf + '</td>';
				str += '<td width="10%" align="center" class=sec1>' + data.bodj + '</td>';
				str += '<td width="10%" align="center" class=sec1>' + data.bozkj + '</td>';
				str += '<td width="10%" align="center" class=sec1>' + data.bobjzkj + '</td>';
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
