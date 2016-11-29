package com.jiaocai.model;

import com.jfinal.log.Logger;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

public class ProtectMeasures extends Model<ProtectMeasures> {

	private static final long serialVersionUID = 1L;
	
	Logger log = Logger.getLogger(getClass());
	
	public static final ProtectMeasures dao = new ProtectMeasures();
	
	public Page<ProtectMeasures> getProtectMeasuresList(int pageNo, int pageSize, String title){
		String sql = "from t_protectmeasures n where 1=1 ";
		if(title != null && !title.equals("")){
			sql += "and n.content like '%" + title + "%'";
		}
 		sql	+= " order by n.recordTime desc";
		log.info(sql);
		Page<ProtectMeasures> noticePage = ProtectMeasures.dao.paginate(pageNo, pageSize, "select n.* ", sql);
		return noticePage;
	}

}
