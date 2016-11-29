package com.jiaocai.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.jfinal.core.Controller;
import com.jfinal.log.Logger;
import com.jfinal.plugin.activerecord.Page;
import com.jiaocai.model.Notice;
import com.jiaocai.model.Schoolfee;

/**TODO
 * 
 */
public class SchoolfeeController extends Controller {
	
	Logger log = Logger.getLogger(getClass());
	/**TODO 查询书
	 * 
	 */
	public void getSchoolFeeList(){
		System.out.println("-----------------------------------------------");
		Map<String, Object> map = new HashMap<String, Object>();
		
		int pageNo = getParaToInt("pageNo");
		int pageSize = getParaToInt("pageSize");
		String ntitle = getPara("ntitle");
		Page<Schoolfee> schoolfeePage = Schoolfee.dao.getSchoolFeeList(pageNo, pageSize, ntitle);
		int count = schoolfeePage.getTotalRow();
		int pageCount = schoolfeePage.getTotalPage();
		
		map.put("count", count);
		map.put("pageCount", pageCount);
		map.put("schoolfeePage", schoolfeePage.getList());
		
		renderJson(map);
		
	}
	/**
	 * TODO 修改schoolfee或添加schoolfee
	 * @author xkq
	 */ 
	public void addOrUpdateschoolfee(){
		Schoolfee books = this.getModel(Schoolfee.class);
		String id = getPara("schoolfee.id");
		if(id != null && !id.equals("")){//如果id不为空，则根据id修改书
			long schfee = Long.valueOf(id);
			Schoolfee book = Schoolfee.dao.findById(schfee);
			book.set("grade", books.get("grade"))
			.set("classes", books.get("classes"))
			.set("classnum", books.get("classnum"))
			.set("amount", books.get("amount"))
			.set("projectname", books.get("projectname"))
			.set("remark", books.get("remark"))
			.set("addtime", new SimpleDateFormat("yyyy").format(new Date()))//默认保存添加书的年份
			.update();
		}else{//如果id为空，则新增一本书
			Schoolfee book = new Schoolfee();
			book.set("grade", books.get("grade"))
			.set("classes", books.get("classes"))
			.set("classnum", books.get("classnum"))
			.set("amount", books.get("amount"))
			.set("projectname", books.get("projectname"))
			.set("remark", books.get("remark"))
			.set("addtime", new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss").format(new Date()))//默认保存添加书的年份
			.save();
		}
		render("/pages/schoolfee/schoolFee.jsp");
	}
	
	
	/**TODO 删除schoolfee
	 */
	public void delschoolfee(){
		long schfeeid = getParaToLong(0);
		Schoolfee.dao.deleteById(schfeeid);
		render("/pages/schoolfee/schoolfee.jsp");
	}
	/**TODO 根据公告id查询schoolfee
	 */
	public void getschfeeById(){
		long schfeeid = getParaToLong(0);
		String view = getPara(1);
		Schoolfee schoolfee = Schoolfee.dao.findById(schfeeid);
		setAttr("schoolfee", schoolfee);
		render("/pages/schoolfee/"+view+".jsp");
	}
	/**TODO 查询往年教材
	 * 
	 *//*
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
	*//**
	 * TODO　查询学生订购的教材
	 * @author admin
	 *//*
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
	
	*/
	/**TODO 根据id查询要修改的书
	 *//*
	public void getBookById(){
		long bookid = getParaToLong(0);
		String view = getPara(1);
		Book book = Book.dao.findById(bookid);
		setAttr("book", book);
		render("/pages/"+view+".jsp");
	}
	*//**TODO 删除书
	 *//*
	public void delBook(){
		long bookid = getParaToLong(0);
		Book.dao.deleteById(bookid);
		render("/pages/book.jsp");
	}
	*//**TODO 审核书
	 *//*
	public void checkBook(){
		long bookid = getParaToLong(0);
		String bosh = getPara(1);
		Book book = Book.dao.findById(bookid);
		book.set("bosh", bosh).update();
		render("/pages/book.jsp");
	}*/
	
}
