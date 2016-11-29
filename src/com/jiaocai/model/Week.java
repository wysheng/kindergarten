package com.jiaocai.model;

import java.util.List;

import com.jfinal.log.Logger;
import com.jfinal.plugin.activerecord.Model;

public class Week extends Model<Week> {

	private static final long serialVersionUID = 1L;

	Logger log = Logger.getLogger(getClass());
	
	public static final Week dao = new Week();
	
	/**TODO 默认搜索week表
	 * @author admin
	 * @return
	 */
	public List<Week> getWeekList(){
		String sql = "select w.* from t_week w where 1=1 order by w.id asc ";
		List<Week> list = Week.dao.find(sql);
		return list;
	}

}
