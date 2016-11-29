package com.jiaocai.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jfinal.core.Controller;
import com.jfinal.log.Logger;
import com.jiaocai.model.Menus;

/**TODO
 * @author 
 */
public class MenuController extends Controller {
	
	Logger log = Logger.getLogger(getClass());
	
	/**TODO 初始化菜单
	 */
	public void getMenusList(){
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object> list = new ArrayList<Object>();
		
		List<Menus> firstMenus = Menus.dao.getFirstMenus();
		for(int i=0; i<firstMenus.size(); i++){
			long parent = firstMenus.get(i).getLong("id");
			List<Menus> secondMenus = Menus.dao.getSecordMenus(parent);
			list.add(secondMenus);
		}
		
		map.put("first", firstMenus);
		map.put("second", list);
		renderJson(map);
	}

}
