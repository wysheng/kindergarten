$(document).ready(function(){
	var pageNo = getParam("pno");	
	var classes = getParam("classes");	
	var ntitle = getParam("ntitle");
	var isTakePills = $("#isTakePills").val();
	if(!pageNo){
		pageNo = 1;
	}
	var pageSize = 10;
	getStuMChkDetailList(pageNo, pageSize, classes, isTakePills);
	$("#search").click(function(){
		var ntitle = $("#ntitle").val();
		if($.trim(ntitle)==null || $.trim(ntitle)=="输入名称关键字查询"){
			ntitle="";
		}
		window.location.href="/kindergarten/pages/stusick/stuSickCheck.jsp?pno=1&ntitle="+encodeURIComponent(encodeURIComponent(ntitle));
	});
	
});
//默认公告显示
function getStuMChkDetailList(pageNo, pageSize, classes,isTakePills){
	var acqx = $("#acqx").val();
	var former = '/kindergarten/pages/stusick';
	var latter = '.jsp';
	var str = '';
	$.post('/kindergarten/stuSickCheck/getStuMChkDetailList?ttid=' + Math.random(), {pageNo:pageNo, pageSize:pageSize, classes:classes,isTakePills:isTakePills}, function(json, textStatus){
		if(json == null)
			return;
		try {
			var stuMChkDetailList = json.stuMChkDetailList;
			var count = json.count;
			var pageCount = json.pageCount;
			$.each(stuMChkDetailList, function(index, data){
				var source;
				var isTakePills;
				var c = index + 1;
				if(data.isMorningCheck == 0){
					source = "晨检";
					
				}else if(data.isMorningCheck == 1){
					source = "家长嘱托";
				}else{
					source = "其他";
				}
				if(data.isMorningCheck == 0){
					isTakePills = "没有喂药";
					
				}else if(data.isMorningCheck == 1){
					isTakePills = "已经喂药";
				}else{
					isTakePills = "需要询问";
				}
				str += '<tr><td width="5%" align="center" class=sec1><input type="checkbox"></td>';
				str += '<td width="5%" align="center" class=sec1>'+c+'</td>';
				str += '<td width="5%" align="left" class=sec1>'+data.classes+'</a></td>';
				str += '<td width="5%" align="left" class=sec1>'+data.sickLevel+'</a></td>';
				str += '<td width="10%" align="left" class=sec1>'+data.stuname+'</td>';
				str += '<td width="10%" align="center" class=sec1>'+source+'</td>';
				str += '<td width="10%" align="center" class=sec1>'+isTakePills+'</td>';
				str += '<td width="25%" align="center" class=sec1>'+data.sickcontent+'</td>';
				str += '<td width="15%" align="center" class=sec1>'+data.stuMChkTime+'</td>';
				if(acqx != 1){
					str += '<td width="20%" align="center" class=sec1><a href="javascript:stuTakePills('+data.id+')">喂药</a></td>';
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
function delStuMchk(id){
	if(confirm("确定删除吗？")){
		window.location.href = '/kindergarten/stuSickCheck/delStuMchk/' + id;
	}
}
//修改生病记录
function stuTakePills(id){
	if(confirm("确定已经喂药吗？")){
		window.location.href = '/kindergarten/stuSickCheck/stuTakePills/' + id;
	}
}
//查看公告内容
function viewNotice(id){
	window.location.href = '/kindergarten/notice/getNoticeById/' + id + '-lookupnotice';
}