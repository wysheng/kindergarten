package com.jiaocai.model;

import com.jfinal.log.Logger;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

public class Paike extends Model<Paike> {
	
	Logger log = Logger.getLogger(getClass());
	private static final long serialVersionUID = 1L;
	
	public static final Paike dao = new Paike();
	/**TODO 查询今年课程
	 * @author admin
	 * @param pageNo
	 * @param pageSize
	 * @param title
	 * @param pknf
	 * @return
	 */
	public Page<Paike> getPaikeList(int pageNo, int pageSize, String title, String pknf, String acqx, String acnj, String aczy){
		String sql = "from t_paike p where 1=1 and p.pkqx = '1' and p.pknf = '"+pknf+"'";
		if(title != null && !title.equals("")){
			sql += " and p.title like '%" + title + "%'";
		}
		if(acqx.equals("1")){
			sql += " and p.pknj = '"+acnj+"'";
		}
		sql	+= " order by p.createtime desc";
		log.info(sql);
		Page<Paike> paikePage = Paike.dao.paginate(pageNo, pageSize, "select p.* ", sql);
		return paikePage;
	}
	/**TODO 查询教师课表
	 * @param pageNo
	 * @param pageSize
	 * @param title
	 * @param pknf
	 * @param acqx
	 * @param acnj
	 * @param aczy
	 * @return
	 */
	public Page<Paike> getTePaikeList(int pageNo, int pageSize, String title, String pknf, String tegh, String acqx){
		String sql = "from t_paike p where 1=1 and p.pkqx = '2' and p.pknf = '"+pknf+"'";
		if(title != null && !title.equals("")){
			sql += " and p.title like '%" + title + "%'";
		}
		if(acqx.equals("2")){
			sql += " and p.tegh = '" + tegh + "'";
		}
		sql	+= " order by p.createtime desc";
		log.info(sql);
		Page<Paike> paikePage = Paike.dao.paginate(pageNo, pageSize, "select p.* ", sql);
		return paikePage;
	}
	/**TODO 查询往年学生课表
	 * @author admin
	 * @param pageNo
	 * @param pageSize
	 * @param title
	 * @param pknf
	 * @return
	 */
	public Page<Paike> getOldPaikeList(int pageNo, int pageSize, String title, String pknf, String acqx, String acnj, String aczy){
		String sql = "from t_paike p where 1=1 and p.pkqx = '1' and p.pknf <> '"+pknf+"'";
		if(title != null && !title.equals("")){
			sql += " and p.title like '%" + title + "%'";
		}
		if(acqx.equals("1")){
			sql += " and p.pknj = '"+acnj+"'";
		}
		sql	+= " order by p.createtime desc";
		log.info(sql);
		Page<Paike> paikePage = Paike.dao.paginate(pageNo, pageSize, "select p.* ", sql);
		return paikePage;
	}
	/**TODO 查询往年老师课表
	 * @author admin
	 * @param pageNo
	 * @param pageSize
	 * @param title
	 * @param pknf
	 * @return
	 */
	public Page<Paike> getOldtePaikeList(int pageNo, int pageSize, String title, String pknf, String acqx, String acxh){
		String sql = "from t_paike p where 1=1 and p.pkqx = '2' and p.pknf <> '"+pknf+"'";
		if(title != null && !title.equals("")){
			sql += " and p.title like '%" + title + "%'";
		}
		if(acqx.equals("2")){
			sql += " and p.tegh = '"+acxh+"'";
		}
		sql	+= " order by p.createtime desc";
		log.info(sql);
		Page<Paike> paikePage = Paike.dao.paginate(pageNo, pageSize, "select p.* ", sql);
		return paikePage;
	}
	/**TODO 得到新增的课程id
	 * @author admin
	 * @param title
	 * @param nj
	 * @param zy
	 * @param sj
	 * @return
	 */
	public Paike getPaikeId(String title, String nj, String zy, String sj, String gh, String xm){
		String sql = "";
		if(gh != null && !gh.equals("")){
			sql += "select p.* from t_paike p where 1=1 and p.title = '"+title+"' and p.tegh = '"+gh+"' and p.pknf = '"+sj+"' and p.tename = '"+xm+"'";
		}else{
			sql += "select p.* from t_paike p where 1=1 and p.title = '"+title+"' and p.pknj = '"+nj+"' and p.pknf = '"+sj+"'";
		}
		log.info(sql);
		Paike paike = Paike.dao.findFirst(sql);
		return paike;
	}

}
