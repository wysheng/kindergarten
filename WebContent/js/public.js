//登陆名非空、小写、最少几个符、不能非法字符
//匹配小写字母和数字
function lowerCase(value) {
	var reg = /^[a-z0-9]{4,}$/g;
	return reg.test(value);
}
//匹配数字
function number(value) {
	var reg = /^[1-9][0-9]*$/g;
	return reg.test(value);
}
//分页
function fenye(pageNo, pageCount, count, former, latter, ntitle) {
	if (count > 0) {// 总页数大于1
		$("#kkpager").show();

		// 有些参数是可选的，比如lang，若不传有默认值
		kkpager.generPageHtml({
			// 当前页（默认为1）
			pno : pageNo,
			// 总页码
			total : pageCount,
			// 总数据条数
			totalRecords : count,
			// 链接前部
			hrefFormer : former,
			// 链接尾部
			hrefLatter : latter,

			getLink : function(n) {
				return this.hrefFormer + this.hrefLatter + "?pno=" + n
						+ "&ntitle=" + encodeURIComponent(ntitle);
			},
			lang : {
				firstPageText : '首页',
				lastPageText : '尾页',
				prePageText : '上一页',
				nextPageText : '下一页',
				totalPageBeforeText : '共',
				totalPageAfterText : '页',
				totalRecordsAfterText : '条数据',
				gopageBeforeText : '转到',
				gopageButtonOkText : '确定',
				gopageAfterText : '页',
				buttonTipBeforeText : '第',
				buttonTipAfterText : '页'
			}
		});
	} else {
		$("#kkpager").hide();
	}
}

// 从url中取得参数
function getParam(paramName) {
	var paramValue = "";
	var isFound = false;
	if (this.location.search.indexOf("?") == 0
			&& this.location.search.indexOf("=") > 1) {
		var arrSource = unescape(this.location.search).substring(1,
				this.location.search.length).split("&");
		var i = 0;
		while (i < arrSource.length && !isFound) {
			if (arrSource[i].indexOf("=") > 0) {
				if (arrSource[i].split("=")[0].toLowerCase() == paramName
						.toLowerCase()) {
					paramValue = arrSource[i].split("=")[1];
					isFound = true;
				}
			}
			i++;
		}
	}
	return paramValue;
}
