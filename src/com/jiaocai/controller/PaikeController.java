package com.jiaocai.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jfinal.core.Controller;
import com.jfinal.log.Logger;
import com.jfinal.plugin.activerecord.Page;
import com.jiaocai.model.Account;
import com.jiaocai.model.Paike;
import com.jiaocai.model.Pkval;
import com.jiaocai.model.Week;

/**TODO
 * @author admin
 */
public class PaikeController extends Controller {
	
	Logger log = Logger.getLogger(getClass());
	
	/**TODO 显示课表
	 * @author admin
	 */
	public void getPaikeList(){
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		int pageNo = getParaToInt("pageNo");
		int pageSize = getParaToInt("pageSize");
		long acid = getParaToLong("acid");
		String ntitle = getPara("title");
		String pknf = new SimpleDateFormat("yyyy").format(new Date());
		if(ntitle != null && !ntitle.equals("")){
			try {
				ntitle = URLDecoder.decode(ntitle, "utf-8");
				log.info("ntitle:"+ntitle);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		Account account = Account.dao.findById(acid);
		String acqx = account.getStr("acqx");
		String acnj = account.getStr("acnj");
		String aczy = account.getStr("aczy");
		
		Page<Paike> paikeList = Paike.dao.getPaikeList(pageNo, pageSize, ntitle, pknf, acqx, acnj, aczy);
		int count = paikeList.getTotalRow();
		int pageCount = paikeList.getTotalPage();
		
		map.put("paikeList", paikeList.getList());
		map.put("count", count);
		map.put("pageCount", pageCount);
		
		renderJson(map);
	}
	/**TODO
	 * 查询教师课表
	 * @author admin
	 */
	public void getTeacPaikeList(){
		Map<String, Object> map = new HashMap<String, Object>();
		
		int pageNo = getParaToInt("pageNo");
		int pageSize = getParaToInt("pageSize");
		long acid = getParaToLong("acid");
		String ntitle = getPara("title");
		String pknf = new SimpleDateFormat("yyyy").format(new Date());
		if(ntitle != null && !ntitle.equals("")){
			try {
				ntitle = URLDecoder.decode(ntitle, "utf-8");
				log.info("ntitle:"+ntitle);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		Account account = Account.dao.findById(acid);
		String acqx = account.getStr("acqx");
		String acxh = account.getStr("acxh");
		
		Page<Paike> paikeList = Paike.dao.getTePaikeList(pageNo, pageSize, ntitle, pknf, acxh, acqx);
		int count = paikeList.getTotalRow();
		int pageCount = paikeList.getTotalPage();
		
		map.put("paikeList", paikeList.getList());
		map.put("count", count);
		map.put("pageCount", pageCount);
		
		renderJson(map);
	}
	/**TODO 查询往年学生课表
	 * @author admin
	 */
	public void getOldPaikeList(){
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		int pageNo = getParaToInt("pageNo");
		int pageSize = getParaToInt("pageSize");
		long acid = getParaToLong("acid");
		String ntitle = getPara("title");
		String pknf = new SimpleDateFormat("yyyy").format(new Date());
		if(ntitle != null && !ntitle.equals("")){
			try {
				ntitle = URLDecoder.decode(ntitle, "utf-8");
				log.info("ntitle:"+ntitle);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		Account account = Account.dao.findById(acid);
		String acqx = account.getStr("acqx");
		String acnj = account.getStr("acnj");
		String aczy = account.getStr("aczy");
		Page<Paike> paikeList = Paike.dao.getOldPaikeList(pageNo, pageSize, ntitle, pknf, acqx, acnj, aczy);
		int count = paikeList.getTotalRow();
		int pageCount = paikeList.getTotalPage();
		
		map.put("paikeList", paikeList.getList());
		map.put("count", count);
		map.put("pageCount", pageCount);
		
		renderJson(map);
	}
	/**TODO 查询往年老师课表
	 * @author admin
	 */
	public void getOldtePaikeList(){
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		int pageNo = getParaToInt("pageNo");
		int pageSize = getParaToInt("pageSize");
		long acid = getParaToLong("acid");
		String ntitle = getPara("title");
		String pknf = new SimpleDateFormat("yyyy").format(new Date());
		if(ntitle != null && !ntitle.equals("")){
			try {
				ntitle = URLDecoder.decode(ntitle, "utf-8");
				log.info("ntitle:"+ntitle);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		Account account = Account.dao.findById(acid);
		String acqx = account.getStr("acqx");
		String acxh = account.getStr("acxh");
		Page<Paike> paikeList = Paike.dao.getOldtePaikeList(pageNo, pageSize, ntitle, pknf, acqx, acxh);
		int count = paikeList.getTotalRow();
		int pageCount = paikeList.getTotalPage();
		
		map.put("paikeList", paikeList.getList());
		map.put("count", count);
		map.put("pageCount", pageCount);
		
		renderJson(map);
	}
	/**TODO 得到课程列表
	 * @author admin
	 */
	public void getWeekList(){
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<Week> list = Week.dao.getWeekList();
		map.put("list", list);
		renderJson(map);
	}
	/**TODO 保存课程
	 * @author admin
	 */
	public void addOrUpdatePaike(){
		log.info("======进入=======");
		List<Week> week = getSessionAttr("Weeklist");
		String title = getPara("title");
		String nj = getPara("nj");
		String xy = getPara("xy");
		String zy = getPara("zy");
		String gh = getPara("gh");
		String xm = getPara("xm");
		String sj = new SimpleDateFormat("yyyy").format(new Date());
		String paiid = getPara("id");
		String pkqx = "";
		if(gh != null && !gh.equals("")){
			pkqx = "2";
		}else{
			pkqx = "1";
		}
		if(paiid != null && !paiid.equals("")){
			long id = Long.valueOf(paiid);
			Paike paike = Paike.dao.findById(id);
			paike.set("title", title)
			.set("createtime", new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()))
			.set("pknf", sj)
			.set("pkxy", xy)
			.set("zypk", zy)
			.set("pkqx", pkqx)
			.set("pknj", nj)
			.set("tegh", gh)
			.set("tename", xm)
			.update();
			//保存课程表信息
			for(int i=0; i<7; i++){
				long c = i+1;
				String weekname = week.get(i).getStr("name");
				String pkva_0 = getPara(weekname+"_0");
				String pkva_1 = getPara(weekname+"_1");
				String pkva_2 = getPara(weekname+"_2");
				String pkva_3 = getPara(weekname+"_3");
				String pkva_4 = getPara(weekname+"_4");
				
				Pkval pkval = Pkval.dao.getPkval(c, id);
				pkval.set("weid", pkva_0)
				.set("pkid", id)
				.set("pkva_1", pkva_1)
				.set("pkva_2", pkva_2)
				.set("pkva_3", pkva_3)
				.set("pkva_4", pkva_4)
				.update();
			}
		}else{
			Paike paike = new Paike();
			paike.set("title", title)
			.set("createtime", new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()))
			.set("pknf", sj)
			.set("pkxy", xy)
			.set("zypk", zy)
			.set("pkqx", pkqx)
			.set("pknj", nj)
			.set("tegh", gh)
			.set("tename", xm)
			.save();
			Paike paikeid = Paike.dao.getPaikeId(title, nj, zy, sj, gh, xm);				
			long pkid = paikeid.getLong("id");
			if(pkid != 0){
				for(int i=0; i<7; i++){
					String weekname = week.get(i).getStr("name");
					String pkva_0 = getPara(weekname+"_0");
					String pkva_1 = getPara(weekname+"_1");
					String pkva_2 = getPara(weekname+"_2");
					String pkva_3 = getPara(weekname+"_3");
					String pkva_4 = getPara(weekname+"_4");
					
					Pkval pkval = new Pkval();
					pkval.set("weid", pkva_0)
					.set("pkid", pkid)
					.set("pkva_1", pkva_1)
					.set("pkva_2", pkva_2)
					.set("pkva_3", pkva_3)
					.set("pkva_4", pkva_4)
					.save();
				}
			}
		}
		if(gh != null && !gh.equals("")){
			render("/pages/teacpaike.jsp");
		}else{
			render("/pages/paike.jsp");
		}
	}
	/**TODO 查看课表
	 * @author admin
	 */
	public void lookPaike(){
		long pkid = getParaToLong(0);
		String view = getPara(1);
		Paike paike = Paike.dao.findById(pkid);
		setAttr("paike", paike);
		List<Pkval> pkval = Pkval.dao.getPkvalList(pkid);
		setAttr("pkval", pkval);
		List<Week> list = Week.dao.getWeekList();
		setAttr("welist", list);
		render("/pages/"+view+".jsp");
	}
	/**
	 * TODO 删除课表
	 * @author admin
	 */
	public void delPaike(){
		long pkid = getParaToLong(0);
		Pkval.dao.delpkval(pkid);
		Paike paike = Paike.dao.findById(pkid);
		if(paike.getStr("tegh") != null &&!paike.getStr("tegh").equals("")){
			Paike.dao.deleteById(pkid);
			render("/pages/teacpaike.jsp");			
		}else{
			Paike.dao.deleteById(pkid);
			render("/pages/paike.jsp");
		}
	}
}
