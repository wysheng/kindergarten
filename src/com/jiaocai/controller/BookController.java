package com.jiaocai.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jfinal.core.Controller;
import com.jfinal.log.Logger;
import com.jfinal.plugin.activerecord.Page;
import com.jiaocai.model.Account;
import com.jiaocai.model.Book;
import com.jiaocai.model.Bost;

/**TODO
 * 
 */
public class BookController extends Controller {
	
	Logger log = Logger.getLogger(getClass());
	/**TODO 查询书
	 * 
	 */
	public void getBookList(){
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		int pageNo = getParaToInt("pageNo");
		int pageSize = getParaToInt("pageSize");
		int stid = getParaToInt("stid");
		String ntitle = getPara("ntitle");
		String acqx = getPara("acqx");
		String acnj = getPara("acnj");
		String bonf = new SimpleDateFormat("yyyy").format(new Date());
		
			try {
				if(ntitle != null && !ntitle.equals("")){
					ntitle = URLDecoder.decode(ntitle, "UTF-8");
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		Page<Book> bookPage = Book.dao.getBookList(pageNo, pageSize, ntitle, acqx, stid, acnj, bonf, "");
		int count = bookPage.getTotalRow();
		int pageCount = bookPage.getTotalPage();
		
		map.put("count", count);
		map.put("pageCount", pageCount);
		map.put("bookPage", bookPage.getList());
		
		renderJson(map);
		
	}
	/**TODO 查询往年教材
	 * 
	 */
	public void getOldBookList(){
		Map<String, Object> map = new HashMap<String, Object>();
		
		int pageNo = getParaToInt("pageNo");
		int pageSize = getParaToInt("pageSize");
		long acid = getParaToLong("acid");
		String ntitle = getPara("ntitle");
		String bonf = new SimpleDateFormat("yyyy").format(new Date());
		
		try {
			if(ntitle != null && !ntitle.equals("")){
				ntitle = URLDecoder.decode(ntitle, "UTF-8");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Account account = Account.dao.findById(acid);
		String acqx = account.getStr("acqx");
		String acnj = account.getStr("acnj");
		
		Page<Book> bookPage = Book.dao.getOldBook(pageNo, pageSize, ntitle, bonf, acqx, acnj);
		int count = bookPage.getTotalRow();
		int pageCount = bookPage.getTotalPage();
		
		map.put("count", count);
		map.put("pageCount", pageCount);
		map.put("bookPage", bookPage.getList());
		
		renderJson(map);
		
	}
	/**
	 * TODO　查询学生订购的教材
	 * @author admin
	 */
	public void getStudBookList(){
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object> list = new ArrayList<Object>();
		long stid = getParaToLong("id");
		String bs = getPara("bs");
		String bonf = new SimpleDateFormat("yyyy").format(new Date());
		
		List<Bost> bostList = Bost.dao.getBook(stid, bonf, bs);
		for(Bost bo: bostList){
			Map<String, Object> mapbo = new HashMap<String, Object>();
			Book book = Book.dao.findById(bo.getLong("boid"));
			mapbo.put("book", book);
			list.add(mapbo);
		}
		map.put("list", list);
		renderJson(map);
	}
	
	/**
	 * TODO 修改书或添加书
	 * @author xkq
	 */
	public void addOrUpdateBook(){
		Book books = this.getModel(Book.class);
		String id = getPara("book.id");
		if(id != null && !id.equals("")){//如果id不为空，则根据id修改书
			long bookid = Long.valueOf(id);
			Book book = Book.dao.findById(bookid);
			book.set("name", books.get("name"))
			.set("author", books.get("author"))
			.set("bocbs", books.get("bocbs"))
			.set("bodj", books.get("bodj"))
			.set("bozkj", books.get("bozkj"))
			.set("boremark", books.get("boremark"))
			.set("bosh", books.get("bosh"))
			.set("teid", books.get("teid"))
			.set("bonj", books.get("bonj"))
			.update();
		}else{//如果id为空，则新增一本书
			Book book = new Book();
			book.set("name", books.get("name"))
			.set("author", books.get("author"))
			.set("bocbs", books.get("bocbs"))
			.set("bodj", books.get("bodj"))
			.set("bozkj", books.get("bozkj"))
			.set("boremark", books.get("boremark"))
			.set("bosh", books.get("bosh"))
			.set("teid", books.get("teid"))
			.set("bonj", books.get("bonj"))
			.set("bonf", new SimpleDateFormat("yyyy").format(new Date()))//默认保存添加书的年份
			.save();
		}
		render("/pages/book.jsp");
	}
	/**TODO 根据id查询要修改的书
	 */
	public void getBookById(){
		long bookid = getParaToLong(0);
		String view = getPara(1);
		Book book = Book.dao.findById(bookid);
		setAttr("book", book);
		render("/pages/"+view+".jsp");
	}
	/**TODO 删除书
	 */
	public void delBook(){
		long bookid = getParaToLong(0);
		Book.dao.deleteById(bookid);
		render("/pages/book.jsp");
	}
	/**TODO 审核书
	 */
	public void checkBook(){
		long bookid = getParaToLong(0);
		String bosh = getPara(1);
		Book book = Book.dao.findById(bookid);
		book.set("bosh", bosh).update();
		render("/pages/book.jsp");
	}
	
}
