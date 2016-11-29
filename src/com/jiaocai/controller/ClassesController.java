package com.jiaocai.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jfinal.core.Controller;
import com.jfinal.log.Logger;
import com.jfinal.plugin.activerecord.Page;
import com.jiaocai.model.Classes;
import com.jiaocai.model.Notice;

/**TODO
 * @author admin
 */
public class ClassesController extends Controller {
	
	Logger log = Logger.getLogger(getClass());
	
	/**TODO 默认班级
	 */
	public void getClassesList(){
		
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
		Page<Classes> classesList = Classes.dao.getClassesList(pageNo, pageSize, ntitle);
		int count = classesList.getTotalRow();
		int pageCount = classesList.getTotalPage();
		
		map.put("classesList", classesList.getList());
		map.put("count", count);
		map.put("pageCount", pageCount);
		renderJson(map);
		
	}
	/**TODO 所有班级名称
	 */
	public List<Classes> getClassesNameList(){
		
		Page<Classes> classesList = Classes.dao.getClassesNameList();
		List<Classes> classesNamelist = classesList.getList();
		return classesNamelist;
		
	}
	
	/**TODO 增加或修改公告
	 */
	public void addOrUpdateClasses(){
		Classes classes = getModel(Classes.class);
		String classesid = getPara("id");
		if(classesid != null && !"".equals(classesid)){
			long id = Long.valueOf(classesid);
			Classes upclasses = Classes.dao.findById(id);
			upclasses.set("classesname", classes.get("classesname"))
					.set("stunum", classes.get("stunum"))
					.set("headmaster", classes.get("headmaster"))
					.set("remark",classes.get("remark"))
					.update();
		}else{
			Classes saveClasses = new Classes();
			saveClasses.set("classesname", classes.get("classesname"))
					.set("stunum", classes.get("stunum"))
					.set("headmaster", classes.get("headmaster"))
					.set("remark",classes.get("remark"))
					.save();
		}
		render("/pages/person/classes.jsp");
	}
	/**TODO 删除公告
	 */
	public void delNotice(){
		long noticeid = getParaToLong(0);
		Notice.dao.deleteById(noticeid);
		render("/pages/notice.jsp");
	}
	/**TODO 根据公告id查询；班级具体信息
	 */
	public void getCalssesById(){
		long classesid = getParaToLong(0);
		String view = getPara(1);
		Classes classes = Classes.dao.findById(classesid);
		setAttr("classes", classes);
		render("/pages/person/"+view+".jsp");
	}
}
