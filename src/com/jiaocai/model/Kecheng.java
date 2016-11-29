package com.jiaocai.model;

import com.jfinal.log.Logger;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

public class Kecheng extends Model<Kecheng> {

	Logger log = Logger.getLogger(getClass());
	
	private static final long serialVersionUID = 1L;
	
	public static final Kecheng dao = new Kecheng();

	/**
	 * TODO　查询课程
	 * @param pageNo
	 * @param pageSize
	 * @param title
	 * @param kcnf
	 * @return
	 */
	public Page<Kecheng> getKechengList(int pageNo, int pageSize, String title, String kcnf, String acqx, String acnj, String aczy){
		String sql = "from t_kecheng k where 1=1 and k.kcnf = '" + kcnf + "'";
		if(title != null && !title.equals("")){
			sql += " and (k.kcm like '%" + title + "%' or k.kczy like '%" + title + "%') ";
		}
		if(acqx.equals("1")){
			sql += " and k.kcnj = '"+acnj+"'";
		}
		sql	+= " order by k.id desc";
		log.info(sql);
		Page<Kecheng> kePage = Kecheng.dao.paginate(pageNo, pageSize, "select k.* ", sql);
		return kePage;
	}
	/**
	 * TODO 查询往年课表
	 * @param pageNo
	 * @param pageSize
	 * @param title
	 * @param kcnf
	 * @return
	 */
	public Page<Kecheng> getOldKechengList(int pageNo, int pageSize, String title, String kcnf, String acqx, String acnj, String aczy){
		String sql = "from t_kecheng k where 1=1 and k.kcnf <> '" + kcnf + "'";
		if(title != null && !title.equals("")){
			sql += " and (k.kcm like '%" + title + "%' or k.kczy like '%" + title + "%') ";
		}
		if(acqx.equals("1")){
			sql += " and k.kcnj = '"+acnj+"'";
		}
		sql	+= " order by k.id desc";
		log.info(sql);
		Page<Kecheng> kePage = Kecheng.dao.paginate(pageNo, pageSize, "select k.* ", sql);
		return kePage;
	}
} 
