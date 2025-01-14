package com.luo.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 订单实体类，用于记录订单的主要信息
 * @author Administrator
 *
 */
public class Orders implements Serializable {
	private Integer oId;//订单编号
	private Users users;//订单用户信息
	private String orderTime;//订单产生时间
	private String orderState;//订单状态
	private Double orderPrice;//订单总价格
	private Set orderdtses = new HashSet(0);
	
	public Integer getoId() {
		return oId;
	}
	public void setoId(Integer oId) {
		this.oId = oId;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	public String getOrderState() {
		return orderState;
	}
	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}
	public Double getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(Double orderPrice) {
		this.orderPrice = orderPrice;
	}
	public Set getOrderdtses() {
		return orderdtses;
	}
	public void setOrderdtses(Set orderdtses) {
		this.orderdtses = orderdtses;
	}
	

}
