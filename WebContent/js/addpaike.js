$(document).ready(function(){
	getWeekList();
});

function getWeekList(){
	var str = '';
	$.post('/kindergarten/paike/getWeekList?ttid='+Math.random(), {}, function(json, textStatus){
		if(json == null)
			return;
		try {
			var datas = json.list;
			$.each(datas, function(index, data){
				str += '<tr>';
				str += '<th width="225px"><input type="hidden" name="'+data.name+'_0" value="'+data.id+'">'+data.week+'</th>';
				str += '<td width="225px" align="center"><input name="'+data.name+'_1" type="text" value=""/></td>';
				str += '<td width="225px" align="center"><input name="'+data.name+'_2" type="text" value=""/></td>';
				str += '<td width="225px" align="center"><input name="'+data.name+'_3" type="text" value=""/></td>';
				str += '<td width="225px" align="center"><input name="'+data.name+'_4" type="text" value=""/></td>';
				str += '</tr>';
			});
			$("#tabweek").html(str);
		} catch (e) {
			alert(e);
		}
	}, 'json');
}
