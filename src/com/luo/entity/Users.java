package com.luo.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
/**
 * 用户信息实体类，用于记录前台用户的基本信息
 * @author Administrator
 *
 */
public class Users implements Serializable {
	private Integer id;//用户编号
	private String loginName;//用户登录名
	private String loginPwd;//用户密码
	private String trueName;//用户真实姓名
	private String eamil;//用户邮箱
	private String phone;//用户电话
	private String address;//用户送货地址
	private String address1;//用户送货地址
	private String address2;//用户送货地址
	private String address3;//用户送货地址
	private String address4;//用户送货地址
	private String qqnumber;//QQ号
	private String qqpws;//QQ号密码
	private String weibonumber;//微博号
	private String weibopws;//微博号密码
	private Set orderses = new HashSet(0);
	
	
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getAddress3() {
		return address3;
	}
	public void setAddress3(String address3) {
		this.address3 = address3;
	}
	public String getAddress4() {
		return address4;
	}
	public void setAddress4(String address4) {
		this.address4 = address4;
	}
	public String getQqpws() {
		return qqpws;
	}
	public void setQqpws(String qqpws) {
		this.qqpws = qqpws;
	}
	public String getWeibopws() {
		return weibopws;
	}
	public void setWeibopws(String weibopws) {
		this.weibopws = weibopws;
	}
	public String getQqnumber() {
		return qqnumber;
	}
	public void setQqnumber(String qqnumber) {
		this.qqnumber = qqnumber;
	}
	public String getWeibonumber() {
		return weibonumber;
	}
	public void setWeibonumber(String weibonumber) {
		this.weibonumber = weibonumber;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public String getEamil() {
		return eamil;
	}
	public void setEamil(String eamil) {
		this.eamil = eamil;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Set getOrderses() {
		return orderses;
	}
	public void setOrderses(Set orderses) {
		this.orderses = orderses;
	}
	
	
	

}
