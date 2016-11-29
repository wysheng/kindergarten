package com.jiaocai.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.jfinal.core.Controller;
import com.jfinal.log.Logger;
import com.jfinal.plugin.activerecord.Page;
import com.jiaocai.model.Notice;
import com.jiaocai.model.KitchenDisinfect;

/**TODO
 * 
 */
public class KitchenDisinfectController extends Controller {
	
	Logger log = Logger.getLogger(getClass());
	/**TODO 查询
	 * 
	 */
	public void getkitchenDisinfectList(){
		Map<String, Object> map = new HashMap<String, Object>();
		
		int pageNo = getParaToInt("pageNo");
		int pageSize = getParaToInt("pageSize");
		String ntitle = getPara("ntitle");
		Page<KitchenDisinfect> kitchenDisinfectList = KitchenDisinfect.dao.getkitchenDisinfectList(pageNo, pageSize, ntitle);
		int count = kitchenDisinfectList.getTotalRow();
		int pageCount = kitchenDisinfectList.getTotalPage();
		
		map.put("count", count);
		map.put("pageCount", pageCount);
		map.put("kitchenDisinfectList", kitchenDisinfectList.getList());
		
		renderJson(map);
		
	}
	/**
	 * TODO 修改kitchenDisinfect或添加kitchenDisinfect
	 * @author xkq
	 */ 
	public void addOrUpdateKitchenDisinfect(){
		KitchenDisinfect kitchenDisinfect = this.getModel(KitchenDisinfect.class);
		String id = getPara("id");
		if(id != null && !id.equals("")){//如果id不为空，则根据id修改书
			long kitchDisId = Long.valueOf(id);
			KitchenDisinfect kitchDis = kitchenDisinfect.dao.findById(kitchDisId);
			kitchDis.set("kitchenNo", kitchenDisinfect.get("kitchenNo"))
			.set("executor", kitchenDisinfect.get("executor"))
			.set("supervision", kitchenDisinfect.get("supervision"))
			.set("tools", kitchenDisinfect.get("tools"))
			.set("remark", kitchenDisinfect.get("remark"))
			.set("recordTime", new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss").format(new Date()))//默认保存添加书的年份
			.update();
		}else{//如果id为空，则新增一本书
			KitchenDisinfect skitchenDisinfect = new KitchenDisinfect();
			skitchenDisinfect.set("kitchenNo", kitchenDisinfect.get("kitchenNo"))
			.set("executor", kitchenDisinfect.get("executor"))
			.set("supervision", kitchenDisinfect.get("supervision"))
			.set("tools", kitchenDisinfect.get("tools"))
			.set("remark", kitchenDisinfect.get("remark"))
			.set("recordTime", new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss").format(new Date()))//默认保存添加书的年份
			.save();
		}
		render("/pages/dailyAffairs/kitchenDisinfect.jsp");
	}
	
	
	/**TODO 删除kitchenDisinfect
	 */
	public void delkitchenDisinfect(){
		long kitchenDisinfectId = getParaToLong(0);
		KitchenDisinfect.dao.deleteById(kitchenDisinfectId);
		render("/pages/dailyAffairs/kitchenDisinfect.jsp");
	}
	/**TODO 根据公告id查询kitchenDisinfect
	 */
	public void getkitchenDisinfectById(){
		long kitchenDisinfectId = getParaToLong(0);
		String view = getPara(1);
		KitchenDisinfect kitchenDisinfect = KitchenDisinfect.dao.findById(kitchenDisinfectId);
		setAttr("kitchenDisinfect", kitchenDisinfect);
		render("/pages/dailyAffairs/"+view+".jsp");
	}
	
}
