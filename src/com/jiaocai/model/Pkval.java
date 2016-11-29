package com.jiaocai.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;

public class Pkval extends Model<Pkval> {
	
	private static final long serialVersionUID = 1L;
	
	public static final Pkval dao = new Pkval();
	
	public List<Pkval> getPkvalList(long pkid){
		String sql = "select p.* from t_pkval p where 1=1 and p.pkid = " + pkid;
		List<Pkval> list = Pkval.dao.find(sql); 
		return list;
	}
	
	/**TODO 删除课程
	 * @author admin
	 */
	public void delpkval(long id){
		String sql = "delete from t_pkval where 1=1 and pkid = "+id;
		Db.update(sql);
	}
	
	public Pkval getPkval(long weid, long pkid){
		String sql = "select * from t_pkval where 1=1 and weid = "+weid+" and pkid = "+pkid;
		Pkval pkval = Pkval.dao.findFirst(sql);
		return pkval;
	}

}
