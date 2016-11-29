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
import com.jiaocai.model.RegularMeeting;

/**TODO
 * @author admin
 */
public class RegularMeetingController extends Controller {
	
	Logger log = Logger.getLogger(getClass());
	
	/**TODO 默认搜索公告
	 */
	public void getRegularMeetingList(){
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		int pageNo = getParaToInt("pageNo");
		int pageSize = getParaToInt("pageSize");
		String ntitle = getPara("title");

		if(!ntitle.equals("") && ntitle != null){
			try {
				ntitle = URLDecoder.decode(ntitle, "utf-8");
				log.info("ntitle:"+ntitle);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		Page<RegularMeeting> regularMeetingList = RegularMeeting.dao.getRegularMeetingList(pageNo, pageSize, ntitle);
		int count = regularMeetingList.getTotalRow();
		int pageCount = regularMeetingList.getTotalPage();
		
		map.put("regularMeetingList", regularMeetingList.getList());
		map.put("count", count);
		map.put("pageCount", pageCount);
		
		renderJson(map);
		
	}
	
	/**TODO 增加或修改公告
	 */
	public void addOrUpdateRegularMeeting(){
		RegularMeeting notices = getModel(RegularMeeting.class);
		String regularMeetingid = getPara("id");
		if(regularMeetingid != null && !"".equals(regularMeetingid)){
			long id = Long.valueOf(regularMeetingid);
			RegularMeeting upRegularMeeting = RegularMeeting.dao.findById(id);
			upRegularMeeting.set("meetingTitle", notices.get("meetingTitle"))
					.set("meetingCompere", notices.get("meetingCompere"))
					.set("meetingAttendee", notices.get("meetingAttendee"))
					.set("meetingAttendeeNum", notices.get("meetingAttendeeNum"))
					.set("meetingContent", notices.get("meetingContent"))
					.set("recordTime", new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()))
					.update();
		}else{
			RegularMeeting sRegularMeeting = new RegularMeeting();
			sRegularMeeting.set("meetingTitle", notices.get("meetingTitle"))
					.set("meetingCompere", notices.get("meetingCompere"))
					.set("meetingAttendee", notices.get("meetingAttendee"))
					.set("meetingAttendeeNum", notices.get("meetingAttendeeNum"))
					.set("meetingContent", notices.get("meetingContent"))
					.set("recordTime", new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()))
					.save();
		}
		render("/pages/dailyAffairs/regularMeeting.jsp");
	}
	/**TODO 删除公告
	 */
	public void delRegularMeeting(){
		long regularMeetingId = getParaToLong(0);
		RegularMeeting.dao.deleteById(regularMeetingId);
		render("/pages/dailyAffairs/regularMeeting.jsp");
	}
	/**TODO 根据公告id查询公告
	 */
	public void getRegularMeetingById(){
		long regularMeetingid = getParaToLong(0);
		String view = getPara(1);
		RegularMeeting regularMeeting = RegularMeeting.dao.findById(regularMeetingid);
		setAttr("regularMeeting", regularMeeting);
		render("/pages/dailyAffairs/"+view+".jsp");
	}
}
