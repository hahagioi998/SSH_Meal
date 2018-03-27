package com.luo.dao;

import java.util.List;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;

import com.luo.entity.Orders;

/**
 * �����û����鿴����
 * @author Administrator
 *
 */
public interface OrdersDAO {
	//��ȡָ���û��Ķ����б�
	public List getOrdersByUserId(int userId);
	//���ݶ����ż��ض���
	public Orders getOrdersByOid(int oId);
	//ɾ������
	public void deleteOrders(Orders orders);
	//��ȡָ��ҳ��ʾ�Ķ����б�
	public List getAllOrders(int Page);
	//ͳ�����еĶ�������
	public Integer getCountOfAllOrders();
	//��ȡ����������ָ��ҳ��ʾ�Ķ����б�
	public List getOrdersByCondition(Orders condition,int page);
	//ͳ�����������Ķ�����
	public Integer getCountOfOrders(Orders condition);
    //���¶���
	public void updateOrders(Orders orders);
}
