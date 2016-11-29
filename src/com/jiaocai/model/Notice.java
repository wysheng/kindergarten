package com.jiaocai.model;

import com.jfinal.log.Logger;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

public class Notice extends Model<Notice> {

	private static final long serialVersionUID = 1L;
	
	Logger log = Logger.getLogger(getClass());
	
	public static final Notice dao = new Notice();
	
	public Page<Notice> getNoticeList(int pageNo, int pageSize, String title,int noticeType){
		String sql = "from t_notice n where 1=1 ";
		if(title != null && !title.equals("")){
			sql += "and n.ntitle like '%" + title + "%'";
		}
		if(noticeType != 4){
			sql += " and n.ntype = " + noticeType ;
		}
 		sql	+= " order by n.ntime desc";
		log.info(sql);
		Page<Notice> noticePage = Notice.dao.paginate(pageNo, pageSize, "select n.* ", sql);
		return noticePage;
	}

}
