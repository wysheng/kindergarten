package com.jiaocai.model;

import java.util.List;

import com.jfinal.log.Logger;
import com.jfinal.plugin.activerecord.Model;

public class Bost extends Model<Bost> {
	
	Logger log = Logger.getLogger(getClass());

	private static final long serialVersionUID = 356302500049242157L;
	
	public static final Bost dao = new Bost();
	/**
	 * TODO 得到年级订阅总人数
	 * @param boid
	 * @return
	 */
	public int getStuCount(long boid, String bj){
		String sql = "select * from t_bost where 1=1 and boid = " + boid;
		if(bj != null && !bj.equals("")){
			sql += " and bj = '" + bj + "'";
		}
		log.info(sql);
		List<Bost> list = Bost.dao.find(sql);
		return list.size();
	}
	/**
	 * TODO 得到班级订阅总人数
	 * @param boid
	 * @return
	 */
	public List<Bost> getClsCount(long boid){
		String sql = "select * from t_bost where 1=1 and boid = " + boid + " group by bj order by id asc";
		log.info(sql);
		List<Bost> list = Bost.dao.find(sql);
		return list;
	}
	/**
	 * TODO 得到每个学生订多少书
	 * @param stid
	 * @return
	 */
	public List<Bost> getBook(long stid, String bonf, String bs){
		String sql = "select * from t_bost where 1=1 and stid = " + stid;
		if(bs != null && bs.equals("2")){
			sql += " and bonf <> '" + bonf + "'";
		}else{
			sql += " and bonf = '" + bonf + "'";
		}
		sql += " order by id desc";
		log.info(sql);
		List<Bost> list = Bost.dao.find(sql);
		return list;
	}
	/**
	 * TODO　查询历年学生订购的教材
	 * @param stid
	 * @param bonf
	 * @return
	 */
	public List<Bost> getOldBook(long stid){
		String sql = "select * from t_bost where 1=1 and stid = " + stid + " group by bonf order by id desc";
		log.info(sql);
		List<Bost> list = Bost.dao.find(sql);
		return list;
	}

}
