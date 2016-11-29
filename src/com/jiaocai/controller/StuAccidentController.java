package com.jiaocai.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.jfinal.core.Controller;
import com.jfinal.log.Logger;
import com.jfinal.plugin.activerecord.Page;
import com.jiaocai.model.Notice;
import com.jiaocai.model.StuAccident;

/**TODO
 * @author admin
 */
public class StuAccidentController extends Controller {
	
	Logger log = Logger.getLogger(getClass());
	
	/**TODO 默认搜索学生事故
	 */
	public void getstuAccidentList(){
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		int pageNo = getParaToInt("pageNo");
		int pageSize = getParaToInt("pageSize");
		String ntitle = getPara("title");

		if(!ntitle.equals("") && ntitle != null){
			try {
				ntitle = URLDecoder.decode(ntitle, "utf-8");
				log.info("ntitle:"+ntitle);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		Page<StuAccident> stuAccidentList = StuAccident.dao.getstuAccidentList(pageNo, pageSize, ntitle);
		int count = stuAccidentList.getTotalRow();
		int pageCount = stuAccidentList.getTotalPage();
		
		map.put("stuAccidentList", stuAccidentList.getList());
		map.put("count", count);
		map.put("pageCount", pageCount);
		
		renderJson(map);
		
	}
	
	/**TODO 增加或修改学生事故
	 */
	public void addOrUpdateStuAccident(){
		StuAccident stuAccident = getModel(StuAccident.class);
		String stuAccidentId= getPara("id");
		if(stuAccidentId != null && !"".equals(stuAccidentId)){
			long id = Long.valueOf(stuAccidentId);
			StuAccident upstuAccident = StuAccident.dao.findById(id);
			upstuAccident.set("classes", stuAccident.get("classes"))
					.set("stuName", stuAccident.get("stuName"))
					.set("level", stuAccident.get("level"))
					.set("accidentDeatail", stuAccident.get("accidentDeatail"))
					.set("recordTime", new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()))
					.update();
		}else{
			StuAccident ONSavestuAccident = new StuAccident();
			ONSavestuAccident.set("classes", stuAccident.get("classes"))
					.set("stuName", stuAccident.get("stuName"))
					.set("level", stuAccident.get("level"))
					.set("accidentDeatail", stuAccident.get("accidentDeatail"))
					.set("recordTime", new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()))
					.save();
		}
		render("/pages/dailyAffairs/stuAccident.jsp");
	}
	/**TODO 删除学生事故
	 */
	public void delStuAccident(){
		long stuAccidentId = getParaToLong(0);
		StuAccident.dao.deleteById(stuAccidentId);
		render("/pages/dailyAffairs/stuAccident.jsp");
	}
	/**TODO 根据学生事故id查询学生事故
	 */
	public void getstuAccidentById(){
		long stuAccidentId = getParaToLong(0);
		String view = getPara(1);
		StuAccident stuAccident = StuAccident.dao.findById(stuAccidentId);
		setAttr("stuAccident", stuAccident);
		render("/pages/dailyAffairs/"+view+".jsp");
	}
}
