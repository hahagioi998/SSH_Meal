package com.luo.action;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import com.luo.biz.AdminBiz;
import com.luo.biz.UserBiz;
import com.luo.entity.Admin;
import com.luo.entity.Users;
import com.opensymphony.xwork2.ActionSupport;
@Controller
public class UserAction extends ActionSupport implements RequestAware,SessionAware {
	 @Resource UserBiz userBiz;
	 @Resource AdminBiz adminBiz;
	 private String username;//����Ajax��֤�û�������
	 
	 public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	private Users users;//��װ������
	 public Users getUsers() {
		return users;
	}
	 public void setUsers(Users users) {
		this.users = users;
	}
	private String type;//��װ��½�û�����	
     public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	//��װ��½������
	private  String loginName;
	private String loginPwd;
	
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	/**
	 * ��½��֤
	 * @return
	 * @throws Exception
	 */
	public String validateLogin()throws Exception{
		List list ;
		if("userlogin".equals(type)){
			Users condition = new Users();
			condition.setLoginName(loginName);
			condition.setLoginPwd(loginPwd);
			list = userBiz.login(condition);
			if(list.size()>0){
				//����½������뵽Session��
				session.put("user", list.get(0));
				
			}
		}
		if("qqlogin".equals(type)){
			Users condition = new Users();
			condition.setQqnumber(loginName);
			condition.setQqpws(loginPwd);
			list = userBiz.login(condition);
			if(list.size()>0){
				session.put("user", list.get(0));
			}
			
		}
		if("weilogin".equals(type)){
			Users condition = new Users();
			condition.setWeibonumber(loginName);
			condition.setWeibopws(loginPwd);
			list = userBiz.login(condition);
			if(list.size()>0){
				session.put("user", list.get(0));
			}
		}
		if("adminlogin".equals(type)){
			Admin condition = new Admin();
			condition.setLoginName(loginName);
			condition.setLoginPwd(loginName);
			list = userBiz.login(condition);
			if(list.size()>0){
				//������Ա���浽Session��
				session.put("admin", list.get(0));
				
			}
		}
		return "toShowMeal";
	}
	/**
	 * �û�ע��
	 * @return
	 * @throws Exception
	 */
	public String register()throws Exception{
		userBiz.register(users);
		return "register";
	}
	Map<String, Object> session;
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
    Map<String, Object>request;
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

}
