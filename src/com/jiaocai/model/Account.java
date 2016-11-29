package com.jiaocai.model;

import com.jfinal.log.Logger;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;


public class Account extends Model<Account> {
	
	
	private static final long serialVersionUID = 1L;

	public static final Account dao = new Account();

	Logger log = Logger.getLogger(getClass());
	
	/**TODO 查询用户登陆名字
	 * @param loginuser
	 * @return account
	 */
	public Account selectUserByloginName(String loginuser){
		Account account = null;
		String sql = "select a.* from t_account a where 1=1 and a.loginname = '" + loginuser + "'";
		log.info(sql);
		account = findFirst(sql);
		return account;
	}
	/**TODO 查询所有用户
	 * @author xkq
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page<Account> selectAllUser(int pageNo, int pageSize, String ntitle,int personAcqx){
		Page<Account> account = null;
		String sql = "from t_account a where 1=1 and a.acqx <> 0 ";
		if(ntitle != null && !ntitle.equals("")){
			sql += " and (a.acname like '%" + ntitle + "%' or a.acxh like '%"+ntitle+"%')";
		}
		if(personAcqx != 4){
			sql += " and a.acqx ="+personAcqx;		
		}
		sql += " order by id asc";			
		log.info(sql);
		account = Account.dao.paginate(pageNo, pageSize, "select a.* ", sql);
		return account;
	}
	/**TODO 
	 * 查询所有学生用户
	 * @param pageNo
	 * @param pageSize
	 * @param ntitle
	 * @return
	 */
	public Page<Account> selectAllStudent(int pageNo, int pageSize, String ntitle){
		Page<Account> account = null;
		String sql = "from t_account a where 1=1 and a.acqx = 1 ";
		if(ntitle != null && !ntitle.equals("")){
			sql += " and (a.acname like '%" + ntitle + "%' or a.acxh like '%"+ntitle+"%')";
		}
		sql += " order by id asc";			
		log.info(sql);
		account = Account.dao.paginate(pageNo, pageSize, "select a.* ", sql);
		return account;
	}
}
