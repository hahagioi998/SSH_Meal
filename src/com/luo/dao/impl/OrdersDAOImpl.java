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
    //获取指定用户的订单列表
	@Override
	public List getOrdersByUserId(int userId) {
		Criteria criteria = factory.getCurrentSession().createCriteria(Orders.class);
		criteria.add(Restrictions.eq("users.id", userId));
		return criteria.list();
	}
	/**
	 * 根据订单编号加载订单
	 */
	@Override
	public Orders getOrdersByOid(int oId) {
		Session session = factory.getCurrentSession();
		return (Orders) session.get(Orders.class, oId);
	}
	/**
	 * 删除订单
	 */
	@Override
	public void deleteOrders(Orders orders) {
		Session session = factory.getCurrentSession();
		session.delete(orders);
	}
	/**
	 * 获取指定页的订单
	 */
	@Override
	public List getAllOrders(int Page) {
		Criteria criteria = factory.getCurrentSession().createCriteria(Orders.class);
		criteria.setFirstResult(9*(Page-1));
		criteria.setMaxResults(9);		
		return criteria.list();
	}
	/**
	 * 统计订单数
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
	 * 获取满足条件的，指定页的订单数
	 */
	@Override
	public List getOrdersByCondition(Orders condition, int page) {
			Session session = factory.getCurrentSession();
			Criteria criteria = session.createCriteria(Orders.class);
			if(condition!=null){
				if((condition.getoId()!=null)&&(condition.getoId()>0)){
					//按订单号进行筛选
					criteria.add(Restrictions.eq("oId", condition.getoId()));
				}
				if((condition.getOrderState()!=null)&& !condition.getOrderState().equals("")&& condition.getOrderState().equals("全部")){
					//按订单状态查询
					criteria.add(Restrictions.eq("orderState", condition.getOrderState()));
				}
			}
			criteria.setFirstResult(9*(page-1));
			criteria.setMaxResults(9);
			
		return criteria.list();
	}
	/**
	 * 统计满足条件的订单数
	 */
	@Override
	public Integer getCountOfOrders(Orders condition) {
		Session session = factory.getCurrentSession();
		Criteria criteria = session.createCriteria(Orders.class);
		if(condition!=null){
			if((condition.getoId()!=null)&&(condition.getoId()>0)){
				//按订单号进行筛选
				criteria.add(Restrictions.eq("oId", condition.getoId()));
			}
			if((condition.getOrderState()!=null)&& !condition.getOrderState().equals("")&& condition.getOrderState().equals("全部")){
				//按订单状态查询
				criteria.add(Restrictions.eq("orderState", condition.getOrderState()));
			}
		}
		return criteria.list().size();
	}
	/**
	 * 更新订单对象
	 */
	@Override
	public void updateOrders(Orders orders) {
		Session session = factory.getCurrentSession();
		session.update(orders);
	}

}
