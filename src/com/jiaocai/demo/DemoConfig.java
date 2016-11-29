package com.jiaocai.demo;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;
import com.jiaocai.controller.AccountController;
import com.jiaocai.controller.BookController;
import com.jiaocai.controller.BostController;
import com.jiaocai.controller.ClassesController;
import com.jiaocai.controller.CommonController;
import com.jiaocai.controller.KechengController;
import com.jiaocai.controller.KitchenDisinfectController;
import com.jiaocai.controller.MenuController;
import com.jiaocai.controller.NoticeController;
import com.jiaocai.controller.PaikeController;
import com.jiaocai.controller.ProtectMeasuresController;
import com.jiaocai.controller.RegularMeetingController;
import com.jiaocai.controller.SchoolfeeController;
import com.jiaocai.controller.StuAccidentController;
import com.jiaocai.controller.StuSickCheckController;
import com.jiaocai.controller.StuMorningCheckController;
import com.jiaocai.controller.TeacherStudyController;
import com.jiaocai.model.Account;
import com.jiaocai.model.Book;
import com.jiaocai.model.Bost;
import com.jiaocai.model.Classes;
import com.jiaocai.model.Kecheng;
import com.jiaocai.model.Menus;
import com.jiaocai.model.Notice;
import com.jiaocai.model.Paike;
import com.jiaocai.model.Pkval;
import com.jiaocai.model.ProtectMeasures;
import com.jiaocai.model.RegularMeeting;
import com.jiaocai.model.Schoolfee;
import com.jiaocai.model.StuAccident;
import com.jiaocai.model.StuSickCheck;
import com.jiaocai.model.StuMorningCheck;
import com.jiaocai.model.TeacherStudy;
import com.jiaocai.model.Week;
import com.jiaocai.model.KitchenDisinfect;

public class DemoConfig extends JFinalConfig {

	@Override
	public void configConstant(Constants me) {
		loadPropertyFile("a_little_config.txt");
		me.setDevMode(true);
		me.setViewType(ViewType.JSP);

	}

	@Override
	public void configRoute(Routes me) {
		me.add("/", CommonController.class);
		me.add("/account", AccountController.class);
		me.add("/menus", MenuController.class);
		me.add("/notice", NoticeController.class);
		me.add("/schoolfee", SchoolfeeController.class);
		me.add("/book", BookController.class);
		me.add("/kecheng", KechengController.class);
		me.add("/paike", PaikeController.class);
		me.add("/bost", BostController.class);
		
		me.add("/classes", ClassesController.class);

		me.add("/stuSickCheck", StuSickCheckController.class);
		me.add("/stuAccident", StuAccidentController.class);
		me.add("/stuMorningCheck", StuMorningCheckController.class);
		me.add("/teacherStudy", TeacherStudyController.class);
		me.add("/regularMeeting", RegularMeetingController.class);
		me.add("/kitchenDisinfect", KitchenDisinfectController.class);
		me.add("/protectMeasures", ProtectMeasuresController.class);
	}

	@Override
	public void configPlugin(Plugins me) {
		
		C3p0Plugin c3p0Plugin = new C3p0Plugin(getProperty("jdbcUrl"),
				getProperty("user"), getProperty("password").trim());
		me.add(c3p0Plugin);

		ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
		me.add(arp);
		arp.addMapping("t_book", Book.class);
		arp.addMapping("t_bost", Bost.class);
		arp.addMapping("t_kecheng", Kecheng.class);
		arp.addMapping("t_notice", Notice.class);
		arp.addMapping("t_schoolfee", Schoolfee.class);
		arp.addMapping("t_paike", Paike.class);
		arp.addMapping("t_account", Account.class);
		arp.addMapping("t_menu", Menus.class);
		arp.addMapping("t_week", Week.class);
		arp.addMapping("t_pkval", Pkval.class);
		
		arp.addMapping("t_classes", Classes.class);
		
		arp.addMapping("t_stuSickCheck", StuSickCheck.class);
		arp.addMapping("t_stuAccident", StuAccident.class);
		arp.addMapping("t_stuMorningCheck", StuMorningCheck.class);
		arp.addMapping("t_teacherStudy", TeacherStudy.class);
		arp.addMapping("t_regularMeeting", RegularMeeting.class);
		arp.addMapping("t_kitchenDisinfect", KitchenDisinfect.class);
		arp.addMapping("t_protectMeasures", ProtectMeasures.class);
		
	}

	@Override
	public void configInterceptor(Interceptors me) {
		// TODO Auto-generated method stub

	}

	@Override
	public void configHandler(Handlers me) {
		// TODO Auto-generated method stub

	}

}
