package com.luo.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luo.biz.OrdersBiz;
import com.luo.dao.OrdersDAO;
import com.luo.entity.Orders;
import com.luo.entity.Pager;
@Service@Transactional
public class OrdersBizImpl implements OrdersBiz {
	@Resource OrdersDAO ordersDAO;
     /**
      * ��ȡָ���û��Ķ����б�
      */
	@Override
	public List getOrdersByUserId(int userId) {
		return ordersDAO.getOrdersByUserId(userId);
	}
	/**
	 * ɾ��ָ�������ŵĶ���
	 */
	@Override
	public void deleteOrders(int oId) {
		Orders orders = ordersDAO.getOrdersByOid(oId);
		ordersDAO.deleteOrders(orders);
		
	}
	/**
	 * //��ȡָ��ҳ�Ķ�����¼��
	 */
	@Override
	public List getAllOrders(int page) {
		
		return ordersDAO.getAllOrders(page);
	}
	/**
	 * ��ȡ���еĶ�����������ʼ����ҳ��
	 */
	@Override
	public Pager getPagerOfOrders() {
		int count = ordersDAO.getCountOfAllOrders();
		Pager pager = new Pager();
		pager.setPerPageRows(9);
		pager.setRowCount(count);
		return pager;
	}
	/**
	 * ��ȡ���������ģ�ָ��ҳ�Ķ����б�
	 */
	@Override
	public List getOrdersByCondition(Orders condition, int page) {
		
		return ordersDAO.getOrdersByCondition(condition, page);
	}
	/**
	 * ��ȡ���������Ķ���������������ʼ����ҳ��
	 */
	@Override
	public Pager getPagerOfOrders(Orders condition) {
		int count = ordersDAO.getCountOfOrders(condition);
		Pager pager = new Pager();
		pager.setPerPageRows(9);
		pager.setRowCount(count);
		return pager;
	}
	/**
	 * ������
	 */
	@Override
	public void handleOrders(Orders orders) {
		ordersDAO.updateOrders(orders);
	}
	/**
	 * ����id���ض���
	 */
	@Override
	public Orders getOrdersByOid(int oid) {
		
		return ordersDAO.getOrdersByOid(oid);
	}

}
