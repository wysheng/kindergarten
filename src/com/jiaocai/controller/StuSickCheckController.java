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
import com.jiaocai.model.StuSickCheck;

/**TODO
 * @author admin
 */
public class StuSickCheckController extends Controller {
	
	Logger log = Logger.getLogger(getClass());
	
	/**TODO 默认搜索学生晨检记录
	 */
	public void getStuSickCheckList(){
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		int pageNo = getParaToInt("pageNo");
		int pageSize = getParaToInt("pageSize");
		String ntitle = getPara("title");
		int isTakePills = getParaToInt("isTakePills");

		if(!ntitle.equals("") && ntitle != null){
			try {
				ntitle = URLDecoder.decode(ntitle, "utf-8");
				log.info("ntitle:"+ntitle);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		Page<StuSickCheck> stuMChkList = StuSickCheck.dao.getStuSickCheckList(pageNo, pageSize, ntitle,isTakePills);
		int count = stuMChkList.getTotalRow();
		int pageCount = stuMChkList.getTotalPage();
		
		map.put("stuMChkList", stuMChkList.getList());
		map.put("count", count);
		map.put("pageCount", pageCount);
		
		renderJson(map);
		
	}
	
	/**TODO 增加或修改学生生病
	 */
	public void addOrUpdateStuSickCheck(){
		StuSickCheck StuCheck = getModel(StuSickCheck.class);
		String StuCheckId = getPara("id");
		if(StuCheckId != null && !"".equals(StuCheckId)){
			long id = Long.valueOf(StuCheckId);
			StuSickCheck upnotice = StuSickCheck.dao.findById(id);
			upnotice.set("classes", StuCheck.get("classes"))
					.set("sickLevel", StuCheck.get("sickLevel"))
					.set("stuname", StuCheck.get("stuname"))
					.set("sickcontent", StuCheck.get("sickcontent"))
					.set("isMorningCheck", StuCheck.get("isMorningCheck"))
					.set("isTakePills", StuCheck.get("isTakePills"))
					.set("stuMChkTime", new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()))
					.update();
		}else{
			StuSickCheck saveStuSickCheck = new StuSickCheck();
			saveStuSickCheck.set("classes", StuCheck.get("classes"))
					.set("sickLevel", StuCheck.get("sickLevel"))
					.set("stuname", StuCheck.get("stuname"))
					.set("sickcontent", StuCheck.get("sickcontent"))
					.set("isMorningCheck", StuCheck.get("isMorningCheck"))
					.set("isTakePills", StuCheck.get("isTakePills"))
					.set("stuMChkTime", new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()))
					.save();
		}
		render("/pages/stusick/stuNeedTakePills.jsp");
	}
	/**TODO 默认搜索学生生病记录   按班级查询
	 */
	public void getStuMChkDetailList(){
		
		Map<String, Object> map = new HashMap<String, Object>();
		int pageNo = getParaToInt("pageNo");
		int pageSize = getParaToInt("pageSize");
		String classes = getPara("classes");
		int isTakePills = getParaToInt("isTakePills");
		if(!classes.equals("") && classes != null){
			try {
				classes = URLDecoder.decode(classes, "utf-8");
				log.info("ntitle:"+classes);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		Page<StuSickCheck> stuMChkDetailList = StuSickCheck.dao.getStuMChkDetailList(pageNo, pageSize, classes,isTakePills);
		int count = stuMChkDetailList.getTotalRow();
		int pageCount = stuMChkDetailList.getTotalPage();
		
		map.put("stuMChkDetailList", stuMChkDetailList.getList());
		map.put("count", count);
		map.put("pageCount", pageCount);
		
		renderJson(map);
		
	}
	/**TODO 删除生病
	 */
	public void delStuMchk(){
		long stuMchkid = getParaToLong(0);
		StuSickCheck.dao.deleteById(stuMchkid);
		render("/pages/stusick/stuSickCheck.jsp");
	}
	/**TODO 给学生喂药
	 */
	public void stuTakePills(){
		long stuMchkid = getParaToLong(0);
		StuSickCheck stusick = StuSickCheck.dao.findById(stuMchkid);
		stusick.set("isTakePills", 1)
		.update();
		render("/pages/stusick/stuNeedTakePills.jsp");
	}
	
	/**TODO 根据生病记录id查询生病记录
	 */
	public void getStuMchkById(){
		long stuMchkid = getParaToLong(0);
		String view = getPara(1);
		StuSickCheck stuSickCheck = StuSickCheck.dao.findById(stuMchkid);
		setAttr("stuMchk", stuSickCheck);
		render("/pages/stusick/"+view+".jsp");
	}
}
