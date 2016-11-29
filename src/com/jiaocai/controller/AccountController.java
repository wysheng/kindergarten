package com.jiaocai.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jfinal.core.Controller;
import com.jfinal.log.Logger;
import com.jfinal.plugin.activerecord.Page;
import com.jiaocai.model.Account;
import com.jiaocai.model.Week;

public class AccountController extends Controller {
	
	Logger log = Logger.getLogger(getClass());
	
	/**TODO 执行登陆
	 * @author John
	 */
	public void loginUser(){
		
		log.info("======执行登陆方法loginUser()========");
		
		Map<String, Object> map = new HashMap<String, Object>();
		String loginuser = getPara("loginuser");
		String loginpass = getPara("loginpass");
		int result = -1;
		
		try {
			Account account = Account.dao.selectUserByloginName(loginuser);
			if(null != account && !account.equals("")){
				String pass = account.getStr("loginpass");
				if(loginpass.equals(pass)){
					List<Week> list = Week.dao.getWeekList();
					setSessionAttr("Weeklist", list);
					setSessionAttr("account", account);
					setSessionAttr("id", account.getLong("id"));
					setSessionAttr("acnj", account.getStr("acnj"));
					setSessionAttr("aczy", account.getStr("aczy"));
					setSessionAttr("acbj", account.getStr("acbj"));
					setSessionAttr("user", loginuser);
					setSessionAttr("username", account.getStr("acname"));
					setSessionAttr("acqx", account.getStr("acqx"));
					setSessionAttr("acsex", account.getStr("acsex"));
					setSessionAttr("acxh", account.getStr("acxh"));
					setSessionAttr("acxy", account.getStr("acxy"));
					log.info("==========登陆成功" + "==" + account.getStr("acname") + "==========");
				}else{
					result = 1;
					log.info("=======登陆失败==密码错误========");
				}
			}else{
				result = 1;
				log.info("=======登陆失败==用户名错误========");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		map.put("result", result);
		renderJson(map);
	}
	/**TODO 默认搜索人员
	 */
	public void getStudentList(){
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		int pageNo = getParaToInt("pageNo");
		int pageSize = getParaToInt("pageSize");
		String ntitle = getPara("title");
		int personAcqx = getParaToInt("personAcqx");
		if(ntitle != null && !ntitle.equals("")){
			try {
				ntitle = URLDecoder.decode(ntitle, "utf-8");
				log.info("ntitle:"+ntitle+"personAcqx:"+personAcqx);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		Page<Account> studentList = Account.dao.selectAllUser(pageNo, pageSize, ntitle,personAcqx);
		int count = studentList.getTotalRow();
		int pageCount = studentList.getTotalPage();
		
		map.put("studentList", studentList.getList());
		map.put("count", count);
		map.put("pageCount", pageCount);
		
		renderJson(map);
		
	}
	
	/**TODO 退出登陆
	 * @author admin
	 */
	public void loginOut(){
		try {
			this.getSession().invalidate();
			redirect("/pages/login.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**TODO 删除人员
	 * @author John
	 */
	public void deleStudent(){
		long id = getParaToLong(0);
		Account.dao.deleteById(id);
		render("/pages/person/student.jsp");
	}
	
	/**TODO 根据学生id查询
	 */
	public void getStudentById(){
		long id = getParaToLong(0);
		String view = getPara(1);
		Account account = Account.dao.findById(id);
		setAttr("t_account", account);
		render("/pages/"+view+".jsp");
	}
	/**TODO 添加或更新人员
	 * @author admin
	 */
	public void addOrUpdateStudent(){
		Account accounts = super.getModel(Account.class);
		String accountid = getPara("account.id");
		String acqx = accounts.get("acqx");
		if(accountid != null && !accountid.equals("")){
			if(acqx != null && acqx.equals("1")){
				long id = Long.valueOf(accountid);
				Account upaccount = Account.dao.findById(id);
				
				upaccount.set("loginname", accounts.get("loginname"))
				.set("loginpass", accounts.get("loginpass"))
				.set("acname", accounts.get("acname"))
				.set("aczy", accounts.get("aczy"))
				.set("acsex", accounts.get("acsex"))
				.set("acxh", accounts.get("acxh"))
				.set("acbj", accounts.get("acbj"))
				.set("acnj", accounts.get("acnj"))
				.set("acxy", accounts.get("acxy"))
				.set("acqx", accounts.get("acqx"))
				.update();
				render("/pages/person/student.jsp");
			}else{
				long id = Long.valueOf(accountid);
				Account upaccount = Account.dao.findById(id);
				
				upaccount.set("loginname", accounts.get("loginname"))
				.set("loginpass", accounts.get("loginpass"))
				.set("acname", accounts.get("acname"))
				.set("acsex", accounts.get("acsex"))
				.set("acxh", accounts.get("acxh"))
				.set("aczy", accounts.get("aczy"))
				.set("acxy", accounts.get("acxy"))
				.set("acqx", accounts.get("acqx"))
				.update();
				render("/pages/person/teacher.jsp");
			}
		}else{
			if(acqx != null && acqx.equals("1")){
				Account account = new Account();
				account.set("loginname", accounts.get("loginname"))
				.set("loginpass", accounts.get("loginpass"))
				.set("acname", accounts.get("acname"))
				.set("aczy", accounts.get("aczy"))
				.set("acsex", accounts.get("acsex"))
				.set("acxh", accounts.get("acxh"))
				.set("acbj", accounts.get("acbj"))
				.set("acnj", accounts.get("acnj"))
				.set("acxy", accounts.get("acxy"))
				.set("acqx", accounts.get("acqx"))
				.save();
				render("/pages/person/student.jsp");
			}else{
				Account account = new Account();
				account.set("loginname", accounts.get("loginname"))
				.set("loginpass", accounts.get("loginpass"))
				.set("acname", accounts.get("acname"))
				.set("acsex", accounts.get("acsex"))
				.set("acxh", accounts.get("acxh"))
				.set("aczy", accounts.get("aczy"))
				.set("acxy", accounts.get("acxy"))
				.set("acqx", accounts.get("acqx"))
				.save();
				render("/pages/person/teacher.jsp");
			}
		}
		
	}

}
