package com.luo.dao.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.criteria.Order;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.luo.dao.OrdersDAO;
import com.luo.entity.Orders;
@Repository
public class OrdersDAOImpl implements OrdersDAO {
	@Resource SessionFactory factory;
    //��ȡָ���û��Ķ����б�
	@Override
	public List getOrdersByUserId(int userId) {
		Criteria criteria = factory.getCurrentSession().createCriteria(Orders.class);
		criteria.add(Restrictions.eq("users.id", userId));
		return criteria.list();
	}
	/**
	 * ���ݶ�����ż��ض���
	 */
	@Override
	public Orders getOrdersByOid(int oId) {
		Session session = factory.getCurrentSession();
		return (Orders) session.get(Orders.class, oId);
	}
	/**
	 * ɾ������
	 */
	@Override
	public void deleteOrders(Orders orders) {
		Session session = factory.getCurrentSession();
		session.delete(orders);
	}
	/**
	 * ��ȡָ��ҳ�Ķ���
	 */
	@Override
	public List getAllOrders(int Page) {
		Criteria criteria = factory.getCurrentSession().createCriteria(Orders.class);
		criteria.setFirstResult(9*(Page-1));
		criteria.setMaxResults(9);		
		return criteria.list();
	}
	/**
	 * ͳ�ƶ�����
	 */
	@Override
	public Integer getCountOfAllOrders() {
		Integer count = null;
		try {
			Session session = factory.getCurrentSession();
			String hql = "select count(o) from Orders o";
			Query query = session.createQuery(hql);
			count = Integer.parseInt(query.uniqueResult().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	/**
	 * ��ȡ���������ģ�ָ��ҳ�Ķ�����
	 */
	@Override
	public List getOrdersByCondition(Orders condition, int page) {
			Session session = factory.getCurrentSession();
			Criteria criteria = session.createCriteria(Orders.class);
			if(condition!=null){
				if((condition.getoId()!=null)&&(condition.getoId()>0)){
					//�������Ž���ɸѡ
					criteria.add(Restrictions.eq("oId", condition.getoId()));
				}
				if((condition.getOrderState()!=null)&& !condition.getOrderState().equals("")&& condition.getOrderState().equals("ȫ��")){
					//������״̬��ѯ
					criteria.add(Restrictions.eq("orderState", condition.getOrderState()));
				}
			}
			criteria.setFirstResult(9*(page-1));
			criteria.setMaxResults(9);
			
		return criteria.list();
	}
	/**
	 * ͳ�����������Ķ�����
	 */
	@Override
	public Integer getCountOfOrders(Orders condition) {
		Session session = factory.getCurrentSession();
		Criteria criteria = session.createCriteria(Orders.class);
		if(condition!=null){
			if((condition.getoId()!=null)&&(condition.getoId()>0)){
				//�������Ž���ɸѡ
				criteria.add(Restrictions.eq("oId", condition.getoId()));
			}
			if((condition.getOrderState()!=null)&& !condition.getOrderState().equals("")&& condition.getOrderState().equals("ȫ��")){
				//������״̬��ѯ
				criteria.add(Restrictions.eq("orderState", condition.getOrderState()));
			}
		}
		return criteria.list().size();
	}
	/**
	 * ���¶�������
	 */
	@Override
	public void updateOrders(Orders orders) {
		Session session = factory.getCurrentSession();
		session.update(orders);
	}

}