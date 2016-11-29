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
import com.jiaocai.model.StuMorningCheck;
import com.jiaocai.model.StuSickCheck;

/**TODO
 * @author admin
 */
public class StuMorningCheckController extends Controller {
	
Logger log = Logger.getLogger(getClass());
	
	/**TODO 默认搜索学生晨检记录
	 */
	public void getStuMorningCheckList(){
		
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
		
		Page<StuMorningCheck> stuMChkList = StuMorningCheck.dao.getStuMorningCheckList(pageNo, pageSize, ntitle);
		int count = stuMChkList.getTotalRow();
		int pageCount = stuMChkList.getTotalPage();
		
		map.put("stuMChkList", stuMChkList.getList());
		map.put("count", count);
		map.put("pageCount", pageCount);
		
		renderJson(map);
		
	}
	
	/**TODO 增加或修改学生生病
	 */
	public void addOrUpdateStuMorningCheck(){
		StuMorningCheck stuMorningCheck = getModel(StuMorningCheck.class);
		String stuMorningCheckId = getPara("id");
		if(stuMorningCheckId != null && !"".equals(stuMorningCheckId)){
			long id = Long.valueOf(stuMorningCheckId);
			StuMorningCheck upStuMorningCheck = StuMorningCheck.dao.findById(id);
			upStuMorningCheck.set("classes", stuMorningCheck.get("classes"))
					.set("stuName", stuMorningCheck.get("stuName"))
					.set("isMorningCheck", stuMorningCheck.get("isMorningCheck"))
					.set("reason", stuMorningCheck.get("reason"))
					.set("morningCheckTime", new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()))
					.update();
		}else{
			StuMorningCheck saveStuMorningCheck = new StuMorningCheck();
			saveStuMorningCheck.set("classes", stuMorningCheck.get("classes"))
						.set("stuName", stuMorningCheck.get("stuName"))
						.set("isMorningCheck", stuMorningCheck.get("isMorningCheck"))
						.set("reason", stuMorningCheck.get("reason"))
						.set("morningCheckTime", new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()))
						.save();
		}
		render("/pages/morningCheck/stuMorningCheck.jsp");
	}
	/**TODO 默认搜索学生生病记录   按班级查询
	 */
	public void getStuMorningCheckDetailList(){
		
		Map<String, Object> map = new HashMap<String, Object>();
		int pageNo = getParaToInt("pageNo");
		int pageSize = getParaToInt("pageSize");
		String classes = getPara("classes");

		if(!classes.equals("") && classes != null){
			try {
				classes = URLDecoder.decode(classes, "utf-8");
				log.info("ntitle:"+classes);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		Page<StuMorningCheck> stuMChkDetailList = StuMorningCheck.dao.getStuMorningCheckDetailList(pageNo, pageSize, classes);
		int count = stuMChkDetailList.getTotalRow();
		int pageCount = stuMChkDetailList.getTotalPage();
		
		map.put("stuMChkDetailList", stuMChkDetailList.getList());
		map.put("count", count);
		map.put("pageCount", pageCount);
		
		renderJson(map);
		
	}
	/**TODO 删除生病
	 */
	public void delStuMorningcheck(){
		long stuMorningcheckid = getParaToLong(0);
		StuMorningCheck.dao.deleteById(stuMorningcheckid);
		render("/pages/morningCheck/stuMorningCheckByClasses.jsp?classes=222");
	}
	/**TODO 根据生病记录id查询生病记录
	 */
	public void getStuMorningChkById(){
		long stuMchkid = getParaToLong(0);
		String view = getPara(1);
		StuMorningCheck stuMorningCheck = StuMorningCheck.dao.findById(stuMchkid);
		setAttr("stuMorningCheck", stuMorningCheck);
		render("/pages/morningCheck/"+view+".jsp");
	}
}
