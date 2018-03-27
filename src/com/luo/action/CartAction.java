package com.luo.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import com.luo.biz.MealBiz;
import com.luo.entity.CartItemBean;
import com.luo.entity.Meal;
import com.opensymphony.xwork2.ActionSupport;
@Controller
public class CartAction extends ActionSupport implements SessionAware {
	@Resource MealBiz mealBiz;
	private Integer mealId;//��װ������򴫵ݵĲ���id
	public Integer getMealId() {
		return mealId;
	}
	public void setMealId(Integer mealId) {
		this.mealId = mealId;
	}
	int quantity;//��װ���ݵĲ�Ʒ����
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * ����Ʒ�ӵ����ﳵ��
	 * @return
	 * @throws Exception
	 */
	public String addtoshopcart()throws Exception{
		//��Session��ȡ�����ﳵ����Map����cart��
		Map cart = (Map) session.get("cart");
		//��ȡ��ǰҪ��ӵ����ﳵ�Ĳ�Ʒ
		Meal meal = mealBiz.getMealById(mealId);
		//������ﳵ�����ڣ��򴴽����ﳵ
		if(cart==null){
			cart = new HashMap();
			session.put("cart", cart);
		}
		//������ڹ��ﳵ�����жϲ�Ʒ�ڲ��ڹ��ﳵ��
		CartItemBean cartItem = (CartItemBean) cart.get(meal.getMealId());
		if(cartItem!=null){
			//��Ʒ�ڹ��ﳵ�����������
			cartItem.setQuantity(cartItem.getQuantity()+1);
		}else{
			//��Ʒ���ڹ��ﳵ��򴴽�һ���µ���Ŀ��Map��
			cart.put(meal.getMealId(), new CartItemBean(meal, 1));
		}
		//ҳ����ת��shopcart.jspҳ��
		return "shopCart";
	}
	
    Map<String, Object>session;
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	/**
	 * �޸Ĺ��ﳵ��Ʒ����
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public String updateQuantity()throws Exception{
		//��session��ȡ�����ﳵ
		Map cart = (Map) session.get("cart");
		CartItemBean cartItem = (CartItemBean) cart.get(mealId);
		cartItem.setQuantity(quantity);
			return "shopCart";
	}
	/**
	 * ɾ�����ﳵ�еĶ���
	 * @return
	 * @throws Exception
	 */
	public String deleteOrders()throws Exception{
		Map cart = (Map) session.get("cart");
		cart.remove(mealId);
		return "shopCart";
	}
	/**
	 * ��չ��ﳵ
	 * @return
	 * @throws Exception
	 */
	public String clearCart()throws Exception{
		//��session��ȡ�����ﳵ
		Map cart = (Map) session.get("cart");
		cart.clear();		
		return "shopCart";
	}
}
