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
 * @author admin
 */
public class BostController extends Controller {
	
	Logger log = Logger.getLogger(getClass());
	/**TODO 保存学生选购的书
	 * @author John
	 */
	public void saveBook(){
		long bookId = getParaToLong(0);
		long accountId = getParaToLong(1);
		String bj = getPara(2);
		String nj = getPara(3);
		String boid = getPara(4);
		String bonf = new SimpleDateFormat("yyyy").format(new Date());
		if(boid != null && !boid.equals("")){
			long id = Long.valueOf(boid);
			Bost.dao.deleteById(id);
		}else{
			Bost bost = new Bost();
			bost.set("boid", bookId)
				.set("stid", accountId)
				.set("bj", bj)
				.set("nj", nj)
				.set("bonf", bonf)
				.save();
		}
		render("/pages/book.jsp");
	}
	/**TODO 查询书的订阅情况
	 * @author John
	 */
	public void getMoneyList(){
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object> list = new ArrayList<Object>();
		
		int pageNo = getParaToInt("pageNo");
		int pageSize = getParaToInt("pageSize");
		String ntitle = getPara("ntitle");
		String mo = "1";
		String bonf = new SimpleDateFormat("yyyy").format(new Date());
		
		try {
			if(ntitle != null && !ntitle.equals("")){
				ntitle = URLDecoder.decode(ntitle, "UTF-8");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		Page<Book> books = Book.dao.getBookList(pageNo, pageSize, ntitle, "", 0, "", bonf, mo);
		for(Book book: books.getList()){
			Map<String, Object> bookmap = new HashMap<String, Object>();
			int count = Bost.dao.getStuCount(book.getLong("id"), "");
			String boremark = book.getStr("boremark");
			double zkj = (Double.valueOf(boremark))*(Double.valueOf(count));
			bookmap.put("zkj", zkj);//年级总价
			bookmap.put("book", book);//保存书名
			bookmap.put("count", count);//保存订阅的总学生数
			list.add(bookmap);
		}
		int count = books.getTotalRow();
		int pageCount = books.getTotalPage();
		
		map.put("count", count);
		map.put("pageCount", pageCount);
		map.put("list", list);
		
		renderJson(map);
	}
	/**TODO 查询学校各项费用
	 * @author John
	 */
	public void getSchoolFeeList(){
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object> list = new ArrayList<Object>();
		
		int pageNo = getParaToInt("pageNo");
		int pageSize = getParaToInt("pageSize");
		String ntitle = getPara("ntitle");
		String mo = "1";
		String bonf = new SimpleDateFormat("yyyy").format(new Date());
		
		try {
			if(ntitle != null && !ntitle.equals("")){
				ntitle = URLDecoder.decode(ntitle, "UTF-8");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		Page<Book> books = Book.dao.getBookList(pageNo, pageSize, ntitle, "", 0, "", bonf, mo);
		for(Book book: books.getList()){
			Map<String, Object> bookmap = new HashMap<String, Object>();
			int count = Bost.dao.getStuCount(book.getLong("id"), "");
			String boremark = book.getStr("boremark");
			double zkj = (Double.valueOf(boremark))*(Double.valueOf(count));
			bookmap.put("zkj", zkj);//年级总价
			bookmap.put("book", book);//保存书名
			bookmap.put("count", count);//保存订阅的总学生数
			list.add(bookmap);
		}
		int count = books.getTotalRow();
		int pageCount = books.getTotalPage();
		
		map.put("count", count);
		map.put("pageCount", pageCount);
		map.put("list", list);
		
		renderJson(map);
	}
	/**TODO 查看班级折扣价
	 * @author John
	 */
	public void getClsCount(){
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object> list = new ArrayList<Object>();
		
		long boid = getParaToLong("boid");
		String boremark = getPara("boremark");
		List<Bost> bosts = Bost.dao.getClsCount(boid);
		for(Bost bt: bosts){
			Map<String, Object> bomap = new HashMap<String, Object>();
			int count = Bost.dao.getStuCount(boid, bt.getStr("bj"));//总人数
			double zkj = (Double.valueOf(boremark)) * (Double.valueOf(count));//总价格
			bomap.put("bt", bt);
			bomap.put("count", count);
			bomap.put("zkj", zkj);
			list.add(bomap);
		}
		map.put("list", list);
		renderJson(map);
	}
	/**
	 * TODO 查看学生费用
	 * @author admin
	 */
	public void getStMoneyList(){
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object> list = new ArrayList<Object>();
		
		int pageNo = getParaToInt("pageNo");
		int pageSize = getParaToInt("pageSize");
		String ntitle = getPara("ntitle");
		long acqx = getParaToLong("acqx");
		long id = getParaToLong("id");
		
		
		String bonf = new SimpleDateFormat("yyyy").format(new Date());
		
		try {
			if(ntitle != null && !ntitle.equals("")){
				ntitle = URLDecoder.decode(ntitle, "UTF-8");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if(acqx == 1){
			Account account = Account.dao.findById(id);
			List<Bost> bostList =  Bost.dao.getOldBook(id);//历年学生订购的书分类
			for(Bost bost: bostList){
				Map<String, Object> acmap = new HashMap<String, Object>();
				List<Bost> bosList =  Bost.dao.getBook(id, bost.getStr("bonf"), "");
				double price = 0;
				for(Bost bo: bosList){
					Book book = Book.dao.findById(bo.getLong("boid"));
					double pri = Double.valueOf(book.getStr("boremark"));
					price += price + pri;
				}
				acmap.put("price", price);
				acmap.put("num", bosList.size());
				acmap.put("ac", account);
				acmap.put("bost", bost);
				list.add(acmap);
				
			}
			
			map.put("list", list);
		}else{
			Page<Account> account = Account.dao.selectAllStudent(pageNo, pageSize, ntitle);			
			for(Account ac: account.getList()){
				Map<String, Object> acmap = new HashMap<String, Object>();
				List<Bost> bosList =  Bost.dao.getBook(ac.getLong("id"), bonf, "");
				double price = 0;
				for(Bost bo: bosList){
					Book book = Book.dao.findById(bo.getLong("boid"));
					double pri = Double.valueOf(book.getStr("boremark"));
					price += price + pri;
				}
				acmap.put("price", price);
				acmap.put("num", bosList.size());
				acmap.put("ac", ac);
				acmap.put("bost", bonf);
				list.add(acmap);
			}
			int count = account.getTotalRow();
			int pageCount = account.getTotalPage();
			
			map.put("count", count);
			map.put("pageCount", pageCount);
			map.put("list", list);
		}
		
		renderJson(map);
	}
}
