package com.jiaocai.model;

import com.jfinal.log.Logger;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

public class Book extends Model<Book> {

	Logger log = Logger.getLogger(getClass());
	
	private static final long serialVersionUID = 1L;
	
	public static final Book dao = new Book();
	
	public Page<Book> getBookList(int pageNo, int pageSize, String ntitle, String acqx, long id, String acnj, String bonf, String mo){
		String sql = "from t_book b left join t_bost s on s.boid = b.id and s.stid in(0, "+id+") where 1=1 and b.bonf = '"+bonf+"'";
		if(!ntitle.equals("") && ntitle != null){
			sql += " and b.name like '%" + ntitle + "%' ";
		}
		if(acqx != null && acqx.equals("1")){
			sql += " and b.bosh = 2 and b.bonj = '"+acnj+"'";
		}
		if(mo.equals("1")){
			sql += " and b.bosh = 2";
		}
		sql += " order by b.id desc";
		log.info(sql);
		Page<Book> booklist = Book.dao.paginate(pageNo, pageSize, "select b.*, s.stid, s.id as sid ", sql);
		return booklist;
		
	}
	public Page<Book> getOldBook(int pageNo, int pageSize, String ntitle, String bonf, String acqx, String acnj){
		String sql = "from t_book where 1=1 and bonf <> '"+bonf+"'";
		if(!ntitle.equals("") && ntitle != null){
			sql += " and name like '%" + ntitle + "%' ";
		}
		if(acqx.equals("1")){
			sql += " and bonj = '"+acnj+"'";
		}
		sql += " order by id desc";
		log.info(sql);
		Page<Book> booklist = Book.dao.paginate(pageNo, pageSize, "select * ", sql);
		return booklist;
	}
	
}
