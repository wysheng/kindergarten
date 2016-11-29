package com.jiaocai.model;

import com.jfinal.log.Logger;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

public class Classes extends Model<Classes> {

	private static final long serialVersionUID = 1L;
	
	Logger log = Logger.getLogger(getClass());
	
	public static final Classes dao = new Classes();
	
	public Page<Classes> getClassesList(int pageNo, int pageSize, String title){
		String sql = "from t_classes n where 1=1 ";
		if(title != null && !title.equals("")){
			sql += "and n.classesname like '%" + title + "'% or n.remark like '%" + title + "'%";
		}
 		sql	+= " order by n.id desc";
		log.info(sql);
		Page<Classes> classesPage = Classes.dao.paginate(pageNo, pageSize, "select n.* ", sql);
		return classesPage;
	}
	public Page<Classes> getClassesNameList(){
		String sql = "from t_classes n where 1=1 ";
 		sql	+= " order by n.id desc";
		log.info(sql);
		Page<Classes> classesPage = Classes.dao.paginate(1, 100000, "select n.* ", sql);
		return classesPage;
	}

	
}
