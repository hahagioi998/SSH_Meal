package com.luo.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
/**
 * 菜品详细信息实体类，菜品和子订单是一对多的关系，菜品和菜系是多对一的关系
 * @author Administrator
 *
 */
public class Meal implements Serializable {
	private Integer mealId;//菜品编号
	private Mealseries mealseries;//菜品所属菜系
	private String mealName;//菜品名称
	private String mealSummarize;//菜品摘要
	private String mealDescription;//菜品描述
	private Double mealPrice; //菜品价格
	private String mealImage;//菜品图片文件名
	private Set orderdtses = new HashSet(0);
	public Integer getMealId() {
		return mealId;
	}
	public void setMealId(Integer mealId) {
		this.mealId = mealId;
	}
	public Mealseries getMealseries() {
		return mealseries;
	}
	public void setMealseries(Mealseries mealseries) {
		this.mealseries = mealseries;
	}
	public String getMealName() {
		return mealName;
	}
	public void setMealName(String mealName) {
		this.mealName = mealName;
	}
	public String getMealSummarize() {
		return mealSummarize;
	}
	public void setMealSummarize(String mealSummarize) {
		this.mealSummarize = mealSummarize;
	}
	public String getMealDescription() {
		return mealDescription;
	}
	public void setMealDescription(String mealDescription) {
		this.mealDescription = mealDescription;
	}
	public Double getMealPrice() {
		return mealPrice;
	}
	public void setMealPrice(Double mealPrice) {
		this.mealPrice = mealPrice;
	}
	public String getMealImage() {
		return mealImage;
	}
	public void setMealImage(String mealImage) {
		this.mealImage = mealImage;
	}
	public Set getOrderdtses() {
		return orderdtses;
	}
	public void setOrderdtses(Set orderdtses) {
		this.orderdtses = orderdtses;
	}
	

}
