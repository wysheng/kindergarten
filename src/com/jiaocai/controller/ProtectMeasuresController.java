package com.jiaocai.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.jfinal.core.Controller;
import com.jfinal.log.Logger;
import com.jfinal.plugin.activerecord.Page;
import com.jiaocai.model.ProtectMeasures;

/**TODO
 * 
 */
public class ProtectMeasuresController extends Controller {
	
	Logger log = Logger.getLogger(getClass());
	/**TODO 查询
	 * 
	 */
	public void getProtectMeasuresList(){
		Map<String, Object> map = new HashMap<String, Object>();
		
		int pageNo = getParaToInt("pageNo");
		int pageSize = getParaToInt("pageSize");
		String ntitle = getPara("ntitle");
		Page<ProtectMeasures> protectMeasuresPage = ProtectMeasures.dao.getProtectMeasuresList(pageNo, pageSize, ntitle);
		int count = protectMeasuresPage.getTotalRow();
		int pageCount = protectMeasuresPage.getTotalPage();
		
		map.put("count", count);
		map.put("pageCount", pageCount);
		map.put("protectMeasuresList", protectMeasuresPage.getList());
		
		renderJson(map);
		
	}
	/**
	 * TODO 修改protectMeasures或添加protectMeasures
	 * @author xkq
	 */ 
	public void addOrUpdateProtectMeasures(){
		ProtectMeasures rotectMeasuress = this.getModel(ProtectMeasures.class);
		String id = getPara("id");
		if(id != null && !id.equals("")){//如果id不为空，则根据id修改书
			long rotectMeasuresId = Long.valueOf(id);
			ProtectMeasures uprotectMeasures = ProtectMeasures.dao.findById(rotectMeasuresId);
			uprotectMeasures.set("title", rotectMeasuress.get("title"))
			.set("executor", rotectMeasuress.get("executor"))
			.set("supervision", rotectMeasuress.get("supervision"))
			.set("content", rotectMeasuress.get("content"))
			.set("recordTime", new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss").format(new Date()))
			.update();
		}else{//如果id为空，则新增一本书
			ProtectMeasures sProtectMeasures = new ProtectMeasures();
			sProtectMeasures.set("title", rotectMeasuress.get("title"))
			.set("executor", rotectMeasuress.get("executor"))
			.set("supervision", rotectMeasuress.get("supervision"))
			.set("content", rotectMeasuress.get("content"))
			.set("recordTime", new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss").format(new Date()))
			.save();
		}
		render("/pages/dailyAffairs/protectMeasures.jsp");
	}
	
	
	/**TODO 删除protectMeasures
	 */
	public void delProtectMeasures(){
		long protectMeasuresid = getParaToLong(0);
		ProtectMeasures.dao.deleteById(protectMeasuresid);
		render("/pages/dailyAffairs/protectMeasures.jsp");
	}
	/**TODO 根据公告id查询protectMeasures
	 */
	public void getProtectMeasuresById(){
		long protectMeasuresid = getParaToLong(0);
		String view = getPara(1);
		ProtectMeasures pm = ProtectMeasures.dao.findById(protectMeasuresid);
		setAttr("protectMeasures", pm);
		render("/pages/dailyAffairs/"+view+".jsp");
	}
	
}
