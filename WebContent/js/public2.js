//验证标题不能为空
function checktitle(){
	var ntitle = $("#ntitle").val();
	if($.trim(ntitle)==null || $.trim(ntitle)==""){
		alert("标题不能为空");
		return false;
	}
}
function checkStuSick(){
	var classes = $("#classes").val();
	if($.trim(classes)==null || $.trim(classes)==""){
		alert("班级不能为空");
		return false;
	}
	if(!number(classes)){
		alert("班级的格式为数字。如：101");
		return false;
	}
}
//不能为空
function checknull(){
	var title = $("#checktitle").val();
	var nj = $("#checknj").val();
	var xy = $("#checkxy").val();
	var zy = $("#checkzy").val();
	
	if($.trim(title)==null || $.trim(title)==""){
		alert("标题不能为空");
		return false;
	}
	if($.trim(xy)==null || $.trim(xy)==""){
		alert("学院不能为空");
		return false;
	}
	if($.trim(zy)==null || $.trim(zy)==""){
		alert("专业不能为空");
		return false;
	}
	if(!number(nj)){
		alert("年级的格式为数字。如：2011");
		return false;
	}
}
/**
 * TODO 验证教师课表
 * @returns {Boolean}
 */
function checktenull(){
	var title = $("#checktitle").val();
	var xy = $("#checkxy").val();
	var gh = $("#checkgh").val();
	var xm = $("#checkxm").val();	
	
	
	if($.trim(title)==null || $.trim(title)==""){
		alert("标题不能为空");
		return false;
	}
	if($.trim(xy)==null || $.trim(xy)==""){
		alert("学院不能为空");
		return false;
	}
	if($.trim(xm)==null || $.trim(xm)==""){
		alert("姓名不能为空");
		return false;
	}
	if(!number(gh)){
		alert("证正确填写工号");
		return false;
	}
}
//验证数字
function checknj(){
	var nj = $("#synj").val();
	if(!number(nj)){
		alert("年级的格式为数字。如：2011");
		return false;
	}
	alert(nj);
}
//检查课程
function chekecheng(){
	var kch = $("#kch").val();
	var kcm = $("#kcm").val();
	var kcsj = $("#kcsj").val();
	var rkls = $("#rkls").val();
	var kcnj = $("#kcnj").val();
	var kczy = $("#kczy").val();
	var kcxf = $("#kcxf").val();
	var kclb = $("#kclb").val();
	var khfs = $("#khfs").val();
	
	if(!number(kch)){
		alert("课程号为不是0开头的数字");
		return false;
	}
	if($.trim(kcm)==null || $.trim(kcm)==""){
		alert("课程名不能为空");
		return false;
	}
	if($.trim(kcsj)==null || $.trim(kcsj)==""){
		alert("课程书籍不能为空");
		return false;
	}
	if($.trim(rkls)==null || $.trim(rkls)==""){
		alert("任课老师不能为空");
		return false;
	}
	if(!number(kcnj)){
		alert("年级的格式为数字。如：2011");
		return false;
	}
	if($.trim(kczy)==null || $.trim(kczy)==""){
		alert("专业不能为空");
		return false;
	}
	if(!number(kcxf)){
		alert("学分为不是0开头的数字");
		return false;
	}
	if($.trim(kclb)==null || $.trim(kclb)==""){
		alert("类别不能为空");
		return false;
	}
	if($.trim(khfs)==null || $.trim(khfs)==""){
		alert("考核方式不能为空");
		return false;
	}
}
//验证学生
function checkstudent(){
	var loginname = $("#loginname").val();
	var loginpass = $("#loginpass").val();
	var acname = $("#acname").val();
	var acsex = $("#acsex").val();
	var acnj = $("#acnj").val();
	var acbj = $("#acbj").val();
	var acxh = $("#acxh").val();
	var acxy = $("#acxy").val();
	var aczy = $("#aczy").val();
	
	if(!lowerCase(loginname)){
		alert("用户名不小于四位的小写字母或数字组合");
		return false;
	}
	if(!lowerCase(loginpass)){
		alert("密码不小于4位的为小写字母或数字组合");
		return false;
	}
	if($.trim(acname)==null || $.trim(acname)==""){
		alert("姓名不能为空");
		return false;
	}
	if($.trim(acsex)==null || $.trim(acsex)==""){
		alert("性别不能为空");
		return false;
	}
	if(!number(acnj)){
		alert("年级班级的格式为数字。如：201101");
		return false;
	}
	if(!number(acxh)){
		alert("学号为不是0开头的数字");
		return false;
	}
	if($.trim(acbj)==null || $.trim(acbj)==""){
		alert("母亲联系方式不能为空");
		return false;
	}
	if($.trim(acxy)==null || $.trim(acxy)==""){
		alert("父亲联系方式不能为空");
		return false;
	}
	/*if($.trim(aczy)==null || $.trim(aczy)==""){
		alert("父亲联系方式不能为空");
		return false;
	}*/
}
//验证老师
function checkteacher(){
	var lsloginname = $("#lsloginname").val();
	var lsloginpass = $("#lsloginpass").val();
	var lsname = $("#lsname").val();
	var lssex = $("#lssex").val();
	var lsgh = $("#lsgh").val();
	var lsxy = $("#lsxy").val();
	
	if(!lowerCase(lsloginname)){
		alert("用户名为小写字母或数字的组合");
		return false;
	}
	if(!lowerCase(lsloginpass)){
		alert("密码为小写字母或数字的组合");
		return false;
	}
	if($.trim(lsname)==null || $.trim(lsname)==""){
		alert("姓名不能为空");
		return false;
	}
	if($.trim(lssex)==null || $.trim(lssex)==""){
		alert("性别不能为空");
		return false;
	}
	if(!number(lsgh)){
		alert("工号为不是0开头的数字");
		return false;
	}
	if($.trim(lsxy)==null || $.trim(lsxy)==""){
		alert("学院不能为空");
		return false;
	}
}
