package com.jiaocai.model;

import com.jfinal.log.Logger;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

public class RegularMeeting extends Model<RegularMeeting> {

	private static final long serialVersionUID = 1L;
	
	Logger log = Logger.getLogger(getClass());
	
	public static final RegularMeeting dao = new RegularMeeting();
	
	public Page<RegularMeeting> getRegularMeetingList(int pageNo, int pageSize, String title){
		String sql = "from t_regularmeeting n where 1=1 ";
		if(title != null && !title.equals("")){
			sql += "and n.meetingTitle like '%" + title + "%'";
		}
 		sql	+= " order by n.recordTime desc";
		log.info(sql);
		Page<RegularMeeting> regularMeetingList = RegularMeeting.dao.paginate(pageNo, pageSize, "select n.* ", sql);
		return regularMeetingList;
	}

}
