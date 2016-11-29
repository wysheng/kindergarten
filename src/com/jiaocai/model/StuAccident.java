package com.jiaocai.model;

import com.jfinal.log.Logger;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

public class StuAccident extends Model<StuAccident> {

	private static final long serialVersionUID = 1L;
	
	Logger log = Logger.getLogger(getClass());
	
	public static final StuAccident dao = new StuAccident();
	
	public Page<StuAccident> getstuAccidentList(int pageNo, int pageSize, String title){
		String sql = "from t_stuaccident n where 1=1 ";
		if(title != null && !title.equals("")){
			sql += "and n.accidentDeatail like '%" + title + "%'";
		}
 		sql	+= " order by n.recordTime desc";
		log.info(sql);
		Page<StuAccident> stuAccidentPage = StuAccident.dao.paginate(pageNo, pageSize, "select n.* ", sql);
		return stuAccidentPage;
	}

}
