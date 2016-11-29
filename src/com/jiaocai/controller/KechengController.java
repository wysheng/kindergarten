package com.jiaocai.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.jfinal.core.Controller;
import com.jfinal.log.Logger;
import com.jfinal.plugin.activerecord.Page;
import com.jiaocai.model.Account;
import com.jiaocai.model.Kecheng;

/**TODO
 * @author admin
 */
public class KechengController extends Controller {
	
	Logger log = Logger.getLogger(getClass());
	
	/**TODO 默认搜索公告
	 */
	public void getKechengList(){
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		int pageNo = getParaToInt("pageNo");
		int pageSize = getParaToInt("pageSize");
		long acid = getParaToLong("acid");
		String ntitle = getPara("title");
		String kcnf	= new SimpleDateFormat("yyyy").format(new Date());
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
		
		Page<Kecheng> keList = Kecheng.dao.getKechengList(pageNo, pageSize, ntitle, kcnf, acqx, acnj, aczy);
		int count = keList.getTotalRow();
		int pageCount = keList.getTotalPage();
		
		map.put("list", keList.getList());
		map.put("count", count);
		map.put("pageCount", pageCount);
		
		renderJson(map);
	}
	/**
	 * TODO 查询往年课程
	 * @author admin
	 */
	public void getOldKechengList(){
		Map<String, Object> map = new HashMap<String, Object>();
		
		int pageNo = getParaToInt("pageNo");
		int pageSize = getParaToInt("pageSize");
		long acid = getParaToLong("acid");
		String ntitle = getPara("title");
		String kcnf	= new SimpleDateFormat("yyyy").format(new Date());
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
		
		Page<Kecheng> keList = Kecheng.dao.getOldKechengList(pageNo, pageSize, ntitle, kcnf, acqx, acnj, aczy);
		int count = keList.getTotalRow();
		int pageCount = keList.getTotalPage();
		
		map.put("list", keList.getList());
		map.put("count", count);
		map.put("pageCount", pageCount);
		
		renderJson(map);
	}
	/**TODO 添加或修改课程
	 */
	public void addOrUpdateKecheng(){
		Kecheng kechengs = getModel(Kecheng.class);
		String kechengid = getPara("kecheng.id");
		if(kechengid != null && !"".equals(kechengid)){
			long id = Long.valueOf(kechengid);
			Kecheng upkecheng = Kecheng.dao.findById(id);
			upkecheng.set("kch", kechengs.get("kch"))
					.set("kcm", kechengs.get("kcm"))
					.set("kcsj", kechengs.get("kcsj"))
					.set("teid", kechengs.get("teid"))
					.set("kcnj", kechengs.get("kcnj"))
					.set("kczy", kechengs.get("kczy"))
					.set("kcxf", kechengs.get("kcxf"))
					.set("kclb", kechengs.get("kclb"))
					.set("kckh", kechengs.get("kckh"))
					.set("kcnf", new SimpleDateFormat("yyyy").format(new Date()))
					.update();
		}else{
			Kecheng kecheng = new Kecheng();
			kecheng.set("kch", kechengs.get("kch"))
					.set("kcm", kechengs.get("kcm"))
					.set("kcsj", kechengs.get("kcsj"))
					.set("teid", kechengs.get("teid"))
					.set("kcnj", kechengs.get("kcnj"))
					.set("kczy", kechengs.get("kczy"))
					.set("kcxf", kechengs.get("kcxf"))
					.set("kclb", kechengs.get("kclb"))
					.set("kckh", kechengs.get("kckh"))
					.set("kcnf", new SimpleDateFormat("yyyy").format(new Date()))
					.save();
		}
		render("/pages/kecheng.jsp");
	}
	/**TODO 删除课程
	 * @author admin
	 */
	public void delKecheng(){
		long kechengid = getParaToLong(0);
		Kecheng.dao.deleteById(kechengid);
		render("/pages/kecheng.jsp");
	}
	/**TODO 根据课程id查询公告
	 * @author admin
	 */
	public void getKechengById(){
		long kechengid = getParaToLong(0);
		String view = getPara(1);
		Kecheng kecheng = Kecheng.dao.findById(kechengid);
		setAttr("kecheng", kecheng);
		render("/pages/"+view+".jsp");
	}
}
