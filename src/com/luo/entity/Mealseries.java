package com.luo.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
/**
 * ��ϵʵ���࣬���ڼ�¼���ֲ�ϵ����ϵ�Ͳ�Ʒ��һ�Զ�Ĺ�ϵ
 * @author Administrator
 *
 */
public class Mealseries implements Serializable {
	private Integer seriesId;//��ϵ���
	private String seriesName;//��ϵ����
	private Set meals = new HashSet(0);
	public Integer getSeriesId() {
		return seriesId;
	}
	public void setSeriesId(Integer seriesId) {
		this.seriesId = seriesId;
	}
	public String getSeriesName() {
		return seriesName;
	}
	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}
	public Set getMeals() {
		return meals;
	}
	public void setMeals(Set meals) {
		this.meals = meals;
	}
	

}
