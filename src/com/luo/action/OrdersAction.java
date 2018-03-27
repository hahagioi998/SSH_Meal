package com.luo.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import com.luo.biz.OrderDtsBiz;
import com.luo.biz.OrdersBiz;
import com.luo.entity.CartItemBean;
import com.luo.entity.Orderdts;
import com.luo.entity.Orders;
import com.luo.entity.Pager;
import com.luo.entity.Users;
import com.opensymphony.xwork2.ActionSupport;
@Controller
public class OrdersAction extends ActionSupport implements RequestAware,SessionAware {
	@Resource OrderDtsBiz orderDtsBiz;
	@Resource OrdersBiz ordersBiz;
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String date = df.format(new Date());
	
	private int ooderid;
	
	public int getOoderid() {
		return ooderid;
	}
	public void setOoderid(int ooderid) {
		this.ooderid = ooderid;
	}
	private Orders order;
	public Orders getOrders() {
		return order;
	}
	public void setOrders(Orders orders) {
		this.order = orders;
	}
	private Pager pager;//��װ��ҳʵ����
	public Pager getPager() {
		return pager;
	}
	public void setPager(Pager pager) {
		this.pager = pager;
	}
	int orderId ;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	Map<String, Object>session;
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	Map<String, Object>request;
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	/**
	 * ����������
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public String addOrders()throws Exception{
		Orders orders = new Orders();
		orders.setOrderState("δ����");
		orders.setOrderTime(date);		
		Users users = (Users) session.get("user");
		orders.setUsers(users);
		orders.setOrderPrice((Double)session.get("sumPrice"));
		Map cart = (Map) session.get("cart");
		Iterator iter = cart.keySet().iterator();
		while(iter.hasNext()){
			Object key = iter.next();
			CartItemBean cartItem = (CartItemBean) cart.get(key);
			Orderdts orderdts = new Orderdts();
			orderdts.setMeal(cartItem.getMeal());
			orderdts.setMealCount(cartItem.getQuantity());
			orderdts.setMealPrice(cartItem.getMeal().getMealPrice());
			orderdts.setOrders(orders);
			orderDtsBiz.addOrderDts(orderdts);
		}
		session.remove("cart");
		return "show";
	}
	/**
	 * ��ȡָ���û��Ķ�������ת���ҵĶ���ҳ��
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public String toShowOrders()throws Exception{
		Users users = (Users) session.get("user");
		List myOrdersList = ordersBiz.getOrdersByUserId(users.getId());
		request.put("myOrdersList", myOrdersList);
		
		return "myorders";
	}
	/**
	 * ���ݶ�������Ż�ȡ ��������ϸ��Ϣ
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public String toOrdersDetails()throws Exception{
		List ordersDtsList = orderDtsBiz.getOrderDtsByOid(orderId);
		request.put("ordersDtsList", ordersDtsList);
		return "toOrdersDetails";
	}
	/**
	 * ɾ������
	 * @return
	 * @throws Exception
	 */
	public String deleteOrders()throws Exception{
		ordersBiz.deleteOrders(orderId);
		return "myorders";
	}
	
	/**
	 * ��ȡ���еĶ����б���ת����������ҳmanagerOrders.jsp
	 * @return
	 * @throws Exception
	 */
	public String toManageOrders()throws Exception{
		int curPage = 1;
		
		if(pager!=null)
			curPage = pager.getCurPage();
		List ordersList = null;
		if(order!=null){
			//ָ����ѯ���������ȡ����������ָ��ҳ�Ķ����б�
			ordersList = ordersBiz.getOrdersByCondition(order, curPage);
			pager = ordersBiz.getPagerOfOrders(order);
			//����ѯ�����ŵ�request��Χ�У�����Ϊ��ҳ�����ӵĲ���ֵ
			if(order.getoId()!=null)
				request.put("ordersid", order.getoId());
			   
			if((order.getOrderState()!=null)&& !order.getOrderState().equals(""))
				request.put("orderState", order.getOrderState());
			 
		}else{
			//û��ָ����ѯ��������ȡָ��ҳ�Ķ����б�
			ordersList = ordersBiz.getAllOrders(curPage);
			//��ȡ���еĶ�����������ʼ����ҳ��
			pager = ordersBiz.getPagerOfOrders();
		}
		//����pager�д���ʾ��ҳ��
		pager.setCurPage(curPage);
		request.put("ordersList", ordersList);
		return "managerorders";
	}
	/**
	 * ������
	 * @return
	 * @throws Exception
	 */
	public String handleOrders()throws Exception{
		Orders orders = ordersBiz.getOrdersByOid(ooderid);
		orders.setOrderState("�Ѵ���");
		ordersBiz.handleOrders(orders);
		return "toManagerOrders";
	}
	

}
