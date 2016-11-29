package com.jiaocai.controller;

import org.apache.log4j.Logger;

import com.jfinal.core.Controller;

public class CommonController extends Controller {
	
	Logger log = Logger.getLogger(getClass());
	
	/**TODO 配置默认调用方法返回登陆页面
	 * @author John
	 */
	public void index(){
		log.info("======执行index()===========");
		render("/pages/login.jsp");
	}

}
