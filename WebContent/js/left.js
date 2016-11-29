//$(document).ready(function(){
//	getMenus();
//});

function getMenus(){
	var str = '';
	$.post('/kindergarten/menus/getMenusList?ttid=' + Math.random(), {}, function(datas, textStatus){
		if(datas == null || datas == "")
			return;
		try {
			var first = datas.first;
			var seconds = datas.second;
			$.each(first, function(index, firstdata){
				str += '<h1 class="type"><a href="javascript:void(0)">' + firstdata.name + '</a></h1>';
				str += '<div class="content">';
				str += '<table width="100%" border="0" cellspacing="0" cellpadding="0">';
				str += '<tr>';
				str += ' <td><img src="images/menu_topline.gif" width="182" height="5" /></td>';
				str += '</tr>';
				str += '</table>';
				str += '<ul class="MM">';
				$.each(seconds, function(sec, seconddata){
					if(index == sec){
						$.each(seconddata, function(secon, data){
							str += '<li><a href="javascript:void(0)" target="main">' + data.name + '</a></li>';							
						});
					}
				});
				str += '</ul></div>';
			    
			});
			$("#container").html(str);
		} catch (e) {
			alert(e);
		}
	}, 'json');
}