package com.jiaocai.model;

import com.jfinal.log.Logger;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

public class StuSickCheck extends Model<StuSickCheck> {

	private static final long serialVersionUID = 1L;
	
	Logger log = Logger.getLogger(getClass());
	
	public static final StuSickCheck dao = new StuSickCheck();
	
	public Page<StuSickCheck> getStuSickCheckList(int pageNo, int pageSize, String title, int isTakePills){
		String sql = "from t_stuSickCheck n where 1=1 ";
		if(title != null && !title.equals("")){
			sql += "and n.classes like '%" + title + "%'";
		}
		if(isTakePills == 0){
			sql += " and n.isTakePills = 0";
		}
 		sql	+= " group by n.classes,DATE_FORMAT(stuMChkTime,'%Y-%m-%d') order by n.stuMChkTime desc";
		log.info(sql);
		Page<StuSickCheck> stuMCheckList = StuSickCheck.dao.paginate(pageNo, pageSize, "select n.classes,DATE_FORMAT(stuMChkTime,'%Y-%m-%d') as time, count(*) as count ,sum(n.sickLevel) as level", sql);
		return stuMCheckList;
	}
	
	public Page<StuSickCheck> getStuMChkDetailList(int pageNo, int pageSize, String classes, int isTakePills){
		String sql = "from t_stuSickCheck n where 1=1 ";
		if(classes != null && !classes.equals("")){
			sql += "and n.classes like '%" + classes + "%'";
		}
		if(isTakePills == 0){
			sql += " and n.isTakePills = 0 ";
		}
 		sql	+= "order by n.stuMChkTime desc";
		log.info(sql);
		Page<StuSickCheck> stuMChkDetailList = StuSickCheck.dao.paginate(pageNo, pageSize, "select n.*", sql);
		return stuMChkDetailList;
	}



}
