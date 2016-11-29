package com.jiaocai.model;

import com.jfinal.log.Logger;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

public class KitchenDisinfect extends Model<KitchenDisinfect> {

	private static final long serialVersionUID = 1L;
	
	Logger log = Logger.getLogger(getClass());
	
	public static final KitchenDisinfect dao = new KitchenDisinfect();
	
	public Page<KitchenDisinfect> getkitchenDisinfectList(int pageNo, int pageSize, String title){
		String sql = "from t_kitchendisinfect n where 1=1 ";
		if(title != null && !title.equals("")){
			sql += "and n.remark like '%" + title + "%'";
		}
 		sql	+= " order by n.recordTime desc";
		log.info(sql);
		Page<KitchenDisinfect> kitchenDisinfectPage = KitchenDisinfect.dao.paginate(pageNo, pageSize, "select n.* ", sql);
		return kitchenDisinfectPage;
	}

}
