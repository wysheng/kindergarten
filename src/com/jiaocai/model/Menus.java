package com.jiaocai.model;

import java.util.ArrayList;
import java.util.List;

import com.jfinal.log.Logger;
import com.jfinal.plugin.activerecord.Model;

public class Menus extends Model<Menus> {
	
	Logger log = Logger.getLogger(getClass());
	
	private static final long serialVersionUID = 1L;
	
	public static final Menus dao = new Menus();
	
	/**TODO 初始化一级菜单
	 * 
	 * @return list
	 */
	public List<Menus> getFirstMenus(){
		List<Menus> list = new ArrayList<Menus>();
		String sql = "select m.* from t_menu m where 1=1 and m.jibie = 1 and m.parent = 0 order by id asc";
		log.info(sql);
		list = Menus.dao.find(sql);
		return list;
	}
	
	/**TODO 初始化二级菜单
	 * 
	 * @return list
	 */
	public List<Menus> getSecordMenus(long parent){
		List<Menus> list = new ArrayList<Menus>();
		String sql = "select m.* from t_menu m where 1=1 and m.jibie = 2 and m.parent = " + parent + " order by id asc";
		log.info(sql);
		list = Menus.dao.find(sql);
		return list;
	}

}
