package com.jiaocai.model;

import com.jfinal.log.Logger;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

public class StuMorningCheck extends Model<StuMorningCheck> {

	private static final long serialVersionUID = 1L;
	
	Logger log = Logger.getLogger(getClass());
	
	public static final StuMorningCheck dao = new StuMorningCheck();
	
	public Page<StuMorningCheck> getStuMorningCheckList(int pageNo, int pageSize, String title){
		String sql = "from t_stuMorningCheck n where 1=1 ";
		if(title != null && !title.equals("")){
			sql += "and n.classes like '%" + title + "%'";
		}
 		sql	+= "group by n.classes,DATE_FORMAT(morningCheckTime,'%Y-%m-%d') order by n.morningCheckTime desc";
		log.info(sql);
		Page<StuMorningCheck> stuMCheckList = StuMorningCheck.dao.paginate(pageNo, pageSize, "select n.classes,DATE_FORMAT(morningCheckTime,'%Y-%m-%d') as time, count(*) as count ", sql);
		return stuMCheckList;
	}
	
	public Page<StuMorningCheck> getStuMorningCheckDetailList(int pageNo, int pageSize, String classes){
		String sql = "from t_stuMorningCheck n where 1=1 ";
		if(classes != null && !classes.equals("")){
			sql += "and n.classes like '%" + classes + "%'";
		}
 		sql	+= "order by n.morningCheckTime desc";
		log.info(sql);
		Page<StuMorningCheck> stuMChkDetailList = StuMorningCheck.dao.paginate(pageNo, pageSize, "select n.*", sql);
		return stuMChkDetailList;
	}

}
