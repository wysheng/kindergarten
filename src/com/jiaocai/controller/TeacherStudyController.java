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
import com.jiaocai.model.TeacherStudy;

/**TODO
 * @author admin
 */
public class TeacherStudyController extends Controller {
	
	Logger log = Logger.getLogger(getClass());
	
	/**TODO 默认搜索教师外出学习
	 */
	public void getTeacherStudyList(){
		
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
		Page<TeacherStudy> teacherStudyList = TeacherStudy.dao.getTeacherStudyList(pageNo, pageSize, ntitle);
		int count = teacherStudyList.getTotalRow();
		int pageCount = teacherStudyList.getTotalPage();
		
		map.put("teacherStudyList", teacherStudyList.getList());
		map.put("count", count);
		map.put("pageCount", pageCount);
		
		renderJson(map);
		
	}
	
	/**TODO 增加或修改教师外出学习
	 */
	public void addOrUpdateTeacherStudy(){
		TeacherStudy teacherStudy = getModel(TeacherStudy.class);
		String teacherStudyid = getPara("id");
		if(teacherStudyid != null && !"".equals(teacherStudyid)){
			long id = Long.valueOf(teacherStudyid);
			TeacherStudy upTeacherStudy = TeacherStudy.dao.findById(id);
			upTeacherStudy.set("teacherName", teacherStudy.get("teacherName"))
					.set("course", teacherStudy.get("course"))
					.set("studyContent", teacherStudy.get("studyContent"))
					.set("studyDetail", teacherStudy.get("studyDetail"))
					.set("recordTime", new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()))
					.update();
		}else{
			TeacherStudy sTeacherStudy = new TeacherStudy();
			sTeacherStudy.set("teacherName", teacherStudy.get("teacherName"))
			.set("course", teacherStudy.get("course"))
			.set("studyContent", teacherStudy.get("studyContent"))
			.set("studyDetail", teacherStudy.get("studyDetail"))
			.set("recordTime", new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()))
					.save();
		}
		render("/pages/dailyAffairs/teacherStudy.jsp");
	}
	/**TODO 删除教师外出学习
	 */
	public void delTeacherStudy(){
		long teacherStudyid = getParaToLong(0);
		TeacherStudy.dao.deleteById(teacherStudyid);
		render("/pages/dailyAffairs/teacherStudy.jsp");
	}
	/**TODO 根据教师外出学习id查询教师外出学习
	 */
	public void getTeacherStudyById(){
		long teacherStudyid = getParaToLong(0);
		String view = getPara(1);
		TeacherStudy teacherStudy = TeacherStudy.dao.findById(teacherStudyid);
		setAttr("teacherStudy", teacherStudy);
		render("/pages/dailyAffairs/"+view+".jsp");
	}
}
