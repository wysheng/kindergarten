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
import com.jiaocai.model.Notice;

/**TODO
 * @author admin
 */
public class NoticeController extends Controller {
	
	Logger log = Logger.getLogger(getClass());
	
	/**TODO 默认搜索公告
	 */
	public void getNoticeList(){
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		int pageNo = getParaToInt("pageNo");
		int pageSize = getParaToInt("pageSize");
		String ntitle = getPara("title");
		int noticeType = getParaToInt("noticeType");

		if(!ntitle.equals("") && ntitle != null){
			try {
				ntitle = URLDecoder.decode(ntitle, "utf-8");
				log.info("ntitle:"+ntitle+"noticeType:"+noticeType);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		Page<Notice> noticeList = Notice.dao.getNoticeList(pageNo, pageSize, ntitle,noticeType);
		int count = noticeList.getTotalRow();
		int pageCount = noticeList.getTotalPage();
		
		map.put("noticeList", noticeList.getList());
		map.put("count", count);
		map.put("pageCount", pageCount);
		
		renderJson(map);
		
	}
	
	/**TODO 增加或修改公告
	 */
	public void addOrUpdateNotice(){
		Notice notices = getModel(Notice.class);
		String noticid = getPara("id");
		if(noticid != null && !"".equals(noticid)){
			long id = Long.valueOf(noticid);
			Notice upnotice = Notice.dao.findById(id);
			upnotice.set("ntitle", notices.get("ntitle"))
					.set("ntype", notices.get("ntype"))
					.set("ncontent", notices.get("ncontent"))
					.set("ntime", new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()))
					.update();
		}else{
			Notice notice = new Notice();
			notice.set("ntitle", notices.get("ntitle"))
					.set("ntype", notices.get("ntype"))
					.set("ncontent", notices.get("ncontent"))
					.set("ntime", new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()))
					.save();
		}
		render("/pages/notice.jsp");
	}
	/**TODO 删除公告
	 */
	public void delNotice(){
		long noticeid = getParaToLong(0);
		Notice.dao.deleteById(noticeid);
		render("/pages/notice.jsp");
	}
	/**TODO 根据公告id查询公告
	 */
	public void getNoticeById(){
		long noticeid = getParaToLong(0);
		String view = getPara(1);
		Notice notice = Notice.dao.findById(noticeid);
		setAttr("notice", notice);
		render("/pages/"+view+".jsp");
	}
}
