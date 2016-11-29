package com.jiaocai.model;

import com.jfinal.log.Logger;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

public class Schoolfee extends Model<Schoolfee> {

	Logger log = Logger.getLogger(getClass());
	
	private static final long serialVersionUID = 1L;
	
	public static final Schoolfee dao = new Schoolfee();
	
	public Page<Schoolfee> getSchoolFeeList(int pageNo, int pageSize, String ntitle){
		String sql = "from t_schoolfee n where 1=1 ";
		if(ntitle != null && !ntitle.equals("")){
			sql += "and n.projectname like '%" + ntitle + "%'";
		}
 		sql	+= " order by n.id desc";
		log.info(sql);
		Page<Schoolfee> schoolfeePage = Schoolfee.dao.paginate(pageNo, pageSize, "select n.* ", sql);
		return schoolfeePage;
	}
	/*
	public Page<Schoolfee> getOldBook(int pageNo, int pageSize, String ntitle, String bonf, String acqx, String acnj){
		String sql = "from t_book where 1=1 and bonf <> '"+bonf+"'";
		if(!ntitle.equals("") && ntitle != null){
			sql += " and name like '%" + ntitle + "%' ";
		}
		if(acqx.equals("1")){
			sql += " and bonj = '"+acnj+"'";
		}
		sql += " order by id desc";
		log.info(sql);
		Page<Schoolfee> booklist = Schoolfee.dao.paginate(pageNo, pageSize, "select * ", sql);
		return booklist;
	}*/
	
}
