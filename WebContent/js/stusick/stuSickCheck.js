$(document).ready(function(){
	var pageNo = getParam("pno");																
	var ntitle = getParam("ntitle");
	var isTakePills = $("#isTakePills").val();
	if(!pageNo){
		pageNo = 1;
	}
	var pageSize = 10;
	getStuSickCheckList(pageNo, pageSize, ntitle,isTakePills);
	
	$("#search").click(function(){
		var ntitle = $("#ntitle").val();
		if($.trim(ntitle)==null || $.trim(ntitle)=="输入名称关键字查询"){
			ntitle="";
		}
		window.location.href="/kindergarten/pages/stusick/stuSickCheck.jsp?pno=1&ntitle="+encodeURIComponent(encodeURIComponent(ntitle));
	});
	
	$("#addStuSickCheck").click(function(){
		addStuSickCheck();
	});
});
//默认公告显示
function getStuSickCheckList(pageNo, pageSize, title,isTakePills){
	var acqx = $("#acqx").val();
	var former = '/kindergarten/pages/stusick';
	var latter = '.jsp';
	var str = '';
	$.post('/kindergarten/stuSickCheck/getStuSickCheckList?ttid=' + Math.random(), {pageNo:pageNo, pageSize:pageSize, title:title,isTakePills:isTakePills}, function(json, textStatus){
		if(json == null)
			return;
		try {
			var stuMChkList = json.stuMChkList;
			var count = json.count;
			var pageCount = json.pageCount;
			$.each(stuMChkList, function(index, data){
				
				var c = index + 1;
				str += '<tr><td width="5%" align="center" class=sec1><input type="checkbox"></td>';
				str += '<td width="10%" align="center" class=sec1>'+c+'</td>';
				str += '<td width="20%" align="left" class=sec1>'+data.classes+'</a></td>';
				str += '<td width="10%" align="left" class=sec1>'+data.count+'</td>';
				str += '<td width="25%" align="center" class=sec1>'+data.level+'</td>'; 
				str += '<td width="15%" align="center" class=sec1>'+data.time+'</td>';
				if(acqx != 1){
					str += '<td width="20%" align="center" class=sec1><a href="javascript:getStuMChkDetailList('+data.classes+')">详情</a></td>';
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

function addStuSickCheck(){
	var dialog = art.dialog({id:'N3960', title:'正在加载', lock:true, resize:false, drag:false, esc:true });
	$.post('/kindergarten/pages/stusick/addStuSickCheck.jsp', {},function(json, textStatus){
		dialog.title('添加学生生病');
		dialog.content(json);
	});
}
function getStuMChkDetailList(classes){
	window.location.href = '/kindergarten/pages/stusick/stuSickCheckByClasses.jsp?classes='+classes;
	
}
