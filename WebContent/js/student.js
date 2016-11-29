$(document).ready(function(){
	var pageNo = getParam("pno");
	var ntitle = getParam("ntitle");
	var personAcqx = $("#personAcqx").val();
	if(!pageNo){
		pageNo = 1;
	}
	var pageSize = 10;
	getNotice(pageNo, pageSize, ntitle,personAcqx);
	
	$("#search").click(function(){
		var ntitle = $("#ntitle").val();
		if($.trim(ntitle)==null || $.trim(ntitle)=="输入名称关键字查询" ||$.trim(ntitle)==""){
			ntitle="";
		}
		window.location.href="/kindergarten/pages/person/student.jsp?pno=1&ntitle="+encodeURIComponent(encodeURIComponent(ntitle));
	});
	
	$("#addstudent").click(function(){
		addstudent();
	});
});
//默认人员显示
function getNotice(pageNo, pageSize, ntitle,personAcqx){
	var acqx = $("#acqx").val();
	var former = '/kindergarten/pages/person/student';
	var latter = '.jsp';
	var str = '';
	$.post('/kindergarten/account/getStudentList?ttid=' + Math.random(), {pageNo:pageNo, pageSize:pageSize, title:ntitle,personAcqx:personAcqx}, function(json, textStatus){
		if(json == null)
			return;
		try {
			var studentList = json.studentList;
			var count = json.count;
			var pageCount = json.pageCount;
			$.each(studentList, function(index, data){
				var s = '';
				var c = index + 1;
				var sex ="";
				if(data.acsex == 1){
					sex = "男";
				}else if(data.acsex == 2){
					sex= "女";
				}else{
					sex = "保密";
				}
				str += '<tr><td width="5%" align="center" class=sec1><input type="checkbox"></td>';
				str += '<td width="5%" align="center" class=sec1>'+c+'</td>';
				str += '<td width="10%" align="center" class=sec1>'+data.acname+'</td>';
				str += '<td width="9%" align="center" class=sec1>'+sex+'</td>';
				str += '<td width="10%" align="center" class=sec1>'+data.acxh+'</td>';
				if(data.acqx == 1){
					s = '学生';
				}else{
					s = '老师';
				}
				str += '<td width="9%" align="center" class=sec1>'+s+'</td>';
				if(personAcqx != 2){
					str += '<td width="10%" align="center" class=sec1>'+data.acnj+'</td>';
					str += '<td width="10%" align="center" class=sec1>'+data.acbj+'</td>';
				}
				str += '<td width="10%" align="center" class=sec1>'+data.aczy+'</td>';
				str += '<td width="10%" align="center" class=sec1>'+data.acxy+'</td>';
				if(acqx == 0){
				str += '<td width="10%" align="center" class=sec1><a href="javascript:updatestudent('+data.id+')">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:delstudent('+data.id+')">删除</a></td>';
				}
				str += '</tr>';
			});
			str += '<tr><td colspan="10"><div id="kkpager"></div></td></tr>';
			$("#tabhtml").html(str);
			fenye(pageNo, pageCount, count, former, latter, ntitle);
		} catch (e) {
			alert(e);
		}
	}, 'json');
}
//添加人员页面
function addstudent(){
	var dialog = art.dialog({id:'N3960', title:'正在加载', lock:true, resize:false, drag:false, esc:true });
	$.post('/kindergarten/pages/person/addstudent.jsp', {},function(json, textStatus){
		dialog.title('添加人员');
		dialog.content(json);
	});
}
//单个删除人员
function delstudent(id){
	if(confirm("确定删除吗？")){
		window.location.href = '/kindergarten/account/deleStudent/' + id;
	}
}
//修改人员信息
function updatestudent(id){
	window.location.href = '/kindergarten/account/getStudentById/' + id + '-updatestudent';
}
//增加老师还是学生
function selectst(){
	var t = $("#selst").val();
	if(t == 1){
		$("#student").show();
		$("#teacher").hide();
	}else{
		$("#student").hide();
		$("#teacher").show();
	}
}