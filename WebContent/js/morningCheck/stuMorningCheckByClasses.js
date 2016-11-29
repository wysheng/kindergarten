$(document).ready(function(){ 
	var pageNo = getParam("pno");	
	var classes = getParam("classes");	
	var ntitle = getParam("ntitle");
	if(!pageNo){
		pageNo = 1;
	}
	var pageSize = 10;
	getStuMorningCheckDetailList(pageNo, pageSize, classes);
	
	$("#search").click(function(){
		var ntitle = $("#ntitle").val();
		if($.trim(ntitle)==null || $.trim(ntitle)=="输入名称关键字查询"){
			ntitle="";
		}
		window.location.href="/kindergarten/pages/stusick/stuSickCheck.jsp?pno=1&ntitle="+encodeURIComponent(encodeURIComponent(ntitle));
	});
	
});
//默认公告显示
function getStuMorningCheckDetailList(pageNo, pageSize, classes){
	var acqx = $("#acqx").val();
	var former = '/kindergarten/pages/stusick';
	var latter = '.jsp';
	var str = '';
	$.post('/kindergarten/stuMorningCheck/getStuMorningCheckDetailList?ttid=' + Math.random(), {pageNo:pageNo, pageSize:pageSize, classes:classes}, function(json, textStatus){
		if(json == null)
			return;
		try {
			var stuMChkDetailList = json.stuMChkDetailList;
			var count = json.count;
			var pageCount = json.pageCount;
			$.each(stuMChkDetailList, function(index, data){
				var source;
				var c = index + 1;
				if(data.isMorningCheck == 0){
					source = "未参加晨检";
					
				}else if(data.isMorningCheck == 1){
					source = "已参加晨检";
				}else{
					source = "其他";
				}
				str += '<tr><td width="5%" align="center" class=sec1><input type="checkbox"></td>';
				str += '<td width="5%" align="center" class=sec1>'+c+'</td>';
				str += '<td width="10%" align="left" class=sec1>'+data.classes+'</a></td>';
				str += '<td width="10%" align="left" class=sec1>'+data.stuName+'</td>';
				str += '<td width="10%" align="center" class=sec1>'+source+'</td>';
				str += '<td width="25%" align="center" class=sec1>'+data.reason+'</td>';
				str += '<td width="15%" align="center" class=sec1>'+data.morningCheckTime+'</td>';
				if(acqx == 0){
					str += '<td width="20%" align="center" class=sec1><a href="javascript:updateStuMorningChk('+data.id+')">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:delStuMorningcheck('+data.id+')">删除</a></td>';
				}
				str += '</tr>';
			});
			str += '<tr><td colspan="5"><div id="kkpager"></div></td></tr>';
			$("#tabhtml").html(str);
			fenye(pageNo, pageCount, count, former, latter, classes);
		} catch (e) {
			alert(e);
		}
	}, 'json');
}
//单个删除生病记录
function delStuMorningcheck(id){
	if(confirm("确定删除吗？")){
		window.location.href = '/kindergarten/stuMorningCheck/delStuMorningcheck/' + id;
	}
}
//修改生病记录
function updateStuMorningChk(id){
	window.location.href = '/kindergarten/stuMorningCheck/getStuMorningChkById/' + id + '-updateStuMorningCheck';
}
