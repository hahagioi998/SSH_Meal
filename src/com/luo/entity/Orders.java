package com.luo.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * ����ʵ���࣬���ڼ�¼��������Ҫ��Ϣ
 * @author Administrator
 *
 */
public class Orders implements Serializable {
	private Integer oId;//�������
	private Users users;//�����û���Ϣ
	private String orderTime;//��������ʱ��
	private String orderState;//����״̬
	private Double orderPrice;//�����ܼ۸�
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