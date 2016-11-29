package com.jiaocai.model;

import com.jfinal.log.Logger;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

public class TeacherStudy extends Model<TeacherStudy> {

	private static final long serialVersionUID = 1L;
	
	Logger log = Logger.getLogger(getClass());
	
	public static final TeacherStudy dao = new TeacherStudy();
	
	public Page<TeacherStudy> getTeacherStudyList(int pageNo, int pageSize, String title){
		String sql = "from t_teacherstudy n where 1=1 ";
		if(title != null && !title.equals("")){
			sql += "and n.studyDetail like '%" + title + "%'";
		}
 		sql	+= " order by n.recordTime desc";
		log.info(sql);
		Page<TeacherStudy> teacherstudyPage = TeacherStudy.dao.paginate(pageNo, pageSize, "select n.* ", sql);
		return teacherstudyPage;
	}

}
